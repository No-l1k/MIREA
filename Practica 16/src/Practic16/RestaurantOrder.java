package Practic16;
public class RestaurantOrder implements Order {
    private int size_dishes, size_drinks;
    private Dish[] dishes;
    private Drink[] drinks;
    public RestaurantOrder(){
        size_dishes = 0;
        size_drinks = 0;
        dishes = new Dish[20];
        drinks = new Drink[20];
    }
    public boolean add(Dish dish){
        if(dishes.length == size_dishes){
            Dish[] temp_dishes = new Dish[size_dishes + 2];
            System.arraycopy(dishes, 0, temp_dishes, 0, temp_dishes.length);
            dishes = temp_dishes;
        }
        try {
            dishes[size_dishes] = dish;
            size_dishes++;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    };
    public boolean add(Drink drink){
        if(drinks.length == size_drinks){
            Drink[] temp_drinks = new Drink[size_drinks + 2];
            System.arraycopy(drinks, 0, temp_drinks, 0, temp_drinks.length);
            drinks = temp_drinks;
        }
        try {
            drinks[size_drinks] = drink;
            size_drinks++;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void removeAll(String name) {
        boolean flag = true;
        while (flag){
            if(!remove(name)){
                flag = false;
            }
        }
    }

    public int getSize() {
        return size_dishes + size_drinks;
    }

    ;
    public boolean remove(String name){
        for (int i = 0; i < dishes.length; i++){
            if(dishes[i].getName().equals(name)){
                if(i == size_dishes){
                    dishes[i] = null;
                }
                else{
                    dishes[i] = dishes[size_dishes];
                    dishes[size_dishes] = null;
                }
                size_dishes--;
                return true;
            }
        }
        for (int i = 0; i < drinks.length; i++){
            if(drinks[i].getName().equals(name)){
                if(i == size_drinks){
                    drinks[i] = null;
                }
                else{
                    drinks[i] = drinks[size_drinks];
                    drinks[size_drinks] = null;
                }
                size_drinks--;
                return true;
            }
        }
        return false;
    }

    public Dish[] getAllDishes() {
        return dishes;
    }

    public Dish[] getDishes() {
        Dish[] dish = new Dish[6];
        boolean flag = true;
        if (size_dishes != 0){
            for (int i = 0; i < size_dishes; i++) {
                for (int j = 0; j < 6; j++){
                    if (dish[j] != null) {
                        if (dish[j].getName().equals(dishes[i].getName())) {
                            flag = false;
                        }
                    }
                }
                if(flag) {
                    for (int j = 0; j < 6; j++){
                        if (dish[j] == null){
                            dish[j] = dishes[i];
                            break;
                        }
                    }
                }
                flag = true;
            }
        }
        return dish;
    }

    public Drink[] getDrinks() {
        Drink[] drink = new Drink[6];
        boolean flag = true;
        if (size_drinks != 0){
            for (int i = 0; i < size_drinks; i++) {
                for (int j = 0; j < 6; j++){
                    if (drink[j] != null) {
                        if (drink[j].getName().equals(drinks[i].getName())) {
                            flag = false;
                        }
                    }
                }
                if(flag) {
                    for (int j = 0; j < 6; j++){
                        if (drink[j] == null){
                            drink[j] = drinks[i];
                            break;
                        }
                    }
                }
                flag = true;
            }
        }
        return drink;
    }

    public Drink[] getAllDrinks() {
        return drinks;
    }

    public double CostTotal(){
        double total = 0;
        for (Dish dish : dishes) {
            if (dish != null)
                total += dish.getCost();
        }
        for (Drink drink : drinks) {
            if (drink != null)
                total += drink.getCost();
        }
        return total;
    }

    public Dish[] SortedDishesByCost(){
        for(int i = dishes.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (dishes[j] != null && dishes[j + 1] != null) {
                    if (dishes[j].getCost() > dishes[j + 1].getCost()) {
                        Dish tmp = dishes[j];
                        dishes[j] = dishes[j + 1];
                        dishes[j + 1] = tmp;
                    }
                }
            }
        }
        return dishes;
    }
    public Drink[] SortedDrinksByCost(){
        for(int i = drinks.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (drinks[j] != null && drinks[j + 1] != null) {
                    if (drinks[j].getCost() < drinks[j + 1].getCost()) {
                        Drink tmp = drinks[j];
                        drinks[j] = drinks[j + 1];
                        drinks[j + 1] = tmp;
                    }
                }
            }
        }
        return drinks;
    }

    public int dishQuantity() {
        return size_dishes;
    }
    public int drinkQuantity() {
        return size_drinks;
    }
    public int dishQuantity(String name) {
        int quantity = 0;
        for(int i = 0; i < size_dishes; i++){
            if (dishes[i].getName().equals(name)){
                quantity++;
            }
        }
        return quantity;
    }
    public int drinkQuantity(String name) {
        int quantity = 0;
        for(int i = 0; i < size_drinks; i++){
            if (drinks[i].getName().equals(name)){
                quantity++;
            }
        }
        return quantity;
    }
}
