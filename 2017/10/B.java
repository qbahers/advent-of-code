import java.util.*;

public class B {

    private static byte[] concat(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    private static void reverse(int[] list, int begin, int end) {
        int N = list.length;

        int i = begin, j = end;
        while (i < j) {
            int tmp = list[i % N];
            list[i % N] = list[j % N];
            list[j % N] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] list = new int[256];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;            
        }
        int currentPosition = 0;
        int skipSize = 0;

        byte[] a = in.next().getBytes();
        byte[] suffix = {17, 31, 73, 47, 23};
        byte[] lengths = concat(a, suffix);

        for (int j = 0; j < 64; j++) {
            for (int i = 0; i < lengths.length; i++) {
                reverse(list, currentPosition, currentPosition + lengths[i] - 1);
                currentPosition += lengths[i] + skipSize;
                skipSize++;
            }
        }

        int[] denseHash = new int[16];
        for (int i = 0; i < 16; i ++) {
            for (int j = 0; j < 16; j++) {
                denseHash[i] ^= list[i * 16 + j];
            }
        }

        String knotHash = "";
        // Represent each number as two hexadecimal digits (including a leading zero as necessary).
        for (int i = 0; i < 16; i++) {
            knotHash += String.format("%02x", denseHash[i]);
        }

        System.out.println(knotHash);
    }

}