import java.util.*;

public class B {

    private static char[][] grid = {{'.', '#', '.'}, {'.', '.', '#'}, {'#', '#', '#'}};

    private static Map<String, String> enhancements = new HashMap<String, String>();

    private static String flip(String s) {
        String[] a = s.split("/");

        String res = "";
        for (int i = a.length - 1; i >= 0; i--) {
            res += a[i] + '/';
        }

        return res.substring(0, res.length() - 1);
    }

    private static String rotate(String s) {
        String[] a = s.split("/");

        String res = "";
        for (int j = 0; j < a.length; j++) {
            for (int i = a.length - 1; i >= 0; i--) {
                res += a[i].charAt(j);
            }
            res += '/';
        }

        return res.substring(0, res.length() - 1);
    }

    private static void enhance(int size) {
        int N = (grid.length / size) * (size + 1);
        char[][] next = new char[N][N];

        for (int i = 0; i < grid.length / size; i++) {
            for (int j = 0; j < grid.length / size; j++) {
                String key = "";
                for (int k = i * size; k < (i + 1) * size; k++) {
                    for (int l = j * size; l < (j + 1) * size; l++) {
                        key += grid[k][l];
                    }
                    key += '/';
                }
                key = key.substring(0, key.length() - 1);

                String value = enhancements.get(key);
                int p = 0;
                for (int k = i * (size + 1); k < (i + 1) * (size + 1); k++) {
                    for (int l = j * (size + 1); l < (j + 1) * (size + 1); l++) {
                        next[k][l] = value.charAt(p);
                        p++;
                    }
                    p++;
                }
            }
        }

        grid = next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" => ");

            for (int i = 0; i < 4; i++) {
                enhancements.put(line[0], line[1]);
                enhancements.put(flip(line[0]), line[1]);
                line[0] = rotate(line[0]);
            }
        }

        for (int i = 0; i < 18; i++) {
            if (grid.length % 2 == 0) {
                enhance(2);
            } else {
                enhance(3);
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '#') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}