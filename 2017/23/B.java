public class B {

    private static boolean isPrime(int b) {
        for (int k = 2; k * k <= b; k++) {
            if (b % k == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 57 * 100 + 100000;
        int c = b + 17000;
        int h = 0;

        while (b <= c) {
            if (!isPrime(b)) {
                h++;
            }
            b += 17;
        }

        System.out.println(h);
    }

}