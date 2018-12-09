import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> ids = new ArrayList<>();
        List<int[]> positions = new ArrayList<>();
        List<int[]> dimensions = new ArrayList<>();

        while (sc.hasNextLine()) {
            ids.add(sc.next().replace("#", ""));
            sc.next();
            positions.add(Arrays.stream(sc.next().replace(":", "").split(",")).mapToInt(Integer::parseInt).toArray());
            dimensions.add(Arrays.stream(sc.next().split("x")).mapToInt(Integer::parseInt).toArray());
        }

        int N = ids.size();

        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j ||
                    positions.get(i)[0] + dimensions.get(i)[0] - 1 < positions.get(j)[0] ||
                    positions.get(i)[0] > positions.get(j)[0] + dimensions.get(j)[0] - 1 ||
                    positions.get(i)[1] + dimensions.get(i)[1] - 1 < positions.get(j)[1] ||
                    positions.get(i)[1] > positions.get(j)[1] + dimensions.get(j)[1] - 1) {
                    continue;
                } else {
                    continue outer;
                }
            }
            System.out.println(ids.get(i));
            return;
        }
    }

}