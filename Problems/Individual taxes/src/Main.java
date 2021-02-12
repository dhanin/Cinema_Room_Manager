import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        int[] rate = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) {
            rate[i] = scanner.nextInt();
        }

        double max = (double) arr[0] * rate[0] / 100;
        double tax = 0.0;
        int index = 0;
        for (int i = 0; i < num; i++) {
            tax = (double) arr[i] * rate[i] / 100;
            if (tax > max) {
                max = tax;
                index = i;
            }
        }
        System.out.println(index + 1);
    }
}