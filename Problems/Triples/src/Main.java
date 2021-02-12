import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int tripple = 0;
        int count = 0;
        for (int k = 0; k < len; k++) {
            for (int i = k + 1; i < len; i++) {
                if (arr[i] - arr[i - 1] == 1) {
                    count++;
                    if (count == 2) {
                        tripple++;
                        k = i;
                        count = 1;

                    }
                } else {
                    count = 0;
                    k = i;
                }
            }
        }
        System.out.println(tripple);
    }
}