// 
// Decompiled by Procyon v0.5.36
// 

package sum.ereignis;

import java.util.Vector;

public class EBAnwendung extends Ereignisanwendung
{
    private Vector hatEreignisbearbeiterListe;
    
    public EBAnwendung() {
        this.hatEreignisbearbeiterListe = null;
        this.hatEreignisbearbeiterListe = new Vector();
    }
    
    public EBAnwendung(final boolean pMitDoubleBuffering) {
        super(pMitDoubleBuffering);
        this.hatEreignisbearbeiterListe = null;
        this.hatEreignisbearbeiterListe = new Vector();
    }
    
    public EBAnwendung(final int pBreite, final int pHoehe) {
        super(pBreite, pHoehe);
        this.hatEreignisbearbeiterListe = null;
        this.hatEreignisbearbeiterListe = new Vector();
    }
    
    public EBAnwendung(final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        super(pBreite, pHoehe, pMitDoubleBuffering);
        this.hatEreignisbearbeiterListe = null;
        this.hatEreignisbearbeiterListe = new Vector();
    }
    
    public EBAnwendung(final int pLinks, final int pOben, final int pBreite, final int pHoehe) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.hatEreignisbearbeiterListe = null;
        this.hatEreignisbearbeiterListe = new Vector();
    }
    
    public EBAnwendung(final int pLinks, final int pOben, final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        super(pLinks, pOben, pBreite, pHoehe, pMitDoubleBuffering);
        this.hatEreignisbearbeiterListe = null;
        this.hatEreignisbearbeiterListe = new Vector();
    }
    
    public void meldeAn(final Ereignisbearbeiter pEreignisbearbeiter) {
        this.hatEreignisbearbeiterListe.addElement(pEreignisbearbeiter);
    }
    
    @Override
    public void bearbeiteTaste(final char pZeichen) {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteTaste(pZeichen);
            }
        }
    }
    
    @Override
    public void bearbeiteMausDruck(final int pWoH, final int pWoV) {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteMausDruck(pWoH, pWoV);
            }
        }
    }
    
    @Override
    public void bearbeiteMausLos(final int pWoH, final int pWoV) {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteMausLos(pWoH, pWoV);
            }
        }
    }
    
    @Override
    public void bearbeiteMausBewegt(final int pWohinH, final int pWohinV) {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteMausBewegt(pWohinH, pWohinV);
            }
        }
    }
    
    @Override
    public void bearbeiteDoppelKlick(final int pWoH, final int pWoV) {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteDoppelKlick(pWoH, pWoV);
            }
        }
    }
    
    @Override
    public void bearbeiteLeerlauf() {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteLeerlauf();
            }
        }
    }
    
    @Override
    public void bearbeiteUpdate() {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteUpdate();
            }
        }
    }
    
    @Override
    public void bearbeiteFokusErhalten() {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteFokusErhalten();
            }
        }
    }
    
    @Override
    public void bearbeiteFokusVerloren() {
        if (this.hatEreignisbearbeiterListe != null) {
            for (int i = 0; i < this.hatEreignisbearbeiterListe.size(); ++i) {
                final Ereignisbearbeiter aktueller = this.hatEreignisbearbeiterListe.elementAt(i);
                aktueller.bearbeiteFokusVerloren();
            }
        }
    }
}
