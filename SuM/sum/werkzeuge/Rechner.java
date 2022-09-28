// 
// Decompiled by Procyon v0.5.36
// 

package sum.werkzeuge;

import java.util.Random;
import java.io.Serializable;

public class Rechner implements Serializable
{
    private Textwerkzeug hatTextwerkzeug;
    private static int randSeed;
    private Random hatRandom;
    
    public Rechner() {
        this.hatTextwerkzeug = new Textwerkzeug();
        if (Rechner.randSeed == 0) {
            this.hatRandom = new Random();
        }
        else {
            this.hatRandom = new Random(System.currentTimeMillis() + Rechner.randSeed);
        }
        ++Rechner.randSeed;
    }
    
    public double zufallsZahl() {
        return this.hatRandom.nextDouble();
    }
    
    public double zufallszahl() {
        return this.hatRandom.nextDouble();
    }
    
    public int ganzeZufallsZahl() {
        return this.hatRandom.nextInt();
    }
    
    public int ganzeZufallszahl() {
        return this.hatRandom.nextInt();
    }
    
    public int ganzeZufallsZahl(final int pVon, final int pBis) {
        return Math.abs(this.hatRandom.nextInt()) % (pBis - pVon + 1) + pVon;
    }
    
    public int ganzeZufallszahl(final int pVon, final int pBis) {
        return Math.abs(this.hatRandom.nextInt()) % (pBis - pVon + 1) + pVon;
    }
    
    public double betrag(final double pZahl) {
        return Math.abs(pZahl);
    }
    
    public int betrag(final int pZahl) {
        return Math.abs(pZahl);
    }
    
    public double quadrat(final double pZahl) {
        return pZahl * pZahl;
    }
    
    public int quadrat(final int pZahl) {
        return pZahl * pZahl;
    }
    
    public double wurzel(final double pZahl) {
        return Math.sqrt(pZahl);
    }
    
    public double sin(final double pWinkel) {
        return Math.sin(pWinkel * 3.141592653589793 / 180.0);
    }
    
    public double cos(final double pWinkel) {
        return Math.cos(pWinkel * 3.141592653589793 / 180.0);
    }
    
    public double tan(final double pWinkel) {
        return Math.tan(pWinkel * 3.141592653589793 / 180.0);
    }
    
    public double asin(final double pZahl) {
        return Math.asin(pZahl) * 180.0 / 3.141592653589793;
    }
    
    public double acos(final double pZahl) {
        return Math.acos(pZahl) * 180.0 / 3.141592653589793;
    }
    
    public double atan(final double pZahl) {
        return Math.atan(pZahl) * 180.0 / 3.141592653589793;
    }
    
    public double exp(final double pZahl) {
        return Math.exp(pZahl);
    }
    
    public double ln(final double pZahl) {
        return Math.log(pZahl);
    }
    
    public double potenz(final double pBasis, final double pExponent) {
        return Math.exp(Math.log(pBasis) * pExponent);
    }
    
    public int potenz(final int pBasis, final int pExponent) {
        return (int)Math.round(Math.exp(Math.log(pBasis) * pExponent));
    }
    
    public int gerundet(final double pZahl) {
        return (int)Math.round(pZahl);
    }
    
    public int ganzerAnteil(final double pZahl) {
        return (int)pZahl;
    }
    
    public String dezimalInDual(int pZahl) {
        String lDualzahl = "";
        do {
            if (pZahl % 2 == 1) {
                lDualzahl = "1" + lDualzahl;
            }
            else {
                lDualzahl = "0" + lDualzahl;
            }
            pZahl /= 2;
        } while (pZahl != 0);
        for (int lZaehler = lDualzahl.length() + 1; lZaehler <= 8; ++lZaehler) {
            lDualzahl = "0" + lDualzahl;
        }
        return lDualzahl;
    }
    
    public int dualInDezimal(final String pDualzahl) {
        int lZahl = 0;
        for (int lZaehler = 1; lZaehler <= this.hatTextwerkzeug.laenge(pDualzahl); ++lZaehler) {
            if (this.hatTextwerkzeug.zeichenAn(pDualzahl, lZaehler) == '1') {
                lZahl = lZahl * 2 + 1;
            }
            else {
                lZahl *= 2;
            }
        }
        return lZahl;
    }
    
    public void gibFrei() {
    }
}
