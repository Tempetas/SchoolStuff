// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.event.ItemListener;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import javax.swing.JComboBox;
import java.io.Serializable;

public class Auswahl extends Komponente implements Serializable
{
    private String zGeaendertBearbeiter;
    private JComboBox hatComboBox;
    
    public Auswahl(final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        this.zGeaendertBearbeiter = "";
        (this.hatComboBox = new JComboBox()).setOpaque(true);
        Bildschirm.topFenster.privatPanel().add(this.hatComboBox, 0);
        this.hatComboBox.addItemListener(new AuswahlReaktor());
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatComboBox);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Auswahl(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe) {
        this.zGeaendertBearbeiter = "";
        (this.hatComboBox = new JComboBox()).setOpaque(true);
        pFenster.privatPanel().add(this.hatComboBox, 0);
        this.hatComboBox.addItemListener(new AuswahlReaktor());
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatComboBox);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public void setzeBearbeiterGeaendert(final String pBearbeiter) {
        this.zGeaendertBearbeiter = pBearbeiter;
    }
    
    protected void gewaehlt(final int pIndex, final String pText) {
        final Class[] formparas = { null };
        final Auswahl[] meineAuswahl = { null };
        if (this.zGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Auswahl.class;
                        final Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, (Class[])formparas);
                        meineAuswahl[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineAuswahl);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl nicht gefunden.");
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
        final Auswahl[] meineAuswahl = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" einer Auswahl: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Auswahl.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meineAuswahl[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineAuswahl);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" einer Auswahl: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" einer Auswahl nicht gefunden.");
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
        final Auswahl[] meineAuswahl = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" einer Auswahl: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Auswahl.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meineAuswahl[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineAuswahl);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" einer Auswahl: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" einer Auswahl nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void haengeAn(final String pText) {
        this.hatComboBox.addItem(pText);
    }
    
    public int index() {
        return this.hatComboBox.getSelectedIndex() + 1;
    }
    
    public String text() {
        return (String)this.hatComboBox.getSelectedItem();
    }
    
    public void waehle(final int pIndex) {
        this.hatComboBox.setSelectedIndex(pIndex - 1);
    }
    
    public void waehle(final String pText) {
        this.hatComboBox.setSelectedItem(pText);
    }
    
    public int zeilenAnzahl() {
        return this.hatComboBox.getItemCount();
    }
    
    public void entferneAlleZeilen() {
        this.hatComboBox.removeAllItems();
    }
    
    private class AuswahlReaktor implements ItemListener
    {
        @Override
        public void itemStateChanged(final ItemEvent e) {
            final JComboBox comboBox = (JComboBox)e.getItemSelectable();
            Auswahl.this.gewaehlt(comboBox.getSelectedIndex(), (String)comboBox.getSelectedItem());
        }
    }
    
    private class KnopfFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Auswahl.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Auswahl.this.verliertFokus();
        }
    }
}
