// 
// Decompiled by Procyon v0.5.36
// 

package sum.ereignis;

import java.awt.Stroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Stift
{
    protected BasicStroke hatStroke;
    protected Bildschirm kenntPrivatschirm;
    protected static final int NORMALMODUS = 0;
    protected static final int RADIERMODUS = 1;
    protected static final int WECHSELMODUS = 2;
    protected double zStiftH;
    protected double zStiftV;
    protected boolean zHoch;
    protected double zWinkel;
    protected int zSchreibModus;
    
    public Stift() {
        this.zStiftH = 0.0;
        this.zStiftV = 0.0;
        this.zHoch = true;
        this.zWinkel = 0.0;
        this.zSchreibModus = 0;
        this.kenntPrivatschirm = Bildschirm.topFenster;
        this.hatStroke = new BasicStroke(1.0f, 0, 0);
        this.setzeStandard();
    }
    
    public Stift(final Fenster pFenster) {
        this.zStiftH = 0.0;
        this.zStiftV = 0.0;
        this.zHoch = true;
        this.zWinkel = 0.0;
        this.zSchreibModus = 0;
        this.kenntPrivatschirm = pFenster;
        this.hatStroke = new BasicStroke(1.0f, 0, 0);
        this.setzeStandard();
    }
    
    public void bewegeBis(final double pH, final double pV) {
        if (!this.zHoch) {
            this.zeichneLinie(pH, pV, this.zStiftH, this.zStiftV);
        }
        this.zStiftH = pH;
        this.zStiftV = pV;
    }
    
    public void bewegeUm(final double pDistanz) {
        final double w = this.zWinkel * 3.141592653589793 / 180.0;
        final double x = this.zStiftH + pDistanz * Math.cos(w);
        final double y = this.zStiftV - pDistanz * Math.sin(w);
        if (!this.zHoch) {
            this.zeichneLinie(this.zStiftH, this.zStiftV, x, y);
        }
        this.zStiftH = x;
        this.zStiftV = y;
    }
    
    public void dreheBis(final double pWinkel) {
        this.zWinkel = pWinkel;
        while (this.zWinkel < 0.0) {
            this.zWinkel += 360.0;
        }
        while (this.zWinkel >= 720.0) {
            this.zWinkel -= 360.0;
        }
    }
    
    public void dreheZu(final double pWohinH, final double pWohinV) {
        if (pWohinH != this.zStiftH || pWohinV != this.zStiftV) {
            if (pWohinH == this.zStiftH) {
                if (pWohinV > this.zStiftV) {
                    this.zWinkel = 270.0;
                }
                else {
                    this.zWinkel = 90.0;
                }
            }
            else if (pWohinV == this.zStiftV) {
                if (pWohinH > this.zStiftH) {
                    this.zWinkel = 0.0;
                }
                else {
                    this.zWinkel = 180.0;
                }
            }
            else if (pWohinH > this.zStiftH) {
                this.zWinkel = Math.atan((pWohinV - this.zStiftV) / (this.zStiftH - pWohinH)) * 180.0 / 3.141592653589793;
            }
            else {
                this.zWinkel = Math.atan((pWohinV - this.zStiftV) / (this.zStiftH - pWohinH)) * 180.0 / 3.141592653589793 + 180.0;
            }
        }
        while (this.zWinkel < 0.0) {
            this.zWinkel += 360.0;
        }
        while (this.zWinkel >= 720.0) {
            this.zWinkel -= 360.0;
        }
    }
    
    public void dreheUm(final double pWinkel) {
        this.zWinkel += pWinkel;
        while (this.zWinkel < 0.0) {
            this.zWinkel += 360.0;
        }
        while (this.zWinkel >= 720.0) {
            this.zWinkel -= 360.0;
        }
    }
    
    public void schreibeText(final String pText) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            g.drawString(pText, (int)this.zStiftH, (int)this.zStiftV);
            this.zStiftH += g.getFontMetrics().stringWidth(pText);
        }
    }
    
    public void schreibeText(final char pZeichen) {
        this.schreibeText("" + pZeichen);
    }
    
    public void schreibeZahl(final int pZahl) {
        this.schreibeText("" + pZahl);
    }
    
    public void schreibeZahl(final double pZahl) {
        this.schreibeText("" + pZahl);
    }
    
    public void hoch() {
        this.zHoch = true;
    }
    
    public void runter() {
        this.zHoch = false;
    }
    
    public boolean istUnten() {
        return !this.zHoch;
    }
    
    public void normal() {
        this.zSchreibModus = 0;
    }
    
    public void radiere() {
        this.zSchreibModus = 1;
    }
    
    public void wechsle() {
        this.zSchreibModus = 2;
    }
    
    public double hPosition() {
        return this.zStiftH;
    }
    
    public double vPosition() {
        return this.zStiftV;
    }
    
    public double winkel() {
        return this.zWinkel;
    }
    
    protected void zeichneLinie(final double x1, final double y1, final double x2, final double y2) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            g.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }
    
    public void zeichneRechteck(final double pBreite, final double pHoehe) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            g.draw(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
        }
    }
    
    public void zeichneKreis(final double pRadius) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            g.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0 * pRadius, 2.0 * pRadius));
        }
    }
    
    private void setzeStandard() {
        this.zStiftH = 0.0;
        this.zStiftV = 0.0;
        this.zHoch = true;
        this.zWinkel = 0.0;
        this.normal();
    }
    
    protected void setzeZustand(final Graphics2D g) {
        if (this.zSchreibModus == 1) {
            g.setPaint(this.kenntPrivatschirm.hintergrundfarbe());
            g.setPaintMode();
        }
        else if (this.zSchreibModus == 0) {
            g.setPaint(Color.black);
            g.setPaintMode();
        }
        else {
            g.setPaint(Color.black);
            g.setXORMode(this.kenntPrivatschirm.hintergrundfarbe());
        }
        g.setFont(Schrift.STANDARDSCHRIFT);
    }
    
    protected Graphics2D get2DGraphics(final Graphics g) {
        final Graphics2D g2d = (Graphics2D)g;
        if (g2d != null) {
            g2d.setStroke(this.hatStroke);
        }
        return g2d;
    }
    
    public void gibFrei() {
    }
}
