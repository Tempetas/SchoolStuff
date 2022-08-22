package Circles;

import sum.kern.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private Vector2 startPos, endPos;
    private List<BasicCircle> circles;

    public Board(Vector2 a, Vector2 b) {
        startPos = a;
        endPos = b;

        circles = new ArrayList();
    }

    public void addCircle(BasicCircle newCircle) {
        for (BasicCircle circle : circles) {
            if (circle.getPosition().distanceSquared(newCircle.getPosition()) < newCircle.getRadius() * newCircle.getRadius() + circle.getRadius() * circle.getRadius()) {
                return;
            }
        }

        circles.add(newCircle);
    }
    
    public List<BasicCircle> getCircles() {
        return circles;
    }

    public BasicCircle getCircleById(int id) {
        return circles.get(id);
    }

    public void setPositions(Vector2 newStartPos, Vector2 newEndPos) {
        startPos = newStartPos;
        endPos = newEndPos;
    }

    public void draw(Buntstift pen) {
        pen.bewegeBis(startPos.x, startPos.y);
        pen.zeichneRechteck(endPos.x - startPos.x, endPos.y - startPos.y);
    }

    public void tick(Buntstift pen, long deltaTime) {
        for (BasicCircle circle : circles) {
            Vector2 pos = circle.getPosition().add(circle.getVelocity());
            float r = circle.getRadius();

            if (pos.x - r < startPos.x || pos.x + r > endPos.x) {
                circle.setVelocity(new Vector2(-circle.getVelocity().x * 0.9f, circle.getVelocity().y));
            }

            if (pos.y - r < startPos.y || pos.y + r > endPos.y) {
                circle.setVelocity(new Vector2(circle.getVelocity().x, -circle.getVelocity().y * 0.9f));
            }
                
           
            circle.tick(deltaTime, circles);
            pen.setzeFuellMuster(1);
            circle.draw(pen);
            pen.setzeFuellMuster(0);
        }

    }
}
