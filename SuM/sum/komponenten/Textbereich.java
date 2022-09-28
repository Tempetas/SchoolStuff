// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import javax.swing.JComponent;
import sum.ereignis.Fenster;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.io.Serializable;

public abstract class Textbereich extends Markierungskomponente implements Serializable, ScrollPaneConstants
{
    protected JScrollPane hatScrollPane;
    
    public Textbereich(final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        (this.hatScrollPane = new JScrollPane(22, 31)).setSize(new Dimension(10, 10));
        Bildschirm.topFenster.privatPanel().add(this.hatScrollPane, 0);
    }
    
    public Textbereich(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        (this.hatScrollPane = new JScrollPane(22, 31)).setSize(new Dimension(10, 10));
        pFenster.privatPanel().add(this.hatScrollPane, 0);
    }
    
    @Override
    protected void lerneKomponenteKennen(final Bildschirm pFenster, final JComponent pKomponente) {
        this.hatScrollPane.setViewportView(pKomponente);
        super.lerneKomponenteKennen(pFenster, pKomponente);
    }
    
    @Override
    public void setzeGroesse(final double pBreite, final double pHoehe) {
        super.setzeGroesse(pBreite, pHoehe);
        this.hatScrollPane.setSize((int)pBreite, (int)pHoehe);
        this.hatScrollPane.revalidate();
    }
    
    @Override
    public void setzePosition(final double pWohinH, final double pWohinV) {
        this.hatScrollPane.setLocation((int)pWohinH, (int)pWohinV);
    }
    
    @Override
    public abstract void fuegeEin(final String p0, final int p1);
    
    @Override
    public abstract void haengeAn(final String p0);
    
    @Override
    public abstract void haengeAn(final char p0);
    
    @Override
    public abstract void haengeAn(final int p0);
    
    @Override
    public abstract void haengeAn(final double p0);
}
