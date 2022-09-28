// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

import javax.swing.JFrame;

public class Maus
{
    public int hPosition() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        if (Bildschirm.topFenster != null) {
            return Bildschirm.topFenster.zMausHatPositionX;
        }
        final Warnung warnung = new Warnung(Bildschirm.topFenster, "Der Bildschirm wurde nicht erzeugt.");
        warnung.setVisible(true);
        if (warnung.istOk()) {
            System.exit(0);
        }
        return -1;
    }
    
    public int vPosition() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        if (Bildschirm.topFenster != null) {
            return Bildschirm.topFenster.zMausHatPositionY;
        }
        final Warnung warnung = new Warnung(Bildschirm.topFenster, "Der Bildschirm wurde nicht erzeugt.");
        warnung.setVisible(true);
        if (warnung.istOk()) {
            System.exit(0);
        }
        return -1;
    }
    
    public boolean istGedrueckt() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        if (Bildschirm.topFenster != null) {
            return Bildschirm.topFenster.zTasteIstUnten;
        }
        final Warnung warnung = new Warnung(Bildschirm.topFenster, "Der Bildschirm wurde nicht erzeugt.");
        warnung.setVisible(true);
        if (warnung.istOk()) {
            System.exit(0);
        }
        return false;
    }
    
    public boolean spezialKlick() {
        return this.doppelKlick();
    }
    
    public boolean doppelKlick() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        if (Bildschirm.topFenster == null) {
            final Warnung warnung = new Warnung(Bildschirm.topFenster, "Der Bildschirm wurde nicht erzeugt.");
            if (warnung.istOk()) {
                System.exit(0);
            }
            return false;
        }
        if (Bildschirm.topFenster.zTasteIstDoppel) {
            Bildschirm.topFenster.zTasteIstDoppel = false;
            return true;
        }
        return false;
    }
    
    public void gibFrei() {
    }
}
