import sum.kern.*;
import java.util.ArrayList;
import java.util.List;

public class Cue {
    private Vector2 position, velocity;
    private int width = 10;
    private int length = 80;
    private float firedVelocity = 0.025f;
    private int defaultY = 520;
    private float hitBoost = 0.2f;
    private float highestY = 520;
    private float highestPossibleY = 570;
    private boolean fired = false;
    private boolean returning = false;

    public Cue() {
        this.position = new Vector2(0, defaultY);
        this.velocity = new Vector2(0, 0);
    }

    public void draw(Buntstift pen) {
        pen.setzeFuellMuster(1);
        pen.bewegeBis(position.x, position.y);
        pen.setzeFarbe((this.returning) ? Farbe.GRAU : Farbe.SCHWARZ);
        pen.zeichneRechteck(width, length);
        pen.setzeFarbe(Farbe.SCHWARZ);
        pen.setzeFuellMuster(0);
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void tick(int deltaTime, List<Board> boards, Maus mouse) {
        if (!this.fired && !this.returning) {
            this.position = this.position.add(new Vector2(((mouse.hPosition() - width / 2)- this.position.x) / (10 * 3 / deltaTime), 0));
            if (mouse.istGedrueckt()) {
                //Slowly pull the cue back
                this.velocity = new Vector2(0, firedVelocity * 4);

                if (this.position.y > this.highestPossibleY) {
                    this.position.y = this.highestPossibleY;
                } else if (this.position.y < this.highestPossibleY) {
                    this.position = this.position.add(velocity.multiplyByNum(deltaTime));
                }
            } else {
                if (this.position.y != this.defaultY) {
                    this.fired = true;
                    this.highestY = this.position.y;
                    this.velocity = new Vector2(0, -firedVelocity * 15 - ((this.highestY - this.defaultY) * 0.02f));
                }
            }
        }
        if (this.fired || this.returning) {
            this.position = this.position.add(velocity.multiplyByNum(deltaTime));

            if (this.position.y > defaultY && this.velocity.y > 0) {
                this.returning = false;
                this.position.y = defaultY;
            }

            //Dont collide with anything after the end of the board has been reached
            if (this.returning)
                return;

            for (Board board : boards) {
                for (BasicCircle circle : board.getCircles()) {
                    if (collides(circle)) {
                        if (circle.getPosition().y < position.y) {
                            circle.setVelocity(new Vector2(circle.getVelocity().x - ((this.position.x + width / 2) - circle.getPosition().x) * 0.01f, -hitBoost * 0.75f - ((this.highestY - this.defaultY) * 0.006f)));
                            this.returnToBottom();
                        } else {
                            //If hit on the side
                            circle.setVelocity(new Vector2(-circle.getVelocity().x, circle.getVelocity().y));
                        }
                    }
                }

            }

            if (this.position.y < 0) {
                returnToBottom();
            }
        }
    }

    public void returnToBottom() {
        this.fired = false;
        this.returning = true;

        float returnVelocity = firedVelocity * 8 * ((this.defaultY - this.position.y) / 200);

        if (returnVelocity < firedVelocity * 8)
            returnVelocity = firedVelocity * 8;

        this.velocity = new Vector2(0, returnVelocity);
    }

    public boolean collides(BasicCircle circle) {
        Vector2 pos = circle.getPosition().add(circle.getVelocity());
        float r = circle.getRadius();

        //awful rectangle x circle collision detection
        if (pos.y - r > position.y && pos.y + r < position.y + length && ((pos.x - r < position.x + width && pos.x + r > position.x + width) || (pos.x + r > position.x && pos.x - r < position.x) || (pos.x - r < position.x && pos.x + r > position.x + width)))
            return true;

        //Only detects collisions when the ball is near one of the corners, seemed like a good idea but will only work if the  cue isnt too wide
        Vector2 corner = new Vector2(position.x, position.y);

        if (corner.distanceSquared(pos) < r * r|| corner.add(new Vector2(width, 0)).distanceSquared(pos) < r * r)
            return true;

        return false;
    }
}
