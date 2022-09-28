// 
// Decompiled by Procyon v0.5.36
// 

package sum.sql;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Datenbank
{
    public static Connection hatVerbindung;
    private String hatProduktDaten;
    private String fehler;
    private SQLErgebnisliste hatErgebnis;
    
    public Datenbank() {
        this.fehler = "SQL-Fehler!";
        Datenbank.hatVerbindung = null;
        this.hatErgebnis = null;
    }
    
    private String transaktionsStatus() {
        try {
            final int action = Datenbank.hatVerbindung.getTransactionIsolation();
            switch (action) {
                case 0: {
                    return "TRANSACTION_NONE ";
                }
                case 1: {
                    return "TRANSACTION_READ_COMMITTED ";
                }
                case 2: {
                    return "TRANSACTION_READ_UNCOMMITTED ";
                }
                case 3: {
                    return "TRANSACTION_REPEATABLE_READ  ";
                }
                case 4: {
                    return "TRANSACTION_SERIALIZABLE  ";
                }
                default: {
                    return "Nicht definiert";
                }
            }
        }
        catch (SQLException e) {
            System.out.println(this.fehler);
            System.out.println("Datenbank Transaktionsstatus: " + e);
            return "DB-Fehler";
        }
    }
    
    public String verbinde(final String pDatenbank, final String pTreiber, final String pAnbindung, final String pUser, final String pPwd) {
        final String lTreiber = pTreiber;
        try {
            Class.forName(lTreiber);
            Datenbank.hatVerbindung = DriverManager.getConnection(pAnbindung + pDatenbank, pUser, pPwd);
            this.hatProduktDaten = "Produkt: " + Datenbank.hatVerbindung.getMetaData().getDatabaseProductName() + " Version: " + Datenbank.hatVerbindung.getMetaData().getDatabaseProductVersion();
            return "";
        }
        catch (Exception e) {
            System.out.println(this.fehler);
            System.out.println("Datenbank verbinden: " + e.toString());
            return "DB-Fehler: " + e.toString();
        }
    }
    
    public String verbindeMySQL(final String pDatenbank, final String pServer, final String pUser, final String pPwd) {
        return this.verbinde(pDatenbank, "com.mysql.jdbc.Driver", "jdbc:mysql://" + pServer + "/", pUser, pPwd);
    }
    
    public void trenne() {
        try {
            Datenbank.hatVerbindung.close();
        }
        catch (SQLException e) {
            System.out.println(this.fehler);
            System.out.println("Datenbank trennen: " + e.toString());
        }
    }
    
    public int tabellenanzahl() {
        try {
            int lAnzahl = 0;
            ResultSet tab = Datenbank.hatVerbindung.getMetaData().getTables(null, null, null, null);
            while (tab.next()) {
                if (tab.getString("Table_Type").equals("TABLE")) {
                    ++lAnzahl;
                }
            }
            tab = null;
            return lAnzahl;
        }
        catch (SQLException e) {
            System.out.println("Datenbanktabellen: " + e);
            return -1;
        }
    }
    
    public String tabellenname(final int pNummer) {
        try {
            int lAnzahl = 0;
            String lName = "";
            ResultSet tab = Datenbank.hatVerbindung.getMetaData().getTables(null, null, null, null);
            while (tab.next()) {
                if (tab.getString("Table_Type").equals("TABLE") && ++lAnzahl == pNummer) {
                    lName = tab.getString("Table_Name");
                }
            }
            tab = null;
            return lName;
        }
        catch (SQLException e) {
            System.out.println("Datenbanktabellen: " + e);
            return "Keine Tabelle";
        }
    }
    
    public String datenbankinfo() {
        try {
            String c;
            if (Datenbank.hatVerbindung.getAutoCommit()) {
                c = "AUTO-COMMIT";
            }
            else {
                c = "KEIN AUTO-COMMIT";
            }
            return this.hatProduktDaten + "\n" + "Status: " + this.transaktionsStatus() + "\n" + "Commit: " + c + "\n" + "User: " + Datenbank.hatVerbindung.getMetaData().getUserName();
        }
        catch (SQLException e) {
            System.out.println(this.fehler);
            System.out.println("DatenbankInfo: " + e.toString());
            return "DB-Fehler: " + e.toString();
        }
    }
    
    public String sendeSQL(final String pSQLAnweisung) {
        if (this.hatErgebnis != null) {
            this.hatErgebnis.gibFrei();
        }
        this.hatErgebnis = new SQLErgebnisliste(this, pSQLAnweisung);
        if (this.hatErgebnis != null) {
            return "";
        }
        System.out.println("sendeSQL: " + this.fehler);
        return this.fehler;
    }
    
    public SQLErgebnisliste ergebnis() {
        return this.hatErgebnis;
    }
}
