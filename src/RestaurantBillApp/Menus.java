package RestaurantBillApp;
import java.util.HashMap;

public class Menus {
    static HashMap<Byte, String> appetizers = new HashMap<> ();
    static HashMap<Byte, String> mainFoods = new HashMap<> ();
    static HashMap<Byte, String> desserts = new HashMap<> ();
    static HashMap<Byte, String> beverages = new HashMap<> ();

    static {
        appetizers.put((byte)11,"Bruschetta, $8.99");
        appetizers.put((byte)12,"Spring Rolls, $6.49");
        appetizers.put((byte)13,"Chicken Wings, $9.49");

        mainFoods.put((byte)41,"Grilled Steak, $19.99");
        mainFoods.put((byte)42,"Spaghetti Carbonara, $12.99");
        mainFoods.put((byte)43,"Vegetarian Stir-Fry, $14.99");

        desserts.put((byte)71,"Chocolate Lava Cake, $7.49");
        desserts.put((byte)72,"Cheesecake, $6.99");
        desserts.put((byte)73,"Apple Pie, $5.99");
        desserts.put((byte)74,"Baklava, $7.99");

        beverages.put((byte)111,"Soft Drinks, $2.49");
        beverages.put((byte)112,"Coffee, $2.99");
        beverages.put((byte)113,"Lemonade, $2.99");
        beverages.put((byte)114,"Fanta, $1.99");
        beverages.put((byte)115,"Coke, $1.99");
    }
}
