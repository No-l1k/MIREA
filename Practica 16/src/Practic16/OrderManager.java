package Practic16;
import java.util.HashMap;

public class OrderManager  {
    private HashMap<Integer, RestaurantOrder> restaurant;
    private HashMap<String, InternetOrder> internet;

    public OrderManager(){
        restaurant = new HashMap<>();
        internet = new HashMap<>();
    }

    public boolean add(int tableNumber, RestaurantOrder order) throws Exception {
        if (restaurant.containsKey(tableNumber)){
            throw new Exception ("OrderAlreadyAddedException");
        }
        else {
            restaurant.put(tableNumber, order);
            return true;
        }
    }
    public boolean add(String address, InternetOrder order){
        internet.put(address, order);
        return true;
    }

    public void removeRestaurantOrder(int tableNumber){
        restaurant.remove(tableNumber);
    }

    public void removeInternetOrder(String address){
        internet.remove(address);
    }

    public RestaurantOrder getRestaurantOrder(int tableNumber) {
        return restaurant.get(tableNumber);
    }

    public InternetOrder getInternetOrder(String address) {
        return internet.get(address);
    }

    public double RestaurantOrdersCostSummary(){
        double total = 0;
        for(int key : restaurant.keySet()){
            total += internet.get(key).CostTotal();
        }
        return total;
    }
    public double InternetOrdersCostSummary(){
        double total = 0;
        for(String key : internet.keySet()){
            total += internet.get(key).CostTotal();
        }
        return total;
    }
    public void addDish_RestaurantOrder(int tableNumber, Dish dish){
        restaurant.get(tableNumber).add(dish);
    }
    public void addDrink_RestaurantOrder(int tableNumber, Drink drink){
        restaurant.get(tableNumber).add(drink);
    }
    public void addDish_InternetOrder(String address, Dish dish){
        internet.get(address).add(dish);
    }
    public void addDrink_InternetOrder(String address, Drink drink){
        internet.get(address).add(drink);
    }

    public String getAllOrders(){
        String s = "";
        if (!restaurant.isEmpty()) {
            s += "Заказ в ресторане:\n";
            for (int key : restaurant.keySet()) {
                s += "стол " + key + "  суммa : " + restaurant.get(key).CostTotal() + "\n";
            }
        }
        if (!internet.isEmpty()) {
            s += "Заказ в интернете:\n";
            for (String key : internet.keySet()) {
                s += "адресу: " + key + " суммa : " + internet.get(key).CostTotal() + "\n";
            }
        }
        return s;
    }
}