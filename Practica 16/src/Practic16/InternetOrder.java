package Practic16;
public class InternetOrder implements Order {
    private ListNode front;
    private int size;
    public InternetOrder() {
        front = null;
    }

    public InternetOrder(RestaurantOrder order) {
        Dish[] dishes = order.getAllDishes();
        Drink[] drinks = order.getAllDrinks();
        for (Dish dish : dishes) {
            add(dish);
        }
        for (Drink drink : drinks) {
            add(drink);
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(Drink drink)
    {
        if (isEmpty())
            front = new ListNode(drink);
        else {
            ListNode temp = front;
            front = new ListNode(null, drink, temp);
            front.next.prev = front;
        }
        size++;
        return true;

    }


    public boolean add(Dish dish)
    {
        if (isEmpty())
            front = new ListNode(dish);
        else {
            ListNode temp = front;
            front = new ListNode(null, dish, temp);
            front.next.prev = front;
        }
        size++;
        return true;
    }

    public boolean remove(String name) {
        if (isEmpty())
            return false;
        if (front.dish != null) {
            if (front.dish.getName().equals(name)) {
                front = front.next;
                return true;
            }
        }
        if (front.drink != null) {
            if (front.drink.getName().equals(name)) {
                front = front.next;
                return true;
            }
        }

        ListNode current = front;
        boolean flag = true;

        while (flag){
            current = current.next;
            if(current == null){
                flag = false;
            }
            else if (current.dish != null){
                if(current.dish.getName().equals(name)){
                    flag = false;
                }
            }
            else if (current.drink != null){
                if(current.drink.getName().equals(name)){
                    flag = false;
                }
            }
        }
        if (current == null)
            return false;
        if (current.next != null)
            current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;
        return true;
    }
    public void removeAll(String name) {
        boolean flag = true;
        while (flag){
            if(!remove(name)){
                flag = false;
            }
        }
    }

    public int getSize()
    {
        return size;
    }
    public RestaurantOrder getOrder()
    {
        RestaurantOrder order = new RestaurantOrder();
        if (!isEmpty()){
            ListNode temp = front;
            while (temp != null) {
                if (temp.dish != null){
                    order.add(temp.dish);
                }
                else if (temp.drink != null){
                    order.add(temp.drink);
                }
                temp = temp.next;
            }
        }
        return order;
    }

    public double CostTotal(){
        double cost = 0;
        if (!isEmpty()){
            ListNode temp = front;
            while (temp != null) {
                if (temp.dish != null){
                    cost += temp.dish.getCost();
                }
                else if (temp.drink != null){
                    cost += temp.drink.getCost();
                }
                temp = temp.next;
            }
        }
        return cost;
    }

    public double CostTotal(String s){
        double cost = 0;
        if (!isEmpty()){
            ListNode temp = front;
            while (temp != null) {
                if (temp.dish != null){
                    cost += temp.dish.getCost();
                }
                else if (temp.drink != null){
                    cost += temp.drink.getCost();
                }
                temp = temp.next;
            }
        }
        return cost;
    }

    public int getOrderQuantity(String name){
        int quantity = 0;
        if (!isEmpty()){
            ListNode temp = front;
            while (temp != null) {
                if (temp.dish != null){
                    if(temp.dish.getName().equals(name)) {
                        quantity++;
                    }
                }
                else if (temp.drink != null){
                    if(temp.drink.getName().equals(name)) {
                        quantity++;
                    }
                }
                temp = temp.next;
            }
        }
        return quantity;
    }

}
