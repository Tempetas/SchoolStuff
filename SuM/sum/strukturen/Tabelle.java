// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

public class Tabelle<Typ extends Ordnungsobjekt> extends Feld<Typ>
{
    static final long serialVersionUID = 8311777061002L;
    int zAnzahl;
    int zMaximaleAnzahl;
    int zErsterFreierPlatz;
    
    public Tabelle(final int pUntereGrenze, final int pObereGrenze) {
        super(pUntereGrenze, pObereGrenze);
        this.zAnzahl = 0;
        this.zMaximaleAnzahl = pObereGrenze - pUntereGrenze + 1;
        this.zErsterFreierPlatz = pUntereGrenze;
    }
    
    public void fuegeEin(final Typ pInhalt) {
        ++this.zAnzahl;
        this.setzeInhalt(this.zErsterFreierPlatz, pInhalt);
        ++this.zErsterFreierPlatz;
    }
    
    public void loesche(final int pIndex) {
        for (int lIndex = pIndex; lIndex < this.zErsterFreierPlatz - 1; ++lIndex) {
            this.setzeInhalt(lIndex, this.inhalt(lIndex + 1));
        }
        --this.zAnzahl;
        --this.zErsterFreierPlatz;
    }
    
    public int index(final Typ pInhalt) {
        for (int lIndex = this.untereGrenze(); lIndex < this.zErsterFreierPlatz; ++lIndex) {
            if (this.inhalt(lIndex).istGleichWie(pInhalt)) {
                return lIndex;
            }
        }
        return this.untereGrenze() - 1;
    }
    
    public int anzahl() {
        return this.zAnzahl;
    }
    
    public boolean voll() {
        return this.zAnzahl >= this.zMaximaleAnzahl;
    }
}
