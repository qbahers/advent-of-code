import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] keypad = {
            ".......",
            "...1...",
            "..234..",
            ".56789.",
            "..ABC..",
            "...D...",
            "......."
        };

        String code = "";
        int i = 3, j = 1;

        while (in.hasNext()) {
            char[] line = in.next().toCharArray();

            for (int k = 0; k < line.length; k++) {
                if (line[k] == 'U' && keypad[i - 1].charAt(j) != '.') {
                    i--;
                } else if (line[k] == 'D' && keypad[i + 1].charAt(j) != '.') {
                    i++;
                } else if (line[k] == 'L' && keypad[i].charAt(j - 1) != '.') {
                    j--;
                } else if (line[k] == 'R' && keypad[i].charAt(j + 1) != '.') {
                    j++;
                }
            }
            code += keypad[i].charAt(j);
        }

        System.out.println(code);
    }

}