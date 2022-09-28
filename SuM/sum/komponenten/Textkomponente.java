// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.Color;
import sum.ereignis.Schrift;
import java.awt.Font;

public abstract class Textkomponente extends Komponente
{
    protected String zAktuellFont;
    protected int zSchriftStil;
    protected int zSchriftGroesse;
    protected Font zSchriftArt;
    
    public Textkomponente() {
        this.zAktuellFont = "Helvetica";
        this.zSchriftStil = 0;
        this.zSchriftGroesse = 12;
        this.zSchriftArt = Schrift.STANDARDSCHRIFT;
    }
    
    protected void init(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pInhalt) {
        super.init(pLinks, pOben, pBreite, pHoehe);
        this.setzeInhalt(pInhalt);
    }
    
    public abstract void setzeInhalt(final String p0);
    
    public void setzeInhalt(final char pZeichen) {
        this.setzeInhalt("" + pZeichen);
    }
    
    public void setzeInhalt(final int pZahl) {
        this.setzeInhalt("" + pZahl);
    }
    
    public void setzeInhalt(final long pZahl) {
        this.setzeInhalt("" + pZahl);
    }
    
    public void setzeInhalt(final double pZahl) {
        this.setzeInhalt("" + pZahl);
    }
    
    public boolean inhaltIstText() {
        return !this.inhaltIstGanzeZahl() && !this.inhaltIstZahl();
    }
    
    public boolean inhaltIstGanzeZahl() {
        try {
            Integer.valueOf(this.inhaltAlsText());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public boolean inhaltIstLangeGanzeZahl() {
        try {
            Long.valueOf(this.inhaltAlsText());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public boolean inhaltIstZahl() {
        try {
            Double.valueOf(this.inhaltAlsText());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public abstract String inhaltAlsText();
    
    public int inhaltAlsGanzeZahl() throws ArithmeticException {
        if (this.inhaltIstGanzeZahl()) {
            return Integer.parseInt(this.inhaltAlsText());
        }
        throw new ArithmeticException("inhaltAlsGanzeZahl: ist keine ganze Zahl");
    }
    
    public long inhaltAlsLangeGanzeZahl() throws ArithmeticException {
        if (this.inhaltIstLangeGanzeZahl()) {
            return Long.parseLong(this.inhaltAlsText());
        }
        throw new ArithmeticException("inhaltAlsLangeGanzeZahl: ist keine lange ganze Zahl");
    }
    
    public double inhaltAlsZahl() throws ArithmeticException {
        if (this.inhaltIstZahl()) {
            final Double d = new Double(this.inhaltAlsText());
            return d;
        }
        throw new ArithmeticException("inhaltAlsZahl: ist keine Zahl");
    }
    
    public void setzeSchriftArt(final String pSchriftart) {
        this.zAktuellFont = pSchriftart;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatComponent.setFont(this.zSchriftArt);
        this.hatComponent.repaint();
    }
    
    public void setzeSchriftart(final String pSchriftart) {
        this.setzeSchriftArt(pSchriftart);
    }
    
    public void setzeSchriftgroesse(final int pGroesse) {
        this.setzeSchriftGroesse(pGroesse);
    }
    
    public void setzeSchriftGroesse(final int pGroesse) {
        this.zSchriftGroesse = pGroesse;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatComponent.setFont(this.zSchriftArt);
        this.hatComponent.repaint();
    }
    
    public void setzeSchriftStil(final int pStil) {
        this.zSchriftStil = pStil;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatComponent.setFont(this.zSchriftArt);
        this.hatComponent.repaint();
    }
    
    public void setzeSchriftstil(final int pStil) {
        this.setzeSchriftStil(pStil);
    }
    
    public void setzeSchriftFarbe(final Color pFarbe) {
        this.hatComponent.setForeground(pFarbe);
        this.hatComponent.repaint();
    }
    
    public void setzeSchriftfarbe(final Color pFarbe) {
        this.setzeSchriftFarbe(pFarbe);
    }
    
    public void setzeSchriftfarbe(final int pFarbe) {
        this.setzeSchriftFarbe(pFarbe);
    }
    
    public Color schriftfarbe() {
        return this.hatComponent.getForeground();
    }
    
    public Color schriftFarbe() {
        return this.schriftfarbe();
    }
    
    public void setzeSchriftFarbe(int pFarbe) {
        if (pFarbe < 0) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        switch (pFarbe) {
            case 0: {
                this.setzeSchriftFarbe(Color.black);
                break;
            }
            case 1: {
                this.setzeSchriftFarbe(Color.blue);
                break;
            }
            case 2: {
                this.setzeSchriftFarbe(Color.cyan);
                break;
            }
            case 3: {
                this.setzeSchriftFarbe(Color.darkGray);
                break;
            }
            case 4: {
                this.setzeSchriftFarbe(Color.gray);
                break;
            }
            case 5: {
                this.setzeSchriftFarbe(Color.green);
                break;
            }
            case 6: {
                this.setzeSchriftFarbe(Color.lightGray);
                break;
            }
            case 7: {
                this.setzeSchriftFarbe(Color.magenta);
                break;
            }
            case 8: {
                this.setzeSchriftFarbe(Color.orange);
                break;
            }
            case 9: {
                this.setzeSchriftFarbe(Color.pink);
                break;
            }
            case 10: {
                this.setzeSchriftFarbe(Color.red);
                break;
            }
            case 11: {
                this.setzeSchriftFarbe(Color.white);
                break;
            }
            case 12: {
                this.setzeSchriftFarbe(Color.yellow);
                break;
            }
        }
        this.hatComponent.repaint();
    }
}
