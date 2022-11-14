import sum.kern.*;
import java.util.ArrayList;
import java.util.List;

public class BasicCircle {
    private Vector2 position, velocity;
    private float radius;

    private float mass = 1;
    private float friction = 0.01f;

    public BasicCircle(float r) {
        radius = r;
        position = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
    }

    public void setRadius(float r) {
        radius = r;
    }

    public float getRadius() {
        return radius;
    }

    public void setMass(float newMass) {
        mass = newMass;
    }

    public float getMass() {
        return mass;
    }

    public void setFriction(float newFriction) {
        friction = newFriction;
    }

    public float getFriction() {
        return friction;
    }

    public void setPosition(Vector2 pos) {
        position = pos;
    }

    public void setVelocity(Vector2 vel) {
        velocity = vel;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void draw(Buntstift pen) {
        pen.bewegeBis(position.x, position.y);
        pen.zeichneKreis(radius);
    }

    public void tick(long deltaTime, List<BasicCircle> circles) {
        for (BasicCircle circle : circles) {
            if (circle == this)
                continue;

            Vector2 pos = this.position.add(this.velocity);
            Vector2 otherPos = circle.getPosition().add(circle.getVelocity());

            if (pos.distanceSquared(otherPos) < (this.radius * this.radius + circle.getRadius() * circle.getRadius()) * 2) {
                Vector2 diff = pos.subtract(otherPos).multiplyByNum(0.001f * (float)Math.sqrt(Math.abs(this.getVelocity().x) + Math.abs(this.getVelocity().y)) + 0.001f);

                Vector2 velPass = this.velocity.multiplyByNum(this.mass / circle.getMass()).subtract(diff);
                Vector2 backVelPass = circle.getVelocity().multiplyByNum(circle.getMass() / this.mass).add(diff);

                this.velocity = this.velocity.add(backVelPass).subtract(velPass.multiplyByNum(0.5f));

                circle.setVelocity(circle.getVelocity().add(velPass).subtract(backVelPass.multiplyByNum(0.5f)));
            }
        }

        this.velocity = this.velocity.multiplyByNum(1 - this.friction / 100);
        this.position = this.position.add(this.velocity.multiplyByNum(deltaTime));
    }
}
