// See https://www.redblobgames.com/grids/hexagons/.

import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] path = in.next().split(",");

        String[] dirs = {"n", "ne", "se", "s", "sw", "nw"};
        int[] dx = {0, 1, 1, 0, -1, -1};
        int[] dy = {-1, 0, 1, 1, 0, -1};
        int x = 0, y = 0;

        for (int i = 0; i < path.length; i++) {
            int index = Arrays.asList(dirs).indexOf(path[i]);
            x += dx[index];
            y += dy[index];
        }

        System.out.println(Math.max(Math.abs(x), Math.abs(y)));
    }

}