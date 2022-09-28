// 
// Decompiled by Procyon v0.5.36
// 

package sum.werkzeuge;

import java.io.Serializable;

public class Textwerkzeug implements Serializable
{
    private String zTrennung;
    
    public Textwerkzeug() {
        this.zTrennung = " ";
    }
    
    public void setzeTrennungszeichen(final String pTrennungszeichenkette) {
        this.zTrennung = pTrennungszeichenkette;
    }
    
    public int laenge(final String pText) {
        return pText.length();
    }
    
    public char zeichenAn(final String pText, final int pStelle) {
        return pText.charAt(pStelle - 1);
    }
    
    public String wortAn(final String pText, final int pWortnummer) {
        String lWort;
        int lWortZaehler;
        int lFundstelle;
        for (lWort = pText, lWortZaehler = 1, lFundstelle = 0; lWortZaehler < pWortnummer && (lFundstelle = lWort.indexOf(this.zTrennung, 0)) > -1; lWort = lWort.substring(lFundstelle + this.zTrennung.length(), lWort.length()), ++lWortZaehler) {}
        if (lFundstelle <= -1) {
            return "";
        }
        if ((lFundstelle = lWort.indexOf(this.zTrennung, 0)) > -1) {
            return lWort.substring(0, lFundstelle);
        }
        return lWort;
    }
    
    public int wortanzahl(final String pText) {
        String lWort = pText;
        int lWortZaehler = 1;
        for (int lFundstelle = 0; (lFundstelle = lWort.indexOf(this.zTrennung, 0)) > -1; lWort = lWort.substring(lFundstelle + this.zTrennung.length(), lWort.length()), ++lWortZaehler) {}
        return lWortZaehler;
    }
    
    public String teilzeichenkette(final String pText, final int pVon, final int pBis) {
        return pText.substring(pVon - 1, pBis);
    }
    
    public String teilZeichenkette(final String pText, final int pVon, final int pBis) {
        return this.teilzeichenkette(pText, pVon, pBis);
    }
    
    public int positionVon(final String pText, final String pSuchtext) {
        return pText.indexOf(pSuchtext) + 1;
    }
    
    public String textOhne(final String pText, final int pVon, final int pBis) {
        String s = "";
        if (pVon > 1) {
            s = pText.substring(0, pVon - 1);
        }
        if (pBis < pText.length()) {
            s += pText.substring(pBis, pText.length());
        }
        return s;
    }
    
    public String textMit(final String pText, final String pNeu, final int pStelle) {
        String s = "";
        if (pStelle > 1) {
            s = pText.substring(0, pStelle);
        }
        s += pNeu;
        s += pText.substring(pStelle, pText.length());
        return s;
    }
    
    public String kleinschrift(final String pText) {
        return pText.toLowerCase();
    }
    
    public String kleinSchrift(final String pText) {
        return pText.toLowerCase();
    }
    
    public String grossschrift(final String pText) {
        return pText.toUpperCase();
    }
    
    public String grossSchrift(final String pText) {
        return pText.toUpperCase();
    }
    
    public boolean istGleich(final String pText1, final String pText2) {
        return pText1.compareTo(pText2) == 0;
    }
    
    public boolean istKleiner(final String pText1, final String pText2) {
        return pText1.compareTo(pText2) < 0;
    }
    
    public boolean istGroesser(final String pText1, final String pText2) {
        return pText1.compareTo(pText2) > 0;
    }
    
    public boolean istZahl(final String pText) {
        try {
            new Double(pText);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public boolean istGanzeZahl(final char pZeichen) {
        return this.istGanzeZahl("" + pZeichen);
    }
    
    public boolean istGanzeZahl(final String pText) {
        try {
            new Integer(pText);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public boolean istLangeGanzeZahl(final String pText) {
        try {
            new Long(pText);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public double alsZahl(final String pText) {
        if (this.istZahl(pText)) {
            final Double d = new Double(pText);
            return d;
        }
        throw new ArithmeticException("alsZahl: ist keine Zahl");
    }
    
    public int alsGanzeZahl(final char pZeichen) {
        return this.alsGanzeZahl("" + pZeichen);
    }
    
    public long alsLangeGanzeZahl(final String pText) {
        if (this.istLangeGanzeZahl(pText)) {
            final Long i = new Long(pText);
            return i;
        }
        throw new ArithmeticException("alsLangeGanzeZahl: ist keine ganze Zahl");
    }
    
    public int alsGanzeZahl(final String pText) {
        if (this.istGanzeZahl(pText)) {
            final Integer i = new Integer(pText);
            return i;
        }
        throw new ArithmeticException("alsGanzeZahl: ist keine ganze Zahl");
    }
    
    public String alsText(final double pZahl) {
        return "" + pZahl;
    }
    
    public String alsText(final int pZahl) {
        return "" + pZahl;
    }
    
    public String verkettung(final String pText1, final String pText2) {
        return pText1 + pText2;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3) {
        return pText1 + pText2 + pText3;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4) {
        return pText1 + pText2 + pText3 + pText4;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4, final String pText5) {
        return pText1 + pText2 + pText3 + pText4 + pText5;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4, final String pText5, final String pText6) {
        return pText1 + pText2 + pText3 + pText4 + pText5 + pText6;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4, final String pText5, final String pText6, final String pText7) {
        return pText1 + pText2 + pText3 + pText4 + pText5 + pText6 + pText7;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4, final String pText5, final String pText6, final String pText7, final String pText8) {
        return pText1 + pText2 + pText3 + pText4 + pText5 + pText6 + pText7 + pText8;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4, final String pText5, final String pText6, final String pText7, final String pText8, final String pText9) {
        return pText1 + pText2 + pText3 + pText4 + pText5 + pText6 + pText7 + pText8 + pText9;
    }
    
    public String verkettung(final String pText1, final String pText2, final String pText3, final String pText4, final String pText5, final String pText6, final String pText7, final String pText8, final String pText9, final String pText10) {
        return pText1 + pText2 + pText3 + pText4 + pText5 + pText6 + pText7 + pText8 + pText9 + pText10;
    }
    
    public char zeichenVon(final int pOrdinalzahl) {
        return (char)pOrdinalzahl;
    }
    
    public int ordinalzahl(final char pZeichen) {
        return pZeichen;
    }
    
    public void gibFrei() {
    }
}
