import java.util.*;

public class B {

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

            List<long[][]> collidingParticles = new ArrayList<long[][]>();
            for (int j = 0; j < particles.size(); j++) {
                for (int k = 0; k < particles.size(); k++) {
                    if (j != k && Arrays.equals(particles.get(j)[0], particles.get(k)[0])) {
                        collidingParticles.add(particles.get(j));
                        break;
                    }
                }
            }
            particles.removeAll(collidingParticles);
        }

        System.out.println(particles.size());
    }

}