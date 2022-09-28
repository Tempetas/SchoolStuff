// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

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
import sum.werkzeuge.Textwerkzeug;
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
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import java.util.Vector;
import javax.swing.JFrame;

public class Bildschirm extends JFrame
{
    protected static Bildschirm hatPrivatschirm;
    protected Vector hatTastaturpuffer;
    private JPanel hatPanel;
    protected static Bildschirm topFenster;
    protected static int zFensternummer;
    private Image dbImage;
    private Graphics2D dbGraphics;
    private Color zHintergrundfarbe;
    private int zHoehe;
    private int zBreite;
    private boolean zMitDoubleBuffering;
    protected boolean zTasteIstUnten;
    protected boolean zTasteIstDoppel;
    protected int zMausHatPositionX;
    protected int zMausHatPositionY;
    
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
        this.dbImage = null;
        this.dbGraphics = null;
        this.zHintergrundfarbe = Color.white;
        this.zHoehe = 0;
        this.zBreite = 0;
        this.zTasteIstUnten = false;
        this.zTasteIstDoppel = false;
        this.zMausHatPositionX = 0;
        this.zMausHatPositionY = 0;
        if (Bildschirm.hatPrivatschirm == null) {
            Bildschirm.hatPrivatschirm = this;
        }
        final String osName = System.getProperty("os.name");
        if (osName.toLowerCase().startsWith("mac os")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        this.zMitDoubleBuffering = pMitDoubleBuffering;
        (this.hatPanel = (JPanel)this.getContentPane()).setLayout(null);
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
        this.hatTastaturpuffer = new Vector();
        this.setVisible(true);
        this.fenstergroesseAnpassen();
        this.setSize(this.getWidth() - this.breite() + pBreite, this.getHeight() - this.hoehe() + pHoehe);
        if (this.zMitDoubleBuffering) {
            this.dbImage = this.createImage(this.getSize().width, this.getSize().height);
            this.dbGraphics = (Graphics2D)this.dbImage.getGraphics();
        }
        ++Bildschirm.zFensternummer;
        this.init2DGraphics();
        this.setzeFarbe(11);
        this.zeichneDich();
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
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setComposite(AlphaComposite.getInstance(3, 1.0f));
    }
    
    protected JPanel privatPanel() {
        return this.hatPanel;
    }
    
    protected void bearbeiteFokusErhalten() {
        Bildschirm.topFenster = this;
    }
    
    protected void merkeGroesse(final int x, final int y) {
        this.zBreite = x;
        this.zHoehe = y;
    }
    
