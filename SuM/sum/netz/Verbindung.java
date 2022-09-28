// 
// Decompiled by Procyon v0.5.36
// 

package sum.netz;

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.Serializable;

public class Verbindung extends Thread implements Serializable
{
    private Socket hatSocket;
    private BufferedReader hatEingabe;
    private PrintStream hatAusgabe;
    private boolean zMitNachrichten;
    private int zPartnerPort;
    private int zEigenerPort;
    private String zPartnerAdresse;
    private String zEigeneAdresse;
    protected boolean zVerbindungAktiv;
    
    protected Verbindung() {
    }
    
    public Verbindung(final Socket pSocket, final boolean pTestModus) {
        this.erstelleVerbindung(pSocket, pTestModus);
    }
    
    public Verbindung(final String pIPAdresse, final int pPortNr, final boolean pTestModus) {
        try {
            this.erstelleVerbindung(new Socket(pIPAdresse, pPortNr), pTestModus);
        }
        catch (Exception fehler) {
            this.hatSocket = null;
            System.err.println("Fehler beim \u00d6ffnen von Socket: " + fehler);
        }
    }
    
    protected void erstelleVerbindung(final Socket pSocket, final boolean pTestModus) {
        this.hatSocket = pSocket;
        this.zMitNachrichten = pTestModus;
        this.zVerbindungAktiv = true;
        this.zPartnerAdresse = this.verbindungsSocket().getInetAddress().toString();
        this.zPartnerAdresse = this.zPartnerAdresse.substring(this.zPartnerAdresse.indexOf(47) + 1);
        this.zPartnerPort = this.verbindungsSocket().getPort();
        this.zEigeneAdresse = this.verbindungsSocket().getLocalAddress().toString();
        this.zEigeneAdresse = this.zEigeneAdresse.substring(this.zEigeneAdresse.indexOf(47) + 1);
        this.zEigenerPort = this.verbindungsSocket().getLocalPort();
        if (this.mitProtokoll()) {
            System.out.println("\u00d6ffne Verbindung: - Eigene IP <" + this.zEigeneAdresse + "> - Partner-IP <" + this.zPartnerAdresse + "> - Eigener Port: " + this.zEigenerPort + " Partner-Port: " + this.zPartnerPort);
        }
        try {
            this.hatEingabe = new BufferedReader(new InputStreamReader(this.hatSocket.getInputStream()));
            this.hatAusgabe = new PrintStream(this.hatSocket.getOutputStream(), true);
        }
        catch (Exception fehler) {
            System.err.println("Fehler beim Erzeugen der Streams der Verbindung: " + fehler);
        }
    }
    
    @Override
    public String toString() {
        return "Verbindung mit Socket: " + this.hatSocket;
    }
    
    public void sende(final String pNachricht) {
        try {
            this.hatAusgabe.print(pNachricht + "\r\n");
            if (this.mitProtokoll()) {
                System.out.println("Verbindung sendet: " + pNachricht);
            }
        }
        catch (Exception fehler) {
            System.err.println("Fehler beim Schreiben in der Verbindung: " + fehler);
        }
    }
    
    public String empfangeneNachricht() {
        String lEingabe = null;
        try {
            lEingabe = this.hatEingabe.readLine();
            if (this.mitProtokoll() && this.zVerbindungAktiv) {
                System.out.println("Verbindung liest: " + lEingabe);
            }
        }
        catch (Exception fehler) {
            if (this.zVerbindungAktiv) {
                System.err.println("Fehler beim Lesen in der Verbindung: " + fehler);
            }
        }
        return lEingabe;
    }
    
    protected Socket verbindungsSocket() {
        return this.hatSocket;
    }
    
    public boolean mitProtokoll() {
        return this.zMitNachrichten;
    }
    
    public String partnerAdresse() {
        return this.zPartnerAdresse;
    }
    
    public String eigeneAdresse() {
        return this.zEigeneAdresse;
    }
    
    public int partnerPort() {
        return this.zPartnerPort;
    }
    
    public int eigenerPort() {
        return this.zEigenerPort;
    }
    
    public boolean vorhanden() {
        return this.hatSocket != null;
    }
    
    public void gibFrei() {
        this.zVerbindungAktiv = false;
        try {
            if (this.mitProtokoll()) {
                System.out.println("Schlie\u00dfe Verbindung mit Socket: " + this.hatSocket);
                System.out.println("");
            }
            this.hatSocket.close();
            this.hatSocket = null;
        }
        catch (Exception fehler) {
            System.err.println("Fehler beim Schlie\u00dfen der Verbindung: " + fehler);
        }
    }
}
