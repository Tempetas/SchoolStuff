// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import sum.werkzeuge.Textwerkzeug;
import java.io.Serializable;

public class Binaerbaum<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060302L;
    Typ kenntInhalt;
    Binaerbaum<Typ> kenntLinkenNachfolger;
    Binaerbaum<Typ> kenntRechtenNachfolger;
    Binaerbaum<Typ> kenntVater;
    
    public Binaerbaum() {
        this.kenntInhalt = null;
        this.kenntLinkenNachfolger = null;
        this.kenntRechtenNachfolger = null;
        this.kenntVater = null;
    }
    
    public Binaerbaum(final Typ pInhalt) {
        this.kenntInhalt = pInhalt;
        (this.kenntLinkenNachfolger = this.neuerLeererBaum()).setzeVater(this);
        (this.kenntRechtenNachfolger = this.neuerLeererBaum()).setzeVater(this);
    }
    
    public Binaerbaum(final Typ pInhalt, final Binaerbaum<Typ> pLinkerBaum, final Binaerbaum<Typ> pRechterBaum) {
        this.kenntInhalt = pInhalt;
        this.kenntLinkenNachfolger = pLinkerBaum;
        this.kenntRechtenNachfolger = pRechterBaum;
        this.kenntLinkenNachfolger.setzeVater(this);
        this.kenntRechtenNachfolger.setzeVater(this);
    }
    
    private Binaerbaum<Typ> neuerLeererBaum() {
        Object lBaum = null;
        try {
            lBaum = this.getClass().newInstance();
        }
        catch (InstantiationException ie) {
            System.out.println("fehler1");
        }
        catch (IllegalAccessException ae) {
            System.out.println("fehler2");
        }
        return (Binaerbaum)lBaum;
    }
    
    public void ueberschreibeWurzel(final Typ pInhalt) {
        if (this.istLeer()) {
            this.kenntLinkenNachfolger = this.neuerLeererBaum();
            this.kenntRechtenNachfolger = this.neuerLeererBaum();
            this.kenntLinkenNachfolger.setzeVater(this);
            this.kenntRechtenNachfolger.setzeVater(this);
        }
        this.kenntInhalt = pInhalt;
    }
    
    public void haengeRechtsAn(final Binaerbaum<Typ> pBaum) {
        if (!this.istLeer()) {
            (this.kenntRechtenNachfolger = pBaum).setzeVater(this);
        }
    }
    
    public void haengeLinksAn(final Binaerbaum<Typ> pBaum) {
        if (!this.istLeer()) {
            (this.kenntLinkenNachfolger = pBaum).setzeVater(this);
        }
    }
    
    private void setzeVater(final Binaerbaum<Typ> pBaum) {
        this.kenntVater = pBaum;
    }
    
    public Binaerbaum<Typ> vater() {
        return this.kenntVater;
    }
    
    public Typ wurzelInhalt() {
        return this.kenntInhalt;
    }
    
    public Binaerbaum<Typ> linkerTeilbaum() {
        return this.kenntLinkenNachfolger;
    }
    
    public Binaerbaum<Typ> rechterTeilbaum() {
        return this.kenntRechtenNachfolger;
    }
    
    public boolean istLeer() {
        return this.kenntInhalt == null;
    }
    
    public boolean teilbaeumeLeer() {
        return this.kenntLinkenNachfolger.istLeer() && this.kenntRechtenNachfolger.istLeer();
    }
    
    @Override
    public String toString() {
        final Textwerkzeug lTextwerkzeug = new Textwerkzeug();
        String lString = this.baumString(0);
        if (lTextwerkzeug.laenge(lString) > 0) {
            lString = lTextwerkzeug.textOhne(lString, lTextwerkzeug.laenge(lString), lTextwerkzeug.laenge(lString));
        }
        return lString;
    }
    
    private String baumString(final int pTiefe) {
        String lString = "";
        String lPunkte = "";
        for (int lNiveau = 1; lNiveau <= pTiefe; ++lNiveau) {
            lPunkte += ".";
        }
        if (this.istLeer()) {
            lString = lString + lPunkte + "leer\n";
        }
        else {
            if (!this.teilbaeumeLeer()) {
                lString += this.kenntLinkenNachfolger.baumString(pTiefe + 1);
            }
            lString = lString + lPunkte + this.kenntInhalt.toString() + "\n";
            if (!this.teilbaeumeLeer()) {
                lString += this.kenntRechtenNachfolger.baumString(pTiefe + 1);
            }
        }
        return lString;
    }
}
