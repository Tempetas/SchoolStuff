// 
// Decompiled by Procyon v0.5.36
// 

package sum.multimedia;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.ImageProducer;
import java.awt.image.ImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ReplicateScaleFilter;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Frame;
import java.awt.FileDialog;
import java.awt.MediaTracker;
import sum.ereignis.Fenster;
import java.applet.Applet;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.JPanel;

public class Bild extends JPanel implements Serializable
{
    private Image hatOriginal;
    private BufferedImage hatKopie;
    private String zGeklicktBearbeiter;
    private String zFokusErhaltenBearbeiter;
    private String zFokusVerlorenBearbeiter;
    private boolean zHatFocus;
    
    public Bild(final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        Bildschirm.topFenster.privatPanel().add(this, 0);
        this.setBackground(Color.black);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.setOpaque(false);
        this.hatOriginal = new BufferedImage(new Double(pBreite).intValue(), new Double(pHoehe).intValue(), 2);
        this.bildPuffern();
        this.repaint();
    }
    
    public Bild(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pPfad) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        Bildschirm.topFenster.privatPanel().add(this, 0);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.ladeBild(pPfad);
        this.repaint();
    }
    
    public Bild(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pPfad, final Applet pApplet) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        Bildschirm.topFenster.privatPanel().add(this, 0);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.ladeBild(pApplet, pPfad);
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.repaint();
    }
    
    public Bild(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final Bild pBild) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        Bildschirm.topFenster.privatPanel().add(this, 0);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.hatOriginal = pBild.hatOriginal;
        this.bildPuffern();
        this.repaint();
    }
    
    public Bild(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        pFenster.privatPanel().add(this, 0);
        this.setBackground(Color.black);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.setOpaque(false);
        this.hatOriginal = new BufferedImage(new Double(pBreite).intValue(), new Double(pHoehe).intValue(), 2);
        this.bildPuffern();
        this.repaint();
    }
    
    public Bild(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pPfad) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        pFenster.privatPanel().add(this, 0);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.ladeBild(pPfad);
        this.repaint();
    }
    
    public Bild(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final Bild pBild) {
        this.hatOriginal = null;
        this.hatKopie = null;
        this.zGeklicktBearbeiter = "";
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFocus = false;
        pFenster.privatPanel().add(this, 0);
        this.addMouseListener(new BildReaktor());
        this.addKeyListener(new BildTastenReaktor());
        this.addFocusListener(new BildFokusReaktor());
        this.setzeGroesse(pBreite, pHoehe);
        this.setzePosition(pLinks, pOben);
        this.hatOriginal = pBild.hatOriginal;
        this.bildPuffern();
        this.repaint();
    }
    
    public void setzeBearbeiterGeklickt(final String pBearbeiter) {
        this.zGeklicktBearbeiter = pBearbeiter;
    }
    
    public void setzeBearbeiterFokusVerloren(final String pBearbeiter) {
        this.zFokusVerlorenBearbeiter = pBearbeiter;
    }
    
    public void setzeBearbeiterFokusErhalten(final String pBearbeiter) {
        this.zFokusErhaltenBearbeiter = pBearbeiter;
    }
    
    public boolean ladeBild(final Applet pApplet, final String pPfad) {
        MediaTracker mt = null;
        this.hatOriginal = pApplet.getImage(pApplet.getCodeBase(), pPfad);
        mt = new MediaTracker((Component)Bildschirm.topFenster);
        mt.addImage(this.hatOriginal, 0);
        try {
            mt.waitForAll();
            this.bildPuffern();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean ladeBild(final String pPfad) {
        MediaTracker mt = null;
        this.hatOriginal = Bildschirm.topFenster.getToolkit().createImage(pPfad);
        mt = new MediaTracker((Component)Bildschirm.topFenster);
        mt.addImage(this.hatOriginal, 0);
        try {
            mt.waitForAll();
            this.bildPuffern();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean ladeBild() {
        final FileDialog ladendialog = new FileDialog((Frame)Bildschirm.topFenster, "Bild laden", 0);
        ladendialog.setVisible(true);
        final String dateiname = ladendialog.getFile();
        if (dateiname != null) {
            final String pfadname = ladendialog.getDirectory();
            return this.ladeBild(pfadname + dateiname);
        }
        return false;
    }
    
    public boolean speichereBild(final String pDatei) {
        final File datei = new File(pDatei);
        try {
            ImageIO.write(this.hatKopie, pDatei.substring(pDatei.length() - 3, pDatei.length()), datei);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean speichereBild() {
        final FileDialog speicherndialog = new FileDialog((Frame)Bildschirm.topFenster, "Ton speichern", 1);
        speicherndialog.setVisible(true);
        final String dateiname = speicherndialog.getFile();
        if (dateiname != null) {
            final String pfadname = speicherndialog.getDirectory();
            return this.speichereBild(pfadname + dateiname);
        }
        return false;
    }
    
    public void setzeBild(final Bild pBild) {
        this.hatOriginal = pBild.hatKopie;
        this.bildPuffern();
    }
    
    private void bildPuffern() {
        if (this.hatOriginal != null) {
            this.setSize(this.hatOriginal.getWidth(null), this.hatOriginal.getHeight(null));
            this.hatKopie = new BufferedImage(this.hatOriginal.getWidth(null), this.hatOriginal.getHeight(null), 2);
            final Graphics2D graphics = this.hatKopie.createGraphics();
            graphics.drawImage(this.hatOriginal, 0, 0, this);
            this.repaint();
        }
    }
    
    @Override
    public void paint(final Graphics g) {
        if (this.hatKopie != null) {
            ((Graphics2D)g).drawImage(this.hatKopie, 0, 0, this);
        }
    }
    
    public void bildGeklickt() {
        final Class[] formparas = { null };
        final Bild[] meinBild = { null };
        if (this.zGeklicktBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zGeklicktBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" des Bilds: " + e0.getTargetException().toString());
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Bild.class;
                        final Method methode = sumEreignis.getMethod(this.zGeklicktBearbeiter, (Class[])formparas);
                        meinBild[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinBild);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" des Bilds: " + e2.getTargetException().toString());
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zGeklicktBearbeiter + "\" des Bilds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("Bild: " + e3.toString());
            }
        }
    }
    
    public void bekommtFokus() {
        final Class[] formparas = { null };
        final Bild[] meinBild = { null };
        this.zHatFocus = true;
        if (this.zFokusErhaltenBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zFokusErhaltenBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zFokusErhaltenBearbeiter + "\" des Bilds: " + e0.getTargetException().toString());
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Bild.class;
                        final Method methode = sumEreignis.getMethod(this.zFokusErhaltenBearbeiter, (Class[])formparas);
                        meinBild[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinBild);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zFokusErhaltenBearbeiter + "\" des Bilds: " + e2.getTargetException().toString());
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zFokusErhaltenBearbeiter + "\" des Bilds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void verliertFokus() {
        final Class[] formparas = { null };
        final Bild[] meinBild = { null };
        this.zHatFocus = false;
        if (this.zFokusVerlorenBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zFokusVerlorenBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zFokusVerlorenBearbeiter + "\" des Bilds: " + e0.getTargetException().toString());
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Bild.class;
                        final Method methode = sumEreignis.getMethod(this.zFokusVerlorenBearbeiter, (Class[])formparas);
                        meinBild[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinBild);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zFokusVerlorenBearbeiter + "\" des Bilds: " + e2.getTargetException().toString());
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zFokusVerlorenBearbeiter + "\" des Bilds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void setzeGroesse(final double pBreite, final double pHoehe) {
        this.setSize((int)pBreite, (int)pHoehe);
        if (this.hatOriginal != null) {
            final ImageFilter groesseFilter = new ReplicateScaleFilter((int)pBreite, (int)pHoehe);
            final ImageProducer imageprod = new FilteredImageSource(this.hatKopie.getSource(), groesseFilter);
            final Image img = this.createImage(imageprod);
            this.hatOriginal = img;
            this.bildPuffern();
        }
    }
    
    public void setzePosition(final double pWohinH, final double pWohinV) {
        this.setLocation((int)pWohinH, (int)pWohinV);
        if (this.hatOriginal != null) {
            this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
            Bildschirm.topFenster.loescheAlles();
        }
    }
    
    public int links() {
        return this.getLocation().x;
    }
    
    public int oben() {
        return this.getLocation().y;
    }
    
    public int breite() {
        return this.getSize().width;
    }
    
    public int hoehe() {
        return this.getSize().height;
    }
    
    public void verstecke() {
        this.setVisible(false);
    }
    
    public void zeige() {
        this.setVisible(true);
    }
    
    public boolean istSichtbar() {
        return this.isVisible();
    }
    
    public void deaktiviere() {
        this.setEnabled(false);
    }
    
    public void aktiviere() {
        this.setEnabled(true);
    }
    
    public boolean istAktiv() {
        return this.isEnabled();
    }
    
    public boolean besitztFocus() {
        return this.zHatFocus;
    }
    
    public void setzeFocus() {
        this.requestFocus();
    }
    
    public void gibFrei() {
        final JPanel lPanel = (JPanel)this.getParent();
        lPanel.remove(this);
        lPanel.repaint();
        this.hatOriginal = null;
        this.hatKopie = null;
    }
    
    public int rotanteil(final int pH, final int pV) {
        final int rgba = this.hatKopie.getRGB(pH, pV);
        final int rot = rgba >> 16 & 0xFF;
        return rot;
    }
    
    public int gruenanteil(final int pH, final int pV) {
        final int rgba = this.hatKopie.getRGB(pH, pV);
        final int gruen = rgba >> 8 & 0xFF;
        return gruen;
    }
    
    public int blauanteil(final int pH, final int pV) {
        final int rgba = this.hatKopie.getRGB(pH, pV);
        final int blau = rgba & 0xFF;
        return blau;
    }
    
    public int alphaanteil(final int pH, final int pV) {
        final int rgba = this.hatKopie.getRGB(pH, pV);
        final int alpha = rgba >> 24 & 0xFF;
        return alpha;
    }
    
    public void setzeRotanteil(final int pH, final int pV, final int pRot) {
        int rgba = this.hatKopie.getRGB(pH, pV);
        final int rot = pRot;
        final int gruen = rgba >> 8 & 0xFF;
        final int blau = rgba & 0xFF;
        final int alpha = rgba >> 24 & 0xFF;
        rgba = (alpha << 24 | rot << 16 | gruen << 8 | blau);
        this.hatKopie.setRGB(pH, pV, rgba);
    }
    
    public void setzeGruenanteil(final int pH, final int pV, final int pGruen) {
        int rgba = this.hatKopie.getRGB(pH, pV);
        int gruen = pGruen;
        final int rot = rgba >> 16 & 0xFF;
        gruen = pGruen;
        final int blau = rgba & 0xFF;
        final int alpha = rgba >> 24 & 0xFF;
        rgba = (alpha << 24 | rot << 16 | gruen << 8 | blau);
        this.hatKopie.setRGB(pH, pV, rgba);
    }
    
    public void setzeBlauanteil(final int pH, final int pV, final int pBlau) {
        int rgba = this.hatKopie.getRGB(pH, pV);
        final int rot = rgba >> 16 & 0xFF;
        final int gruen = rgba >> 8 & 0xFF;
        final int blau = pBlau;
        final int alpha = rgba >> 24 & 0xFF;
        rgba = (alpha << 24 | rot << 16 | gruen << 8 | blau);
        this.hatKopie.setRGB(pH, pV, rgba);
    }
    
    public void setzeAlphaanteil(final int pH, final int pV, final int pAlpha) {
        int rgba = this.hatKopie.getRGB(pH, pV);
        final int rot = rgba >> 16 & 0xFF;
        final int gruen = rgba >> 8 & 0xFF;
        final int blau = rgba & 0xFF;
        final int alpha = pAlpha;
        rgba = (alpha << 24 | rot << 16 | gruen << 8 | blau);
        this.hatKopie.setRGB(pH, pV, rgba);
    }
    
    public void filter(final ImageFilter pFilter) {
        final ImageProducer imageprod = new FilteredImageSource(this.hatKopie.getSource(), pFilter);
        final Image img = this.createImage(imageprod);
        this.hatOriginal = img;
        this.bildPuffern();
    }
    
    private class BildReaktor extends MouseAdapter
    {
        @Override
        public void mouseEntered(final MouseEvent e) {
        }
        
        @Override
        public void mousePressed(final MouseEvent e) {
        }
        
        @Override
        public void mouseReleased(final MouseEvent e) {
            Bild.this.bildGeklickt();
        }
    }
    
    private class BildTastenReaktor implements KeyListener
    {
        @Override
        public void keyTyped(final KeyEvent e) {
        }
        
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == 10) {
                Bild.this.bildGeklickt();
            }
        }
        
        @Override
        public void keyReleased(final KeyEvent e) {
        }
    }
    
    private class BildFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Bild.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Bild.this.verliertFokus();
        }
    }
}
