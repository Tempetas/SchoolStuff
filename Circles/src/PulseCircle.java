import sum.kern.*;
import java.util.ArrayList;
import java.util.List;

public class PulseCircle extends BasicCircle {
    boolean growing = true;
    float drawRadius = 0;

    public PulseCircle(float radius) {
        super(radius);
    }

    public void draw(Buntstift pen) {
        float r = this.getRadius();
        this.setRadius(drawRadius);
        pen.setzeFarbe(Farbe.BLAU);
        super.draw(pen);
        pen.setzeFarbe(Farbe.SCHWARZ);
        this.setRadius(r);
    }

    public void tick(long deltaTime, List<BasicCircle> circles) {
        super.tick(deltaTime, circles);
        drawRadius += ((growing) ? deltaTime : -deltaTime) * 0.02f;
        if (drawRadius > this.getRadius() || drawRadius < 0) {
            growing = !growing;
        }
    }
}
