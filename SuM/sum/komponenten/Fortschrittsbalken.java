// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import javax.swing.JComponent;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;
import javax.swing.JProgressBar;
import java.io.Serializable;

public class Fortschrittsbalken extends Komponente implements Serializable
{
    private JProgressBar hatProgressBar;
    
    public Fortschrittsbalken(final Fenster pFenster, final int pStil, final int pMinWert, final int pMaxWert) {
        this(pFenster, 10.0, 10.0, 10.0, 10.0, pMinWert, pMaxWert);
    }
    
    public Fortschrittsbalken(final int pStil, final int pMinWert, final int pMaxWert) {
        this(10.0, 10.0, 10.0, 10.0, pMinWert, pMaxWert);
    }
    
    public Fortschrittsbalken(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pMinWert, final int pMaxWert) {
        if (pHoehe > pBreite) {
            this.hatProgressBar = new JProgressBar(1, pMinWert, pMaxWert);
        }
        else {
            this.hatProgressBar = new JProgressBar(0, pMinWert, pMaxWert);
        }
        this.hatProgressBar.setOpaque(true);
        Bildschirm.topFenster.privatPanel().add(this.hatProgressBar, 0);
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatProgressBar);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Fortschrittsbalken(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pMinWert, final int pMaxWert) {
        if (pHoehe > pBreite) {
            this.hatProgressBar = new JProgressBar(1, pMinWert, pMaxWert);
        }
        else {
            this.hatProgressBar = new JProgressBar(0, pMinWert, pMaxWert);
        }
        this.hatProgressBar.setOpaque(true);
        pFenster.privatPanel().add(this.hatProgressBar, 0);
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatProgressBar);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public void setzeWert(final int pWert) {
        this.hatProgressBar.setValue(pWert);
        this.hatProgressBar.paintImmediately(0, 0, this.hatProgressBar.getWidth(), this.hatProgressBar.getHeight());
    }
    
    public int wert() {
        return this.hatProgressBar.getValue();
    }
    
    public void setzeMinimum(final int pWert) {
        this.hatProgressBar.setMinimum(pWert);
    }
    
    public int minimum() {
        return this.hatProgressBar.getMinimum();
    }
    
    public void setzeMaximum(final int pWert) {
        this.hatProgressBar.setMaximum(pWert);
    }
    
    public int maximum() {
        return this.hatProgressBar.getMaximum();
    }
}
