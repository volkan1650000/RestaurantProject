package RestaurantBillApp;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Order {

    static Scanner scan = new Scanner(System.in);
    static int billNr = 0;
    static float total = 0;
    static LinkedHashMap<String, Integer> orderList = new LinkedHashMap<>();

    public static boolean orders(){
        if(orderList.size()==0){
            System.out.println("No orders found");
            return true;
        }
        Set<String> set =  orderList.keySet();
        System.out.println("\nOrders :");
        for(String w : set){
            int orderAmount = orderList.get(w);
            total+=Double.parseDouble(w.replaceAll("[^0-9.]",""))*orderAmount;
            System.out.println(orderAmount+"x - "+w);
        }
        System.out.println("Amount to be paid : "+total+"$");
        System.out.println("\nF - to order\nR - to reset the orders\nM - to get back to the main menu");
        String a;
        do{
            a = scan.nextLine();
            if(a.equals("M")){
                break;
            }
            if(a.equals("F")){
                getTheBill();
                return false;
            }
            else if(a.equals("R")){
                reset();
                break;
            }else{
                System.out.println("Please choose a valid option!");
            }
        }while (true);
        return true;
    }

    private static void getTheBill(){
        Set<String> set =  orderList.keySet();
        System.out.println("\nOrders :");
        for(String w : set){
            int orderAmount = orderList.get(w);
            total+=Integer.parseInt(w.replaceAll("[^0-9]",""))*orderAmount;
            System.out.println(orderAmount+"x - "+w+"\n");
        }
        System.out.println("Bill Number : "+billNr);
        System.out.println("We are looking forward to your next orders! :)");
    }

    public static void reset(){
        total = 0;
        orderList.clear();
        System.out.println("Your orders have successfully been removed");
    }


    private static boolean orderAccordingly(String s, byte x){
        switch (s) {
            case "appetizers":
                if(!Menus.appetizers.containsKey(x)){
                    System.out.println("Please correctly enter the code of the appetizer you would like to order");
                    return false;
                }{String ord = Menus.appetizers.get(x);
                Integer orderAmount = orderList.get(ord);
                if(orderAmount==null){
                    orderList.put(ord,1);
                }else{
                    orderList.replace(ord,orderAmount+1);
                }}
                System.out.println("The meal has been added to order list, will you buy something else from " + s + "? (1 - For yes, 2 - For no)");
                String b = scan.nextLine();
                do {
                    if (b.equals("1")) {
                        return false;
                    } else if (b.equals("2")) {
                        return true;
                    } else {
                        System.out.println("Please choose a valid process!");
                    }
                } while (true);
            case "mainfoods":
                if(!Menus.mainFoods.containsKey(x)){
                    System.out.println("Please correctly enter the code of the main food you would like to order");
                    return false;
                }{String ord = Menus.mainFoods.get(x);
                Integer orderAmount = orderList.get(ord);
                if(orderAmount==null){
                    orderList.put(ord,1);
                }else{
                    orderList.replace(ord,orderAmount+1);
                }}
                System.out.println("The meal has been added to order list, will you buy something else from " + s + "? (1 - For yes, 2 - For no)");
                b = scan.nextLine();
                do {
                    if (b.equals("1")) {
                        return false;
                    } else if (b.equals("2")) {
                        return true;
                    } else {
                        System.out.println("Please choose a valid process!");
                    }
                } while (true);
            case "desserts":
                if(!Menus.desserts.containsKey(x)){
                    System.out.println("Please correctly enter the code of the dessert you would like to order");
                    return false;
                }{String ord = Menus.desserts.get(x);
                Integer orderAmount = orderList.get(ord);
                if(orderAmount==null){
                    orderList.put(ord,1);
                }else{
                    orderList.replace(ord,orderAmount+1);
                }}
                System.out.println("The meal has been added to order list, will you buy something else from " + s + "? (1 - For yes, 2 - For no)");
                b = scan.nextLine();
                do {
                    if (b.equals("1")) {
                        return false;
                    } else if (b.equals("2")) {
                        return true;
                    } else {
                        System.out.println("Please choose a valid process!");
                    }
                } while (true);
            case "beverages":
                if(!Menus.beverages.containsKey(x)){
                    System.out.println("Please correctly enter the code of the beverage you would like to order");
                    return false;
                }{String ord = Menus.beverages.get(x);
                Integer orderAmount = orderList.get(ord);
                if(orderAmount==null){
                    orderList.put(ord,1);
                }else{
                    orderList.replace(ord,orderAmount+1);
                }}
                System.out.println("The meal has been added to order list, will you buy something else from " + s + "? (1 - For yes, 2 - For no)");
                b = scan.nextLine();
                do {
                    if (b.equals("1")) {
                        return false;
                    } else if (b.equals("2")) {
                        return true;
                    } else {
                        System.out.println("Please choose a valid process!");
                    }
                } while (true);
        }
        return true;
    }




    public static void random(){
        Random rand = new Random();
        billNr = Math.abs(rand.nextInt()+10000);
    }




    private static void ordering(String s){
        outerLoop:
        do{
            System.out.println("\n1 - order, 2 - get back to the menu lists");
            String a = scan.nextLine();
            if(a.equals("2")){
                break;
            }else if(a.equals("1")){
                String b;
                boolean ok;
                do{
                    System.out.println("Write the code of the "+s+" you would like to order");
                    b = scan.nextLine();
                    int order;
                    try{
                        order = Integer.parseInt(b);
                    }catch (NumberFormatException e){
                        System.out.println("Please enter a number!");
                        continue;
                    }
                    ok = orderAccordingly(s,(byte)order);
                    if(ok){
                        break outerLoop;
                    }
                }while(true);
            }else{
                System.out.println("PLease choose a valid process");
            }
        }while(true);
    }





    public static void showAppetizers(){
        Set<Byte> set = Menus.appetizers.keySet();
        for (Byte b : set){
            String[]a = Menus.appetizers.get(b).split(",");
            System.out.println("Code : "+b+",  Name : "+a[0]+",  Price : "+a[1]);
        }
        ordering("appetizers");
    }
    public static void showMainFoods(){
        Set<Byte> set = Menus.mainFoods.keySet();
        for (Byte b : set){
            String[]a = Menus.mainFoods.get(b).split(",");
            System.out.println("Code : "+b+",  Name : "+a[0]+",  Price : "+a[1]);
        }
        ordering("mainfoods");
    }
    public static void showDesserts(){
        Set<Byte> set = Menus.desserts.keySet();
        for (Byte b : set){
            String[]a = Menus.desserts.get(b).split(",");
            System.out.println("Code : "+b+",  Name : "+a[0]+",  Price : "+a[1]);
        }
        ordering("desserts");
    }
    public static void showBeverages(){
        Set<Byte> set = Menus.beverages.keySet();
        for (Byte b : set){
            String[]a = Menus.beverages.get(b).split(",");
            System.out.println("Code : "+b+",  Name : "+a[0]+",  Price : "+a[1]);
        }
        ordering("beverages");
    }
}
