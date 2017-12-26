import java.util.*;

public class A {

    private static long parse(String s, long[] registers) {
        if (Character.isLetter(s.charAt(0))) {
            return registers[s.charAt(0) - 'a'];
        } else {
            return Long.parseLong(s);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> instructions = new ArrayList<String>();
        while (in.hasNextLine()) {
            instructions.add(in.nextLine());
        }

        long[] registers = new long[8];

        int i = 0;
        int count = 0;
        while (i >= 0 && i < instructions.size()) {
            String[] instruction = instructions.get(i).split(" ");

            String op = instruction[0];
            int x = instruction[1].charAt(0) - 'a';
            long y = parse(instruction[2], registers);

            if (op.equals("set")) {
                registers[x] = y;
            } else if (op.equals("sub")) {
                registers[x] -= y;
            } else if (op.equals("mul")) {
                registers[x] *= y;
                count++;
            } else if (op.equals("jnz") && parse(instruction[1], registers) != 0) {
                i += y;
                continue;
            }

            i++;
        }

        System.out.println(count);
    }

}