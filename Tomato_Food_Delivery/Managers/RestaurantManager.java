
package Managers;

import Models.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {

    private final List<Restaurant> restaurants = new ArrayList<>();

    private static RestaurantManager instance;

    private RestaurantManager() {
    }

    // Singleton pattern
    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    // Add a restaurant
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    // Search restaurants by location
    public List<Restaurant> searchByLocation(String loc) {
        List<Restaurant> result = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getLocation() != null
                    && loc != null
                    && restaurant.getLocation().equalsIgnoreCase(loc)) {
                result.add(restaurant);
            }
        }

        return result;
    }
}
