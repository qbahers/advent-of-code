import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int res = 0;

        while (in.hasNextLine()) {
            Set<String> set = new HashSet<String>();

            String[] words = in.nextLine().split(" ");

            int i = 0;
            while (i < words.length) {
                if (set.contains(words[i])) {
                    break;
                } else {
                    set.add(words[i]);
                }
                i++;
            }

            if (i == words.length) {
                res++;
            }
        }

        System.out.println(res);
    }

}