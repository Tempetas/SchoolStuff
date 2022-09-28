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

public class Zeilenbereich extends Textbereich implements Serializable
{
    private JTextArea hatTextArea;
    private String zInhaltGeaendertBearbeiter;
    private String zMarkierungGeaendertBearbeiter;
    public static final String NEUERABSATZ = "\n";
    
    public Zeilenbereich(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
        this.hatScrollPane.setHorizontalScrollBarPolicy(30);
        (this.hatTextArea = new JTextArea("", 2, 2)).setLineWrap(false);
        this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatTextArea.addMouseMotionListener(new BereichMausReaktor());
        this.hatTextArea.addFocusListener(new BereichFokusReaktor());
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatTextArea);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Zeilenbereich(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final String pText) {
        super(pFenster, pLinks, pOben, pBreite, pHoehe);
        this.zInhaltGeaendertBearbeiter = "";
        this.zMarkierungGeaendertBearbeiter = "";
        this.hatScrollPane.setHorizontalScrollBarPolicy(30);
        (this.hatTextArea = new JTextArea("", 2, 2)).setLineWrap(false);
        this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor());
        this.hatTextArea.addMouseMotionListener(new BereichMausReaktor());
        this.hatTextArea.addFocusListener(new BereichFokusReaktor());
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatTextArea);
        this.init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    protected void inhaltGeaendert() {
        final Class[] formparas = { null };
        final Zeilenbereich[] meinZeilenbereich = { null };
        if (this.zInhaltGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeilenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, (Class[])formparas);
                        meinZeilenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeilenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeilenbereichs nicht gefunden.");
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
        final Zeilenbereich[] meinZeilenbereich = { null };
        if (this.zMarkierungGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeilenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, (Class[])formparas);
                        meinZeilenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeilenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeilenbereichs nicht gefunden.");
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
        final Zeilenbereich[] meinZeilenbereich = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeilenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meinZeilenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeilenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Zeilenbereichs nicht gefunden.");
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
        final Zeilenbereich[] meinZeilenbereich = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Zeilenbereich.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meinZeilenbereich[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinZeilenbereich);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Zeilenbereichs nicht gefunden.");
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
        return this.hatTextArea.getLineCount();
    }
    
    public void neuerAbsatz() {
        this.hatTextArea.append("\n");
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void fuegeEin(final String pText, final int pZeile) {
        try {
            this.hatTextArea.insert(pText + '\n', this.hatTextArea.getLineStartOffset(pZeile - 1));
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(final String pText) {
        this.hatTextArea.append(pText + '\n');
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(final char pZeichen) {
        this.haengeAn("" + pZeichen);
    }
    
    @Override
    public void haengeAn(final int pZahl) {
        this.haengeAn("" + pZahl);
    }
    
    @Override
    public void haengeAn(final double pZahl) {
        this.haengeAn("" + pZahl);
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
        try {
            if (this.hatTextArea.getLineStartOffset(pAnfang - 1) == this.hatTextArea.getLineEndOffset(pEnde - 1)) {
                return "";
            }
            if (pEnde < this.anzahl()) {
                return this.hatTextArea.getText(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1) - this.hatTextArea.getLineStartOffset(pAnfang - 1) - 1);
            }
            return this.hatTextArea.getText(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1) - this.hatTextArea.getLineStartOffset(pAnfang - 1));
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    @Override
    public String markierterInhalt() {
        return this.hatTextArea.getSelectedText();
    }
    
    @Override
    public void setzeMarkierung(final int pAnfang, final int pEnde) {
        try {
            this.hatTextArea.requestFocus();
            this.hatTextArea.select(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1));
            this.markierungGeaendert();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    @Override
    public void markiereAlles() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.selectAll();
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
        this.markierungGeaendert();
    }
    
    @Override
    public void markiereNichts() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.select(0, 0);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
        this.markierungGeaendert();
    }
    
    @Override
    public void loescheAlles() {
        this.setzeInhalt("");
    }
    
    @Override
    public void loescheMarkierung() {
        this.hatTextArea.cut();
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void loesche(final int pAnfang, final int pEnde) {
        this.setzeMarkierung(pAnfang, pEnde);
        this.loescheMarkierung();
    }
    
    @Override
    public boolean istMarkiert() {
        return this.hatTextArea.getSelectionStart() < this.hatTextArea.getSelectionEnd();
    }
    
    @Override
    public int markierungsAnfang() {
        try {
            return this.hatTextArea.getLineOfOffset(this.hatTextArea.getSelectionStart()) + 1;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    @Override
    public int markierungsEnde() {
        try {
            return this.hatTextArea.getLineOfOffset(this.hatTextArea.getSelectionEnd()) + 1;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    private class DokumentReaktor implements DocumentListener
    {
        @Override
        public void insertUpdate(final DocumentEvent e) {
            Zeilenbereich.this.inhaltGeaendert();
            Zeilenbereich.this.markierungGeaendert();
        }
        
        @Override
        public void removeUpdate(final DocumentEvent e) {
            Zeilenbereich.this.inhaltGeaendert();
            Zeilenbereich.this.markierungGeaendert();
        }
        
        @Override
        public void changedUpdate(final DocumentEvent e) {
            Zeilenbereich.this.inhaltGeaendert();
            Zeilenbereich.this.markierungGeaendert();
        }
    }
    
    private class BereichMausReaktor implements MouseMotionListener
    {
        @Override
        public void mouseDragged(final MouseEvent e) {
            Zeilenbereich.this.markierungGeaendert();
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
        }
    }
    
    private class BereichFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Zeilenbereich.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Zeilenbereich.this.verliertFokus();
        }
    }
}
