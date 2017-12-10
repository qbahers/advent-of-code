import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> banks = new ArrayList<Integer>();

        while (in.hasNextInt()) {
            banks.add(in.nextInt());
        }

        Set<List<Integer>> configurations = new HashSet<List<Integer>>();

        int cycles = 0;
        while (!configurations.contains(banks)) {
            configurations.add(new ArrayList<Integer>(banks));
            cycles++;

            int max = Collections.max(banks);
            int index = banks.indexOf(max);
            banks.set(index, 0);

            int N = banks.size();
            for (int i = index + 1; i < index + 1 + max; i++) {
                banks.set(i % N, banks.get(i % N) + 1);
            }
        }

        System.out.println(cycles);
    }

}