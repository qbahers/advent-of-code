import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> instructions = new ArrayList<String>();
        while (in.hasNextLine()) {
            instructions.add(in.nextLine());
        }

        long[] registers = new long[26];
        long frequency = -1;

        int i = 0;
        while (true) {
            String[] instruction = instructions.get(i).split(" ");

            String op = instruction[0];
            int x = instruction[1].charAt(0) - 'a';
            long y = -1;
            if (instruction.length > 2) {
                if (Character.isLetter(instruction[2].charAt(0))) {
                    y = registers[instruction[2].charAt(0) - 'a'];
                } else {
                    y = Long.parseLong(instruction[2]);
                }
            }

            if (op.equals("snd")) {
                frequency = registers[x];
            } else if (op.equals("set")) {
                registers[x] = y;
            } else if (op.equals("add")) {
                registers[x] += y;
            } else if (op.equals("mul")) {
                registers[x] *= y;
            } else if (op.equals("mod")) {
                registers[x] %= y;
            } else if (op.equals("rcv") && registers[x] != 0) {
                System.out.println(frequency);
                break;
            } else if (op.equals("jgz") && registers[x] > 0) {
                i += y;
                continue;
            }

            i++;
        }
    }

}