package Darts;

import sum.kern.Buntstift;
import sum.kern.Fenster;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

import javax.swing.JPanel;

public class BetterStift extends Buntstift {
    private BufferedImage buffer;

    private Graphics2D bufferGraphics, screenGraphics;

    public BetterStift(Fenster screen) {
        super(screen);

        try {
            Method panelGetter = screen.getClass().getSuperclass().getDeclaredMethod("privatPanel");
            panelGetter.setAccessible(true);

            Field dbGraphics = screen.getClass().getSuperclass().getDeclaredField("dbGraphics");
            dbGraphics.setAccessible(true);

            Field withDb = screen.getClass().getSuperclass().getDeclaredField("zMitDoubleBuffering");
            withDb.setAccessible(true);

            this.buffer = new BufferedImage(screen.breite(), screen.hoehe(), BufferedImage.TYPE_INT_RGB);

            this.bufferGraphics = this.buffer.createGraphics();
            this.screenGraphics = this.get2DGraphics(((JPanel)panelGetter.invoke(screen)).getGraphics());

            dbGraphics.set(screen, this.bufferGraphics);
            withDb.set(screen, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawToScreen() {
        this.screenGraphics.drawImage(buffer, 0, 0, this.kenntPrivatschirm);

        this.clear();
    }

    private void clear() {
        this.setzeZustand(this.bufferGraphics);

        this.bufferGraphics.setPaint(new Color(255, 255, 255));
        this.bufferGraphics.fillRect(0, 0, this.buffer.getWidth(), this.buffer.getHeight());
    }
}

