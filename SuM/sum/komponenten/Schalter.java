// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.ItemListener;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import javax.swing.JCheckBox;
import java.io.Serializable;

public class Schalter extends Textkomponente implements Serializable
{
    private String zGeklicktBearbeiter;
    private JCheckBox hatCheckbox;
    
    public Schalter(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift) {
        this.zGeklicktBearbeiter = "";
        (this.hatCheckbox = new JCheckBox(pAufschrift)).setOpaque(true);
        Bildschirm.topFenster.privatPanel().add(this.hatCheckbox, 0);
        this.hatCheckbox.addItemListener(new SchalterReaktor());
        this.hatCheckbox.addKeyListener(new SchalterTastenReaktor());
        this.hatCheckbox.addFocusListener(new SchalterFokusReaktor());
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatCheckbox);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Schalter(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift) {
        this.zGeklicktBearbeiter = "";
        (this.hatCheckbox = new JCheckBox(pAufschrift)).setOpaque(true);
        pFenster.privatPanel().add(this.hatCheckbox, 0);
        this.hatCheckbox.addItemListener(new SchalterReaktor());
        this.hatCheckbox.addKeyListener(new SchalterTastenReaktor());
        this.hatCheckbox.addFocusListener(new SchalterFokusReaktor());
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatCheckbox);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Schalter(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift, final String pGeklicktBearbeiter) {
        this(pLinks, pOben, pBreite, pHoehe, pAufschrift);
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
    }
    
    public void setzeBearbeiterGeklickt(final String pBearbeiter) {
        this.zGeklicktBearbeiter = pBearbeiter;
    }
    
    protected void schalterGeklickt() {
        final Class[] formparas = { null };
        final Schalter[] schalter = { null };
        if (this.zGeklicktBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method method = sumEreignis.getMethod(this.zGeklicktBearbeiter, (Class[])null);
                    method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Schalter \"" + this.inhaltAlsText() + "\": " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Schalter.class;
                        final Method method = sumEreignis.getMethod(this.zGeklicktBearbeiter, (Class[])formparas);
                        schalter[0] = this;
                        method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])schalter);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Schalter \"" + this.inhaltAlsText() + "\": " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zGeklicktBearbeiter + "\" von Schalter \"" + this.inhaltAlsText() + "\" nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    protected void fokusErhalten() {
        final Class[] formparas = { null };
        final Schalter[] schalter = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method method = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" von Schalter \"" + this.inhaltAlsText() + "\": " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Schalter.class;
                        final Method method = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        schalter[0] = this;
                        method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])schalter);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" von Schalter \"" + this.inhaltAlsText() + "\": " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" von Schalter \"" + this.inhaltAlsText() + "\" nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    protected void fokusVerloren() {
        final Class[] formparas = { null };
        final Schalter[] schalter = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method method = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" von Schalter \"" + this.inhaltAlsText() + "\": " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Schalter.class;
                        final Method method = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        schalter[0] = this;
                        method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])schalter);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" von Schalter \"" + this.inhaltAlsText() + "\": " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" von Schalter \"" + this.inhaltAlsText() + "\" nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void schalteAn() {
        this.hatCheckbox.setSelected(true);
    }
    
    public void schalteAus() {
        this.hatCheckbox.setSelected(false);
    }
    
    public boolean angeschaltet() {
        return this.hatCheckbox.isSelected();
    }
    
    @Override
    public void setzeInhalt(final String pText) {
        this.hatCheckbox.setText(pText);
        this.kenntFenster.doUpdate((JComponent)this.hatCheckbox);
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatCheckbox.getText();
    }
    
    private class SchalterReaktor implements ItemListener
    {
        @Override
        public void itemStateChanged(final ItemEvent e) {
            Schalter.this.schalterGeklickt();
        }
    }
    
    private class SchalterTastenReaktor implements KeyListener
    {
        @Override
        public void keyTyped(final KeyEvent e) {
        }
        
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == 10) {
                Schalter.this.schalterGeklickt();
            }
        }
        
        @Override
        public void keyReleased(final KeyEvent e) {
        }
    }
    
    private class SchalterFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Schalter.this.fokusErhalten();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Schalter.this.fokusVerloren();
        }
    }
}
