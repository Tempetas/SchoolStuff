// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import java.awt.Color;
import java.util.Vector;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import java.awt.Dimension;
import javax.swing.event.ListSelectionListener;
import java.awt.event.FocusListener;
import javax.swing.event.TableModelListener;
import sum.ereignis.Schrift;
import java.awt.Font;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.io.Serializable;

public class Tabelle extends Komponente implements Serializable, ScrollPaneConstants
{
    private String zInhaltGeaendertBearbeiter;
    private String zMarkierungGeaendertBearbeiter;
    private JTable hatTable;
    private JScrollPane hatScrollPane;
    private TableModel hatModel;
    protected String zAktuellFont;
    protected int zSchriftStil;
    protected int zSchriftGroesse;
    protected Font zSchriftArt;
    
    public Tabelle(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pZeilen, final int pSpalten) {
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
        this.zAktuellFont = "Helvetica";
        this.zSchriftStil = 0;
        this.zSchriftGroesse = 12;
        this.zSchriftArt = Schrift.STANDARDSCHRIFT;
        this.hatTable = new JTable(pZeilen, pSpalten);
        (this.hatModel = this.hatTable.getModel()).addTableModelListener(new TableDataReaktor());
        this.hatTable.addFocusListener(new BereichFokusReaktor());
        this.hatTable.getSelectionModel().addListSelectionListener(new AuswahlReaktor());
        (this.hatScrollPane = new JScrollPane(22, 32)).setSize(new Dimension(80, 80));
        Bildschirm.topFenster.privatPanel().add(this.hatScrollPane, 0);
        this.hatScrollPane.setViewportView(this.hatTable);
        this.hatTable.setCellSelectionEnabled(true);
        this.hatTable.setSelectionMode(1);
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatTable);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Tabelle(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pZeilen, final int pSpalten) {
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
        this.zAktuellFont = "Helvetica";
        this.zSchriftStil = 0;
        this.zSchriftGroesse = 12;
        this.zSchriftArt = Schrift.STANDARDSCHRIFT;
        this.hatTable = new JTable(pZeilen, pSpalten);
        (this.hatModel = this.hatTable.getModel()).addTableModelListener(new TableDataReaktor());
        this.hatTable.addFocusListener(new BereichFokusReaktor());
        this.hatTable.getSelectionModel().addListSelectionListener(new AuswahlReaktor());
        (this.hatScrollPane = new JScrollPane(22, 32)).setSize(new Dimension(80, 80));
        pFenster.privatPanel().add(this.hatScrollPane, 0);
        this.hatScrollPane.setViewportView(this.hatTable);
        this.hatTable.setCellSelectionEnabled(true);
        this.hatTable.setSelectionMode(1);
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatTable);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    protected void inhaltGeaendert() {
        final Class[] formparas = { null };
        final Tabelle[] meineTabelle = { null };
        if (this.zInhaltGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" einer Tabelle: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Tabelle.class;
                        final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])formparas);
                        meineTabelle[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineTabelle);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" einer Tabelle: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" einer Tabelle nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    protected void markierungGeaendert() {
        final Class[] formparas = { null };
        final Tabelle[] meineTabelle = { null };
        if (this.zMarkierungGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" einer Tabelle: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Tabelle.class;
                        final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])formparas);
                        meineTabelle[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineTabelle);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" einer Tabelle: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" einer Tabelle nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    protected void bekommtFokus() {
        final Class[] formparas = { null };
        final Tabelle[] meineTabelle = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" einer Tabelle: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Tabelle.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meineTabelle[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineTabelle);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" einer Tabelle: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" einer Tabelle nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    protected void verliertFokus() {
        final Class[] formparas = { null };
        final Tabelle[] meineTabelle = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" einer Tabelle: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Tabelle.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meineTabelle[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineTabelle);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" einer Tabelle: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" einer Tabelle nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void setzeBearbeiterInhaltGeaendert(final String pBearbeiter) {
        this.zInhaltGeaendertBearbeiter = pBearbeiter;
    }
    
    public void setzeBearbeiterMarkierungGeaendert(final String pBearbeiter) {
        this.zMarkierungGeaendertBearbeiter = pBearbeiter;
    }
    
    @Override
    public void setzeGroesse(final double pBreite, final double pHoehe) {
        super.setzeGroesse(pBreite, pHoehe);
        this.hatScrollPane.setSize((int)pBreite, (int)pHoehe);
        this.hatScrollPane.revalidate();
    }
    
    @Override
    public void setzePosition(final double pWohinH, final double pWohinV) {
        this.hatScrollPane.setLocation((int)pWohinH, (int)pWohinV);
    }
    
    public void setzeZeilenhoehe(final int pHoehe) {
        this.hatTable.setRowHeight(pHoehe);
    }
    
    public void setzeSpaltenbreite(final int pBreite) {
        this.hatTable.setAutoResizeMode(0);
        for (int i = 0; i < this.hatTable.getColumnCount(); ++i) {
            this.hatTable.getColumnModel().getColumn(i).setPreferredWidth(pBreite);
        }
    }
    
    public int zeilenanzahl() {
        return this.hatTable.getRowCount();
    }
    
    public int spaltenanzahl() {
        return this.hatTable.getColumnCount();
    }
    
    public void setzeSpaltenanzahl(final int pAnzahl) {
        ((DefaultTableModel)this.hatModel).setColumnCount(pAnzahl);
    }
    
    public void setzeZeilenanzahl(final int pAnzahl) {
        ((DefaultTableModel)this.hatModel).setRowCount(pAnzahl);
    }
    
    public void haengeNeueSpalteAn() {
        this.hatTable.addColumn(new TableColumn());
    }
    
    public void haengeNeueZeileAn() {
        ((DefaultTableModel)this.hatModel).addRow(new Vector<Object>());
    }
    
    public void fuegeNeueSpalteEinAn(final int pSpalte) {
        this.haengeNeueSpalteAn();
        this.hatTable.moveColumn(this.hatTable.getColumnCount() - 1, pSpalte);
    }
    
    public void fuegeNeueZeileEinAn(final int pZeile) {
        ((DefaultTableModel)this.hatModel).insertRow(pZeile, new Vector<Object>());
    }
    
    public void entferneSpalteAn(final int pSpalte) {
        this.hatTable.removeColumn(this.hatTable.getColumnModel().getColumn(pSpalte));
    }
    
    public void entferneZeileAn(final int pZeile) {
        ((DefaultTableModel)this.hatModel).removeRow(pZeile);
    }
    
    public void setzeSpaltentitelAn(final String pText, final int pSpalte) {
        this.hatTable.getColumnModel().getColumn(pSpalte - 1).setHeaderValue(pText);
    }
    
    public String spaltentitel(final int pSpalte) {
        return this.hatTable.getColumnName(pSpalte - 1);
    }
    
    public void setzeInhaltAn(final String pText, final int pZeile, final int pSpalte) {
        this.hatTable.setValueAt(pText, pZeile - 1, pSpalte - 1);
    }
    
    public void setzeInhaltAn(final char pZeichen, final int pZeile, final int pSpalte) {
        this.setzeInhaltAn("" + pZeichen, pZeile, pSpalte);
    }
    
    public void setzeInhaltAn(final double pZahl, final int pZeile, final int pSpalte) {
        this.setzeInhaltAn("" + pZahl, pZeile, pSpalte);
    }
    
    public void setzeInhaltAn(final int pZahl, final int pZeile, final int pSpalte) {
        this.setzeInhaltAn("" + pZahl, pZeile, pSpalte);
    }
    
    public void haengeAnAn(final String pText, final int pZeile, final int pSpalte) {
        this.hatTable.setValueAt((String)this.hatTable.getValueAt(pSpalte - 1, pZeile - 1) + pText, pZeile - 1, pSpalte - 1);
    }
    
    public boolean inhaltIstTextAn(final int pZeile, final int pSpalte) {
        return !this.inhaltIstGanzeZahlAn(pZeile, pSpalte) && !this.inhaltIstZahlAn(pZeile, pSpalte);
    }
    
    public boolean inhaltIstGanzeZahlAn(final int pZeile, final int pSpalte) {
        try {
            Integer.valueOf(this.inhaltAlsTextAn(pZeile, pSpalte));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public boolean inhaltIstZahlAn(final int pZeile, final int pSpalte) {
        try {
            Double.valueOf(this.inhaltAlsTextAn(pZeile, pSpalte));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public String inhaltAlsTextAn(final int pZeile, final int pSpalte) {
        return (String)this.hatTable.getValueAt(pZeile - 1, pSpalte - 1);
    }
    
    public int inhaltAlsGanzeZahlAn(final int pZeile, final int pSpalte) throws ArithmeticException {
        if (this.inhaltIstGanzeZahlAn(pZeile, pSpalte)) {
            return Integer.parseInt(this.inhaltAlsTextAn(pZeile, pSpalte));
        }
        throw new ArithmeticException("inhaltAlsGanzeZahlAn: ist keine ganze Zahl");
    }
    
    public double inhaltAlsZahlAn(final int pZeile, final int pSpalte) throws ArithmeticException {
        if (this.inhaltIstZahlAn(pZeile, pSpalte)) {
            final Double d = new Double(this.inhaltAlsTextAn(pZeile, pSpalte));
            return d;
        }
        throw new ArithmeticException("inhaltAlsZahlAn: ist keine Zahl");
    }
    
    public void setzeMarkierteZeilen(final int pAnfang, final int pEnde) {
        this.hatTable.addRowSelectionInterval(pAnfang - 1, pEnde - 1);
    }
    
    public void setzeMarkierteSpalten(final int pAnfang, final int pEnde) {
        this.hatTable.addColumnSelectionInterval(pAnfang - 1, pEnde - 1);
    }
    
    public void setzeMarkierteZelle(final int pZeile, final int pSpalte) {
        this.setzeMarkierteSpalten(pSpalte, pSpalte);
        this.setzeMarkierteZeilen(pZeile, pZeile);
    }
    
    public boolean istZelleMarkiert(final int pZeile, final int pSpalte) {
        return this.hatTable.isCellSelected(pZeile - 1, pSpalte - 1);
    }
    
    public boolean istZeileMarkiert(final int pZeile) {
        return this.hatTable.isRowSelected(pZeile - 1);
    }
    
    public boolean istSpalteMarkiert(final int pSpalte) {
        return this.hatTable.isColumnSelected(pSpalte - 1);
    }
    
    public void markiereAlles() {
        this.hatTable.selectAll();
    }
    
    public void markiereNichts() {
        this.hatTable.clearSelection();
    }
    
    public void setzeSchriftArt(final String pSchriftart) {
        this.zAktuellFont = pSchriftart;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatTable.setFont(this.zSchriftArt);
    }
    
    public void setzeSchriftart(final String pSchriftart) {
        this.setzeSchriftArt(pSchriftart);
    }
    
    public void setzeSchriftgroesse(final int pGroesse) {
        this.setzeSchriftGroesse(pGroesse);
    }
    
    public void setzeSchriftGroesse(final int pGroesse) {
        this.zSchriftGroesse = pGroesse;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatTable.setFont(this.zSchriftArt);
        this.hatTable.setRowHeight(this.hatTable.getFontMetrics(this.hatTable.getFont()).getHeight());
    }
    
    public void setzeSchriftStil(final int pStil) {
        this.zSchriftStil = pStil;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatTable.setFont(this.zSchriftArt);
    }
    
    public void setzeSchriftstil(final int pStil) {
        this.setzeSchriftStil(pStil);
    }
    
    public void setzeSchriftFarbe(final Color pFarbe) {
        this.hatTable.setForeground(pFarbe);
    }
    
    public void setzeSchriftfarbe(final Color pFarbe) {
        this.setzeSchriftFarbe(pFarbe);
    }
    
    public void setzeSchriftfarbe(final int pFarbe) {
        this.setzeSchriftFarbe(pFarbe);
    }
    
    public void setzeSchriftFarbe(int pFarbe) {
        if (pFarbe < 0) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        switch (pFarbe) {
            case 0: {
                this.setzeSchriftFarbe(Color.black);
                break;
            }
            case 1: {
                this.setzeSchriftFarbe(Color.blue);
                break;
            }
            case 2: {
                this.setzeSchriftFarbe(Color.cyan);
                break;
            }
            case 3: {
                this.setzeSchriftFarbe(Color.darkGray);
                break;
            }
            case 4: {
                this.setzeSchriftFarbe(Color.gray);
                break;
            }
            case 5: {
                this.setzeSchriftFarbe(Color.green);
                break;
            }
            case 6: {
                this.setzeSchriftFarbe(Color.lightGray);
                break;
            }
            case 7: {
                this.setzeSchriftFarbe(Color.magenta);
                break;
            }
            case 8: {
                this.setzeSchriftFarbe(Color.orange);
                break;
            }
            case 9: {
                this.setzeSchriftFarbe(Color.pink);
                break;
            }
            case 10: {
                this.setzeSchriftFarbe(Color.red);
                break;
            }
            case 11: {
                this.setzeSchriftFarbe(Color.white);
                break;
            }
            case 12: {
                this.setzeSchriftFarbe(Color.yellow);
                break;
            }
        }
    }
    
    private class TableDataReaktor implements TableModelListener
    {
        @Override
        public void tableChanged(final TableModelEvent e) {
            Tabelle.this.inhaltGeaendert();
            Tabelle.this.markierungGeaendert();
        }
    }
    
    private class AuswahlReaktor implements ListSelectionListener
    {
        @Override
        public void valueChanged(final ListSelectionEvent e) {
            Tabelle.this.markierungGeaendert();
        }
    }
    
    private class BereichFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Tabelle.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Tabelle.this.verliertFokus();
        }
    }
}
