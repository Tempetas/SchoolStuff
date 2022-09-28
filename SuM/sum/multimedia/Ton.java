// 
// Decompiled by Procyon v0.5.36
// 

package sum.multimedia;

import javax.sound.sampled.AudioFileFormat;
import java.io.InputStream;
import javax.sound.sampled.SourceDataLine;
import java.io.ByteArrayInputStream;
import java.awt.Frame;
import java.awt.FileDialog;
import sum.ereignis.Bildschirm;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import javax.sound.sampled.Line;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import java.io.ByteArrayOutputStream;
import javax.sound.sampled.AudioFormat;
import java.io.Serializable;

public class Ton implements Serializable
{
    private boolean zNimmtAuf;
    private boolean zSpieltAb;
    private AudioFormat hatFormat;
    private ByteArrayOutputStream hatOutStream;
    
    public Ton() {
        this.zNimmtAuf = false;
        this.zSpieltAb = false;
        this.hatFormat = null;
        this.hatFormat = this.getFormat();
    }
    
    private AudioFormat getFormat() {
        final float sampleRate = 44100.0f;
        final int sampleSizeInBits = 16;
        final int channels = 2;
        final boolean signed = true;
        final boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
    }
    
    public void starteAufnahme() {
        if (!this.zSpieltAb) {
            try {
                this.hatFormat = this.getFormat();
                final DataLine.Info info = new DataLine.Info(TargetDataLine.class, this.hatFormat);
                final TargetDataLine line = (TargetDataLine)AudioSystem.getLine(info);
                line.open(this.hatFormat);
                line.start();
                final Runnable runner = new Runnable() {
                    int bufferSize = (int)Ton.this.hatFormat.getSampleRate() * Ton.this.hatFormat.getFrameSize();
                    byte[] buffer = new byte[this.bufferSize];
                    
                    @Override
                    public void run() {
                        Ton.this.hatOutStream = new ByteArrayOutputStream();
                        Ton.this.zNimmtAuf = true;
                        try {
                            while (Ton.this.zNimmtAuf) {
                                final int count = line.read(this.buffer, 0, this.buffer.length);
                                if (count > 0) {
                                    Ton.this.hatOutStream.write(this.buffer, 0, count);
                                }
                            }
                            Ton.this.hatOutStream.close();
                        }
                        catch (IOException e) {
                            System.out.println("I/O problems: " + e);
                            System.exit(-1);
                        }
                    }
                };
                final Thread captureThread = new Thread(runner);
                captureThread.start();
            }
            catch (LineUnavailableException e) {
                System.out.println("Line unavailable: " + e);
                System.exit(-2);
            }
        }
    }
    
    public void stoppeAufnahme() {
        if (this.zNimmtAuf) {
            this.zNimmtAuf = false;
        }
    }
    
    public boolean ladeTon(final String pDatei) {
        final File soundFile = new File(pDatei);
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
        this.hatFormat = audioInputStream.getFormat();
        final int bufferSize = (int)this.hatFormat.getSampleRate() * this.hatFormat.getFrameSize();
        final byte[] buffer = new byte[bufferSize];
        this.hatOutStream = new ByteArrayOutputStream();
        try {
            int nBytesRead = 0;
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(buffer, 0, buffer.length);
                if (nBytesRead > 0) {
                    this.hatOutStream.write(buffer, 0, nBytesRead);
                }
            }
            this.hatOutStream.close();
        }
        catch (Exception e2) {
            System.out.println(e2.toString());
            e2.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean ladeTon() {
        final FileDialog ladendialog = new FileDialog((Frame)Bildschirm.topFenster, "Ton laden", 0);
        ladendialog.setVisible(true);
        final String dateiname = ladendialog.getFile();
        if (dateiname != null) {
            final String pfadname = ladendialog.getDirectory();
            return this.ladeTon(pfadname + dateiname);
        }
        return false;
    }
    
    public void spieleTon() {
        if (!this.zNimmtAuf && this.hatOutStream != null) {
            try {
                final byte[] audio = this.hatOutStream.toByteArray();
                final InputStream input = new ByteArrayInputStream(audio);
                final AudioInputStream ais = new AudioInputStream(input, this.hatFormat, audio.length / this.hatFormat.getFrameSize());
                final DataLine.Info info = new DataLine.Info(SourceDataLine.class, this.hatFormat);
                final SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
                line.open(this.hatFormat);
                line.start();
                final Runnable runner = new Runnable() {
                    int bufferSize = (int)Ton.this.hatFormat.getSampleRate() * Ton.this.hatFormat.getFrameSize();
                    byte[] buffer = new byte[this.bufferSize];
                    
                    @Override
                    public void run() {
                        Ton.this.zSpieltAb = true;
                        try {
                            int count;
                            while ((count = ais.read(this.buffer, 0, this.buffer.length)) != -1 && Ton.this.zSpieltAb) {
                                if (count > 0) {
                                    line.write(this.buffer, 0, count);
                                }
                            }
                            if (Ton.this.zSpieltAb) {
                                line.drain();
                            }
                            Ton.this.zSpieltAb = false;
                        }
                        catch (IOException e) {
                            System.out.println("I/O problems: " + e);
                            System.exit(-3);
                        }
                    }
                };
                final Thread playThread = new Thread(runner);
                playThread.start();
            }
            catch (LineUnavailableException e) {
                System.out.println("Line unavailable: " + e);
                System.exit(-4);
            }
        }
    }
    
    public void stoppeAbspielen() {
        if (this.zSpieltAb) {
            this.zSpieltAb = false;
        }
    }
    
    public boolean speichereTon(final String pDatei) {
        final String fileName = pDatei + ".wav";
        final File outputFile = new File(fileName);
        final AudioFileFormat.Type targetType = AudioFileFormat.Type.WAVE;
        if (!this.zNimmtAuf && !this.zSpieltAb && this.hatOutStream != null) {
            final byte[] audio = this.hatOutStream.toByteArray();
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audio);
            final AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, this.hatFormat, audio.length / this.hatFormat.getFrameSize());
            try {
                AudioSystem.write(audioInputStream, targetType, outputFile);
                return true;
            }
            catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    
    public boolean speichereTon() {
        final FileDialog speicherndialog = new FileDialog((Frame)Bildschirm.topFenster, "Ton speichern", 1);
        speicherndialog.setVisible(true);
        final String dateiname = speicherndialog.getFile();
        if (dateiname != null) {
            final String pfadname = speicherndialog.getDirectory();
            return this.speichereTon(pfadname + dateiname);
        }
        return false;
    }
    
    public void gibFrei() {
    }
}
