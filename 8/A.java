import java.util.*;

public class A {

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

        while (in.hasNextLine()) {
            String[] ins = in.nextLine().split(" ");

            if (evalCondition(reg.getOrDefault(ins[4], 0), ins[5], Integer.parseInt(ins[6]))) {
                reg.put(ins[0], reg.getOrDefault(ins[0], 0) + (ins[1].equals("inc") ? 1 : -1) * Integer.parseInt(ins[2]));
            }
        }

        System.out.println(Collections.max(reg.values()));
    }

}