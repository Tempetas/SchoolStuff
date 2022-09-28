// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import java.io.Serializable;

public class Schlange<Typ> extends Liste<Typ> implements Serializable
{
    static final long serialVersionUID = 8311777060202L;
    
    public Typ erstes() {
        this.zumAnfang();
        return this.aktuellesElement();
    }
    
    public Typ kopf() {
        return this.erstes();
    }
    
    @Override
    public void haengeAn(final Typ pInhalt) {
        this.zumEnde();
        this.fuegeDahinterEin(pInhalt);
    }
    
    public void entferneErstes() {
        this.zumAnfang();
        this.loescheAktuelles();
    }
    
    public void entferneKopf() {
        this.entferneErstes();
    }
}
