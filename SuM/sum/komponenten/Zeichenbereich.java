// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import sum.ereignis.Bildschirm;
import java.awt.event.FocusListener;
import java.awt.event.MouseMotionListener;
import javax.swing.event.DocumentListener;
import javax.swing.JTextArea;
import java.io.Serializable;

public class Zeichenbereich extends Textbereich implements Serializable
{
    private JTextArea hatTextArea;
    private String zInhaltGeaendertBearbeiter;
    private String zMarkierungGeaendertBearbeiter;
    public static final String NEUERABSATZ = "\n";
    
    public Zeichenbereich(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
        (this.hatTextArea = new JTextArea("", 2, 2)).setLineWrap(true);
        this.hatTextArea.setWrapStyleWord(true);
        this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatTextArea.addMouseMotionListener(new BereichMausReaktor());
        this.hatTextArea.addFocusListener(new BereichFokusReaktor());
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatTextArea);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Zeichenbereich(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
        (this.hatTextArea = new JTextArea("", 2, 2)).setLineWrap(true);
        this.hatTextArea.setWrapStyleWord(true);
        this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatTextArea.addMouseMotionListener(new BereichMausReaktor());
        this.hatTextArea.addFocusListener(new BereichFokusReaktor());
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatTextArea);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    protected void inhaltGeaendert() {
        final Class[] formparas = { null };
        final Zeichenbereich[] meinZeichenbereich = { null };
        if (this.zInhaltGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeichenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])formparas);
                        meinZeichenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeichenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeichenbereichs nicht gefunden.");
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
        final Zeichenbereich[] meinZeichenbereich = { null };
        if (this.zMarkierungGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeichenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])formparas);
                        meinZeichenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeichenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeichenbereichs nicht gefunden.");
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
        final Zeichenbereich[] meinZeichenbereich = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeichenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meinZeichenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeichenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Zeichenbereichs nicht gefunden.");
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
        final Zeichenbereich[] meinZeichenbereich = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeichenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meinZeichenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeichenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Zeichenbereichs nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    @Override
    public void setzeBearbeiterInhaltGeaendert(final String pBearbeiter) {
        this.zInhaltGeaendertBearbeiter = pBearbeiter;
    }
    
    @Override
    public void setzeBearbeiterMarkierungGeaendert(final String pBearbeiter) {
        this.zMarkierungGeaendertBearbeiter = pBearbeiter;
    }
    
    public int anzahl() {
        return this.hatTextArea.getText().length();
    }
    
    public void neuerAbsatz() {
        this.hatTextArea.append("\n");
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void fuegeEin(final String pText, final int pStelle) {
        this.hatTextArea.insert(pText, pStelle - 1);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(final String pText) {
        this.hatTextArea.append(pText);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(final char pZeichen) {
        this.hatTextArea.append("" + pZeichen);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(final int pZahl) {
        this.hatTextArea.append("" + pZahl);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(final double pZahl) {
        this.hatTextArea.append("" + pZahl);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void setzeInhalt(final String pText) {
        this.hatTextArea.setText(pText);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatTextArea.getText();
    }
    
    @Override
    public String teilinhalt(final int pAnfang, final int pEnde) {
        final String s = this.hatTextArea.getText();
        return s.substring(pAnfang - 1, pEnde);
    }
    
    @Override
    public String markierterInhalt() {
        return this.hatTextArea.getSelectedText();
    }
    
    @Override
    public void setzeMarkierung(final int pAnfang, final int pEnde) {
        this.hatTextArea.requestFocus();
        this.hatTextArea.select(pAnfang - 1, pEnde);
        this.markierungGeaendert();
    }
    
    @Override
    public void markiereAlles() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.selectAll();
        this.markierungGeaendert();
    }
    
    @Override
    public void markiereNichts() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.select(0, 0);
        this.markierungGeaendert();
    }
    
    @Override
    public void loescheAlles() {
        this.setzeInhalt("");
    }
    
    @Override
    public void loescheMarkierung() {
        final String s = this.hatTextArea.getText();
        final int von = this.hatTextArea.getSelectionStart();
        final int bis = this.hatTextArea.getSelectionEnd();
        if (bis > von) {
            final String s2 = s.substring(0, von);
            final String s3 = s.substring(bis, s.length());
            this.setzeInhalt(s2 + s3);
            this.markierungGeaendert();
        }
    }
    
    @Override
    public void loesche(final int pAnfang, final int pEnde) {
        final String s = this.hatTextArea.getText();
        final String s2 = s.substring(0, pAnfang - 1);
        final String s3 = s.substring(pEnde, s.length());
        this.setzeInhalt(s2 + s3);
        this.markierungGeaendert();
    }
    
    @Override
    public boolean istMarkiert() {
        return this.hatTextArea.getSelectionStart() < this.hatTextArea.getSelectionEnd();
    }
    
    @Override
    public int markierungsAnfang() {
        return this.hatTextArea.getSelectionStart() + 1;
    }
    
    @Override
    public int markierungsEnde() {
        return this.hatTextArea.getSelectionEnd();
    }
    
    private class DokumentReaktor implements DocumentListener
    {
        @Override
        public void insertUpdate(final DocumentEvent e) {
            Zeichenbereich.this.inhaltGeaendert();
            Zeichenbereich.this.markierungGeaendert();
        }
        
        @Override
        public void removeUpdate(final DocumentEvent e) {
            Zeichenbereich.this.inhaltGeaendert();
            Zeichenbereich.this.markierungGeaendert();
        }
        
        @Override
        public void changedUpdate(final DocumentEvent e) {
            Zeichenbereich.this.inhaltGeaendert();
            Zeichenbereich.this.markierungGeaendert();
        }
    }
    
    private class BereichMausReaktor implements MouseMotionListener
    {
        @Override
        public void mouseDragged(final MouseEvent e) {
            Zeichenbereich.this.markierungGeaendert();
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
        }
    }
    
    private class BereichFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Zeichenbereich.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Zeichenbereich.this.verliertFokus();
        }
    }
}
