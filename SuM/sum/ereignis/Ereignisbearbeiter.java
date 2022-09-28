// 
// Decompiled by Procyon v0.5.36
// 

package sum.ereignis;

import java.io.Serializable;

public abstract class Ereignisbearbeiter implements Serializable
{
    public void bearbeiteTaste(final char pZeichen) {
    }
    
    public void bearbeiteMausDruck(final int pWoH, final int pWoV) {
    }
    
    public void bearbeiteMausLos(final int pWoH, final int pWoV) {
    }
    
    public void bearbeiteMausBewegt(final int pWohinH, final int pWohinV) {
    }
    
    public void bearbeiteDoppelKlick(final int pWoH, final int pWoV) {
    }
    
    public void bearbeiteLeerlauf() {
    }
    
    public void bearbeiteUpdate() {
    }
    
    public void bearbeiteFokusErhalten() {
    }
    
    public void bearbeiteFokusVerloren() {
    }
    
    public void gibFrei() {
    }
}
