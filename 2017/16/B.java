import java.util.*;

public class B {

    private static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
        return new String(sb);
    }

    private static String dance(String programs, String[] moves) {
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

        return programs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] moves = in.next().split(",");

        String programs = "abcdefghijklmnop";

        Set<String> permutations = new HashSet<String>();

        while (!permutations.contains(programs)) {
            permutations.add(programs);
            programs = dance(programs, moves);
        }

        for (int i = 0; i < 1e9 % permutations.size(); i++) {
            programs = dance(programs, moves);
        }

        System.out.println(programs);
    }

}