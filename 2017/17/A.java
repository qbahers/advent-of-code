import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nbSteps = in.nextInt();

        List<Integer> circularBuffer = new LinkedList<Integer>();
        circularBuffer.add(0, 0);

        int currentPosition = 0;
        for (int i = 1; i <= 2017; i++) {
            currentPosition = (currentPosition + nbSteps) % circularBuffer.size() + 1;
            circularBuffer.add(currentPosition, i);
        }

        System.out.println(circularBuffer.get(currentPosition + 1));
    }

}