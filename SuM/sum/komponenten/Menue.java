// 
// Decompiled by Procyon v0.5.36
// 

package sum.komponenten;

import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import sum.ereignis.Ereignisanwendung;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import sum.ereignis.Bildschirm;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Menue extends Textkomponente implements Serializable
{
    private ActionListener hatListener;
    private JMenu hatMenu;
    
    public Menue(final String pTitel) {
        this(pTitel, null);
    }
    
    protected Menue(final String pTitel, final JMenu pObermenu) {
        JMenuBar lMenuBar = Bildschirm.topFenster.getJMenuBar();
        this.hatMenu = new JMenu(pTitel);
        this.hatListener = new MenueReaktor();
        this.hatMenu.addActionListener(this.hatListener);
        if (pObermenu == null) {
            if (lMenuBar == null) {
                lMenuBar = new JMenuBar();
                Bildschirm.topFenster.setJMenuBar(lMenuBar);
            }
            lMenuBar.add(this.hatMenu);
        }
        else {
            pObermenu.add(this.hatMenu);
        }
        lMenuBar.setVisible(false);
        lMenuBar.setVisible(true);
    }
    
    protected void gewaehlt(final String pAuftrag) {
        final Class[] formparas = { null };
        final Menue[] meineAuswahl = { null };
        if (pAuftrag.length() > 0) {
            try {
                final Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
                try {
                    final Method methode = sumEreignis.getMethod(pAuftrag, (Class[])null);
                    methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])null);
                }
                catch (InvocationTargetException e0) {
                    System.out.println("Fehler in Methode \"" + pAuftrag + "\" eines Menues: " + e0.getTargetException().toString());
                    e0.printStackTrace();
                }
                catch (Exception e4) {
                    try {
                        formparas[0] = Menue.class;
                        final Method methode = sumEreignis.getMethod(pAuftrag, (Class[])formparas);
                        meineAuswahl[0] = this;
                        methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, (Object[])meineAuswahl);
                    }
                    catch (InvocationTargetException e2) {
                        System.out.println("Fehler in Methode \"" + pAuftrag + "\" eines Menues: " + e2.getTargetException().toString());
                        e2.printStackTrace();
                    }
                    catch (Exception e5) {
                        System.out.println("Fehler: Methode \"" + pAuftrag + "\" eines Menues nicht gefunden.");
                    }
                }
            }
            catch (Exception e3) {
                System.out.println("SuMAnwendung: " + e3.toString());
            }
        }
    }
    
    public void haengeZeileAn(final String pText, final String pAuftrag) {
        final JMenuItem mi = new JMenuItem(pText);
        mi.addActionListener(this.hatListener);
        mi.setActionCommand(pAuftrag);
        this.hatMenu.add(mi);
    }
    
    public void haengeZeileAn(final String pText, final char pZeichen, final boolean pMitShift, final String pAuftrag) {
        final KeyStroke msc = KeyStroke.getKeyStroke(pZeichen, 1, false);
        final JMenuItem mi = new JMenuItem(pText);
        mi.setAccelerator(msc);
        mi.addActionListener(this.hatListener);
        mi.setActionCommand(pAuftrag);
        this.hatMenu.add(mi);
    }
    
    @Override
    public void setzeInhalt(final String pText) {
        this.hatMenu.setText(pText);
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatMenu.getText();
    }
    
    public void setzeBearbeiterGewaehlt(final int pZeile, final String pAuftrag) {
        this.hatMenu.getItem(pZeile).setActionCommand(pAuftrag);
    }
    
    public Menue neuesUntermenue(final String pText) {
        return new Menue(pText, this.hatMenu);
    }
    
    public void haengeTrennungAn() {
        this.hatMenu.addSeparator();
    }
    
    public int zeilenAnzahl() {
        return this.hatMenu.getItemCount();
    }
    
    @Override
    public void deaktiviere() {
        this.hatMenu.setEnabled(false);
    }
    
    @Override
    public void aktiviere() {
        this.hatMenu.setEnabled(true);
    }
    
    @Override
    public boolean istAktiv() {
        return this.hatMenu.isEnabled();
    }
    
    public void deaktiviereZeile(final int pZeile) {
        this.hatMenu.getItem(pZeile).setEnabled(false);
    }
    
    public void aktiviereZeile(final int pZeile) {
        this.hatMenu.getItem(pZeile).setEnabled(true);
    }
    
    public boolean istZeileAktiv(final int pZeile) {
        return this.hatMenu.getItem(pZeile).isEnabled();
    }
    
    @Override
    public void setzeSchriftArt(final String pSchriftart) {
        this.zAktuellFont = pSchriftart;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatMenu.setFont(this.zSchriftArt);
    }
    
    @Override
    public void setzeSchriftGroesse(final int pGroesse) {
        this.zSchriftGroesse = pGroesse;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatMenu.setFont(this.zSchriftArt);
    }
    
    @Override
    public void setzeSchriftStil(final int pStil) {
        this.zSchriftStil = pStil;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatMenu.setFont(this.zSchriftArt);
    }
    
    @Override
    public void setzeSchriftstil(final int pStil) {
        this.setzeSchriftStil(pStil);
    }
    
    @Override
    public void setzeSchriftFarbe(final Color pFarbe) {
    }
    
    protected void lerneKomponenteKennen(final JComponent pKomponente) {
    }
    
    @Override
    public void setzeBearbeiterFokusVerloren(final String pBearbeiter) {
    }
    
    @Override
    public void setzeBearbeiterFokusErhalten(final String pBearbeiter) {
    }
    
    @Override
    public void setzePosition(final double pWohinH, final double pWohinV) {
    }
    
    @Override
    public void setzeGroesse(final double pBreite, final double pHoehe) {
    }
    
    @Override
    public void setzeFarbe(final Color pFarbe) {
    }
    
    @Override
    public int links() {
        return 0;
    }
    
    @Override
    public int oben() {
        return 0;
    }
    
    @Override
    public int breite() {
        return 0;
    }
    
    @Override
    public int hoehe() {
        return 0;
    }
    
    @Override
    public void verstecke() {
    }
    
    @Override
    public void zeige() {
    }
    
    @Override
    public boolean istSichtbar() {
        return true;
    }
    
    @Override
    public void setzeFokus() {
    }
    
    private class MenueReaktor implements ActionListener
    {
        @Override
        public void actionPerformed(final ActionEvent e) {
            final String cmd = e.getActionCommand();
            Menue.this.gewaehlt(cmd);
        }
    }
}
