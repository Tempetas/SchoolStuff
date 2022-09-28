// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

public abstract class Markierungskomponente extends Textkomponente
{
    protected String zInhaltGeaendertBearbeiter;
    protected String zMarkierungGeaendertBearbeiter;
    
    public Markierungskomponente() {
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
    }
    
    public void setzeBearbeiterInhaltGeaendert(final String pBearbeiter) {
        this.zInhaltGeaendertBearbeiter = pBearbeiter;
    }
    
    public void setzeBearbeiterMarkierungGeaendert(final String pBearbeiter) {
        this.zMarkierungGeaendertBearbeiter = pBearbeiter;
    }
    
    protected abstract void markierungGeaendert();
    
    public abstract String teilinhalt(final int p0, final int p1);
    
    public String teilInhalt(final int pAnfang, final int pEnde) {
        return this.teilinhalt(pAnfang, pEnde);
    }
    
    public abstract void fuegeEin(final String p0, final int p1);
    
    public abstract void haengeAn(final String p0);
    
    public abstract void haengeAn(final char p0);
    
    public abstract void haengeAn(final int p0);
    
    public abstract void haengeAn(final double p0);
    
    public abstract String markierterInhalt();
    
    public abstract void setzeMarkierung(final int p0, final int p1);
    
    public abstract void markiereAlles();
    
    public abstract void markiereNichts();
    
    public void loescheAlles() {
        this.setzeInhalt("");
    }
    
    public abstract void loescheMarkierung();
    
    public abstract void loesche(final int p0, final int p1);
    
    public abstract boolean istMarkiert();
    
    public abstract int markierungsAnfang();
    
    public abstract int markierungsEnde();
}
