// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

public class Feld<Typ>
{
    static final long serialVersionUID = 8311777060902L;
    Object[] hatArray;
    int zUntereGrenze;
    int zObereGrenze;
    
    public Feld(final int pUntereGrenze, final int pObereGrenze) {
        this.hatArray = new Object[pObereGrenze - pUntereGrenze + 1];
        this.zUntereGrenze = pUntereGrenze;
        this.zObereGrenze = pObereGrenze;
    }
    
    public void setzeInhalt(final int pPosition, final Typ pInhalt) {
        this.hatArray[pPosition - this.zUntereGrenze] = pInhalt;
    }
    
    public Typ inhalt(final int pPosition) {
        return (Typ)this.hatArray[pPosition - this.zUntereGrenze];
    }
    
    public int untereGrenze() {
        return this.zUntereGrenze;
    }
    
    public int obereGrenze() {
        return this.zObereGrenze;
    }
}
