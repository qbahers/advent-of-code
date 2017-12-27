import java.util.*;

public class A {

    public static void main(String[] args) {
        Map<Integer, Integer> tape = new HashMap<Integer, Integer>();
        int cursor = 0;
        Map<Character, char[][]> rules = new HashMap<Character, char[][]>();
        rules.put('A', new char[][]{{'1', 'R', 'B'}, {'0', 'R', 'C'}});
        rules.put('B', new char[][]{{'0', 'L', 'A'}, {'0', 'R', 'D'}});
        rules.put('C', new char[][]{{'1', 'R', 'D'}, {'1', 'R', 'A'}});
        rules.put('D', new char[][]{{'1', 'L', 'E'}, {'0', 'L', 'D'}});
        rules.put('E', new char[][]{{'1', 'R', 'F'}, {'1', 'L', 'B'}});
        rules.put('F', new char[][]{{'1', 'R', 'A'}, {'1', 'R', 'E'}});

        char state = 'A';
        for (int i = 0; i < 12399302; i++) {
            char[][] rule = rules.get(state);
            int value = tape.getOrDefault(cursor, 0);
            tape.put(cursor, rule[value][0] - '0');
            cursor = (rule[value][1] == 'R') ? cursor + 1 : cursor - 1;
            state = rule[value][2];
        }

        System.out.println(tape.values().stream().mapToInt(Integer::intValue).sum());
    }

}