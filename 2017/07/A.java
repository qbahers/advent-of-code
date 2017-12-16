import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<String> programs = new HashSet<String>();
        Set<String> descendants = new HashSet<String>();

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" -> ");
            String program = line[0].split(" ")[0];
            programs.add(program);

            if (line.length > 1) {
                String[] children = line[1].split(", ");
                descendants.addAll(Arrays.asList(children));
            }
        }
        programs.removeAll(descendants);

        System.out.println(programs.toArray()[0]);
    }

}