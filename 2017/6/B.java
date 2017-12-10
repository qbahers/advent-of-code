import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> banks = new ArrayList<Integer>();

        while (in.hasNextInt()) {
            banks.add(in.nextInt());
        }

        Map<List<Integer>, Integer> configurations = new HashMap<List<Integer>, Integer>();

        int cycles = 0;
        while (!configurations.containsKey(banks)) {
            configurations.put(new ArrayList<Integer>(banks), cycles);
            cycles++;

            int max = Collections.max(banks);
            int index = banks.indexOf(max);
            banks.set(index, 0);

            int N = banks.size();
            for (int i = index + 1; i < index + 1 + max; i++) {
                banks.set(i % N, banks.get(i % N) + 1);
            }
        }

        System.out.println(cycles - configurations.get(banks));
    }

}