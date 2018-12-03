import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int twos = 0;
        int threes = 0;

        while (sc.hasNext()) {
            Map<Character, Integer> occurences = new HashMap<>();

            String s = sc.next();
            for (int k = 0; k < s.length(); k++) {
                occurences.merge(s.charAt(k), 1, Integer::sum);
            }

            if (occurences.containsValue(2)) twos++;
            if (occurences.containsValue(3)) threes++;
        }

        System.out.println(twos * threes);
    }

}
