// 
// Decompiled by Procyon v0.5.36
// 

package sum.kern;

import java.awt.Paint;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class Buntstift extends Stift
{
    private String zAktuellFont;
    private int zSchriftStil;
    private int zSchriftGroesse;
    private Font zSchriftArt;
    private Color zFarbe;
    private int zLinienbreite;
    private int zMuster;
    
    public Buntstift() {
        this.zAktuellFont = "Helvetica";
        this.zSchriftStil = 0;
        this.zSchriftGroesse = 12;
        this.zSchriftArt = Schrift.STANDARDSCHRIFT;
        this.zFarbe = Color.black;
        this.zLinienbreite = 1;
        this.zMuster = 0;
    }
    
    public Buntstift(final Fenster pFenster) {
        super(pFenster);
        this.zAktuellFont = "Helvetica";
        this.zSchriftStil = 0;
        this.zSchriftGroesse = 12;
        this.zSchriftArt = Schrift.STANDARDSCHRIFT;
        this.zFarbe = Color.black;
        this.zLinienbreite = 1;
        this.zMuster = 0;
    }
    
    public void setzeFarbe(final Color pFarbe) {
        this.zFarbe = pFarbe;
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
    
    public void setzeLinienbreite(final int pBreite) {
        if (pBreite > 0) {
            this.zLinienbreite = pBreite;
            this.hatStroke = new BasicStroke(pBreite * 1.0f, 0, 0);
        }
    }
    
    public void setzeLinienBreite(final int pBreite) {
        this.setzeLinienbreite(pBreite);
    }
    
    public int linienbreite() {
        return this.zLinienbreite;
    }
    
    public int linienBreite() {
        return this.zLinienbreite;
    }
    
    public void setzeSchriftart(final String pArt) {
        this.zAktuellFont = pArt;
    }
    
    public void setzeSchriftArt(final String pArt) {
        this.zAktuellFont = pArt;
    }
    
    public void setzeSchriftgroesse(final int pGroesse) {
        this.zSchriftGroesse = pGroesse;
    }
    
    public void setzeSchriftGroesse(final int pGroesse) {
        this.zSchriftGroesse = pGroesse;
    }
    
    public void setzeSchriftstil(final int pStil) {
        this.zSchriftStil = pStil;
    }
    
    public void setzeSchriftStil(final int pStil) {
        this.zSchriftStil = pStil;
    }
    
    public void setzeFuellmuster(final int pMuster) {
        this.zMuster = pMuster;
    }
    
    public void setzeFuellMuster(final int pMuster) {
        this.zMuster = pMuster;
    }
    
    @Override
    public void zeichneRechteck(final double pBreite, final double pHoehe) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            if (this.zMuster == 0) {
                g.draw(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
            }
            else {
                g.fill(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
            }
        }
    }
    
    @Override
    public void zeichneKreis(final double pRadius) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            if (this.zMuster == 0) {
                g.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0 * pRadius, 2.0 * pRadius));
            }
            else {
                g.fill(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0 * pRadius, 2.0 * pRadius));
            }
        }
    }
    
    @Override
    protected void zeichneLinie(final double x1, final double y1, final double x2, final double y2) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            g.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }
    
    public int textbreite(final String pText) {
        final Graphics2D g = this.get2DGraphics(this.kenntPrivatschirm.g());
        if (g != null) {
            this.setzeZustand(g);
            return g.getFontMetrics().stringWidth(pText);
        }
        return 12;
    }
    
    public int zeichenbreite(final char pZeichen) {
        final String lText = "" + pZeichen;
        return this.textbreite(lText);
    }
    
    public int zahlbreite(final int pZahl) {
        final String lText = "" + pZahl;
        return this.textbreite(lText);
    }
    
    public int zahlbreite(final double pZahl) {
        final String lText = "" + pZahl;
        return this.textbreite(lText);
    }
    
    public int textBreite(final String pText) {
        return this.textbreite(pText);
    }
    
    public int zeichenBreite(final char pZeichen) {
        return this.zeichenbreite(pZeichen);
    }
    
    public int zahlBreite(final int pZahl) {
        return this.zahlbreite(pZahl);
    }
    
    public int zahlBreite(final double pZahl) {
        return this.zahlbreite(pZahl);
    }
    
    @Override
    protected void setzeZustand(final Graphics2D g) {
        if (this.zMuster == 2 && this.zFarbe.getTransparency() != 3) {
            this.zFarbe = new Color(this.zFarbe.getRed(), this.zFarbe.getGreen(), this.zFarbe.getBlue(), 128);
        }
        else if (this.zMuster != 2 && this.zFarbe.getTransparency() != 1) {
            this.zFarbe = new Color(this.zFarbe.getRed(), this.zFarbe.getGreen(), this.zFarbe.getBlue());
        }
        if (this.zSchreibModus == 1) {
            g.setPaint(Bildschirm.hatPrivatschirm.hintergrundfarbe());
            g.setPaintMode();
        }
        else if (this.zSchreibModus == 0) {
            g.setPaint(this.zFarbe);
            g.setPaintMode();
        }
        else {
            g.setPaint(this.zFarbe);
            g.setXORMode(Bildschirm.hatPrivatschirm.hintergrundfarbe());
        }
        g.setFont(this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse));
    }
    
    protected void setzeStandard() {
        this.zStiftH = 0.0;
        this.zStiftV = 0.0;
        this.zHoch = true;
        this.zWinkel = 0.0;
        this.zSchreibModus = 0;
        this.zAktuellFont = "Helvetica";
        this.zSchriftStil = 0;
        this.zSchriftGroesse = 12;
        this.zSchriftArt = Schrift.STANDARDSCHRIFT;
        this.zFarbe = Color.black;
        this.zLinienbreite = 1;
        this.zMuster = 0;
    }
}
