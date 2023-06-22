import java.util.Arrays;
import java.util.Random;

public class Seminar_1 {

    public static void main(String[] args) {
        int i = getRandomInt(0, 2000);
        System.out.println(i);
        System.out.println(OldBit(i));
        int n = OldBit(i);
        int[] m1 = getMultiple(i, n);
        System.out.println(Arrays.toString(m1));
        System.out.println("_____________________________________________________");
        int[] m2 = getNonMultiple(i, n);
        System.out.println(Arrays.toString(m2));


    }

    private static int getRandomInt(int start, int end) {
        Random random = new Random();
        int i = random.nextInt(start, end);
        return i;
    }

    private static int OldBit(int num) {
        int x = 0;
        while (num > 1) {
            num >>= 1;
            x++;
        }
        return x;
    }


    private static int[] getMultiple(int i, int n) {
        int size = 0;
        for (int k = i; k < Short.MAX_VALUE; k++) {
            if (k % n == 0) {
                size++;
            }
        }
        int[] arr = new int[size];
        int t = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                arr[t] = j;
                t++;
            }
        }
        return arr;
    }

    private static int[] getNonMultiple(int i, int n) {
        int size = 0;
        for (int k = Short.MIN_VALUE; k < i; k++) {
            if (k % n != 0) {
                size++;
            }
        }
        int[] arr = new int[size];
        int t = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                arr[t] = j;
                t++;
            }
        }
        return arr;
    }
}