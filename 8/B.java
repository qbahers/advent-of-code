import java.util.*;

public class B {

    private static boolean evalCondition(int left, String operator, int right) throws UnsupportedOperationException {
        switch (operator) {
            case "<": return left < right;
            case ">": return left > right;
            case "<=": return left <= right;
            case ">=": return left >= right;
            case "==": return left == right;
            case "!=": return left != right;
            default: throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) throws UnsupportedOperationException {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> reg = new HashMap<String, Integer>();

        int max = 0;
        while (in.hasNextLine()) {
            String[] ins = in.nextLine().split(" ");

            if (evalCondition(reg.getOrDefault(ins[4], 0), ins[5], Integer.parseInt(ins[6]))) {
                reg.put(ins[0], reg.getOrDefault(ins[0], 0) + (ins[1].equals("inc") ? 1 : -1) * Integer.parseInt(ins[2]));
                max = Math.max(max, reg.get(ins[0]));
            }
        }

        System.out.println(max);
    }

}