import java.util.*;

public class B {

    private static boolean[][] visited = new boolean[128][128];

    private static void dfs(int[][] grid, int x, int y) {
        visited[x][y] = true;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < 4; i++) {
            int k = x + dirs[i][0];
            int l = y + dirs[i][1];

            if (k >= 0 && k < 128 && l >= 0 && l < 128 && grid[k][l] == 1 && !visited[k][l]) {
                dfs(grid, k, l);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String keyString = in.next();

        int[][] grid = new int[128][128];

        for (int i = 0; i < 128; i++) {
            String row = knotHash(keyString + '-' + i);

            for (int j = 0; j < 32; j++) {
                int decimal = Integer.parseInt("" + row.charAt(j), 16);    
                String binary = Integer.toBinaryString(decimal);
                int N = binary.length();

                for (int k = 0; k < N; k++) {
                    grid[i][4 * j + 4 - N + k] = binary.charAt(k) - '0';
                }
            }
        }

        int count = 0;
        for(int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // Adapted from 10/B.java

    private static byte[] concat(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    private static void reverse(int[] list, int begin, int end) {
        int N = list.length;

        int i = begin, j = end;
        while (i < j) {
            int tmp = list[i % N];
            list[i % N] = list[j % N];
            list[j % N] = tmp;
            i++;
            j--;
        }
    }

    private static String knotHash(String s) {
        int[] list = new int[256];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;            
        }
        int currentPosition = 0;
        int skipSize = 0;

        byte[] a = s.getBytes();
        byte[] suffix = {17, 31, 73, 47, 23};
        byte[] lengths = concat(a, suffix);

        for (int j = 0; j < 64; j++) {
            for (int i = 0; i < lengths.length; i++) {
                reverse(list, currentPosition, currentPosition + lengths[i] - 1);
                currentPosition += lengths[i] + skipSize;
                skipSize++;
            }
        }

        int[] denseHash = new int[16];
        for (int i = 0; i < 16; i ++) {
            for (int j = 0; j < 16; j++) {
                denseHash[i] ^= list[i * 16 + j];
            }
        }

        String knotHash = "";
        // Represent each number as two hexadecimal digits (including a leading zero as necessary).
        for (int i = 0; i < 16; i++) {
            knotHash += String.format("%02x", denseHash[i]);
        }

        return knotHash;
    }

}