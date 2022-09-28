// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.FocusEvent;
import javax.swing.event.ChangeEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import javax.swing.JComponent;
import java.awt.Component;
import sum.ereignis.Bildschirm;
import java.awt.event.FocusListener;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import java.io.Serializable;

public class Regler extends Komponente implements Serializable
{
    private String zGeaendertBearbeiter;
    private JSlider hatSlider;
    
    public Regler(final int pStil, final int pAnfangswert, final int pMinwert, final int pMaxwert) {
        this(10.0, 10.0, 10.0, 10.0, pAnfangswert, pMinwert, pMaxwert);
    }
    
    public Regler(final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pAnfangswert, final int pMinwert, final int pMaxwert) {
        this.zGeaendertBearbeiter = "";
        if (pHoehe > pBreite) {
            this.hatSlider = new JSlider(1, pMinwert, pMaxwert, pAnfangswert);
        }
        else {
            this.hatSlider = new JSlider(0, pMinwert, pMaxwert, pAnfangswert);
        }
        this.hatSlider.setOpaque(true);
        this.hatSlider.addChangeListener(new SliderReaktor());
        this.hatSlider.addFocusListener(new SliderFokusReaktor());
        Bildschirm.topFenster.privatPanel().add(this.hatSlider, 0);
        this.lerneKomponenteKennen(Bildschirm.topFenster, this.hatSlider);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public Regler(final Fenster pFenster, final int pStil, final int pAnfangswert, final int pMinwert, final int pMaxwert) {
        this(pFenster, 10.0, 10.0, 10.0, 10.0, pAnfangswert, pMinwert, pMaxwert);
    }
    
    public Regler(final Fenster pFenster, final double pLinks, final double pOben, final double pBreite, final double pHoehe, final int pAnfangswert, final int pMinwert, final int pMaxwert) {
        this.zGeaendertBearbeiter = "";
        if (pHoehe > pBreite) {
            this.hatSlider = new JSlider(1, pMinwert, pMaxwert, pAnfangswert);
        }
        else {
            this.hatSlider = new JSlider(0, pMinwert, pMaxwert, pAnfangswert);
        }
        this.hatSlider.setOpaque(true);
        this.hatSlider.addChangeListener(new SliderReaktor());
        this.hatSlider.addFocusListener(new SliderFokusReaktor());
        pFenster.privatPanel().add(this.hatSlider, 0);
        this.lerneKomponenteKennen((Bildschirm)pFenster, this.hatSlider);
        this.init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public void setzeBearbeiterGeaendert(final String pBearbeiter) {
        this.zGeaendertBearbeiter = pBearbeiter;
    }
    
    protected void geaendert() {
        final Class[] formparas = { null };
        final Regler[] meinRegler = { null };
        if (this.zGeaendertBearbeiter.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Regler.class;
                        final Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, (Class[])formparas);
                        meinRegler[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinRegler);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
        this.kenntFenster.doUpdate((JComponent)this.hatSlider);
    }
    
    protected void bekommtFokus() {
        final Class[] formparas = { null };
        final Regler[] meinRegler = { null };
        this.setzeFokusWert(true);
        if (this.fokusErhaltenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Reglers: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Regler.class;
                        final Method methode = sumEreignis.getMethod(this.fokusErhaltenBearbeiter(), (Class[])formparas);
                        meinRegler[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinRegler);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Reglers: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusErhaltenBearbeiter() + "\" eines Reglers nicht gefunden.");
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
        final Regler[] meinRegler = { null };
        this.setzeFokusWert(false);
        if (this.fokusVerlorenBearbeiter().length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Reglers: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Regler.class;
                        final Method methode = sumEreignis.getMethod(this.fokusVerlorenBearbeiter(), (Class[])formparas);
                        meinRegler[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meinRegler);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Reglers: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + this.fokusVerlorenBearbeiter() + "\" eines Reglers nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void setzeWert(final int pWert) {
        this.hatSlider.setValue(pWert);
        this.hatSlider.paintImmediately(0, 0, this.hatSlider.getWidth(), this.hatSlider.getHeight());
        this.hatSlider.validate();
    }
    
    public int wert() {
        return this.hatSlider.getValue();
    }
    
    public void setzeMinimum(final int pWert) {
        this.hatSlider.setMinimum(pWert);
    }
    
    public int minimum() {
        return this.hatSlider.getMinimum();
    }
    
    public void setzeMaximum(final int pWert) {
        this.hatSlider.setMaximum(pWert);
    }
    
    public int maximum() {
        return this.hatSlider.getMaximum();
    }
    
    private class SliderReaktor implements ChangeListener
    {
        @Override
        public void stateChanged(final ChangeEvent e) {
            Regler.this.geaendert();
        }
    }
    
    private class SliderFokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Regler.this.bekommtFokus();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            Regler.this.verliertFokus();
        }
    }
}
