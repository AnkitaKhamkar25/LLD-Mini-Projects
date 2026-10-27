
package Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Restaurant restaurant;
    private List<MenuItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    // Getters
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    // Setters
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    // Add an item to the cart
    public void addItem(MenuItem item) {
        if (restaurant == null) {
            System.out.println("Set a restaurant before adding items.");
            return;
        }

        items.add(item);
    }

    // Calculate total cost
    public double getTotalCost() {
        double sum = 0;

        for (MenuItem item : items) {
            sum += item.getPrice();
        }

        return sum;
    }

    // Check whether cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Clear all items
    public void clear() {
        items.clear();
    }
}
