import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        int res = 0;
        int N = s.length();

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == s.charAt((i + N / 2) % N)) {
                res += s.charAt(i) - '0';
            }
        }

        System.out.println(res);
    }

}