    public void nachVorn() {
        this.setAlwaysOnTop(true);
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
            g.drawImage(this.dbImage, this.hatPanel.getX(), this.hatPanel.getY(), this.hatPanel);
        }
        else {
            super.paint(g);
        }
    }
    
    public void zeichneDich() {
        if (this.zMitDoubleBuffering) {
            this.hatPanel.getGraphics().drawImage(this.dbImage, this.hatPanel.getX(), this.hatPanel.getY(), this.hatPanel);
        }
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
        this.hatPanel.paintImmediately(this.hatPanel.getBounds());
        this.hatPanel.validate();
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
    
    protected Color hintergrundfarbe() {
        return this.zHintergrundfarbe;
    }
    
    public int breite() {
        return this.zBreite;
    }
    
    public int hoehe() {
        return this.zHoehe;
    }
    
    public String holeText() {
        final Eingabe lEingabe = new Eingabe(this, "Gib einen Text ein.");
        return lEingabe.eingabe();
    }
    
    public double holeZahl() {
        final Textwerkzeug lTW = new Textwerkzeug();
        final Eingabe lEingabe = new Eingabe(this, "Gib eine Zahl ein.");
        final String lText = lEingabe.eingabe();
        double lZahl;
        if (lTW.istZahl(lText)) {
            lZahl = lTW.alsZahl(lText);
        }
        else {
            lZahl = 0.0;
        }
        return lZahl;
    }
    
    public int holeGanzeZahl() {
        final Textwerkzeug lTW = new Textwerkzeug();
        final Eingabe lEingabe = new Eingabe(this, "Gib eine ganze Zahl ein.");
        final String lText = lEingabe.eingabe();
        int lZahl;
        if (lTW.istGanzeZahl(lText)) {
            lZahl = lTW.alsGanzeZahl(lText);
        }
        else {
            lZahl = 0;
        }
        return lZahl;
    }
    
    public String holeText(final String pMeldung) {
        final Eingabe lEingabe = new Eingabe(this, pMeldung);
        return lEingabe.eingabe();
    }
    
    public double holeZahl(final String pMeldung) {
        final Textwerkzeug lTW = new Textwerkzeug();
        final Eingabe lEingabe = new Eingabe(this, pMeldung);
        final String lText = lEingabe.eingabe();
        double lZahl;
        if (lTW.istZahl(lText)) {
            lZahl = lTW.alsZahl(lText);
        }
        else {
            lZahl = 0.0;
        }
        return lZahl;
    }
    
    public int holeGanzeZahl(final String pMeldung) {
        final Textwerkzeug lTW = new Textwerkzeug();
        final Eingabe lEingabe = new Eingabe(this, pMeldung);
        final String lText = lEingabe.eingabe();
        int lZahl;
        if (lTW.istGanzeZahl(lText)) {
            lZahl = lTW.alsGanzeZahl(lText);
        }
        else {
            lZahl = 0;
        }
        return lZahl;
    }
    
    public void gibFrei() {
        if (this.equals(Bildschirm.hatPrivatschirm)) {
            this.setTitle("Das SuM-Programm ist beendet.");
            this.warte(1L);
            while (this.zTasteIstUnten) {
                this.warte(1L);
            }
            while (!this.zTasteIstUnten) {
                this.warte(1L);
            }
        }
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
        this.dispose();
        if (this.equals(Bildschirm.hatPrivatschirm)) {
            System.exit(0);
        }
    }
    
    private void merkeUnten(final boolean b) {
        this.zTasteIstUnten = b;
    }
    
    private void merkeXY(final int x, final int y) {
        this.zMausHatPositionX = x;
        this.zMausHatPositionY = y;
    }
    
    private void merkeDoppelklick(final boolean b) {
        this.zTasteIstDoppel = b;
    }
    
    private void merkeDruck(final int z) {
        this.hatTastaturpuffer.addElement(new Integer(z));
        if (z == 27) {
            this.dispose();
            System.exit(0);
        }
    }
    
    protected static void fehler(final String pMeldung) {
        System.out.println(pMeldung);
        System.exit(0);
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
        }
    }
    
    private class MausBeweger extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(final MouseEvent e) {
            Bildschirm.this.merkeXY(e.getX(), e.getY());
            Bildschirm.this.merkeUnten(true);
        }
        
        @Override
        public void mouseMoved(final MouseEvent e) {
            Bildschirm.this.merkeXY(e.getX(), e.getY());
            Bildschirm.this.merkeUnten(false);
        }
    }
    
    private class MausTaster extends MouseAdapter
    {
        @Override
        public void mouseEntered(final MouseEvent e) {
            Bildschirm.this.merkeXY(e.getX(), e.getY());
        }
        
        @Override
        public void mousePressed(final MouseEvent e) {
            Bildschirm.this.merkeXY(e.getX(), e.getY());
            Bildschirm.this.merkeUnten(true);
        }
        
        @Override
        public void mouseReleased(final MouseEvent e) {
            Bildschirm.this.merkeXY(e.getX(), e.getY());
            Bildschirm.this.merkeUnten(false);
            if (e.getClickCount() > 1) {
                Bildschirm.this.merkeDoppelklick(true);
            }
            else {
                Bildschirm.this.merkeDoppelklick(false);
            }
        }
    }
    
    private class TastenTester extends KeyAdapter
    {
        @Override
        public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() != 17) {
                if (e.isActionKey() || e.getKeyCode() < 32 || e.getKeyCode() == 127) {
                    Bildschirm.this.merkeDruck(e.getKeyCode() + 500);
                }
                else {
                    Bildschirm.this.merkeDruck(e.getKeyChar());
                }
            }
        }
    }
    
    private class FokusReaktor implements FocusListener
    {
        @Override
        public void focusGained(final FocusEvent e) {
            Bildschirm.this.bearbeiteFokusErhalten();
        }
        
        @Override
        public void focusLost(final FocusEvent e) {
        }
    }
}
