import sum.kern.*;

public class RedCircle extends BasicCircle {
    public RedCircle(float radius) {
        super(radius);
    }

    public void draw(Buntstift pen) {
        pen.setzeFarbe(Farbe.ROT);
        super.draw(pen);
        pen.setzeFarbe(Farbe.SCHWARZ);
    }
}
