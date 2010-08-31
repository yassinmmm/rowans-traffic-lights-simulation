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
    private static char[][] grid = new char[SimModel.gridSize][SimModel.gridSize];

    public static void ShowGrid() {
        setBorders();
        PlaceCars();
        DrawGrid();
    }

    private static void setBorders() {
        for (int row = 0; row < SimModel.gridSize; ++row) {
            for (int col = 0; col < SimModel.gridSize; ++col) {

                if (col > MIDPOINT && col <= MIDPOINT + SimModel.getVertLanes()) {          // If is a street column
                    grid[row][col] = ' ';
                } else if (row > MIDPOINT && row <= MIDPOINT + SimModel.getHorLanes()) {    // If is a street row
                    grid[row][col] = ' ';
                } else {
                    grid[row][col] = '?';                                           // Else mark boundary ?
                }
            }
        }
    }

    private static void PlaceCars() {
        for (Car c : SimModel.getCarList()) {
            grid[c.loc()[0]][c.loc()[1]] = 'c';
        }
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
