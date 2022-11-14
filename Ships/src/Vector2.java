//Copy pasted from an old project
public class Vector2 {
    public float x, y;

    Vector2(float X, float Y) {
        x = X;
        y = Y;
    }

    Vector2 add(Vector2 b) {
        return new Vector2(this.x + b.x, this.y + b.y);
    }

    Vector2 subtract(Vector2 b) {
        return new Vector2(this.x - b.x, this.y - b.y);
    }

    Vector2 multiply(Vector2 b) {
        return new Vector2(this.x * b.x, this.y * b.y);
    }

    Vector2 divide(Vector2 b) {
        return new Vector2(this.x / b.x, this.y / b.y);
    }

    float distanceSquared(Vector2 b) {
        return (this.x - b.x) * (this.x - b.x) + (this.y - b.y) * (this.y - b.y);
    }
}
