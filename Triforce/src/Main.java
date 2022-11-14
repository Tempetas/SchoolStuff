import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class Main extends EBAnwendung
{
    private Knopf hatKnopf;
    private Buntstift hatStift;

    public static void main(String[] args) {
        new Main();
    }

    public Main()
    {
        super(900, 600);

        hatKnopf = new Knopf(10, 200, 100, 25, "Draw");
        hatKnopf.setzeBearbeiterGeklickt("draw");

        hatStift = new Buntstift();
    }

    public void draw()
    {
        int depth = 6;
        int x = 100;
        int y = 500;

        //Construct outer shell
        hatStift.bewegeBis(x, y);
        hatStift.dreheBis(0);
        triangle((int)Math.pow(2, depth + 3));

        triforce(x, y, depth);
    }

    private void triangle(float size) {
        hatStift.runter();

        for (int i = 0; i < 3; i++) {
            hatStift.bewegeUm(size);
            hatStift.dreheUm(120);
        }

        hatStift.hoch();
    }

    private void triforce(float x, float y, int depth) {
        if (depth > 0) {
            float size = (int)Math.pow(2, depth + 3);

            hatStift.bewegeBis(x + size / 2, y);
            hatStift.dreheBis(60);
            triangle(size / 2);

            //Calculate the y offset of the middle triangle by calculating the height of the upside down one
            float heightOffset = ((size / 4) * 1.732f);

            for (int i = 0; i < 3; i++) {
                triforce(x + ((size / 4) * i) , y - ((i == 1) ? heightOffset : 0), depth - 1);
            }
        }
    }

}

