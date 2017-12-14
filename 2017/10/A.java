import java.util.*;

public class A {

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

        int[] lengths = Arrays.stream(in.next().split(",")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lengths.length; i++) {
            reverse(list, currentPosition, currentPosition + lengths[i] - 1);
            currentPosition += lengths[i] + skipSize;
            skipSize++;
        }

        System.out.println(list[0] * list[1]);
    }

}