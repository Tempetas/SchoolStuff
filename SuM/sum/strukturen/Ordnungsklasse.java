// 
// Decompiled by Procyon v0.5.36
// 

package sum.strukturen;

import java.io.Serializable;

public abstract class Ordnungsklasse implements Serializable
{
    public abstract boolean istGleich(final Ordnungsklasse p0);
    
    public abstract boolean istKleiner(final Ordnungsklasse p0);
    
    public boolean istGroesser(final Ordnungsklasse pObjekt) {
        return !this.istGleich(pObjekt) && !this.istKleiner(pObjekt);
    }
}
