// 
// Decompiled by Procyon v0.5.36
// 

package sum.ereignis;

import java.awt.Font;
import java.io.Serializable;

public class Schrift implements Serializable
{
    public static final String HELVETICA = "Helvetica";
    public static final String ARIAL = "Arial";
    public static final String TIMESROMAN = "TimesRoman";
    public static final String STANDARDSCHRIFTART = "Helvetica";
    public static final int KURSIV = 2;
    public static final int FETT = 1;
    public static final int KURSIVFETT = 3;
    public static final int STANDARDSTIL = 0;
    public static final int STANDARDGROESSE = 12;
    public static final Font STANDARDSCHRIFT;
    
    static {
        STANDARDSCHRIFT = new Font("Helvetica", 0, 12);
    }
}
