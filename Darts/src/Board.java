package Darts;

import sum.kern.*;

public class Board {
    private Vector2 pos;

    private int ringSize = 20;
    private int rings = 5;

    public Board(Vector2 position) {
        pos = position;
    }

    public boolean isHit(Arrow arrow) {
        return (pos.distanceSquared(arrow.pos) < ringSize * ringSize);
    }

    public void draw(Buntstift pen) {
        pen.hoch();
        pen.bewegeBis(pos.x, pos.y);
        pen.setzeFarbe(10);
        for (int i = 0; i < rings; i++) {
            if (i == 2) pen.setzeFarbe(6);
            pen.zeichneKreis(ringSize * i);
        }
        pen.setzeFarbe(0);
    }
}
