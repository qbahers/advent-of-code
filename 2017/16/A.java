import java.util.*;

public class A {

    private static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
        return new String(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] moves = in.next().split(",");

        String programs = "abcdefghijklmnop";
        int N = programs.length();

        for (int i = 0; i < moves.length; i++) {
            if (moves[i].charAt(0) == 's') {
                int size = Integer.parseInt(moves[i].substring(1));
                programs = programs.substring(N - size) + programs.substring(0, N - size);
            } else if (moves[i].charAt(0) == 'x') {
                int posA = Integer.parseInt(moves[i].substring(1, moves[i].indexOf('/')));
                int posB = Integer.parseInt(moves[i].substring(moves[i].indexOf('/') + 1));
                programs = swap(programs, posA, posB);
            } else {
                int posA = programs.indexOf(moves[i].charAt(1));
                int posB = programs.indexOf(moves[i].charAt(3));
                programs = swap(programs, posA, posB);
            }
        }

        System.out.println(programs);
    }

}