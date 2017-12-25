import java.util.*;

public class B {

    private static long[][] registers = new long[2][26];

    private static Queue<Long> queue0 = new LinkedList<Long>();
    private static Queue<Long> queue1 = new LinkedList<Long>();

    private static int[] steps = new int[2];
    private static int[] count = new int[2];
    private static boolean[] isStuck = new boolean[2];

    private static long parse(String s, long[] registers) {
        if (Character.isLetter(s.charAt(0))) {
            return registers[s.charAt(0) - 'a'];
        } else {
            return Long.parseLong(s);
        }
    }

    private static void execute(List<String> instructions, long[] registers, Queue<Long> received, Queue<Long> sent, int id) {
        String[] instruction = instructions.get(steps[id]).split(" ");

        String op = instruction[0];
        int x = instruction[1].charAt(0) - 'a';
        long y = -1;
        if (instruction.length > 2) {
            y = parse(instruction[2], registers);
        }

        if (op.equals("snd")) {
            sent.add(registers[x]);
            isStuck[1 - id] = false;
            count[id]++;
        } else if (op.equals("set")) {
            registers[x] = y;
        } else if (op.equals("add")) {
            registers[x] += y;
        } else if (op.equals("mul")) {
            registers[x] *= y;
        } else if (op.equals("mod")) {
            registers[x] %= y;
        } else if (op.equals("rcv")) {
            if (received.peek() != null) {
                registers[x] = received.poll();
            } else {
                isStuck[id] = true;
                return;
            }
        } else if (op.equals("jgz") && parse(instruction[1], registers) > 0) {
            steps[id] += y - 1;
        }

        steps[id]++;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> instructions = new ArrayList<String>();
        while (in.hasNextLine()) {
            instructions.add(in.nextLine());
        }

        registers[1]['p' - 'a'] = 1;

        while (true) {
            if (!isStuck[0])      execute(instructions, registers[0], queue0, queue1, 0);
            else if (!isStuck[1]) execute(instructions, registers[1], queue1, queue0, 1);
            else                  break;
        }

        System.out.println(count[1]);
    }

}