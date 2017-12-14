import java.util.*;

public class A {

    private static Set<Integer> visited = new HashSet<Integer>();

    private static void dfs(Map<Integer, int[]> adj, int v) {
        visited.add(v);

        for (int w : adj.get(v)) {
            if (!visited.contains(w)) {
                dfs(adj, w);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, int[]> adj = new HashMap<Integer, int[]>();

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" <-> ");
            int vertex = Integer.parseInt(line[0]);
            int[] neighbors = Arrays.stream(line[1].split(", ")).mapToInt(Integer::parseInt).toArray();
            adj.put(vertex, neighbors);
        }

        dfs(adj, 0);

        System.out.println(visited.size());
    }

}