// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import javax.swing.AbstractButton;
import java.io.Serializable;
import javax.swing.ButtonGroup;

public class Radiogruppe extends ButtonGroup implements Serializable
{
    public void fuegeEin(final Radioknopf pKnopf) {
        this.add((AbstractButton)pKnopf.hatComponent);
    }
    
    public void entferne(final Radioknopf pKnopf) {
        this.remove((AbstractButton)pKnopf.hatComponent);
    }
}
