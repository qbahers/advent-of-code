import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<long[][]> particles = new ArrayList<long[][]>();

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(", ");

            long[][] particle = new long[3][3];
            for (int i = 0; i <= 2; i++) {
                String coordinates = line[i].substring(line[i].indexOf("<") + 1, line[i].indexOf(">"));
                particle[i] = Arrays.stream(coordinates.split(",")).mapToLong(Long::parseLong).toArray();
            }
            particles.add(particle);
        }

        for (int i = 0; i < 1e3; i++) {
            for (int j = 0; j < particles.size(); j++) {
                for (int k = 0; k <= 2; k++) {
                    particles.get(j)[1][k] += particles.get(j)[2][k];
                    particles.get(j)[0][k] += particles.get(j)[1][k];
                }
            }
        }

        long minDistance = Long.MAX_VALUE;
        int particuleId = -1;

        for (int i = 0; i < particles.size(); i++) {
            long[] p = particles.get(i)[0];
            long manhattanDistance = Math.abs(p[0]) + Math.abs(p[1]) + Math.abs(p[2]);

            if (manhattanDistance < minDistance) {
                minDistance = manhattanDistance;
                particuleId = i;
            }
        }

        System.out.println(particuleId);
    }

}