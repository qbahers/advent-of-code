import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] stream = in.nextLine().toCharArray();

        int garbageAmount = 0;
        boolean withinGarbage = false;

        int i = 0;
        while (i < stream.length) {
            if (stream[i] == '!') {
                i += 2;
                continue;
            } else if (!withinGarbage && stream[i] == '<') {
                withinGarbage = true;
            } else if (stream[i] == '>') {
                withinGarbage = false;
            } else if (withinGarbage) {
                garbageAmount++;
            }
            i++;
        }

        System.out.println(garbageAmount);
    }

}