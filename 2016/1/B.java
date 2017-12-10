import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] instructions = in.nextLine().split(", ");

        // North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int x = 0, y = 0;

        Set<List<Integer>> visited = new HashSet<List<Integer>>();

        outer:
        for (int i = 0; i < instructions.length; i++) {
            index += (instructions[i].charAt(0) == 'L') ? -1 : 1;
            index = (index + 4) % 4; 
            int nbBlocks = Integer.parseInt(instructions[i].substring(1)); 

            for (int j = 0; j < nbBlocks; j++) {
                x += directions[index][0];
                y += directions[index][1];

                List<Integer> location = Arrays.asList(x, y);
                if (visited.contains(location)) {
                    System.out.println(Math.abs(x) + Math.abs(y));
                    break outer;
                } else {
                    visited.add(location);
                }
            }
        }
    }

}