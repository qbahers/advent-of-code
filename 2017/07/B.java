import java.util.*;

public class B {

    private static Map<String, Integer> weights = new HashMap<String, Integer>();
    private static Map<String, String[]> children = new HashMap<String, String[]>();

    private static int weightOfDescendants(String program) {
        if (children.containsKey(program)) {
            int sum = 0;
            for (String child : children.get(program)) {
                sum += weights.get(child) + weightOfDescendants(child);
            }
            return sum;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" -> ");
            String program = line[0].substring(0, line[0].indexOf(' '));
            String weight = line[0].substring(line[0].indexOf('(') + 1, line[0].indexOf(')'));
            weights.put(program, Integer.parseInt(weight));

            if (line.length > 1) {
                children.put(program, line[1].split(", "));
            }
        }

        for (String program : weights.keySet()) {
            if (children.containsKey(program)) {
                String[] cs = children.get(program);
                int sum = weights.get(cs[0]) + weightOfDescendants(cs[0]);
                for (int i = 1; i < cs.length; i++) {
                    int s = weights.get(cs[i]) + weightOfDescendants(cs[i]);
                    if (s != sum) {
                        System.out.println(weights.get(cs[0]) - (sum - s));
                        System.out.println(weights.get(cs[i]) - (s - sum));
                        break;
                    }
                 }
            }
        }
    }

}