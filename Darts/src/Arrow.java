import sum.kern.*;

public class Arrow {
    public Vector2 pos;
    public float rotation;

    private int speed = 250;
    private int shotSpeed = 400;
    private int length = 40;
    private int startWidth = 35;
    private int startHeight = 50;

    public boolean fired = false;

    public Arrow() {
        pos = new Vector2(startWidth, startHeight);
    }

    public void tick(Bildschirm screen, Buntstift pen, float deltaTime) {
        if (!fired) {
            pos.y += speed * (deltaTime / 1000);

            if (pos.y > screen.hoehe() - startHeight) {
                pos.y = startHeight;
            }
        } else {
            float angle = rotation * 3.14159f / 180;
            pos.x += shotSpeed * (Math.cos(angle) + 1) * (deltaTime / 1000);
            pos.y -= shotSpeed * Math.sin(angle) * 2 * (deltaTime / 1000);
            if (pos.x > screen.breite() - startWidth * 2) {
                pos = new Vector2(startWidth, startHeight);
                fired = false;
                rotation = 0;
            }
        }

    }

    public void fire() {
        fired = true;
    }

    public void onHit() {
        fired = false;
        pos = new Vector2(startWidth, startHeight);
    }

    public void drawTip(Buntstift pen, int amount) {
        for (int i = 0; i < amount; i++) {
            pen.runter();
            pen.dreheUm(-25);
            pen.bewegeUm(-length / 4);
            pen.bewegeUm(length / 4);
            pen.dreheUm(50);
            pen.bewegeUm(-length / 4);
            pen.bewegeUm(length / 4);
            pen.dreheUm(-25);
            pen.hoch();
            pen.bewegeUm(length / 6);
        }
    }

    public void draw(Buntstift pen) {
        pen.hoch();
        pen.bewegeBis(pos.x, pos.y);

        pen.dreheBis(rotation);

        //Draw the fancy end
        drawTip(pen, 2);

        pen.bewegeBis(pos.x, pos.y);

        pen.runter();

        pen.bewegeUm(length);

        //Draw the fancy tip
        drawTip(pen, 1);

        pen.hoch();
    }
}

