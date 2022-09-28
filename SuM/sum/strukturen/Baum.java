// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import sum.werkzeuge.Textwerkzeug;
import java.io.Serializable;

public class Baum<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060602L;
    private Typ kenntInhalt;
    private Baum<Typ> kenntLinks;
    private Baum kenntRechts;
    private Baum<Typ> kenntVater;
    
    public Baum(final Typ pInhalt) {
        this.kenntInhalt = pInhalt;
        this.kenntLinks = null;
        this.kenntRechts = null;
        this.kenntVater = null;
    }
    
    public Baum(final Typ pInhalt, final Baum<Typ> pLinks, final Baum<Typ> pRechts) {
        this.kenntInhalt = pInhalt;
        this.kenntLinks = pLinks;
        if (pLinks != null) {
            pLinks.setzeVater(this);
        }
        if ((this.kenntRechts = pRechts) != null) {
            pRechts.setzeVater(this);
        }
        this.kenntVater = null;
    }
    
    public Typ inhalt() {
        return this.kenntInhalt;
    }
    
    public void setzeInhalt(final Typ pInhalt) {
        this.kenntInhalt = pInhalt;
    }
    
    public boolean istLeer() {
        return this.kenntInhalt == null;
    }
    
    public boolean teilbaeumeLeer() {
        return this.kenntLinks.istLeer() && this.kenntRechts.istLeer();
    }
    
    public Baum<Typ> linkerTeilbaum() {
        return this.kenntLinks;
    }
    
    public Baum<Typ> rechterTeilbaum() {
        return this.kenntRechts;
    }
    
    public void setzeLinkenTeilbaum(final Baum<Typ> pBaum) {
        this.kenntLinks = pBaum;
        if (pBaum != null) {
            pBaum.setzeVater(this);
        }
    }
    
    public void setzeRechtenTeilbaum(final Baum<Typ> pBaum) {
        this.kenntRechts = pBaum;
        if (pBaum != null) {
            pBaum.setzeVater(this);
        }
    }
    
    public boolean istBlatt() {
        return this.kenntLinks == null && this.kenntRechts == null;
    }
    
    public Baum<Typ> vater() {
        return this.kenntVater;
    }
    
    public void setzeVater(final Baum<Typ> pBaum) {
        this.kenntVater = pBaum;
    }
    
    public boolean istWurzel() {
        return this.kenntVater == null;
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
        for (int i = 1; i <= pTiefe; ++i) {
            lPunkte += ".";
        }
        if (this.kenntLinks != null) {
            lString += this.kenntLinks.baumString(pTiefe + 1);
        }
        if (this.kenntInhalt == null) {
            lString = lString + lPunkte + "leer\n";
        }
        else {
            lString = lString + lPunkte + this.kenntInhalt.toString() + "\n";
        }
        if (this.kenntRechts != null) {
            lString += this.kenntRechts.baumString(pTiefe + 1);
        }
        return lString;
    }
}
