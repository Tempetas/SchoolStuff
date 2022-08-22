package Circles;

import sum.kern.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private BetterScreen screen;
    private BufferedPen pen;
    private Maus mouse;

    private List<Board> boards;
    private Cue cue;

    long frameStartTime = 0;
    long deltaTime = 3;

    boolean shouldClose = false;

    //Necessary for programs other than BlueJ
    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        this.screen = new BetterScreen(800, 600);
        this.screen.setTitle("Circles");
        this.screen.setResizable(false);

        //Buffer everything before rendering to prevent flickering
        this.pen = new BufferedPen(screen);
        this.mouse = new Maus();
        this.cue = new Cue();
        this.boards = new ArrayList();

        this.frameStartTime = System.currentTimeMillis();

        Board board = new Board(new Vector2(128, 128), new Vector2(512, 512));

        /*Hack! When Graphics2D.drawString() is called for the first time, it causes a huge lagspike which makes the cue rendering to break.
        Calling it here prevents the lag from happening later on, when the program is actively rendering*/
        pen.schreibeText("");

        //Spawn the ball triangle
        int radius = 10;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                BasicCircle circle = new BasicCircle(radius);
                circle.setPosition(new Vector2(325 + j * radius * 2.5f - i * radius * 1.25f, 300 - i * radius * 2.5f));
                circle.setFriction(0.1f);
                board.addCircle(circle);
            }
        }

        RedCircle redCircle = new RedCircle(12);
        redCircle.setPosition(new Vector2(312.5f, 320));
        redCircle.setFriction(0.1f);
        board.addCircle(redCircle);

        this.boards.add(board);

        Board secondaryBoard = new Board(new Vector2(550, 128), new Vector2(750, 512));

        PulseCircle pulseCircle = new PulseCircle(12);
        pulseCircle.setPosition(new Vector2(700, 320));
        pulseCircle.setFriction(0.1f);
        secondaryBoard.addCircle(pulseCircle);

        NumCircle numCircle = new NumCircle(12);
        numCircle.setPosition(new Vector2(600, 320));
        numCircle.setFriction(0.1f);
        secondaryBoard.addCircle(numCircle);

        this.boards.add(secondaryBoard);
   
        this.gameLoop();
        this.pen.gibFrei();
        this.screen.gibFrei();
    }

    public void gameLoop() {
        while (!this.shouldClose) {
            this.frameStartTime = System.currentTimeMillis();

            this.cue.tick((int)deltaTime, boards, mouse);
            this.cue.draw(this.pen);

            for (Board board : this.boards) {
                board.tick(this.pen, this.deltaTime);
                board.draw(this.pen);
            }

            this.pen.drawToScreen();

            if (this.mouse.doppelKlick()) {
                this.shouldClose = true;
            }

            this.deltaTime = System.currentTimeMillis() - this.frameStartTime;
        }
    }
}
