// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

public class Fenster extends Bildschirm
{
    public Fenster() {
        super(0, 0, -1, -1, "SuM-Fenster " + (Fenster.zFensternummer + 1), false);
    }
    
    public Fenster(final String pName) {
        super(0, 0, -1, -1, pName, false);
    }
    
    public Fenster(final boolean pMitDoubleBuffering) {
        super(0, 0, -1, -1, "SuM-Fenster" + (Fenster.zFensternummer + 1), pMitDoubleBuffering);
    }
    
    public Fenster(final String pName, final boolean pMitDoubleBuffering) {
        super(0, 0, -1, -1, pName, pMitDoubleBuffering);
    }
    
    public Fenster(final int pBreite, final int pHoehe) {
        super(0, 0, pBreite, pHoehe, "SuM-Fenster " + (Fenster.zFensternummer + 1), false);
    }
    
    public Fenster(final int pBreite, final int pHoehe, final String pName) {
        super(0, 0, pBreite, pHoehe, pName, false);
    }
    
    public Fenster(final int pBreite, final int pHoehe, final String pName, final boolean pMitDoubleBuffering) {
        super(0, 0, pBreite, pHoehe, pName, pMitDoubleBuffering);
    }
    
    public Fenster(final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        super(0, 0, pBreite, pHoehe, "SuM-Fenster " + (Fenster.zFensternummer + 1), pMitDoubleBuffering);
    }
    
    public Fenster(final int pLinks, final int pOben, final int pBreite, final int pHoehe, final String pName) {
        super(pLinks, pOben, pBreite, pHoehe, pName, false);
    }
    
    public Fenster(final int pLinks, final int pOben, final int pBreite, final int pHoehe) {
        super(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (Fenster.zFensternummer + 1), false);
    }
    
    public Fenster(final int pLinks, final int pOben, final int pBreite, final int pHoehe, final String pName, final boolean pMitDoubleBuffering) {
        super(pLinks, pOben, pBreite, pHoehe, pName, false);
    }
    
    public Fenster(final int pLinks, final int pOben, final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        super(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (Fenster.zFensternummer + 1), false);
    }
}
