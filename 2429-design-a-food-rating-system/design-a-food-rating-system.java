import java.util.*;

class FoodRatings {
    // Map food -> cuisine
    private Map<String, String> foodToCuisine;
    // Map food -> rating
    private Map<String, Integer> foodToRating;
    // Map cuisine -> sorted foods
    private Map<String, TreeSet<String>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int r1 = foodToRating.get(a);
                    int r2 = foodToRating.get(b);
                    if (r1 != r2) return r2 - r1; // higher rating first
                    return a.compareTo(b);        // lexicographically smaller first
                }
            ));

            cuisineToFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> foodsSet = cuisineToFoods.get(cuisine);

        // Remove old record
        foodsSet.remove(food);

        // Update rating
        foodToRating.put(food, newRating);

        // Reinsert into sorted set
        foodsSet.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first(); // TreeSet is sorted, so first is highest
    }
}

/**
 * Example usage:
 * FoodRatings foodRatings = new FoodRatings(
 *     new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
 *     new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
 *     new int[]{9, 12, 8, 15, 14, 7}
 * );
 * 
 * System.out.println(foodRatings.highestRated("korean"));   // "kimchi"
 * System.out.println(foodRatings.highestRated("japanese")); // "ramen"
 * foodRatings.changeRating("sushi", 16);
 * System.out.println(foodRatings.highestRated("japanese")); // "sushi"
 * foodRatings.changeRating("ramen", 16);
 * System.out.println(foodRatings.highestRated("japanese")); // "ramen"
 */
