package Darts;

//time to overcomplicate things

import sum.kern.*;

public class Main {
    Bildschirm screen;
    Buntstift pen;
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

        screen = new Bildschirm(800, 600);
        pen = new Buntstift();
        keyboard = new Tastatur();
        Maus mouse = new Maus();

        arrow = new Arrow();
        board = new Board(new Vector2(650, 300));  

        scorePos = new Vector2(30, 10);
        this.drawScore();

        while(!shouldExit) {
            frameStartTime = System.currentTimeMillis();

            this.drawBorders(screen);

            pen.radiere();
            arrow.draw(pen);
            pen.normal();

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
                pen.radiere();
                arrow.draw(pen);
                pen.normal();

                arrow.rotation += 0.02;

                if (arrow.rotation > 30) {
                    arrow.rotation = -30;
                }

                arrow.draw(pen);
                deltaTime = System.currentTimeMillis() - frameStartTime;
            }

            if (clicked) {
                pen.radiere();
                arrow.draw(pen);
                pen.normal();
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

            deltaTime = System.currentTimeMillis() - frameStartTime;
        }
    }

    private void drawScore() {
        //Erase old score
        pen.bewegeBis(scorePos.x + 40, scorePos.y);
        pen.radiere();
        pen.runter();
        for (int i = 0; i < 20; i++) {
            pen.bewegeBis(scorePos.x + 40 + i, scorePos.y);
            pen.bewegeBis(scorePos.x + 40 + i, scorePos.y - 20);
        }
        pen.hoch();
        pen.normal();

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
