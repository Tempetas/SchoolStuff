// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import java.io.Serializable;

public class Suchbaum<Typ extends Ordnungsobjekt> extends Baum<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060702L;
    
    public Suchbaum(final Typ pInhalt) {
        super(pInhalt);
    }
    
    public void fuegeEin(final Typ pInhalt) {
        if (this.inhalt() == null) {
            this.setzeInhalt(pInhalt);
        }
        else if (pInhalt.istKleinerAls(this.inhalt())) {
            if (this.linkerTeilbaum() == null) {
                this.setzeLinkenTeilbaum(new Suchbaum(pInhalt));
            }
            else {
                final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.linkerTeilbaum();
                lTeilbaum.fuegeEin(pInhalt);
            }
        }
        else if (pInhalt.istGroesserAls(this.inhalt())) {
            if (this.rechterTeilbaum() == null) {
                this.setzeRechtenTeilbaum(new Suchbaum(pInhalt));
            }
            else {
                final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.rechterTeilbaum();
                lTeilbaum.fuegeEin(pInhalt);
            }
        }
    }
    
    public void loesche(final Typ pInhalt) {
        if (this.inhalt() != null) {
            if (pInhalt.istKleinerAls(this.inhalt())) {
                if (this.linkerTeilbaum() != null) {
                    final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.linkerTeilbaum();
                    lTeilbaum.loesche(pInhalt);
                }
            }
            else if (pInhalt.istGroesserAls(this.inhalt())) {
                if (this.rechterTeilbaum() != null) {
                    final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.rechterTeilbaum();
                    lTeilbaum.loesche(pInhalt);
                }
            }
            else if (this.linkerTeilbaum() == null && this.rechterTeilbaum() == null) {
                final Suchbaum<Typ> lVater = (Suchbaum)this.vater();
                if (lVater != null) {
                    if (lVater.linkerTeilbaum() == this) {
                        lVater.setzeLinkenTeilbaum(null);
                    }
                    else {
                        lVater.setzeRechtenTeilbaum(null);
                    }
                }
                else {
                    this.setzeInhalt(null);
                }
            }
            else if (this.linkerTeilbaum() == null) {
                this.setzeInhalt(this.rechterTeilbaum().inhalt());
                this.setzeLinkenTeilbaum(this.rechterTeilbaum().linkerTeilbaum());
                this.setzeRechtenTeilbaum(this.rechterTeilbaum().rechterTeilbaum());
            }
            else if (this.rechterTeilbaum() == null) {
                this.setzeInhalt(this.linkerTeilbaum().inhalt());
                this.setzeLinkenTeilbaum(this.linkerTeilbaum().linkerTeilbaum());
                this.setzeRechtenTeilbaum(this.linkerTeilbaum().rechterTeilbaum());
            }
            else {
                final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.rechterTeilbaum();
                this.setzeInhalt(this.linkerTeilbaum().inhalt());
                this.setzeRechtenTeilbaum(this.linkerTeilbaum().rechterTeilbaum());
                this.setzeLinkenTeilbaum(this.linkerTeilbaum().linkerTeilbaum());
                Suchbaum<Typ> lTeilbaum2;
                for (lTeilbaum2 = this; lTeilbaum2.rechterTeilbaum() != null; lTeilbaum2 = (Suchbaum)lTeilbaum2.rechterTeilbaum()) {}
                lTeilbaum2.setzeRechtenTeilbaum(lTeilbaum);
            }
        }
    }
    
    public Typ suche(final Typ pInhalt) {
        if (this.inhalt() == null) {
            return null;
        }
        if (pInhalt.istKleinerAls(this.inhalt())) {
            if (this.linkerTeilbaum() == null) {
                return null;
            }
            final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.linkerTeilbaum();
            return lTeilbaum.suche(pInhalt);
        }
        else {
            if (!pInhalt.istGroesserAls(this.inhalt())) {
                return this.inhalt();
            }
            if (this.rechterTeilbaum() == null) {
                return null;
            }
            final Suchbaum<Typ> lTeilbaum = (Suchbaum)this.rechterTeilbaum();
            return lTeilbaum.suche(pInhalt);
        }
    }
}
