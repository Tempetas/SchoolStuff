// 
// Decompiled by Procyon v0.5.36
// 

package sum.netz;

import java.net.Socket;
import java.util.Vector;
import java.net.ServerSocket;
import java.io.Serializable;

public class Server implements Serializable
{
    private ServerSocket hatServerSocket;
    private Vector hatVerbindungen;
    private ServerSchleife hatSchleife;
    private boolean zMitNachrichten;
    private int zPort;
    private boolean zLaeuft;
    
    public Server(final int pPortNr, final boolean pTestModus) {
        try {
            this.hatServerSocket = new ServerSocket(pPortNr);
            this.zPort = pPortNr;
            this.zMitNachrichten = pTestModus;
            if (this.zMitNachrichten) {
                System.out.println("\u00d6ffne Server mit ServerSocket: " + this.hatServerSocket);
            }
            this.zLaeuft = true;
            this.hatVerbindungen = new Vector();
            (this.hatSchleife = new ServerSchleife(this)).start();
        }
        catch (Exception fehler) {
            System.err.println("Fehler beim \u00d6ffnen der Server: " + fehler);
        }
    }
    
    @Override
    public String toString() {
        return "Server von ServerSocket: " + this.hatServerSocket;
    }
    
    private void melde(final String pMeldung) {
        System.out.println(pMeldung);
    }
    
    public int port() {
        return this.zPort;
    }
    
    public boolean mitProtokoll() {
        return this.zMitNachrichten;
    }
    
    protected Vector clientListe() {
        return this.hatVerbindungen;
    }
    
    public Serververbindung SerververbindungVonIP(final String pClientIP) {
        for (int lNr = 0; lNr < this.hatVerbindungen.size(); ++lNr) {
            final Serververbindung lSerververbindung = this.hatVerbindungen.elementAt(lNr);
            if (lSerververbindung.partnerAdresse().equals(pClientIP)) {
                return lSerververbindung;
            }
        }
        return null;
    }
    
    public Serververbindung SerververbindungVonIPUndPort(final String pClientIP, final int pPartnerPort) {
        for (int lNr = 0; lNr < this.hatVerbindungen.size(); ++lNr) {
            final Serververbindung lSerververbindung = this.hatVerbindungen.elementAt(lNr);
            if (lSerververbindung.partnerAdresse().equals(pClientIP) && lSerververbindung.partnerPort() == pPartnerPort) {
                return lSerververbindung;
            }
        }
        return null;
    }
    
    public int zahlDerVerbindungen() {
        return this.hatVerbindungen.size();
    }
    
    public void sendeAnEinen(final String pClientIP, final String pText) {
        final Serververbindung lSerververbindung = this.SerververbindungVonIP(pClientIP);
        if (lSerververbindung != null) {
            lSerververbindung.sende(pText);
        }
        else if (this.mitProtokoll()) {
            System.err.println("Fehler beim Senden: IP " + pClientIP + " nicht vorhanden.");
        }
    }
    
    public void sendeAnEinen(final String pClientIP, final int pPartnerPort, final String pText) {
        final Serververbindung lSerververbindung = this.SerververbindungVonIPUndPort(pClientIP, pPartnerPort);
        if (lSerververbindung != null) {
            lSerververbindung.sende(pText);
        }
        else if (this.mitProtokoll()) {
            System.err.println("Fehler beim Senden: IP " + pClientIP + " mit Port " + pPartnerPort + " nicht vorhanden.");
        }
    }
    
    public void sendeAnAlle(final String pText) {
        for (int lNr = 0; lNr < this.hatVerbindungen.size(); ++lNr) {
            final Serververbindung lSerververbindung = this.hatVerbindungen.elementAt(lNr);
            lSerververbindung.sende(pText);
        }
    }
    
    public void beendeVerbindung(final String pClientIP) {
        if (this.SerververbindungVonIP(pClientIP) != null) {
            this.bearbeiteVerbindungsende(pClientIP);
        }
        this.schliesseVerbindung(pClientIP);
    }
    
