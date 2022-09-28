// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

public abstract class SuchbaumInhalt extends Ordnungsklasse
{
    int zAnzahl;
    
    public SuchbaumInhalt() {
        this.zAnzahl = 1;
    }
    
    public SuchbaumInhalt(final int pAnzahl) {
        this.zAnzahl = pAnzahl;
    }
    
    public int anzahl() {
        return this.zAnzahl;
    }
    
    public void setzeAnzahl(final int pAnzahl) {
        this.zAnzahl = pAnzahl;
    }
    
    public void erhoeheAnzahl() {
        ++this.zAnzahl;
    }
}
