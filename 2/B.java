import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int res = 0;

        while (in.hasNextLine()) {
            Scanner row = new Scanner(in.nextLine());

            List<Integer> l = new ArrayList<Integer>();

            while (row.hasNextInt()) {
                l.add(row.nextInt());
            }

            int N = l.size();

            found:
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (l.get(i) % l.get(j) == 0) {
                        res += l.get(i) / l.get(j);
                        break found;
                    }
                    else if (l.get(j) % l.get(i) == 0) {
                        res += l.get(j) / l.get(i);
                        break found;
                    }
                }
            }
        }

        System.out.println(res);
    }

}