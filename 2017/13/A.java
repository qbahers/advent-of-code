import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tripSeverity = 0;

        while (in.hasNextLine()) {
            String[] layer = in.nextLine().split(": ");
            int depth = Integer.parseInt(layer[0]);
            int range = Integer.parseInt(layer[1]);

            if (depth % (2 * (range - 1)) == 0) {
                tripSeverity += depth * range;
            }
        }

        System.out.println(tripSeverity);
    }

}