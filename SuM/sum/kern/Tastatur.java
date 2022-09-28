// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

import javax.swing.JFrame;

public class Tastatur
{
    private boolean zGetestet;
    
    public Tastatur() {
        this.zGetestet = false;
    }
    
    public boolean wurdeGedrueckt() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return Bildschirm.hatPrivatschirm != null && Bildschirm.hatPrivatschirm.hatTastaturpuffer.size() > 0 && (this.zGetestet = true);
    }
    
    public char zeichen() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        if (Bildschirm.hatPrivatschirm == null) {
            final Warnung warnung = new Warnung(Bildschirm.hatPrivatschirm, "Der Bildschirm wurde nicht erzeugt.");
            if (warnung.istOk()) {
                System.exit(0);
            }
            return '\0';
        }
        if (!this.zGetestet) {
            final Warnung warnung = new Warnung(Bildschirm.hatPrivatschirm, "Die Tastatur wurde nicht getestet.");
            if (warnung.istOk()) {
                System.exit(0);
            }
            return '\0';
        }
        final Integer merke = Bildschirm.hatPrivatschirm.hatTastaturpuffer.elementAt(0);
        return (char)(int)merke;
    }
    
    public void weiter() {
        try {
            Thread.sleep(1L);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        if (!this.zGetestet) {
            final Warnung warnung = new Warnung(Bildschirm.hatPrivatschirm, "Die Tastatur wurde nicht getestet.");
            if (warnung.istOk()) {
                System.exit(0);
            }
        }
        else {
            this.zGetestet = false;
            Bildschirm.hatPrivatschirm.hatTastaturpuffer.removeElementAt(0);
        }
    }
    
    public void gibFrei() {
    }
}
