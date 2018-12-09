import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nbSquareInches = 0;
        int[][] fabric = new int[1000][1000];

        while (sc.hasNextLine()) {
            sc.next();
            sc.next();
            int[] positions = Arrays.stream(sc.next().replace(":", "").split(",")).mapToInt(Integer::parseInt).toArray();
            int[] dimensions = Arrays.stream(sc.next().split("x")).mapToInt(Integer::parseInt).toArray();

            for (int i = positions[1]; i < positions[1] + dimensions[1]; i++) {
                for (int j = positions[0]; j < positions[0] + dimensions[0]; j++) {
                    fabric[i][j]++;
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (fabric[i][j] >= 2) {
                    nbSquareInches++;
                }
            }
        }

        System.out.println(nbSquareInches);
    }

}