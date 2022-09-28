// 
// Decompiled by Procyon v0.5.36
// 

package sum.sql;

import java.sql.SQLException;
import sum.komponenten.Tabelle;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLErgebnisliste
{
    private Statement hatSQLAnweisung;
    private ResultSet hatSQLErgebnis;
    private ResultSetMetaData hatMetaDaten;
    private String fehler;
    private int zZeilenanzahl;
    private int zAktuelleZeile;
    private int zSpaltenanzahl;
    private String hatSQLAnfrage;
    private Datenbank kenntDatenbank;
    
    public SQLErgebnisliste(final Datenbank pDatenbank, final String pSQLAnfrage) {
        this.fehler = "SQL - Fehler!";
        this.hatSQLErgebnis = null;
        this.zZeilenanzahl = 0;
        this.zSpaltenanzahl = 0;
        this.zAktuelleZeile = 0;
        this.kenntDatenbank = pDatenbank;
        this.hatSQLAnfrage = pSQLAnfrage;
        this.hatSQLErgebnis = this.bearbeiteAnweisung();
        this.zumAnfang();
    }
    
    private ResultSet bearbeiteAnweisung() {
        try {
            final Datenbank kenntDatenbank = this.kenntDatenbank;
            this.hatSQLAnweisung = Datenbank.hatVerbindung.createStatement();
            if (this.hatSQLAnweisung.execute(this.hatSQLAnfrage)) {
                this.zZeilenanzahl = 0;
                ResultSet lErgebnis = this.hatSQLAnweisung.executeQuery(this.hatSQLAnfrage);
                this.hatMetaDaten = lErgebnis.getMetaData();
                this.zSpaltenanzahl = this.hatMetaDaten.getColumnCount();
                while (lErgebnis.next()) {
                    ++this.zZeilenanzahl;
                }
                lErgebnis.close();
                this.hatSQLAnweisung.close();
                final Datenbank kenntDatenbank2 = this.kenntDatenbank;
                this.hatSQLAnweisung = Datenbank.hatVerbindung.createStatement();
                lErgebnis = this.hatSQLAnweisung.executeQuery(this.hatSQLAnfrage);
                return lErgebnis;
            }
            this.zSpaltenanzahl = 0;
            this.zZeilenanzahl = 0;
            this.zAktuelleZeile = 0;
            return null;
        }
        catch (Exception e) {
            System.out.println("Keine Ergebnisliste erhalten!");
            System.out.println(e.toString());
            return null;
        }
    }
    
    public void zumAnfang() {
        this.zAktuelleZeile = 0;
        try {
            if (this.hatSQLErgebnis != null) {
                this.hatSQLErgebnis.close();
                this.hatSQLAnweisung.close();
                this.hatSQLErgebnis = this.bearbeiteAnweisung();
                this.vor();
                this.zAktuelleZeile = 1;
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void vor() {
        ++this.zAktuelleZeile;
        if (!this.istDahinter()) {
            try {
                this.hatSQLErgebnis.next();
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean istDahinter() {
        return this.zAktuelleZeile > this.zZeilenanzahl;
    }
    
    public int zeilenanzahl() {
        return this.zZeilenanzahl;
    }
    
    public int aktuelleZeile() {
        return this.zAktuelleZeile;
    }
    
    public int spaltenanzahl() {
        return this.zSpaltenanzahl;
    }
    
    public String spaltentyp(final int pSpalte) {
        try {
            if (pSpalte <= this.zSpaltenanzahl) {
                return this.hatMetaDaten.getColumnTypeName(pSpalte);
            }
            return this.fehler;
        }
        catch (Exception e) {
            return this.fehler;
        }
    }
    
    public String spaltenname(final int pSpalte) {
        try {
            String name = "";
            if (pSpalte <= this.zSpaltenanzahl) {
                name = this.hatMetaDaten.getColumnName(pSpalte);
            }
            return name;
        }
        catch (Exception e) {
            return this.fehler;
        }
    }
    
    public int spaltennummer(final String pSpaltenname) {
        try {
            return this.hatSQLErgebnis.findColumn(pSpaltenname);
        }
        catch (Exception e) {
            return -1;
        }
    }
    
    public int spaltenbreite(final int pSpalte) {
        try {
            return this.hatMetaDaten.getColumnDisplaySize(pSpalte);
        }
        catch (Exception e) {
            return -1;
        }
    }
    
    public String datenfeldAlsText(final String pSpaltenname) {
        try {
            final Object lObjekt = this.hatSQLErgebnis.getObject(pSpaltenname);
            return lObjekt.toString();
        }
        catch (Exception e) {
            return this.fehler + " " + e.toString();
        }
    }
    
    public String datenfeldAlsText(final int pSpalte) {
        try {
            final Object lObjekt = this.hatSQLErgebnis.getObject(pSpalte);
            if (lObjekt == null) {
                return "null";
            }
            return lObjekt.toString();
        }
        catch (Exception e) {
            return this.fehler + " " + e.toString();
        }
    }
    
    public double datenfeldAlsZahl(final String pDatenfeldname) {
        try {
            return this.hatSQLErgebnis.getDouble(pDatenfeldname);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return 0.0;
        }
    }
    
    public double datenfeldAlsZahl(final int pSpalte) {
        try {
            return this.hatSQLErgebnis.getDouble(pSpalte);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return 0.0;
        }
    }
    
    public int datenfeldAlsGanzeZahl(final String pSpaltenname) {
        try {
            return this.hatSQLErgebnis.getInt(pSpaltenname);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    public int datenfeldAlsGanzeZahl(final int pSpalte) {
        try {
            return this.hatSQLErgebnis.getInt(pSpalte);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    public void alsTabelle(final Tabelle pTabelle) {
        final int altZeile = this.zAktuelleZeile;
        if (this.spaltenanzahl() > 0) {
            pTabelle.setzeSpaltenanzahl(this.spaltenanzahl());
            pTabelle.setzeZeilenanzahl(this.zeilenanzahl());
            for (int spalte = 1; spalte <= this.spaltenanzahl(); ++spalte) {
                pTabelle.setzeSpaltentitelAn(this.spaltenname(spalte), spalte);
            }
            this.zumAnfang();
            int aktZeile = 0;
            while (!this.istDahinter()) {
                ++aktZeile;
                for (int spalte = 1; spalte <= this.spaltenanzahl(); ++spalte) {
                    pTabelle.setzeInhaltAn(this.datenfeldAlsText(spalte), aktZeile, spalte);
                }
                this.vor();
            }
            this.zumAnfang();
            while (altZeile > this.zAktuelleZeile) {
                this.vor();
            }
        }
    }
    
    public void gibFrei() {
        try {
            if (this.hatSQLErgebnis != null) {
                this.hatSQLErgebnis.close();
            }
            if (this.hatSQLAnweisung != null) {
                this.hatSQLAnweisung.close();
            }
            this.hatSQLErgebnis = null;
            this.hatSQLAnweisung = null;
            System.gc();
        }
        catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
