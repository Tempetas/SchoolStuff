// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.Color;
import sum.ereignis.Bildschirm;
import javax.swing.JComponent;

public abstract class Komponente
{
    private String zFokusErhaltenBearbeiter;
    private String zFokusVerlorenBearbeiter;
    private boolean zHatFokus;
    protected JComponent hatComponent;
    protected Bildschirm kenntFenster;
    
    public Komponente() {
        this.zFokusErhaltenBearbeiter = "";
        this.zFokusVerlorenBearbeiter = "";
        this.zHatFokus = false;
    }
    
    protected void init(final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        this.setzePosition(pLinks, pOben);
        this.setzeGroesse(pBreite, pHoehe);
        this.setzeFarbe(this.kenntFenster.hintergrundfarbe());
    }
    
    protected void lerneKomponenteKennen(final Bildschirm pFenster, final JComponent pKomponente) {
        this.hatComponent = pKomponente;
        this.kenntFenster = pFenster;
    }
    
    protected void setzeFokusWert(final boolean pFokus) {
        this.zHatFokus = pFokus;
    }
    
    public void setzeBearbeiterFokusVerloren(final String pBearbeiter) {
        this.zFokusVerlorenBearbeiter = pBearbeiter;
    }
    
    public void setzeBearbeiterFokusErhalten(final String pBearbeiter) {
        this.zFokusErhaltenBearbeiter = pBearbeiter;
    }
    
    protected String fokusVerlorenBearbeiter() {
        return this.zFokusVerlorenBearbeiter;
    }
    
    protected String fokusErhaltenBearbeiter() {
        return this.zFokusErhaltenBearbeiter;
    }
    
    public void setzePosition(final double pWohinH, final double pWohinV) {
        this.hatComponent.setLocation((int)pWohinH, (int)pWohinV);
    }
    
    public void setzeGroesse(final double pBreite, final double pHoehe) {
        this.hatComponent.setSize((int)pBreite, (int)pHoehe);
    }
    
    public void setzeFarbe(final Color pFarbe) {
        this.hatComponent.setBackground(pFarbe);
        this.hatComponent.repaint();
    }
    
    public void setzeFarbe(int pFarbe) {
        if (pFarbe < 0) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        switch (pFarbe) {
            case 0: {
                this.setzeFarbe(Color.black);
                break;
            }
            case 1: {
                this.setzeFarbe(Color.blue);
                break;
            }
            case 2: {
                this.setzeFarbe(Color.cyan);
                break;
            }
            case 3: {
                this.setzeFarbe(Color.darkGray);
                break;
            }
            case 4: {
                this.setzeFarbe(Color.gray);
                break;
            }
            case 5: {
                this.setzeFarbe(Color.green);
                break;
            }
            case 6: {
                this.setzeFarbe(Color.lightGray);
                break;
            }
            case 7: {
                this.setzeFarbe(Color.magenta);
                break;
            }
            case 8: {
                this.setzeFarbe(Color.orange);
                break;
            }
            case 9: {
                this.setzeFarbe(Color.pink);
                break;
            }
            case 10: {
                this.setzeFarbe(Color.red);
                break;
            }
            case 11: {
                this.setzeFarbe(Color.white);
                break;
            }
            case 12: {
                this.setzeFarbe(Color.yellow);
                break;
            }
        }
        this.hatComponent.repaint();
    }
    
    public Color farbe() {
        return this.hatComponent.getBackground();
    }
    
    public int links() {
        return this.hatComponent.getLocation().x;
    }
    
    public int oben() {
        return this.hatComponent.getLocation().y;
    }
    
    public int breite() {
        return this.hatComponent.getSize().width;
    }
    
    public int hoehe() {
        return this.hatComponent.getSize().height;
    }
    
    public void verstecke() {
        this.hatComponent.setVisible(false);
    }
    
    public void zeige() {
        this.hatComponent.setVisible(true);
    }
    
    public boolean istSichtbar() {
        return this.hatComponent.isVisible();
    }
    
    public void deaktiviere() {
        this.hatComponent.setEnabled(false);
    }
    
    public void aktiviere() {
        this.hatComponent.setEnabled(true);
    }
    
    public boolean istAktiv() {
        return this.hatComponent.isEnabled();
    }
    
    public boolean besitztFokus() {
        return this.zHatFokus;
    }
    
    public void setzeFokus() {
        this.hatComponent.requestFocus();
    }
    
    public void setzeHinweis(final String pText) {
        this.hatComponent.setToolTipText(pText);
    }
    
    public void gibFrei() {
    }
}
