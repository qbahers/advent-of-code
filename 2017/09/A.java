import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] stream = in.next().toCharArray();

        int score = 0;
        int totalScore = 0;
        boolean withinGarbage = false;

        int i = 0;
        while(i < stream.length) {
            if (stream[i] == '!') {
                i += 2;
                continue;
            } else if (stream[i] == '<') {
                withinGarbage = true;
            } else if (stream[i] == '>') {
                withinGarbage = false;
            } else if (!withinGarbage && stream[i] == '{') {
                score++;
            } else if (!withinGarbage && stream[i] == '}') {
                totalScore += score;
                score--;
            }
            i++;
        }

        System.out.println(totalScore);
    }

}