// 
// Decompiled by Procyon v0.5.36
// 

package sum.werkzeuge;

import java.util.Date;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Uhr implements Serializable
{
    private GregorianCalendar hatKalender;
    private long zStartZeit;
    private long zStoppZeit;
    
    public Uhr() {
        this.hatKalender = new GregorianCalendar();
        this.zStoppZeit = 0L;
        this.zStartZeit = System.currentTimeMillis();
    }
    
    public String datum() {
        return "" + this.tag() + "." + this.monat() + "." + this.jahr();
    }
    
    public String zeit() {
        return "" + this.stunde() + ":" + this.minute() + ":" + this.sekunde();
    }
    
    public int tag() {
        this.hatKalender.setTime(new Date(System.currentTimeMillis()));
        return this.hatKalender.get(5);
    }
    
    public int monat() {
        this.hatKalender.setTime(new Date(System.currentTimeMillis()));
        return this.hatKalender.get(2) + 1;
    }
    
    public int jahr() {
        this.hatKalender.setTime(new Date(System.currentTimeMillis()));
        return this.hatKalender.get(1);
    }
    
    public int stunde() {
        this.hatKalender.setTime(new Date(System.currentTimeMillis()));
        return this.hatKalender.get(11);
    }
    
    public int minute() {
        this.hatKalender.setTime(new Date(System.currentTimeMillis()));
        return this.hatKalender.get(12);
    }
    
    public int sekunde() {
        this.hatKalender.setTime(new Date(System.currentTimeMillis()));
        return this.hatKalender.get(13);
    }
    
    public void warte(final long pDauer) {
        try {
            Thread.currentThread();
            Thread.sleep(pDauer);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void starte() {
        this.zStartZeit = System.currentTimeMillis();
    }
    
    public void stoppe() {
        this.zStoppZeit = System.currentTimeMillis();
    }
    
    public double gestoppteZeit() {
        return (double)(this.zStoppZeit - this.zStartZeit);
    }
    
    public double verstricheneZeit() {
        return (double)(System.currentTimeMillis() - this.zStartZeit);
    }
    
    public void gibFrei() {
    }
}
