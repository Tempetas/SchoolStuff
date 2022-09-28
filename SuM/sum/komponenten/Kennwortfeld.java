// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import java.awt.event.KeyListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseMotionListener;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import java.io.Serializable;

public class Kennwortfeld extends Textfeld implements Serializable
{
    protected String zEingabeBestaetigtBearbeiter;
    protected JPasswordField hatPasswordField;
    
    public Kennwortfeld(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final char pEchozeichen) {
        this.zEingabeBestaetigtBearbeiter = "";
        (this.hatPasswordField = new JPasswordField()).setOpaque(true);
        this.hatTextField = this.hatPasswordField;
        this.hatPasswordField.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatPasswordField.addMouseMotionListener(new FeldMausReaktor());
        this.hatPasswordField.addFocusListener(new FeldFokusReaktor());
        this.hatPasswordField.addKeyListener(new FeldTastenReaktor());
        this.hatPasswordField.setEchoChar(pEchozeichen);
        Bildschirm.topFenster.privatPanel().add(this.hatPasswordField, 0);
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatPasswordField);
        this.init(pLinks, pOben, pBreite, pHoehe, "");
    }
    
    public Kennwortfeld(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final char pEchozeichen) {
        this.zEingabeBestaetigtBearbeiter = "";
        (this.hatPasswordField = new JPasswordField()).setOpaque(true);
        this.hatTextField = this.hatPasswordField;
        this.hatPasswordField.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatPasswordField.addMouseMotionListener(new FeldMausReaktor());
        this.hatPasswordField.addFocusListener(new FeldFokusReaktor());
        this.hatPasswordField.addKeyListener(new FeldTastenReaktor());
        this.hatPasswordField.setEchoChar(pEchozeichen);
        pFenster.privatPanel().add(this.hatPasswordField, 0);
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatPasswordField);
        this.init(pLinks, pOben, pBreite, pHoehe, "");
    }
    
    @Override
    public void setzeBearbeiterEingabeBestaetigt(final String pBearbeiter) {
        this.zEingabeBestaetigtBearbeiter = pBearbeiter;
    }
    
    @Override
    protected void inhaltGeaendert() {
        final Class[] formparas = { null };
        final Kennwortfeld[] meinTextfeld = { null };
        if (this.zInhaltGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Kennwortfeld.class;
                        final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])formparas);
                        meinTextfeld[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinTextfeld);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    @Override
    protected void eingabeBestaetigt() {
        final Class[] formparas = { null };
        final Kennwortfeld[] meinTextfeld = { null };
        if (this.zEingabeBestaetigtBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zEingabeBestaetigtBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Kennwortfeld.class;
                        final Method methode = sumEreignis.getMethod(this.zEingabeBestaetigtBearbeiter, (Class[])formparas);
                        meinTextfeld[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinTextfeld);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    @Override
    protected void markierungGeaendert() {
        final Class[] formparas = { null };
        final Kennwortfeld[] meinTextfeld = { null };
        if (this.zMarkierungGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Kennwortfeld.class;
                        final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])formparas);
                        meinTextfeld[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinTextfeld);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    @Override
    protected void bekommtFokus() {
        final Class[] formparas = { null };
        final Kennwortfeld[] meinTextfeld = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Textfelds: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Kennwortfeld.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meinTextfeld[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinTextfeld);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Textfelds: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Textfelds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    @Override
    protected void verliertFokus() {
        final Class[] formparas = { null };
        final Kennwortfeld[] meinTextfeld = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Textfelds: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Textfeld.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meinTextfeld[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinTextfeld);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Textfelds: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Textfelds nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void setzeKennwortzeichen(final char pZeichen) {
        this.hatPasswordField.setEchoChar(pZeichen);
    }
    
    public void setzeKennwortZeichen(final char pZeichen) {
        this.hatPasswordField.setEchoChar(pZeichen);
    }
    
    public char kennwortzeichen() {
        return this.hatPasswordField.getEchoChar();
    }
    
    public char kennwortZeichen() {
        return this.hatPasswordField.getEchoChar();
    }
    
    private class DokumentReaktor implements DocumentListener
    {
        @Override
        public void insertUpdate(final DocumentEvent e) {
            Kennwortfeld.this.inhaltGeaendert();
            Kennwortfeld.this.markierungGeaendert();
        }
        
        @Override
        public void removeUpdate(final DocumentEvent e) {
            Kennwortfeld.this.inhaltGeaendert();
            Kennwortfeld.this.markierungGeaendert();
        }
        
        @Override
        public void changedUpdate(final DocumentEvent e) {
            Kennwortfeld.this.inhaltGeaendert();
            Kennwortfeld.this.markierungGeaendert();
        }
    }
    
    private class FeldMausReaktor implements MouseMotionListener
    {
        @Override
        public void mouseDragged(final MouseEvent e) {
            Kennwortfeld.this.markierungGeaendert();
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
        }
    }
    
    private class FeldTastenReaktor implements KeyListener
    {
        @Override
        public void keyTyped(final KeyEvent e) {
        }
        
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == 10) {
                Kennwortfeld.this.eingabeBestaetigt();
            }
        }
        
        @Override
        public void keyReleased(final KeyEvent e) {
        }
    }
    
    private class FeldFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Kennwortfeld.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Kennwortfeld.this.verliertFokus();
        }
    }
}
