// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import java.io.Serializable;

public class Suchbinaerbaum<Typ extends SuchbaumInhalt> extends Binaerbaum<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060402L;
    private Liste hatListe;
    
    public Suchbinaerbaum<Typ> linkerSuchbaum() {
        return (Suchbinaerbaum)this.linkerTeilbaum();
    }
    
    public Suchbinaerbaum<Typ> rechterSuchbaum() {
        return (Suchbinaerbaum)this.rechterTeilbaum();
    }
    
    public void fuegeEin(final Typ pInhalt) {
        final Typ lSuchergebnis = this.suche(pInhalt);
        if (lSuchergebnis != null) {
            lSuchergebnis.erhoeheAnzahl();
        }
        else if (this.istLeer()) {
            this.ueberschreibeWurzel(pInhalt);
        }
        else if (pInhalt.istKleiner(this.wurzelInhalt())) {
            this.linkerSuchbaum().fuegeEin(pInhalt);
        }
        else if (pInhalt.istGroesser(this.wurzelInhalt())) {
            this.rechterSuchbaum().fuegeEin(pInhalt);
        }
    }
    
    public Typ suche(final Typ pObjekt) {
        if (this.istLeer()) {
            return null;
        }
        if (pObjekt.istKleiner(this.wurzelInhalt())) {
            return this.linkerSuchbaum().suche(pObjekt);
        }
        if (pObjekt.istGroesser(this.wurzelInhalt())) {
            return this.rechterSuchbaum().suche(pObjekt);
        }
        return this.wurzelInhalt();
    }
    
    public void entferne(final Typ pObjekt) {
        if (this.istLeer()) {
            if (this.wurzelInhalt().istGleich(pObjekt)) {
                if (this.rechterSuchbaum().istLeer() && this.linkerSuchbaum().istLeer()) {
                    this.haengeRechtsAn(null);
                    this.haengeLinksAn(null);
                    this.ueberschreibeWurzel(null);
                }
                else if (this.rechterSuchbaum().istLeer()) {
                    final Suchbinaerbaum<Typ> lKnoten = this.rechterSuchbaum();
                    this.ueberschreibeWurzel(lKnoten.wurzelInhalt());
                    this.haengeLinksAn(lKnoten.linkerSuchbaum());
                    this.haengeRechtsAn(lKnoten.rechterSuchbaum());
                }
                else {
                    Suchbinaerbaum<Typ> lVaterGroesster = null;
                    Suchbinaerbaum<Typ> lGroessterLinkerKnoten;
                    for (lGroessterLinkerKnoten = this.linkerSuchbaum(); !lGroessterLinkerKnoten.rechterSuchbaum().istLeer(); lGroessterLinkerKnoten = lGroessterLinkerKnoten.rechterSuchbaum()) {
                        lVaterGroesster = lGroessterLinkerKnoten;
                    }
                    if (!lVaterGroesster.istLeer()) {
                        lVaterGroesster.haengeRechtsAn(lGroessterLinkerKnoten.linkerSuchbaum());
                        lGroessterLinkerKnoten.haengeLinksAn(this.linkerSuchbaum());
                    }
                    this.ueberschreibeWurzel(lGroessterLinkerKnoten.wurzelInhalt());
                    this.haengeLinksAn(lGroessterLinkerKnoten.linkerSuchbaum());
                }
            }
            else if (this.wurzelInhalt().istKleiner(pObjekt)) {
                this.rechterSuchbaum().entferne(pObjekt);
            }
            else {
                this.linkerSuchbaum().entferne(pObjekt);
            }
        }
    }
    
    public void entferneAlle() {
        if (!this.istLeer()) {
            this.linkerSuchbaum().entferneAlle();
            this.rechterSuchbaum().entferneAlle();
            this.entferne(this.wurzelInhalt());
        }
    }
    
    public Liste sortierteListe() {
        this.ergaenzeListe(this.hatListe = new Liste());
        return this.hatListe;
    }
    
    private void ergaenzeListe(final Liste pListe) {
        if (!this.istLeer()) {
            this.linkerSuchbaum().ergaenzeListe(pListe);
            pListe.haengeAn(this.wurzelInhalt());
            this.rechterSuchbaum().ergaenzeListe(pListe);
        }
    }
}
