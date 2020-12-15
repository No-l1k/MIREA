package Practic16;
public class ListNode {
    Drink drink;
    Dish dish;
    ListNode next;
    ListNode prev;

    ListNode(Drink drink) {
        this(null, drink, null);
    }
    ListNode(Dish dish) {
        this(null, dish, null);
    }

    ListNode(ListNode prev, Drink drink, ListNode next) {
        this.drink = drink;
        this.next = next;
        this.prev = prev;
    }
    ListNode(ListNode prev, Dish dish, ListNode next) {
        this.dish = dish;
        this.next = next;
        this.prev = prev;
    }
}
