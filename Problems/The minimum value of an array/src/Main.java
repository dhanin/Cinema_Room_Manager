import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here\
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int min = arr[0];

        for (int num: arr
             ) {
            min = num < min ? num : min;
        }
        System.out.println(min);
    }
}