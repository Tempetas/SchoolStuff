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
import javax.swing.JTextField;
import java.io.Serializable;

public class Textfeld extends Markierungskomponente implements Serializable
{
    protected String zEingabeBestaetigtBearbeiter;
    protected JTextField hatTextField;
    
    public Textfeld(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        this.zEingabeBestaetigtBearbeiter = "";
        (this.hatTextField = new JTextField()).setOpaque(true);
        this.hatTextField.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatTextField.addMouseMotionListener(new FeldMausReaktor());
        this.hatTextField.addFocusListener(new FeldFokusReaktor());
        this.hatTextField.addKeyListener(new FeldTastenReaktor());
        Bildschirm.topFenster.privatPanel().add(this.hatTextField, 0);
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatTextField);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Textfeld(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        this.zEingabeBestaetigtBearbeiter = "";
        (this.hatTextField = new JTextField()).setOpaque(true);
        this.hatTextField.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatTextField.addMouseMotionListener(new FeldMausReaktor());
        this.hatTextField.addFocusListener(new FeldFokusReaktor());
        this.hatTextField.addKeyListener(new FeldTastenReaktor());
        pFenster.privatPanel().add(this.hatTextField, 0);
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatTextField);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Textfeld() {
        this.zEingabeBestaetigtBearbeiter = "";
    }
    
    public void setzeBearbeiterEingabeBestaetigt(final String pBearbeiter) {
        this.zEingabeBestaetigtBearbeiter = pBearbeiter;
    }
    
    protected void inhaltGeaendert() {
        final Class[] formparas = { null };
        final Textfeld[] meinTextfeld = { null };
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
                        formparas[0] = Textfeld.class;
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
    
    protected void eingabeBestaetigt() {
        final Class[] formparas = { null };
        final Textfeld[] meinTextfeld = { null };
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
                        formparas[0] = Textfeld.class;
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
        final Textfeld[] meinTextfeld = { null };
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
                        formparas[0] = Textfeld.class;
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
    
    protected void bekommtFokus() {
        final Class[] formparas = { null };
        final Textfeld[] meinTextfeld = { null };
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
                        formparas[0] = Textfeld.class;
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
    
    protected void verliertFokus() {
        final Class[] formparas = { null };
        final Textfeld[] meinTextfeld = { null };
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
    
    @Override
    public void setzeInhalt(final String pText) {
        this.hatTextField.setText(pText);
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatTextField.getText();
    }
    
    @Override
    public String teilinhalt(final int pAnfang, final int pEnde) {
        final String s = this.hatTextField.getText();
        return s.substring(pAnfang - 1, pEnde);
    }
    
    @Override
    public void fuegeEin(final String pText, final int pStelle) {
        final String s = this.hatTextField.getText();
        final String s2 = s.substring(0, pStelle - 1);
        final String s3 = s.substring(pStelle - 1, s.length());
        this.setzeInhalt(s2 + pText + s3);
    }
    
    @Override
    public void haengeAn(final String pText) {
        this.setzeInhalt(this.hatTextField.getText() + pText);
    }
    
    @Override
    public void haengeAn(final char pZeichen) {
        this.setzeInhalt(this.hatTextField.getText() + pZeichen);
    }
    
    @Override
    public void haengeAn(final int pZahl) {
        this.setzeInhalt(this.hatTextField.getText() + pZahl);
    }
    
    @Override
    public void haengeAn(final double pZahl) {
        this.setzeInhalt(this.hatTextField.getText() + pZahl);
    }
    
    @Override
    public String markierterInhalt() {
        return this.hatTextField.getSelectedText();
    }
    
    @Override
    public void setzeMarkierung(final int pAnfang, final int pEnde) {
        this.hatTextField.requestFocus();
        this.hatTextField.select(pAnfang - 1, pEnde);
        this.markierungGeaendert();
    }
    
    @Override
    public void markiereAlles() {
        this.hatTextField.requestFocus();
        this.hatTextField.selectAll();
        this.markierungGeaendert();
    }
    
    @Override
    public void markiereNichts() {
        this.hatTextField.requestFocus();
        this.hatTextField.select(0, 0);
        this.markierungGeaendert();
    }
    
    @Override
    public void loescheAlles() {
        this.setzeInhalt("");
    }
    
    @Override
    public void loescheMarkierung() {
        final String s = this.hatTextField.getText();
        final int von = this.hatTextField.getSelectionStart();
        final int bis = this.hatTextField.getSelectionEnd();
        if (bis > von) {
            final String s2 = s.substring(0, von);
            final String s3 = s.substring(bis, s.length());
            this.setzeInhalt(s2 + s3);
            this.markierungGeaendert();
        }
    }
    
    @Override
    public void loesche(final int pAnfang, final int pEnde) {
        final String s = this.hatTextField.getText();
        final String s2 = s.substring(0, pAnfang - 1);
        final String s3 = s.substring(pEnde, s.length());
        this.setzeInhalt(s2 + s3);
        this.markierungGeaendert();
    }
    
    @Override
    public boolean istMarkiert() {
        return this.hatTextField.getSelectionStart() < this.hatTextField.getSelectionEnd();
    }
    
    @Override
    public int markierungsAnfang() {
        return this.hatTextField.getSelectionStart() + 1;
    }
    
    @Override
    public int markierungsEnde() {
        return this.hatTextField.getSelectionEnd();
    }
    
    public void setzeAusrichtung(final int pAusrichtung) {
        switch (pAusrichtung) {
            case 0: {
                this.hatTextField.setHorizontalAlignment(2);
                break;
            }
            case 1: {
                this.hatTextField.setHorizontalAlignment(0);
                break;
            }
            case 2: {
                this.hatTextField.setHorizontalAlignment(4);
                break;
            }
        }
    }
    
    private class DokumentReaktor implements DocumentListener
    {
        @Override
        public void insertUpdate(final DocumentEvent e) {
            Textfeld.this.inhaltGeaendert();
            Textfeld.this.markierungGeaendert();
        }
        
        @Override
        public void removeUpdate(final DocumentEvent e) {
            Textfeld.this.inhaltGeaendert();
            Textfeld.this.markierungGeaendert();
        }
        
        @Override
        public void changedUpdate(final DocumentEvent e) {
            Textfeld.this.inhaltGeaendert();
            Textfeld.this.markierungGeaendert();
        }
    }
    
    private class FeldMausReaktor implements MouseMotionListener
    {
        @Override
        public void mouseDragged(final MouseEvent e) {
            Textfeld.this.markierungGeaendert();
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
                Textfeld.this.eingabeBestaetigt();
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
            Textfeld.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Textfeld.this.verliertFokus();
        }
    }
}
