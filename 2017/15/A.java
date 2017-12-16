import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long A = Long.parseLong(in.nextLine().split(" ")[4]);
        long B = Long.parseLong(in.nextLine().split(" ")[4]);

        int count = 0;
        for (int i = 0; i < 4e7; i++) {
            A = A * 16807 % 2147483647;
            B = B * 48271 % 2147483647;

            if ((A & 0xffff) == (B & 0xffff)) {
                count++;
            }
        }

        System.out.println(count);
    }

}