// 
// Decompiled by Procyon v0.5.36
// 

package sum.netz;

import java.io.Serializable;

class Clientempfaenger extends Thread implements Serializable
{
    private Clientverbindung kenntClientverbindung;
    private boolean zMitNachrichten;
    private boolean zVerbindungAktiv;
    
    public Clientempfaenger(final Clientverbindung pClientverbindung, final boolean pTestModus) {
        this.kenntClientverbindung = pClientverbindung;
        this.zMitNachrichten = pTestModus;
        this.zVerbindungAktiv = true;
    }
    
    @Override
    public void run() {
        boolean lNachrichtEmpfangen = true;
        do {
            if (this.zVerbindungAktiv) {
                final String lNachricht = this.kenntClientverbindung.empfangeneNachricht();
                lNachrichtEmpfangen = (lNachricht != null);
                if (!lNachrichtEmpfangen) {
                    continue;
                }
                this.kenntClientverbindung.bearbeiteNachricht(lNachricht);
            }
        } while (this.zVerbindungAktiv && lNachrichtEmpfangen);
        if (this.zMitNachrichten && !lNachrichtEmpfangen) {
            System.out.println("Der Client hat die Verbindung zum Server verloren.");
        }
        this.kenntClientverbindung.bearbeiteVerbindungsverlust();
    }
    
    public void gibFrei() {
        this.zVerbindungAktiv = false;
    }
}
