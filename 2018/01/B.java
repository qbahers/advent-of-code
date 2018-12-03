import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input.txt");
        Scanner sc = new Scanner(input);

        int frequency = 0;
        Set<Integer> frequencies = new HashSet<>();

        while (!frequencies.contains(frequency)) {
            frequencies.add(frequency);
            frequency += sc.nextInt();

            if (!sc.hasNextInt()) {
                sc = new Scanner(input);
            }
        }

        System.out.println(frequency);
    }

}
