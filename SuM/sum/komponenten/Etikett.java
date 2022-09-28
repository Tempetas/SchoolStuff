// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import javax.swing.JLabel;
import java.io.Serializable;

public class Etikett extends Textkomponente implements Serializable
{
    private JLabel hatLabel;
    
    public Etikett(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        (this.hatLabel = new JLabel(pText)).setOpaque(false);
        Bildschirm.topFenster.privatPanel().add(this.hatLabel, 0);
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatLabel);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Etikett(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pZahl) {
        this(pLinks, pOben, pBreite, pHoehe, "" + pZahl);
    }
    
    public Etikett(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final double pZahl) {
        this(pLinks, pOben, pBreite, pHoehe, "" + pZahl);
    }
    
    public Etikett(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        (this.hatLabel = new JLabel(pText)).setOpaque(false);
        pFenster.privatPanel().add(this.hatLabel, 0);
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatLabel);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Etikett(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pZahl) {
        this(pFenster, pLinks, pOben, pBreite, pHoehe, "" + pZahl);
    }
    
    public Etikett(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final double pZahl) {
        this(pFenster, pLinks, pOben, pBreite, pHoehe, "" + pZahl);
    }
    
    @Override
    public void setzeInhalt(final String pText) {
        this.hatLabel.setText(pText);
        this.kenntFenster.doUpdate((JComponent)this.hatLabel);
    }
    
    public void fuegeEin(final String pText, final int pStelle) {
        final String s = this.hatLabel.getText();
        final String s2 = s.substring(0, pStelle - 1);
        final String s3 = s.substring(pStelle, s.length());
        this.hatLabel.setText(s2 + pText + s3);
        this.kenntFenster.doUpdate((JComponent)this.hatLabel);
    }
    
    public void haengeAn(final String pText) {
        this.hatLabel.setText(this.hatLabel.getText() + pText);
        this.kenntFenster.doUpdate((JComponent)this.hatLabel);
    }
    
    public void haengeAn(final char pZeichen) {
        this.hatLabel.setText(this.hatLabel.getText() + pZeichen);
        this.kenntFenster.doUpdate((JComponent)this.hatLabel);
    }
    
    public void haengeAn(final int pZahl) {
        this.hatLabel.setText(this.hatLabel.getText() + pZahl);
        this.kenntFenster.doUpdate((JComponent)this.hatLabel);
    }
    
    public void haengeAn(final double pZahl) {
        this.hatLabel.setText(this.hatLabel.getText() + pZahl);
        this.kenntFenster.doUpdate((JComponent)this.hatLabel);
    }
    
    public void setzeAusrichtung(final int pAusrichtung) {
        switch (pAusrichtung) {
            case 0: {
                this.hatLabel.setHorizontalAlignment(2);
                break;
            }
            case 1: {
                this.hatLabel.setHorizontalAlignment(0);
                break;
            }
            case 2: {
                this.hatLabel.setHorizontalAlignment(4);
                break;
            }
        }
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatLabel.getText();
    }
}
