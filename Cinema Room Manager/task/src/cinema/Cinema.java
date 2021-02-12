package cinema;

import java.util.Scanner;

public class Cinema {
    int row;
    int seat;
    char[][] matrix;
    Ticket[] ticket;
    int index;
    int numTicketToPurchase;
    int menu;

    public static void main(String[] args) {

       Cinema cinema = new Cinema();
       while (cinema.getMenu() != 0) {
           switch (cinema.menu) {
               case 1:
                   cinema.showSeat();
                   break;
               case 2:
                   cinema.getTicketInfo();
                   break;
               case 3:
                   cinema.showStatistics();
                   break;
           }
       }
    }
    public Cinema() {
        numTicketToPurchase = 0;
        index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seat = scanner.nextInt();
        System.out.println();
        matrix = new char[row][seat];
        ticket = new Ticket[row * seat];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++)
                matrix[i][j] = 'S';
        }
    }
    public int getMenu() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
        Scanner scanner = new Scanner(System.in);
        menu = scanner.nextInt();
        System.out.println();
        return menu;
    }
    public void showSeat() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seat; i++) {
            System.out.print(i + 1 + " " );
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < seat; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void getTicketInfo() {



        if (numTicketToPurchase < Cinema.this.row * Cinema.this.seat) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();

            if (row > Cinema.this.row || seat > Cinema.this.seat) {
                System.out.println("Wrong input!\n");
                getTicketInfo();
                return;
            }

            if (matrix[row - 1][seat - 1] != 'B') {
                matrix[row - 1][seat - 1] = 'B';
                numTicketToPurchase++;
                Ticket ticket = new Ticket();
                ticket.row = row;
                ticket.seat = seat;
                ticket.setPrice();
                ticket.showTicketPrice();
                Cinema.this.ticket[index++] = ticket;
                return;
            } else {
                System.out.println("That ticket has already been purchased!\n");
                getTicketInfo();
            }
        } else {
            System.out.println("Ticket sold out\n");
            return;
        }
    }
    public int calculateTotalIncome() {
        int totalIncome = 0;
        if (row * seat < 60) {
            totalIncome = row * seat * 10;
        } else {
            totalIncome = row / 2 * seat * 10 +  (row - row / 2) * seat * 8;
        }
        return totalIncome;
    }
    public  class Ticket {
        int row;
        int seat;
        int price;

        public void setPrice() {
            if ( Cinema.this.row * Cinema.this.seat <= 60) {
                price = 10;
            } else {
                if ( (row - 1) * Cinema.this.seat + seat <= Cinema.this.row / 2 * Cinema.this.seat) {
                    price = 10;
                } else {
                    price = 8;
                }
            }
        }
        public void showTicketPrice() {
            System.out.printf("Ticket price: $%d\n\n", price);
        }
    }
    public void showStatistics() {
        System.out.printf("Number of purchased tickets: %d\n",numTicketToPurchase);
        System.out.printf("Percentage: %3.2f%c\n", (double) numTicketToPurchase *
                100 / (Cinema.this.row * Cinema.this.seat),'%');
        System.out.printf("Current income: $%d\n", this.calculateCurrentIncome());
        System.out.printf("Total income: $%d\n\n", this.calculateTotalIncome());
    }
    public int calculateCurrentIncome() {
        int sum = 0;
        try {
            for (Ticket temp : ticket
            ) {
                sum += temp.price;
            }
        } catch (Exception e)
        {
            return sum;
        }
        return sum;
    }
}
