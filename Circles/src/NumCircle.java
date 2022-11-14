import sum.kern.*;

public class NumCircle extends BasicCircle {
    public NumCircle(float radius) {
        super(radius);
    }

    public void draw(Buntstift pen) {
        super.draw(pen);
        pen.setzeFarbe(Farbe.WEISS);
        pen.bewegeBis(this.getPosition().x - this.getRadius() / 4, this.getPosition().y + this.getRadius() / 2);
        pen.schreibeZahl(8);
        pen.setzeFarbe(Farbe.SCHWARZ);
    }
}
