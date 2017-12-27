import java.util.*;

public class A {

    private static int maxStrength = 0;

    private static void dfs(Map<Integer, List<Integer>> adj, int v, int strength) {
        List<Integer> neighbours = new ArrayList<Integer>(adj.get(v));

        for (int w : neighbours) {
            maxStrength = Math.max(maxStrength, strength + v + w);
            adj.get(v).remove((Integer) w);
            adj.get(w).remove((Integer) v);
            dfs(adj, w, strength + v + w);
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

        dfs(adj, 0, 0);

        System.out.println(maxStrength);
    }

}