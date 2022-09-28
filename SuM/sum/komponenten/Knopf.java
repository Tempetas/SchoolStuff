// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import java.io.Serializable;

public class Knopf extends Textkomponente implements Serializable
{
    private String zGeklicktBearbeiter;
    protected AbstractButton hatButton;
    
    public Knopf(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift) {
        this.zGeklicktBearbeiter = "";
        (this.hatButton = new JButton(pAufschrift)).setOpaque(true);
        Bildschirm.topFenster.privatPanel().add(this.hatButton, 0);
        this.hatButton.addActionListener(new KnopfReaktor());
        this.hatButton.addKeyListener(new KnopfTastenReaktor());
        this.hatButton.addFocusListener(new KnopfFokusReaktor());
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatButton);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Knopf(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift, final String pGeklicktBearbeiter) {
        this(pLinks, pOben, pBreite, pHoehe, pAufschrift);
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
    }
    
    public Knopf(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift) {
        this.zGeklicktBearbeiter = "";
        (this.hatButton = new JButton(pAufschrift)).setOpaque(true);
        pFenster.privatPanel().add(this.hatButton, 0);
        this.hatButton.addActionListener(new KnopfReaktor());
        this.hatButton.addKeyListener(new KnopfTastenReaktor());
        this.hatButton.addFocusListener(new KnopfFokusReaktor());
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatButton);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Knopf(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pAufschrift, final String pGeklicktBearbeiter) {
        this(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
    }
    
    public Knopf() {
        this.zGeklicktBearbeiter = "";
    }
    
    public void setzeBearbeiterGeklickt(final String pBearbeiter) {
        this.zGeklicktBearbeiter = pBearbeiter;
    }
    
    protected void knopfGeklickt() {
        final Class[] formparas = { null };
        final Knopf[] meinKnopf = { null };
        if (this.zGeklicktBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zGeklicktBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + this.inhaltAlsText() + "\": " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Knopf.class;
                        final Method methode = sumEreignis.getMethod(this.zGeklicktBearbeiter, (Class[])formparas);
                        meinKnopf[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinKnopf);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + this.inhaltAlsText() + "\": " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + this.inhaltAlsText() + "\" nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("Knopf: " + e3.toString());
            }
        }
    }
    
    protected void bekommtFokus() {
        final Class[] formparas = { null };
        final Knopf[] meinKnopf = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" von Knopf \"" + this.inhaltAlsText() + "\": " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Knopf.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meinKnopf[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinKnopf);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" von Knopf \"" + this.inhaltAlsText() + "\": " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" von Knopf \"" + this.inhaltAlsText() + "\" nicht gefunden.");
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
        final Knopf[] meinKnopf = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" von Knopf \"" + this.inhaltAlsText() + "\": " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Knopf.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meinKnopf[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinKnopf);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" von Knopf \"" + this.inhaltAlsText() + "\": " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" von Knopf \"" + this.inhaltAlsText() + "\" nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    @Override
    public void setzeInhalt(final String pText) {
        this.hatButton.setText(pText);
        Bildschirm.topFenster.doUpdate((JComponent)this.hatButton);
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatButton.getText();
    }
    
    private class KnopfReaktor implements ActionListener
    {
        @Override
        public void actionPerformed(final ActionEvent e) {
            Knopf.this.knopfGeklickt();
        }
    }
    
    private class KnopfTastenReaktor implements KeyListener
    {
        @Override
        public void keyTyped(final KeyEvent e) {
        }
        
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == 10) {
                Knopf.this.knopfGeklickt();
            }
        }
        
        @Override
        public void keyReleased(final KeyEvent e) {
        }
    }
    
    private class KnopfFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Knopf.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Knopf.this.verliertFokus();
        }
    }
}
