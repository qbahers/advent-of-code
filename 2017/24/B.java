import java.util.*;

public class B {

    private static int maxStrength = 0;
    private static int maxLength = 0;

    private static void dfs(Map<Integer, List<Integer>> adj, int v, int strength, int length) {
        List<Integer> neighbours = new ArrayList<Integer>(adj.get(v));

        for (int w : neighbours) {
            if (length + 1 > maxLength) {
                maxLength = length + 1;
                maxStrength = strength + v + w;
            } else if (length + 1 == maxLength) {
                maxStrength = Math.max(maxStrength, strength + v + w);
            }
            adj.get(v).remove((Integer) w);
            adj.get(w).remove((Integer) v);
            dfs(adj, w, strength + v + w, length + 1);
            adj.get(v).add(w);
            adj.get(w).add(v);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split("/");
            int v = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);

            adj.putIfAbsent(v, new ArrayList<Integer>());
            adj.putIfAbsent(w, new ArrayList<Integer>());
            adj.get(v).add(w);
            adj.get(w).add(v);
        }

        dfs(adj, 0, 0, 0);

        System.out.println(maxStrength);
    }

}