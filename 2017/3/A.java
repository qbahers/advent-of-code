import java.util.*;

public class A {

    // up, left, down, right
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int target = in.nextInt();

        int i = 0;
        int j = 0;
        int cur = 1;
        // length of the square
        int length = 1;

        done:
        while (true) {
            for (int k = 0; k < 4; k++) {
                for (int m = 0; m < length - 1; m++) {
                    i += directions[k][0];
                    j += directions[k][1];
                    cur++;

                    if (cur == target) {
                        System.out.println(Math.abs(i) + Math.abs(j));
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