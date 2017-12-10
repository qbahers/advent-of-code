import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int res = 0;

        while (in.hasNextLine()) {
            Scanner row = new Scanner(in.nextLine());

            int min = Integer.MAX_VALUE;
            int max = 0;

            while (row.hasNextInt()) {
                int num = row.nextInt();
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            res += max - min;
        }

        System.out.println(res);
    }

}