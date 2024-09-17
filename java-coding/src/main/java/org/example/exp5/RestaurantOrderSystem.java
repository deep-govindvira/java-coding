package org.example.exp5;

// Dish interface and implementations
interface Dish {
    String getDescription();
    double getCost();
}

class Pizza implements Dish {
    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getCost() {
        return 8.00;
    }
}

class Salad implements Dish {
    @Override
    public String getDescription() {
        return "Salad";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}

// Dish Factory
class DishFactory {
    public static Dish getDish(String dishType) {
        if (dishType == null) {
            return null;
        }
        if (dishType.equalsIgnoreCase("PIZZA")) {
            return new Pizza();
        } else if (dishType.equalsIgnoreCase("SALAD")) {
            return new Salad();
        }
        return null;
    }
}

// Meal class with an inner static Builder class
// Updated Meal class with additional variables
class Meal {
    private Dish dish;
    private boolean hasToppings;
    private String size; // e.g., Small, Medium, Large
    private boolean hasExtraCheese;
    private String drink; // e.g., Soda, Water

    private Meal(Builder builder) {
        this.dish = builder.dish;
        this.hasToppings = builder.hasToppings;
        this.size = builder.size;
        this.hasExtraCheese = builder.hasExtraCheese;
        this.drink = builder.drink;
    }

    // Inner static Builder class
    public static class Builder {
        private Dish dish;
        private boolean hasToppings;
        private String size;
        private boolean hasExtraCheese;
        private String drink;

        public Builder(String dishType) {
            this.dish = DishFactory.getDish(dishType);
        }

        public Builder addToppings(boolean hasToppings) {
            this.hasToppings = hasToppings;
            return this;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder addExtraCheese(boolean hasExtraCheese) {
            this.hasExtraCheese = hasExtraCheese;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }
}

// Dish Decorator
abstract class DishDecorator implements Dish {
    protected Dish dish;

    public DishDecorator(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String getDescription() {
        return dish.getDescription();
    }

    @Override
    public double getCost() {
        return dish.getCost();
    }
}

// Concrete Decorators
class Cheese extends DishDecorator {
    public Cheese(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return dish.getCost() + 2.00;
    }
}

class Olives extends DishDecorator {
    public Olives(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return dish.getCost() + 1.50;
    }
}

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        // Use the inner static Builder to create a Meal with toppings
        Meal meal = new Meal.Builder("PIZZA")
            .addToppings(true)
            .build();


        // Use Decorators to add additional toppings
        Dish pizzaWithCheese = new Cheese(DishFactory.getDish("PIZZA"));
        Dish pizzaWithOlives = new Olives(pizzaWithCheese);

        System.out.println("Decorated Dish: " + pizzaWithOlives.getDescription() + " | Cost: $" + pizzaWithOlives.getCost());
    }
}
