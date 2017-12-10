import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] instructions = in.nextLine().split(", ");

        // North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int x = 0, y = 0;

        for (int i = 0; i < instructions.length; i++) {
            index += (instructions[i].charAt(0) == 'L') ? -1 : 1;
            index = (index + 4) % 4; 
            int nbBlocks = Integer.parseInt(instructions[i].substring(1)); 

            x += nbBlocks * directions[index][0];
            y += nbBlocks * directions[index][1];
        }

        System.out.println(Math.abs(x) + Math.abs(y));
    }

}
