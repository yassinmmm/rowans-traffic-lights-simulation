/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/**
 *
 * @author Confucius
 */
public class Grid {

    public static final int MIDPOINT = SimModel.gridSize / 2;
    private static Object[][] grid = new Object[SimModel.gridSize][SimModel.gridSize];

    public static Object[][] getGrid() {
        return grid;
    }

    public static void ShowGrid() {
        setBorders();
        PlaceDynamics();
        DrawGrid();
    }

    private static void setBorders() {
        for (int row = 0; row < SimModel.gridSize; ++row) {
            for (int col = 0; col < SimModel.gridSize; ++col) {

                if (col > MIDPOINT && col <= MIDPOINT + SimModel.getVertLanes()) {          // If is a street column
                    grid[row][col] = ' ';

                } else if (row > MIDPOINT && row <= MIDPOINT + SimModel.getHorLanes()) {    // If is a street row
                    grid[row][col] = ' ';

                } else if (row == MIDPOINT && col < MIDPOINT                                                                // Top left     -
                        || row == MIDPOINT + SimModel.getHorLanes() + 1 && col < MIDPOINT                                   // Bottom Left  -
                        || row == MIDPOINT && col > MIDPOINT + SimModel.getVertLanes() + 1                                  // Top Right    -
                        || row == MIDPOINT + SimModel.getHorLanes() + 1 && col > MIDPOINT + SimModel.getVertLanes() + 1){   // Bottom Right -
                    grid[row][col] = '-';
                } else if (col == MIDPOINT && row < MIDPOINT                                                                // Top Left     |
                        || col == MIDPOINT && row > MIDPOINT + SimModel.getHorLanes() + 1                                   // Bottom Left  |
                        || col == MIDPOINT + SimModel.getVertLanes() + 1 && row < MIDPOINT                                  // Top Right    |
                        || col == MIDPOINT + SimModel.getVertLanes() + 1 && row > MIDPOINT + SimModel.getHorLanes() + 1) {  // Bottom Right |
                    grid[row][col] = '|';
                } else {
                    grid[row][col] = ' ';
                }
            }
        }
    }

    private static void PlaceDynamics() {
        for (Car c : SimModel.getCarList()) {
            grid[c.loc()[0]][c.loc()[1]] = c;
        }

        grid[MIDPOINT + SimModel.getHorLanes() + 3][MIDPOINT - 2] = Lights.VLight();        // Bottom left quadrant
        grid[MIDPOINT - 1][MIDPOINT + SimModel.getVertLanes() + 4] = Lights.HLight();       // Top right quadrant
    }

    private static void DrawGrid() {
        System.out.println("");
        for (int i = 0; i < SimModel.gridSize; ++i) {
            System.out.print("_");
        }
        System.out.println("");

        for (int row = 0; row < SimModel.gridSize; ++row) {
            for (int col = 0; col < SimModel.gridSize; ++col) {
                System.out.print(grid[row][col]);
            }
            System.out.println("");
        }

        for (int i = 0; i < SimModel.gridSize; ++i) {
            System.out.print("_");
        }
        System.out.println("\n");
    }
}
