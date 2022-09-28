// 
// Decompiled by Procyon v0.5.36
// 

package sum.ereignis;

import javax.swing.UIManager;
import java.io.Serializable;

public class Ereignisanwendung implements Runnable, Serializable
{
    public Bildschirm hatBildschirm;
    private Thread sumThread;
    public static Ereignisanwendung hatSuMPrivateAnwendung;
    private boolean zFuehrtAus;
    
    public Ereignisanwendung() {
        this.zFuehrtAus = false;
        Ereignisanwendung.hatSuMPrivateAnwendung = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatBildschirm = new Bildschirm();
    }
    
    public Ereignisanwendung(final boolean pMitDoubleBuffering) {
        this.zFuehrtAus = false;
        Ereignisanwendung.hatSuMPrivateAnwendung = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatBildschirm = new Bildschirm(pMitDoubleBuffering);
    }
    
    public Ereignisanwendung(final int pBreite, final int pHoehe) {
        this.zFuehrtAus = false;
        Ereignisanwendung.hatSuMPrivateAnwendung = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatBildschirm = new Bildschirm(pBreite, pHoehe);
    }
    
    public Ereignisanwendung(final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        this.zFuehrtAus = false;
        Ereignisanwendung.hatSuMPrivateAnwendung = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatBildschirm = new Bildschirm(pBreite, pHoehe, pMitDoubleBuffering);
    }
    
    public Ereignisanwendung(final int pLinks, final int pOben, final int pBreite, final int pHoehe) {
        this.zFuehrtAus = false;
        Ereignisanwendung.hatSuMPrivateAnwendung = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatBildschirm = new Bildschirm(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster" + (Bildschirm.zFensternummer + 1), false);
    }
    
    public Ereignisanwendung(final int pLinks, final int pOben, final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        this.zFuehrtAus = false;
        Ereignisanwendung.hatSuMPrivateAnwendung = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatBildschirm = new Bildschirm(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster" + (Bildschirm.zFensternummer + 1), pMitDoubleBuffering);
    }
    
    protected void melde(final String s) {
        System.out.println(s);
    }
    
    public Bildschirm bildschirm() {
        return this.hatBildschirm;
    }
    
    public void fuehreAus() {
        if (this.sumThread == null) {
            this.warte(500L);
            this.zFuehrtAus = true;
            (this.sumThread = new Thread(this)).start();
        }
    }
    
    protected void halteAn() {
        this.zFuehrtAus = false;
    }
    
    public void beenden() {
        this.halteAn();
        this.hatBildschirm.gibFrei();
        System.exit(0);
    }
    
    protected boolean fuehrtAus() {
        return this.zFuehrtAus;
    }
    
    @Override
    public void run() {
        while (this.zFuehrtAus) {
            try {
                this.bearbeiteLeerlauf();
                Thread.sleep(30L);
            }
            catch (InterruptedException e) {}
        }
    }
    
    protected void warte(final long pMillisekunden) {
        final long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < pMillisekunden) {}
    }
    
    public void bearbeiteTaste(final char pZeichen) {
    }
    
    public void bearbeiteMausDruck(final int pWoH, final int pWoV) {
    }
    
    public void bearbeiteMausLos(final int pWoH, final int pWoV) {
    }
    
    public void bearbeiteMausBewegt(final int pWohinH, final int pWohinV) {
    }
    
    public void bearbeiteDoppelKlick(final int pWoH, final int pWoV) {
    }
    
    public void bearbeiteLeerlauf() {
    }
    
    public void bearbeiteUpdate() {
    }
    
    public void bearbeiteFokusErhalten() {
    }
    
    public void bearbeiteFokusVerloren() {
    }
    
    public boolean besitztFokus() {
        return this.hatBildschirm.besitztFokus();
    }
    
    public void setzeFokus() {
        this.hatBildschirm.requestFocus();
    }
    
    public void gibFrei() {
        this.hatBildschirm.gibFrei();
    }
}
