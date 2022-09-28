// 
// Decompiled by Procyon v0.5.36
// 

package sum.werkzeuge;

import java.io.Serializable;

public abstract class Animation extends Thread implements Serializable
{
    private boolean zAngehalten;
    
    public Animation() {
        this.zAngehalten = false;
    }
    
    @Override
    public void run() {
        while (!this.zAngehalten) {
            try {
                this.zeichne();
                Thread.sleep(30L);
            }
            catch (InterruptedException e) {}
        }
    }
    
    public abstract void zeichne();
    
    public void gibFrei() {
        this.zAngehalten = true;
    }
}
