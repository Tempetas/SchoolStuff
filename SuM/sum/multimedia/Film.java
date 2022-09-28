// 
// Decompiled by Procyon v0.5.36
// 

package sum.multimedia;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.FileDialog;
import sum.ereignis.Bildschirm;
import quicktime.app.view.QTFactory;
import quicktime.io.OpenMovieFile;
import quicktime.io.QTFile;
import quicktime.std.movies.media.DataRef;
import quicktime.QTSession;
import java.awt.event.WindowListener;
import java.applet.Applet;
import quicktime.app.view.QTComponent;
import quicktime.std.movies.MovieController;
import quicktime.std.movies.Movie;
import java.io.Serializable;
import java.awt.Frame;

public class Film extends Frame implements Serializable
{
    private Frame hatFrame;
    private Movie hatMovie;
    private MovieController hatController;
    private QTComponent hatQTC;
    private Applet kenntApplet;
    
    public Film(final String pPfad) {
        this.hatFrame = null;
        this.hatQTC = null;
        this.ladeFilm(pPfad);
    }
    
    public Film(final Applet pApplet) {
        this.hatFrame = null;
        this.hatQTC = null;
        this.kenntApplet = pApplet;
        this.ladeFilm();
    }
    
    public Film() {
        this.hatFrame = null;
        this.hatQTC = null;
        this.ladeFilm();
    }
    
    public boolean ladeFilm(final String pPfad) {
        if (this.hatFrame == null) {
            (this.hatFrame = new Frame("SuM-Film")).addWindowListener(new FensterTester());
            try {
                QTSession.open();
            }
            catch (Exception e) {
                System.out.println(e.toString());
                System.exit(-9);
            }
        }
        try {
            if (this.kenntApplet == null) {
                final DataRef urlMovie = new DataRef("file://" + pPfad);
                this.hatMovie = Movie.fromDataRef(urlMovie, 1);
            }
            else {
                final QTFile qtf = new QTFile("file://" + pPfad);
                final OpenMovieFile fis = OpenMovieFile.asRead(qtf);
                this.hatMovie = Movie.fromFile(fis);
            }
            this.hatController = new MovieController(this.hatMovie);
            if (this.hatQTC == null) {
                this.hatQTC = QTFactory.makeQTComponent(this.hatController);
                this.hatFrame.add(this.hatQTC.asComponent());
            }
            else {
                this.hatQTC.setMovieController(this.hatController);
            }
            this.hatFrame.pack();
            this.hatFrame.setVisible(true);
            this.hatQTC.asComponent().repaint();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean ladeFilm() {
        final FileDialog ladendialog = new FileDialog((Frame)Bildschirm.topFenster, "Film laden", 0);
        ladendialog.setVisible(true);
        final String dateiname = ladendialog.getFile();
        if (dateiname != null) {
            final String pfadname = ladendialog.getDirectory();
            return this.ladeFilm(pfadname + dateiname);
        }
        return false;
    }
    
    private void schliessen() {
        QTSession.close();
        this.hatFrame.dispose();
        this.hatFrame = null;
        this.hatQTC = null;
        this.hatController = null;
        this.hatMovie = null;
    }
    
    public void gibFrei() {
    }
    
    private class FensterTester extends WindowAdapter
    {
        @Override
        public void windowClosing(final WindowEvent e) {
            Film.this.schliessen();
        }
    }
}
