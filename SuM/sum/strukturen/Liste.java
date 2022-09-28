// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import sum.werkzeuge.Textwerkzeug;
import java.io.Serializable;

public class Liste<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060102L;
    private Textwerkzeug hatTextwerkzeug;
    private Knoten<Typ> hatBug;
    private Knoten<Typ> hatHeck;
    private Knoten<Typ> kenntAktuell;
    private int zAnzahl;
    private int zPosition;
    
    public Liste() {
        this.hatBug = new Knoten<Typ>(null);
        this.hatHeck = new Knoten<Typ>(null);
        this.hatBug.setzeNachfolger(this.hatHeck);
        this.hatHeck.setzeVorgaenger(this.hatBug);
        this.kenntAktuell = this.hatBug;
        this.zAnzahl = 0;
        this.zPosition = 0;
        this.hatTextwerkzeug = new Textwerkzeug();
    }
    
    public void zumAnfang() {
        this.kenntAktuell = this.hatBug.nachfolger();
        this.zPosition = 1;
    }
    
    public void zumEnde() {
        this.kenntAktuell = this.hatHeck.vorgaenger();
        this.zPosition = this.zAnzahl;
    }
    
    public void vor() {
        if (!this.istDahinter()) {
            this.kenntAktuell = this.kenntAktuell.nachfolger();
            ++this.zPosition;
        }
    }
    
    public void zurueck() {
        if (!this.istDavor()) {
            this.kenntAktuell = this.kenntAktuell.vorgaenger();
            --this.zPosition;
        }
    }
    
    public boolean istDahinter() {
        return this.kenntAktuell == this.hatHeck;
    }
    
    public boolean istDavor() {
        return this.kenntAktuell == this.hatBug;
    }
    
    public boolean istAmAnfang() {
        return !this.istLeer() && this.kenntAktuell == this.hatBug.nachfolger();
    }
    
    public boolean istAmEnde() {
        return !this.istLeer() && this.kenntAktuell == this.hatHeck.vorgaenger();
    }
    
    public Typ aktuellesElement() {
        return this.kenntAktuell.inhalt();
    }
    
    public Typ aktuelles() {
        return this.kenntAktuell.inhalt();
    }
    
    public void fuegeDahinterEin(final Typ pInhalt) {
        if (this.istDahinter()) {
            this.zurueck();
        }
        final Knoten lNeuer = new Knoten((Typ)pInhalt);
        lNeuer.setzeNachfolger(this.kenntAktuell.nachfolger());
        lNeuer.nachfolger().setzeVorgaenger(lNeuer);
        lNeuer.setzeVorgaenger(this.kenntAktuell);
        this.kenntAktuell.setzeNachfolger(lNeuer);
        ++this.zAnzahl;
    }
    
    public void fuegeDavorEin(final Typ pInhalt) {
        if (this.istDavor()) {
            this.vor();
        }
        final Knoten lNeuer = new Knoten((Typ)pInhalt);
        lNeuer.setzeVorgaenger(this.kenntAktuell.vorgaenger());
        lNeuer.vorgaenger().setzeNachfolger(lNeuer);
        lNeuer.setzeNachfolger(this.kenntAktuell);
        this.kenntAktuell.setzeVorgaenger(lNeuer);
        ++this.zAnzahl;
        ++this.zPosition;
    }
    
    public int laenge() {
        return this.zAnzahl;
    }
    
    public boolean istLeer() {
        return this.zAnzahl == 0;
    }
    
    public void entferneAlleElemente() {
        this.hatBug.setzeNachfolger(this.hatHeck);
        this.hatHeck.setzeVorgaenger(this.hatBug);
        this.kenntAktuell = this.hatBug;
        this.zAnzahl = 0;
        this.zPosition = 0;
    }
    
    public void geheZuPosition(final int pPosition) {
        if (pPosition >= 0 && pPosition <= this.zAnzahl + 1) {
            while (pPosition > this.zPosition) {
                this.vor();
            }
            while (pPosition < this.zPosition) {
                this.zurueck();
            }
        }
    }
    
    public int aktuellePosition() {
        return this.zPosition;
    }
    
    public void loescheAktuelles() {
        this.entferneAktuelles();
    }
    
    public void entferneAktuelles() {
        if (!this.istDavor() || !this.istDahinter()) {
            this.kenntAktuell.vorgaenger().setzeNachfolger(this.kenntAktuell.nachfolger());
            this.kenntAktuell.nachfolger().setzeVorgaenger(this.kenntAktuell.vorgaenger());
            this.kenntAktuell = this.kenntAktuell.nachfolger();
            --this.zAnzahl;
        }
    }
    
    public void ersetzeAktuelles(final Typ pObject) {
        if (!this.istDavor() || !this.istDahinter()) {
            this.kenntAktuell.setzeInhalt(pObject);
        }
    }
    
    public int position(final Typ pObject) {
        int lPosition = -1;
        if (!this.istLeer()) {
            this.zumAnfang();
            do {
                if (this.aktuellesElement() == pObject) {
                    lPosition = this.zPosition;
                }
                else {
                    this.vor();
                }
            } while (!this.istDahinter() && lPosition == -1);
        }
        return lPosition;
    }
    
    public void haengeListeAn(final Liste pListe) {
        if (!pListe.istLeer()) {
            this.zumEnde();
            this.kenntAktuell.setzeNachfolger(pListe.ersterKnoten());
            pListe.ersterKnoten().setzeVorgaenger(this.kenntAktuell);
            this.hatHeck = (Knoten<Typ>)pListe.letzterKnoten().nachfolger();
            this.zAnzahl += pListe.laenge();
        }
    }
    
    public void setzeListeDavor(final Liste pListe) {
        if (!pListe.istLeer()) {
            this.zumAnfang();
            this.kenntAktuell.setzeVorgaenger(pListe.letzterKnoten());
            pListe.letzterKnoten().setzeNachfolger(this.kenntAktuell);
            this.hatBug = (Knoten<Typ>)pListe.ersterKnoten().vorgaenger();
            this.zAnzahl += pListe.laenge();
        }
    }
    
    protected Knoten ersterKnoten() {
        return this.hatBug.nachfolger();
    }
    
    protected Knoten letzterKnoten() {
        return this.hatHeck.vorgaenger();
    }
    
    @Override
    public String toString() {
        if (this.istLeer()) {
            return "leere Liste";
        }
        String lString = "";
        this.zumAnfang();
        while (!this.istDahinter()) {
            lString = lString + this.aktuellesElement().toString() + "\n";
            this.vor();
        }
        if (this.hatTextwerkzeug.laenge(lString) > 0) {
            lString = this.hatTextwerkzeug.textOhne(lString, this.hatTextwerkzeug.laenge(lString), this.hatTextwerkzeug.laenge(lString));
        }
        return lString;
    }
    
    public void setzeDavor(final Typ pInhalt) {
        this.zumAnfang();
        this.fuegeDavorEin(pInhalt);
    }
    
    public void haengeAn(final Typ pInhalt) {
        this.zumEnde();
        this.fuegeDahinterEin(pInhalt);
    }
    
    private class Knoten<Typ> implements Serializable
    {
        static final long serialVersionUID = 8311777060002L;
        private Typ kenntInhalt;
        private Knoten kenntNachfolger;
        private Knoten kenntVorgaenger;
        
        public Knoten(final Typ pInhalt) {
            this.kenntInhalt = pInhalt;
            this.kenntNachfolger = null;
            this.kenntVorgaenger = null;
        }
        
        public Typ inhalt() {
            return this.kenntInhalt;
        }
        
        public void setzeInhalt(final Typ pObject) {
            this.kenntInhalt = pObject;
        }
        
        public Knoten nachfolger() {
            return this.kenntNachfolger;
        }
        
        public Knoten vorgaenger() {
            return this.kenntVorgaenger;
        }
        
        public void setzeNachfolger(final Knoten pNachfolger) {
            this.kenntNachfolger = pNachfolger;
        }
        
        public void setzeVorgaenger(final Knoten pVorgaenger) {
            this.kenntVorgaenger = pVorgaenger;
        }
    }
}
