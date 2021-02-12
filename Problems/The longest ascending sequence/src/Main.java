import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i] = scanner.nextInt();
        int maxCount = 1;
        int index = 0;


        for (; index < num && maxCount < num - 1 - index; index++ ) {
            int count = 1;
            for (int i = index + 1; i < num; i++) {
                if (arr[i] >= arr[i -1]) {
                    count++;
                } else {
                    maxCount = maxCount > count ? maxCount : count;
                    count = 1;
                }
                maxCount = maxCount > count ? maxCount : count;
            }
        }
        if (num == 1) {
            System.out.println(1);
        } else {
            System.out.println(maxCount);
        }

    }
}