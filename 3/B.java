import java.util.*;

public class B {

    // up, left, down, right
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int sumOfNeighbours(int[][] grid, int i, int j) {
        int sum = 0;

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k != i || l != j) {
                    sum += grid[k][l];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int target = in.nextInt();

        int nbRows = 11;
        int[][] grid = new int[nbRows][nbRows];
        int i = nbRows / 2;
        int j = nbRows / 2;
        // length of the square
        int length = 1;

        grid[i][j] = 1;

        done:
        while (true) {
            for (int k = 0; k < 4; k++) {
                for (int m = 0; m < length - 1; m++) {
                    i += directions[k][0];
                    j += directions[k][1];
                    grid[i][j] = sumOfNeighbours(grid, i, j);

                    if (grid[i][j] > target) {
                        System.out.println(grid[i][j]);
                        break done;
                    }
                }
            }

            i++;
            j++;
            length += 2;
        }
    }

}