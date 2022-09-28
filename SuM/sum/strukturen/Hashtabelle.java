// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import sum.werkzeuge.Rechner;
import java.io.Serializable;

public class Hashtabelle<Typ extends Schluesselobjekt> implements Serializable
{
    static final long serialVersionUID = 8311777060802L;
    private Rechner hatRechner;
    private Object hatGeloescht;
    private Object[] zFeld;
    private int zGroesse;
    private int zAnzahl;
    
    public Hashtabelle() {
        this.zGroesse = 11;
        this.zFeld = new Object[this.zGroesse];
        this.hatRechner = new Rechner();
        this.hatGeloescht = new Object();
        this.zAnzahl = 0;
    }
    
    public Hashtabelle(final int pGroesse) {
        this.zGroesse = pGroesse;
        this.zFeld = new Object[this.zGroesse];
        this.hatRechner = new Rechner();
        this.hatGeloescht = new Object();
        this.zAnzahl = 0;
    }
    
    private int h(final Object pObject) {
        final int lHashcode = pObject.hashCode();
        return this.hatRechner.betrag(lHashcode) % this.zGroesse;
    }
    
    public void fuegeEin(final Schluesselobjekt pSchluesselobjekt) {
        if (this.suche(pSchluesselobjekt.schluessel()) == null) {
            int lPosition;
            for (lPosition = this.h(pSchluesselobjekt.schluessel()); !this.leer(lPosition) && !this.geloescht(lPosition); lPosition = ++lPosition % this.zGroesse) {}
            this.zFeld[lPosition] = pSchluesselobjekt;
            ++this.zAnzahl;
            if (this.zAnzahl / 0.75 > this.zGroesse) {
                this.rehash();
            }
        }
    }
    
    @Override
    public String toString() {
        String lString = "";
        for (int i = 0; i < this.zGroesse; ++i) {
            if (this.leer(i)) {
                lString += "leer\n";
            }
            else if (this.geloescht(i)) {
                lString += "gel&ouml;scht\n";
            }
            else {
                final Schluesselobjekt lSchluesselobjekt = (Schluesselobjekt)this.zFeld[i];
                lString = lString + this.zFeld[i].toString() + " (" + lSchluesselobjekt.schluessel().hashCode() + " )\n";
            }
        }
        return lString;
    }
    
    private boolean leer(final int pPosition) {
        return this.zFeld[pPosition] == null;
    }
    
    private boolean geloescht(final int pPosition) {
        return this.zFeld[pPosition].equals(this.hatGeloescht);
    }
    
    public void loesche(final Object pSchluessel) {
        boolean lGefunden;
        int lPosition;
        Schluesselobjekt lSchluesselobjekt;
        for (lGefunden = false, lPosition = this.h(pSchluessel); !this.leer(lPosition) && !lGefunden; lPosition = ++lPosition % this.zGroesse) {
            if (!this.geloescht(lPosition)) {
                lSchluesselobjekt = (Schluesselobjekt)this.zFeld[lPosition];
                lGefunden = lSchluesselobjekt.schluessel().equals(pSchluessel);
            }
            if (!lGefunden) {}
        }
        if (lGefunden) {
            this.zFeld[lPosition] = this.hatGeloescht;
            --this.zAnzahl;
        }
    }
    
    public Typ suche(final Object pSchluessel) {
        boolean lGefunden;
        int lPosition;
        Schluesselobjekt lSchluesselobjekt;
        for (lGefunden = false, lPosition = this.h(pSchluessel); !this.leer(lPosition) && !lGefunden; lPosition = ++lPosition % this.zGroesse) {
            if (!this.geloescht(lPosition)) {
                lSchluesselobjekt = (Schluesselobjekt)this.zFeld[lPosition];
                lGefunden = lSchluesselobjekt.schluessel().equals(pSchluessel);
            }
            if (!lGefunden) {}
        }
        if (lGefunden) {
            return (Typ)this.zFeld[lPosition];
        }
        return null;
    }
    
    private void rehash() {
        final Object[] lAltesFeld = this.zFeld;
        final int lAlteGroesse = this.zGroesse;
        this.zGroesse = this.zGroesse * 2 + 1;
        this.zFeld = new Object[this.zGroesse];
        this.zAnzahl = 0;
        for (int i = 0; i < lAlteGroesse; ++i) {
            if (lAltesFeld[i] != null && !lAltesFeld[i].equals(this.hatGeloescht)) {
                final Schluesselobjekt lSchluesselobjekt = (Schluesselobjekt)lAltesFeld[i];
                this.fuegeEin(lSchluesselobjekt);
            }
        }
    }
    
    public void entferneAlleElemente() {
        for (int i = 0; i < this.zGroesse; ++i) {
            this.zFeld[i] = null;
        }
        this.zAnzahl = 0;
    }
}
