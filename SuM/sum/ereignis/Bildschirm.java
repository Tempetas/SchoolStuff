// 
// Decompiled by Procyon v0.5.36
// 

package sum.ereignis;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JComponent;
import java.awt.Component;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.RenderingHints;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;
import java.awt.LayoutManager;
import javax.swing.JMenuBar;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Bildschirm extends JFrame
{
    public static Bildschirm hatPrivatschirm;
    private JPanel hatPanel;
    public static Bildschirm topFenster;
    protected static int zFensternummer;
    private Ereignisanwendung kenntEreignisanwendung;
    private Color zHintergrundfarbe;
    private Image dbImage;
    private Graphics2D dbGraphics;
    private int zHoehe;
    private int zBreite;
    private boolean zHatFocus;
    private boolean zHatGezeichnet;
    private boolean zMitDoubleBuffering;
    
    public Bildschirm() {
        this(0, 0, -1, -1, "SuM-Fenster " + (Bildschirm.zFensternummer + 1), false);
    }
    
    public Bildschirm(final boolean pMitDoubleBuffering) {
        this(0, 0, -1, -1, "SuM-Fenster " + (Bildschirm.zFensternummer + 1), pMitDoubleBuffering);
    }
    
    public Bildschirm(final int pLinks, final int pOben, final int pBreite, final int pHoehe) {
        this(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (Bildschirm.zFensternummer + 1), false);
    }
    
    public Bildschirm(final int pLinks, final int pOben, final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        this(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (Bildschirm.zFensternummer + 1), pMitDoubleBuffering);
    }
    
    public Bildschirm(final int pBreite, final int pHoehe) {
        this(0, 0, pBreite, pHoehe, "SuM-Fenster " + (Bildschirm.zFensternummer + 1), false);
    }
    
    public Bildschirm(final int pBreite, final int pHoehe, final boolean pMitDoubleBuffering) {
        this(0, 0, pBreite, pHoehe, "SuM-Fenster " + (Bildschirm.zFensternummer + 1), pMitDoubleBuffering);
    }
    
    protected Bildschirm(final int pLinks, final int pOben, int pBreite, int pHoehe, final String pName, final boolean pMitDoubleBuffering) {
        super(pName);
        this.zHintergrundfarbe = Color.white;
        this.dbImage = null;
        this.dbGraphics = null;
        this.zHoehe = 0;
        this.zBreite = 0;
        this.zHatFocus = true;
        this.zHatGezeichnet = false;
        if (Bildschirm.hatPrivatschirm == null) {
            Bildschirm.hatPrivatschirm = this;
        }
        this.zMitDoubleBuffering = pMitDoubleBuffering;
        this.kenntEreignisanwendung = Ereignisanwendung.hatSuMPrivateAnwendung;
        final String osName = System.getProperty("os.name");
        if (osName.toLowerCase().startsWith("mac os")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        this.setJMenuBar(new JMenuBar());
        (this.hatPanel = (JPanel)this.getContentPane()).setLayout(null);
        if (osName.toLowerCase().startsWith("mac os")) {
            this.hatPanel.setBounds(0, 0, 2000, 2000);
        }
        else {
            this.hatPanel.setBounds(0, 22, 2000, 2022);
        }
        this.hatPanel.setOpaque(true);
        this.addWindowListener(new FensterTester());
        this.addComponentListener(new GroesseTester());
        this.hatPanel.addMouseMotionListener(new MausBeweger());
        this.hatPanel.addMouseListener(new MausTaster());
        this.hatPanel.addKeyListener(new TastenTester());
        this.hatPanel.addFocusListener(new FokusReaktor());
        if (pBreite == -1) {
            final Dimension dimension = this.getToolkit().getScreenSize();
            pBreite = dimension.width - 20;
            pHoehe = dimension.height - 60;
        }
        this.setBounds(pLinks, pOben, pBreite, pHoehe);
        this.setVisible(true);
        this.getJMenuBar().setVisible(true);
        this.fenstergroesseAnpassen();
        this.setSize(this.getWidth() - this.breite() + pBreite, this.getHeight() - this.hoehe() + pHoehe);
        if (this.zMitDoubleBuffering) {
            this.dbImage = this.createImage(this.getSize().width, this.getSize().height);
            this.dbGraphics = (Graphics2D)this.dbImage.getGraphics();
        }
        this.init2DGraphics();
        this.setzeFarbe(11);
        this.bearbeiteFokusErhalten();
        this.warte(1000L);
        this.hatPanel.requestFocus();
    }
    
    protected void init2DGraphics() {
        Graphics2D g2d;
        if (this.zMitDoubleBuffering) {
            g2d = this.dbGraphics;
        }
        else {
            g2d = (Graphics2D)this.hatPanel.getGraphics();
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }
    
    public JPanel privatPanel() {
        return this.hatPanel;
    }
    
    protected void bearbeiteFokusErhalten() {
        Bildschirm.topFenster = this;
    }
    
    protected void merkeGroesse(final int x, final int y) {
        this.zBreite = x;
        this.zHoehe = y;
    }
    
    protected Graphics g() {
        if (this.zMitDoubleBuffering) {
            return this.dbGraphics;
        }
        return this.hatPanel.getGraphics();
    }
    
    @Override
    public void paint(final Graphics g) {
        if (this.dbImage != null) {
            g.drawImage(this.dbImage, 0, 0, this);
        }
        else {
            super.paint(g);
        }
        for (int i = 0; i < this.hatPanel.getComponentCount(); ++i) {
            final Component komponente = this.hatPanel.getComponent(i);
            komponente.repaint();
        }
    }
    
    @Override
    public void update(final Graphics g) {
        super.update(g);
        if (this.zHatGezeichnet) {
            this.kenntEreignisanwendung.bearbeiteUpdate();
        }
        else if (this.isVisible() && this.kenntEreignisanwendung.fuehrtAus()) {
            this.zHatGezeichnet = true;
            this.loescheAlles();
        }
    }
    
    public void zeichneDich() {
        if (this.zMitDoubleBuffering) {
            this.hatPanel.getGraphics().drawImage(this.dbImage, 0, 0, this);
        }
        for (int i = 0; i < this.hatPanel.getComponentCount(); ++i) {
            final Component komponente = this.hatPanel.getComponent(i);
            komponente.repaint();
        }
    }
    
    public boolean besitztFokus() {
        return this.zHatFocus;
    }
    
    public void setzeFokus() {
        this.hatPanel.requestFocus();
    }
    
    public void setzeFarbe(final Color pFarbe) {
        if (this.zMitDoubleBuffering) {
            this.dbGraphics.setBackground(pFarbe);
            this.dbGraphics.clearRect(0, 0, 2000, 2000);
        }
        else {
            this.hatPanel.setBackground(pFarbe);
            this.hatPanel.getGraphics().clearRect(0, 0, 2000, 2000);
        }
        this.zHintergrundfarbe = pFarbe;
        this.hatPanel.paintImmediately(0, 0, 2000, 2000);
        this.hatPanel.validate();
        for (int i = 0; i < this.hatPanel.getComponentCount(); ++i) {
            final Component komponente = this.hatPanel.getComponent(i);
            komponente.setBackground(pFarbe);
            komponente.repaint();
        }
    }
    
    public void setzeFarbe(int pFarbe) {
        if (pFarbe < 0) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        switch (pFarbe) {
            case 0: {
                this.setzeFarbe(Color.black);
                break;
            }
            case 1: {
                this.setzeFarbe(Color.blue);
                break;
            }
            case 2: {
                this.setzeFarbe(Color.cyan);
                break;
            }
            case 3: {
                this.setzeFarbe(Color.darkGray);
                break;
            }
            case 4: {
                this.setzeFarbe(Color.gray);
                break;
            }
            case 5: {
                this.setzeFarbe(Color.green);
                break;
            }
            case 6: {
                this.setzeFarbe(Color.lightGray);
                break;
            }
            case 7: {
                this.setzeFarbe(Color.magenta);
                break;
            }
            case 8: {
                this.setzeFarbe(Color.orange);
                break;
            }
            case 9: {
                this.setzeFarbe(Color.pink);
                break;
            }
            case 10: {
                this.setzeFarbe(Color.red);
                break;
            }
            case 11: {
                this.setzeFarbe(Color.white);
                break;
            }
            case 12: {
                this.setzeFarbe(Color.yellow);
                break;
            }
        }
    }
    
    public void loescheAlles() {
        this.setzeFarbe(this.zHintergrundfarbe);
    }
    
    protected void warte(final long zeit) {
        try {
            Thread.sleep(zeit);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public Color hintergrundfarbe() {
        return this.zHintergrundfarbe;
    }
    
    public void doUpdate(final JComponent pKomponente) {
        pKomponente.paintImmediately(0, 0, pKomponente.getWidth(), pKomponente.getHeight());
        pKomponente.validate();
    }
    
    public int breite() {
        return this.zBreite;
    }
    
    public int hoehe() {
        return this.zHoehe;
    }
    
    public void verstecke() {
        this.setVisible(false);
    }
    
    public void zeige() {
        this.setVisible(true);
    }
    
    public void immerNachVorn() {
        this.setAlwaysOnTop(true);
    }
    
    public void nachVorn() {
        this.toFront();
    }
    
    public void nachHinten() {
        this.toBack();
    }
    
    public void gibFrei() {
        this.fensterZerstoeren();
    }
    
    private void fenstergroesseAnpassen() {
        this.merkeGroesse(this.hatPanel.getVisibleRect().width, this.hatPanel.getVisibleRect().height);
        if (this.zMitDoubleBuffering) {
            this.dbImage = this.createImage(this.getSize().width, this.getSize().height);
            this.dbGraphics = (Graphics2D)this.dbImage.getGraphics();
            this.init2DGraphics();
            this.setzeFarbe(this.zHintergrundfarbe);
        }
    }
    
    private void fensterZerstoeren() {
        if (this.equals(Bildschirm.hatPrivatschirm)) {
            this.kenntEreignisanwendung.halteAn();
        }
        this.dispose();
    }
    
    private class FensterTester extends WindowAdapter
    {
        @Override
        public void windowClosing(final WindowEvent e) {
            Bildschirm.this.fensterZerstoeren();
        }
    }
    
    private class GroesseTester extends ComponentAdapter
    {
        @Override
        public void componentResized(final ComponentEvent e) {
            Bildschirm.this.fenstergroesseAnpassen();
            e.getComponent().repaint();
        }
        
        @Override
        public void componentMoved(final ComponentEvent e) {
            e.getComponent().repaint();
        }
    }
    
    private class MausBeweger extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(final MouseEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
            }
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
            }
        }
    }
    
    private class MausTaster extends MouseAdapter
    {
        @Override
        public void mouseEntered(final MouseEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
            }
        }
        
        @Override
        public void mousePressed(final MouseEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteMausDruck(e.getX(), e.getY());
                Bildschirm.this.hatPanel.requestFocus();
            }
        }
        
        @Override
        public void mouseReleased(final MouseEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                if (e.getClickCount() > 1) {
                    Bildschirm.this.kenntEreignisanwendung.bearbeiteDoppelKlick(e.getX(), e.getY());
                }
                else {
                    Bildschirm.this.kenntEreignisanwendung.bearbeiteMausLos(e.getX(), e.getY());
                }
            }
        }
    }
    
    private class TastenTester extends KeyAdapter
    {
        @Override
        public void keyPressed(final KeyEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus() && e.getKeyCode() != 17) {
                if (e.isActionKey() || e.getKeyCode() < 32 || e.getKeyCode() == 127) {
                    Bildschirm.this.kenntEreignisanwendung.bearbeiteTaste((char)(e.getKeyCode() + 500));
                }
                else {
                    Bildschirm.this.kenntEreignisanwendung.bearbeiteTaste(e.getKeyChar());
                }
            }
        }
    }
    
    private class FokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Bildschirm.this.bearbeiteFokusErhalten();
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                Bildschirm.this.zHatFocus = true;
                Bildschirm.this.kenntEreignisanwendung.bearbeiteFokusErhalten();
            }
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
            if (Bildschirm.this.kenntEreignisanwendung != null && Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) {
                Bildschirm.this.zHatFocus = false;
                Bildschirm.this.kenntEreignisanwendung.bearbeiteFokusVerloren();
            }
        }
    }
    
    private class ComponentRepaintAdapter extends ComponentAdapter
    {
        @Override
        public void componentMoved(final ComponentEvent event) {
            event.getComponent().repaint();
        }
        
        @Override
        public void componentResized(final ComponentEvent event) {
            event.getComponent().repaint();
        }
    }
}
