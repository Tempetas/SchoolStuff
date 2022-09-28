// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import java.io.Serializable;

public class Stapel<Typ> extends Liste<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060502L;
    
    public void legeAuf(final Typ pObject) {
        this.zumAnfang();
        this.fuegeDavorEin(pObject);
    }
    
    public void nimmAb() {
        this.zumAnfang();
        this.loescheAktuelles();
    }
    
    public void entferneOberstes() {
        this.zumAnfang();
        this.loescheAktuelles();
    }
    
    public Typ oberstes() {
        this.zumAnfang();
        return this.aktuellesElement();
    }
    
    public Typ spitze() {
        this.zumAnfang();
        return this.aktuellesElement();
    }
}
