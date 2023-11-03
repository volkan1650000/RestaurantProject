package RestaurantBillApp;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Welcome To Our Restaurant!\n");
        run();
    }
    private static void run(){
        Scanner scan = new Scanner(System.in);
        String a;
        Order.random();
        label:
        do {
            System.out.println("Choose what you would like to do :");
            System.out.println("1 - View the appetizers\n" +
                    "2 - View the main foods\n" +
                    "3 - View the desserts\n" +
                    "4 - View the beverages\n" +
                    "5 - View the orders\n" +
                    "Q - Quit the system");
            a = scan.nextLine();
            switch (a) {
                case "Q":
                    break label;
                case "1":
                    Order.showAppetizers();
                    break;
                case "2":
                    Order.showMainFoods();
                    break;
                case "3":
                    Order.showDesserts();
                    break;
                case "4":
                    Order.showBeverages();
                    break;
                case "5":
                    if(!Order.orders()){
                        break label;


                    }
                    break;
                default:
                    System.out.println("Please choose a valid process!");
                    break;
            }
        }while(true);
        System.out.println("Thank you for using our system!");
    }
}
