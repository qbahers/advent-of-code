import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> routingDiagram = new ArrayList<String>();

        while (in.hasNextLine()) {
            routingDiagram.add(in.nextLine());
        }

        int i = 0, j = routingDiagram.get(0).indexOf('|');
        char direction = 'D';

        String letters = "";
        while (routingDiagram.get(i).charAt(j) != ' ') {
            if (routingDiagram.get(i).charAt(j) == '+') {
                if (routingDiagram.get(i - 1).charAt(j) != ' ' && direction != 'D') {
                    direction = 'U';
                } else if (routingDiagram.get(i + 1).charAt(j) != ' ' && direction != 'U') {
                    direction = 'D';
                } else if (routingDiagram.get(i).charAt(j - 1) != ' ' && direction != 'R') {
                    direction = 'L';
                } else {
                    direction = 'R';
                }
            } else if (routingDiagram.get(i).charAt(j) != '|' && routingDiagram.get(i).charAt(j) != '-') {
                letters += routingDiagram.get(i).charAt(j);
            }

            if (direction == 'U') {
                i--;
            } else if (direction == 'D') {
                i++;
            } else if (direction == 'L') {
                j--;
            } else {
                j++;
            }
        }

        System.out.println(letters);
    }

}