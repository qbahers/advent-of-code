import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> firewall = new HashMap<Integer, Integer>();

        while (in.hasNextLine()) {
            String[] layer = in.nextLine().split(": ");
            int depth = Integer.parseInt(layer[0]);
            int range = Integer.parseInt(layer[1]);

            firewall.put(depth, range);
        }

        int delay = 0;
        boolean caught = true;

        while (caught) {
            caught = false;

            for (Map.Entry<Integer, Integer> entry : firewall.entrySet()) {
                Integer depth = entry.getKey();
                Integer range = entry.getValue();

                if ((depth + delay) % (2 * (range - 1)) == 0) {
                    caught = true;
                    delay++;
                    break;
                }
            }
        }

        System.out.println(delay);
    }

}