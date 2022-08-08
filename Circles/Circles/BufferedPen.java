package Circles;

import sum.kern.Bildschirm;
import sum.kern.Buntstift;
import sum.kern.Farbe;
import sum.kern.Fenster;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class BufferedPen extends Buntstift {
    private BufferedImage buffer;
    private Graphics2D graphics;

    private Graphics2D screenGraphics;

    protected int zMuster;

    public BufferedPen(BetterScreen screen) {
        super(screen);

        this.buffer = new BufferedImage(screen.breite(), screen.hoehe(), BufferedImage.TYPE_INT_RGB);
        this.graphics = this.buffer.createGraphics();

        screenGraphics = this.get2DGraphics(screen.getPanel().getGraphics());
    }

    @Override
    public void setzeFuellMuster(final int pMuster) {
        this.zMuster = pMuster;
    }

    //Methods ported from the SuM lib, now using ~double buffering~
    @Override
    public void zeichneKreis(final double pRadius) {
        this.setzeZustand(this.graphics);
        if (this.zMuster == 0) {
            this.graphics.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0 * pRadius, 2.0 * pRadius));
        } else {
            this.graphics.fill(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0 * pRadius, 2.0 * pRadius));
        }
    }

    @Override
    public void zeichneRechteck(final double pBreite, final double pHoehe) {
        this.setzeZustand(this.graphics);
        if (this.zMuster == 0) {
            this.graphics.draw(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
        } else {
            this.graphics.fill(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
        }
    }

    @Override
    protected void zeichneLinie(final double x1, final double y1, final double x2, final double y2) {
        this.setzeZustand(this.graphics);
        this.graphics.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    @Override
    public void schreibeText(final String pText) {
        this.setzeZustand(this.graphics);
        this.graphics.drawString(pText, (float)this.zStiftH, (float)this.zStiftV);
        this.zStiftH += this.graphics.getFontMetrics().stringWidth(pText);
    }

    @Override
    public void schreibeZahl(final int pZahl) {
        this.schreibeText("" + pZahl);
    }

    //Draw the buffer to the screen, must be called for anything to be displayed at all
    public void drawToScreen() {
        this.screenGraphics.drawImage(buffer, 0, 0, this.kenntPrivatschirm);

        this.clear();
    }

    //Clear the screenbuffer
    public void clear() {
        this.setzeZustand(this.graphics);
        this.graphics.setPaint(new Color(255, 255, 255));
        this.graphics.fill(new Rectangle2D.Double(0, 0, this.buffer.getWidth(), this.buffer.getHeight()));
        this.graphics.setPaint(new Color(0, 0, 0));
    }
}