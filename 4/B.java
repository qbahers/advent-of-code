import java.util.*;

public class B {

    private static String sort(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int res = 0;

        while (in.hasNextLine()) {
            Set<String> set = new HashSet<String>();

            String[] words = in.nextLine().split(" ");

            int i = 0;
            while (i < words.length) {
                String word = sort(words[i]);

                if (set.contains(word)) {
                    break;
                } else {
                    set.add(word);
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