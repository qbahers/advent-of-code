import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int res = 0;

        List<Integer> l = new ArrayList<Integer>();

        while (in.hasNextInt()) {
            l.add(in.nextInt());
        }

        int i = 0;
        while (i >= 0 && i < l.size()) {
            int jump = l.get(i);
            if (jump >= 3) {
                l.set(i, jump - 1);
            } else {
                l.set(i, jump + 1);
            }
            i += jump;

            res++;
        }

        System.out.println(res);
    }

}