    public void beendeVerbindung(final String pClientIP, final int pPartnerPort) {
        if (this.SerververbindungVonIPUndPort(pClientIP, pPartnerPort) != null) {
            this.bearbeiteVerbindungsende(pClientIP, pPartnerPort);
        }
        this.schliesseVerbindung(pClientIP, pPartnerPort);
    }
    
    protected void schliesseVerbindung(final String pClientIP) {
        final Serververbindung lSerververbindung = this.SerververbindungVonIP(pClientIP);
        if (lSerververbindung != null) {
            this.loescheVerbindung(lSerververbindung);
            lSerververbindung.gibFrei();
        }
        else if (this.mitProtokoll()) {
            System.err.println("Fehler beim Schlie\u00dfen der Verbindung: IP " + pClientIP + " nicht vorhanden.");
        }
    }
    
    protected void schliesseVerbindung(final String pClientIP, final int pPartnerPort) {
        final Serververbindung lSerververbindung = this.SerververbindungVonIPUndPort(pClientIP, pPartnerPort);
        if (lSerververbindung != null) {
            this.loescheVerbindung(lSerververbindung);
            lSerververbindung.gibFrei();
        }
        else if (this.mitProtokoll()) {
            System.err.println("Fehler beim Schlie\u00dfen der Verbindung: IP " + pClientIP + " mit Port " + pPartnerPort + " nicht vorhanden.");
        }
    }
    
    protected void loescheVerbindung(final Serververbindung pVerbindung) {
        for (int lNr = 0; lNr < this.hatVerbindungen.size(); ++lNr) {
            final Serververbindung lSerververbindung = this.hatVerbindungen.elementAt(lNr);
            if (lSerververbindung == pVerbindung) {
                this.hatVerbindungen.removeElementAt(lNr);
            }
        }
    }
    
    public void bearbeiteVerbindungsaufbau(final String pClientIP) {
    }
    
    public void bearbeiteVerbindungsaufbau(final String pClientIP, final int pPartnerPort) {
    }
    
    public void bearbeiteNachricht(final String pClientIP, final String pNachricht) {
    }
    
    public void bearbeiteNachricht(final String pClientIP, final int pPartnerPort, final String pNachricht) {
    }
    
    public void bearbeiteVerbindungsverlust(final String pClientIP) {
    }
    
    public void bearbeiteVerbindungsverlust(final String pClientIP, final int pPartnerPort) {
    }
    
    public void bearbeiteVerbindungsende(final String pClientIP) {
    }
    
    public void bearbeiteVerbindungsende(final String pClientIP, final int pPartnerPort) {
    }
    
    public Serververbindung neueSerververbindung() {
        return new Serververbindung();
    }
    
    public void gibFrei() {
        try {
            if (this.mitProtokoll()) {
                System.out.println("Schlie\u00dfe Server mit ServerSocket: " + this.hatServerSocket);
                System.out.println("");
            }
            this.zLaeuft = false;
            this.hatServerSocket.close();
            this.hatServerSocket = null;
        }
        catch (Exception fehler) {
            System.err.println("Fehler beim Schlie\u00dfen des Servers: " + fehler);
        }
    }
    
    private class ServerSchleife extends Thread implements Serializable
    {
        private Server kenntServer;
        
        public ServerSchleife(final Server pServer) {
            this.kenntServer = pServer;
        }
        
        @Override
        public void run() {
            while (Server.this.zLaeuft) {
                try {
                    final Socket lClientSocket = this.kenntServer.hatServerSocket.accept();
                    final Serververbindung lNeueSerververbindung = this.kenntServer.neueSerververbindung();
                    lNeueSerververbindung.initialisiere(lClientSocket, this.kenntServer.mitProtokoll(), this.kenntServer);
                    if (this.kenntServer.mitProtokoll()) {
                        System.out.println("Server baut neue Verbindung auf: " + lNeueSerververbindung);
                    }
                    this.kenntServer.clientListe().addElement(lNeueSerververbindung);
                    lNeueSerververbindung.start();
                }
                catch (Exception fehler) {
                    System.err.println("Fehler beim Erwarten einer Verbindung in Server: " + fehler);
                }
            }
        }
    }
}
