import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> ids = new ArrayList<>();
        while (sc.hasNext()) {
            ids.add(sc.next());
        }

        int N = ids.size();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String id1 = ids.get(i);
                String id2 = ids.get(j);

                int M = id1.length();
                for (int k = 0; k < M; k++) {
                    if (id1.substring(0, k).equals(id2.substring(0, k)) &&
                            id1.substring(k + 1, M).equals(id2.substring(k + 1, M))) {
                        System.out.println(id1.substring(0, k) + id1.substring(k + 1, M));
                        return;
                    }
                }
            }
        }
    }

}
