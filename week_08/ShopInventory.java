// Implement the Iterable and Iterator interfaces.
// To do this we will reuse the ShopInventory use-case,
// where there is a basket of food items that needs
// to be iterated over.

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

class Item {
    final String name;
    final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.name + ": " + this.price;
    }
}

class Basket implements Iterable<Item> {
    private  List<Item> basket = new ArrayList<>();

    public Iterator<Item> iterator() {
        return new BasketIterator();
    }

    private class BasketIterator implements Iterator<Item> {
        private int iterated;

        public boolean hasNext() {
            return iterated < basket.size();
        }

        public Item next() {
            if(hasNext()) {
                Item item = basket.get(iterated);
                iterated += 1;
                return item;
            }
            return null;
        }
    }

    public void addItem(Item item) {
        basket.add(item);
    }

    public void removeItem(Item item) {
        basket.remove(item);
    }

    public boolean empty() {
        return this.basket.isEmpty();
    }

    public String toString() {
        return "Basket: " + this.basket;
    }
}

public class ShopInventory {
    public static void main(String[] args) {
        Basket basket = new Basket();
        loadBasket(basket);

        for(Item item: basket) {
            System.out.println(item);
        }

        System.out.println("----------");

        Iterator<Item> iter = basket.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    static void loadBasket(Basket basket) {
        basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
        basket.addItem(new Item("Folans Orange Marmalade", 4.00));
        basket.addItem(new Item("Free-range Eggs", 3.35));
        basket.addItem(new Item("Brennan's Bread", 2.15));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
    }
}