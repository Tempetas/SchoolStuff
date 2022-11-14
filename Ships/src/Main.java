import sum.kern.*;
import java.util.Arrays;

public class Main
{
    Bildschirm screen;
    Buntstift pen;
    Maus mouse;

    int fieldCount = 8;
    int cellWidth = 64;

    boolean[] field;

    Ship[] ships;
    int shipAmount = 8;

    public static void main(String args[]) {
        Main main = new Main();
    }

    public Main()
    {
        screen = new Bildschirm(fieldCount * cellWidth, fieldCount * cellWidth);
        pen = new Buntstift();
        mouse = new Maus();

        field = new boolean[fieldCount * fieldCount];

        ships = new Ship[shipAmount];
        spawnShips(pen);

        drawField();
        gameLoop();

        mouse.gibFrei();
        pen.gibFrei();
        screen.gibFrei();
    }

    private void gameLoop() {
        while (!mouse.doppelKlick()) {
            if (mouse.istGedrueckt()) {
                int clickedCell = posToCell(new Vector2(mouse.hPosition(), mouse.vPosition()));

                for (Ship ship : ships) {
                    if (ship == null)
                        continue;
                    for (int i = 0; i < ship.cells.length; i++) {
                        int cell = ship.cells[i];
                        if (clickedCell == cell) {
                            pen.bewegeBis(Math.floor(mouse.hPosition() / cellWidth) * cellWidth, Math.floor(mouse.vPosition() / cellWidth) * cellWidth);
                            pen.setzeFuellMuster(1);
                            pen.zeichneRechteck(cellWidth, cellWidth);
                            pen.setzeFuellMuster(0);
                            //ship.cellStates[Arrays.asList(ship.cells).indexOf(cell)] = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void drawField() {
        for (int i = 0; i < fieldCount; i++) {
            for (int j = 0; j < fieldCount; j++) {
                pen.bewegeBis(i * cellWidth, j * cellWidth);
                pen.zeichneRechteck(cellWidth, cellWidth);
            }
        }
    }

    private void spawnShips(Buntstift pen) {
        shipSpawning:
        for (int i = 0; i < shipAmount; i++) {
            int startCell = (int)(Math.random() * 64);

            //Try to find a good spot for the ship, give up if impossible
            int spawnAttempts = 0;
            while (!isCellIsolated(startCell)) {
                startCell = (int)(Math.random() * 64);
                spawnAttempts++;

                if (spawnAttempts == 4) {
                    continue shipSpawning;
                }
            }

            int expectedLength = (int)(Math.random() * 3) + 3;

            int[] isolatedCells = new int[expectedLength];
            int length = 1;

            int cell = startCell;
            boolean rotation = (Math.random() < 0.5);

            isolatedCells[0] = startCell;

            for (int j = 1; j < expectedLength; j++) {

                if (rotation) {
                    cell += fieldCount;
                } else {
                    cell++;
                }

                if (!isCellIsolated(cell)) {
                    break;
                }

                isolatedCells[j] = cell;
                length++;
            }

            ships[i] = new Ship();
            ships[i].cells = new int[length];
            ships[i].cellStates = new boolean[length];

            for (int a = 0; a < length; a++) {
                ships[i].cells[a] = isolatedCells[a];
                field[isolatedCells[a]] = true;

                //Draw lines at ship`s location (for debugging purposes)
                Vector2 cellPos = cellToPos(isolatedCells[a]);
                pen.bewegeBis(cellPos.x, cellPos.y + cellWidth / 6);
                pen.runter();
                pen.bewegeBis(cellPos.x + cellWidth, cellPos.y + cellWidth / 6);
                pen.hoch();
            }
        }

    }

    private int posToCell(Vector2 pos) {
        return (int)(Math.floor(pos.y / cellWidth) * fieldCount + Math.floor(pos.x / cellWidth));
    }

    private Vector2 cellToPos(int cell) {
        int yRows = (int)(Math.floor(cell / fieldCount));
        float y = yRows * cellWidth;
        return new Vector2((cell - yRows * fieldCount) * cellWidth, y);
    }

    private boolean isCellIsolated(int cell) {
        return (!getCellState(cell + 1) && !getCellState(cell - 1) && !getCellState(cell + fieldCount) && !getCellState(cell - fieldCount));
    }

    private boolean getCellState(int cell) {
        if (cell < 0 || cell >= fieldCount * fieldCount)
            return true;
        return field[cell];
    }
}

