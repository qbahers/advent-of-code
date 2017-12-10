import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String code = "";
        int button = 5;

        while (in.hasNext()) {
            char[] line = in.next().toCharArray();

            for (int i = 0; i < line.length; i++) {
                if (line[i] == 'U' && button > 3) {
                    button -= 3;
                } else if (line[i] == 'D' && button < 7) {
                    button += 3;
                } else if (line[i] == 'L' && button % 3 != 1) {
                    button--;
                } else if (line[i] == 'R' && button % 3 != 0) {
                    button++;
                }
            }
            code += button;
        }

        System.out.println(code);
    }

}