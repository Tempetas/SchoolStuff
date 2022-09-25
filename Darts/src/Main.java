package Darts;

//Time to overcomplicate things

import sum.kern.*;

public class Main {
    Fenster screen;
    BetterStift pen;
    Tastatur keyboard;
    Maus mouse;

    boolean shouldExit = false;

    Arrow arrow;
    Board board;

    int score;
    Vector2 scorePos;

    long frameStartTime = 0;
    long deltaTime = 16;

    int borderWidth = 20;

    public static void main(String[] args) {
        new Main();
    }

    public Main()  {
        frameStartTime = System.currentTimeMillis();

        screen = new Fenster(800, 600);
        pen = new BetterStift(screen);
        keyboard = new Tastatur();
        mouse = new Maus();

        arrow = new Arrow();
        board = new Board(new Vector2(650, 300));

        scorePos = new Vector2(30, 10);
        this.drawScore();

        while(!shouldExit) {
            frameStartTime = System.currentTimeMillis();

            this.drawBorders(screen);

            boolean clicked = false;

            if (keyboard.wurdeGedrueckt()) {
                switch (keyboard.zeichen()) {
                    case 'q':
                    shouldExit = true;
                    break;
                }
                keyboard.weiter();
            }

            while (mouse.istGedrueckt() && !arrow.fired) {
                frameStartTime = System.currentTimeMillis();
                clicked = true;

                arrow.rotation += 0.02;

                if (arrow.rotation > 30) {
                    arrow.rotation = -30;
                }

                arrow.draw(pen);
                board.draw(pen);

                pen.drawToScreen();

                deltaTime = System.currentTimeMillis() - frameStartTime;
            }

            if (clicked) {
                clicked = false;
                arrow.fire();
            }

            arrow.tick(screen, pen, deltaTime);

            if (board.isHit(arrow)) {
                arrow.onHit();
                arrow.rotation = 0;
                score++;
                this.drawScore();
            }

            arrow.draw(pen);
            board.draw(pen);

            pen.drawToScreen();

            deltaTime = System.currentTimeMillis() - frameStartTime;
        }
    }

    private void drawScore() {
        pen.bewegeBis(scorePos.x, scorePos.y);
        pen.schreibeText("Score: ");
        pen.bewegeBis(scorePos.x + 40, scorePos.y);
        pen.schreibeZahl(score);
    }

    //Todo: make them look more fancy?
    private void drawBorders(Bildschirm screen) {
        pen.bewegeBis(borderWidth, borderWidth);
        pen.zeichneRechteck(screen.breite() - borderWidth * 2, screen.hoehe() - borderWidth * 2);
    }
}

