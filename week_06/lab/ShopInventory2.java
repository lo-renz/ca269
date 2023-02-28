import java.util.List;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class Item {
    final String name;
    final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.name + ": " +  this.price;
    }
}

class Basket {
    private final Stack<Item> basket;

    Basket() {
        this.basket = new Stack<Item>();
    }

    public void addItem(Item item) {
        this.basket.push(item);
    }

    public Item removeItem() {
        return this.basket.pop();
    }

    public boolean empty() {
        return this.basket.isEmpty();
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }
}

class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        this.checkout = new LinkedList<Item>();
        while(!basket.empty()) {
            addItem(basket.removeItem());
        }
    }

    public void addItem(Item item) {
        this.checkout.add(item);
    }

    public Item removeItem() {
        return this.checkout.remove();
    }

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }
}

public class ShopInventory2 {
    static void loadBasket(Basket basket) {
        basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
        basket.addItem(new Item("Folans Orange Marmalade", 4.00));
        basket.addItem(new Item("Free-range Eggs", 3.55));
        basket.addItem(new Item("Brennan's Bread", 2.15));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        //basket.removeItem();
        //basket.removeItem();
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        loadBasket(basket);
        System.out.println(basket.empty());
        Checkout checkout = new Checkout(basket);
        System.out.println(checkout);
    }
}