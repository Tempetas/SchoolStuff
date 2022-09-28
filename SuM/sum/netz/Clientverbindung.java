// 
// Decompiled by Procyon v0.5.36
// 

package sum.netz;

import java.io.Serializable;

public abstract class Clientverbindung extends Verbindung implements Serializable
{
    private Clientempfaenger hatEmpfaenger;
    
    public Clientverbindung(final String pIPAdresse, final int pPortNr, final boolean pTestModus) {
        super(pIPAdresse, pPortNr, pTestModus);
        if (this.vorhanden()) {
            try {
                (this.hatEmpfaenger = new Clientempfaenger(this, pTestModus)).start();
            }
            catch (Exception fehler) {
                System.err.println("Fehler beim \u00d6ffnen von ClientVerbindung: " + fehler);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Verbindung mit Socket: " + this.verbindungsSocket();
    }
    
    public abstract void bearbeiteNachricht(final String p0);
    
    public void bearbeiteVerbindungsverlust() {
    }
    
    @Override
    public void gibFrei() {
        if (this.hatEmpfaenger != null) {
            this.hatEmpfaenger.gibFrei();
        }
        this.hatEmpfaenger = null;
        super.gibFrei();
    }
}
