// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

import java.awt.Component;
import javax.swing.JColorChooser;
import java.awt.Color;

public class Farbe
{
    public static final int SCHWARZ = 0;
    public static final int BLAU = 1;
    public static final int CYAN = 2;
    public static final int DUNKELGRAU = 3;
    public static final int GRAU = 4;
    public static final int GRUEN = 5;
    public static final int HELLGRAU = 6;
    public static final int MAGENTA = 7;
    public static final int ORANGE = 8;
    public static final int PINK = 9;
    public static final int ROT = 10;
    public static final int WEISS = 11;
    public static final int GELB = 12;
    
    public static final Color rgb(final int pR, final int pG, final int pB) {
        return new Color(pR, pG, pB);
    }
    
    public static final Color neueFarbe(final Color pAlteFarbe) {
        final Color neueFarbe = JColorChooser.showDialog(Bildschirm.hatPrivatschirm, "Farbauswahl", pAlteFarbe);
        if (neueFarbe != null) {
            return neueFarbe;
        }
        return pAlteFarbe;
    }
}
