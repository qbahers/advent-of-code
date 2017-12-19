import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nbSteps = in.nextInt();

        int currentPosition = 0;
        int valueAfterZero = 0;

        for (int i = 1; i <= 5e7; i++) {
            currentPosition = (currentPosition + nbSteps) % i + 1;
            if (currentPosition == 1) {
                valueAfterZero = i;
            }
        }

        System.out.println(valueAfterZero);
    }

}