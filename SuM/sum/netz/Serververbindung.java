// 
// Decompiled by Procyon v0.5.36
// 

package sum.netz;

import java.net.Socket;
import java.io.Serializable;

public class Serververbindung extends Verbindung implements Serializable
{
    private Server kenntServer;
    
    protected Serververbindung() {
    }
    
    protected void initialisiere(final Socket pSocket, final boolean pTestModus, final Server pServer) {
        this.erstelleVerbindung(pSocket, pTestModus);
        this.kenntServer = pServer;
    }
    
    @Override
    public void run() {
        this.bearbeiteProtokoll();
    }
    
    public void bearbeiteProtokoll() {
        this.bearbeiteVerbindungsaufbau();
        while (this.zVerbindungAktiv) {
            final String lNachricht = this.empfangeneNachricht();
            if (lNachricht == null) {
                if (!this.zVerbindungAktiv) {
                    continue;
                }
                if (this.mitProtokoll()) {
                    System.out.println("Der Server hat die Verbindung zum Client " + this.partnerAdresse() + " verloren.");
                }
                this.bearbeiteVerbindungsverlust();
                this.kenntServer.schliesseVerbindung(this.partnerAdresse(), this.partnerPort());
            }
            else {
                this.bearbeiteNachricht(lNachricht);
            }
        }
    }
    
    public void bearbeiteVerbindungsaufbau() {
        this.kenntServer.bearbeiteVerbindungsaufbau(this.partnerAdresse());
        this.kenntServer.bearbeiteVerbindungsaufbau(this.partnerAdresse(), this.partnerPort());
    }
    
    public void bearbeiteNachricht(final String pNachricht) {
        this.kenntServer.bearbeiteNachricht(this.partnerAdresse(), pNachricht);
        this.kenntServer.bearbeiteNachricht(this.partnerAdresse(), this.partnerPort(), pNachricht);
    }
    
    public void bearbeiteVerbindungsverlust() {
        this.kenntServer.bearbeiteVerbindungsverlust(this.partnerAdresse());
        this.kenntServer.bearbeiteVerbindungsverlust(this.partnerAdresse(), this.partnerPort());
    }
    
    public void beendeVerbindung() {
        this.kenntServer.beendeVerbindung(this.partnerAdresse());
        this.kenntServer.beendeVerbindung(this.partnerAdresse(), this.partnerPort());
    }
}
