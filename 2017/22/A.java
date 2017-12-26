import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> map = new ArrayList<String>();

        while (in.hasNextLine()) {
            map.add(in.nextLine());
        }

        int h = map.size();
        int w = map.get(0).length();

        int H = 1000, W = 1000;

        char[][] grid = new char[H][W];

        int x = H / 2 - 1;
        int y = W / 2 - 1;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[x - h / 2 + i][y - w / 2 + j] = map.get(i).charAt(j);
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int k = 0;

        int count = 0;
        for (int i = 0; i < 10000; i++) {
            if (grid[x][y] == '#') {
                k++;
                grid[x][y] = '.';
            } else {
                k--;
                grid[x][y] = '#';
                count++;
            }
            x += directions[(k % 4 + 4) % 4][0];
            y += directions[(k % 4 + 4) % 4][1];
        }

        System.out.println(count);
    }

}