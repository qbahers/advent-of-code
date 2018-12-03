import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int frequency = 0;

        while (sc.hasNextInt()) {
            frequency += sc.nextInt();
        }

        System.out.println(frequency);
    }

}
