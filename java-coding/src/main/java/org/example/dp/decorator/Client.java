package org.example.dp.decorator;

// Component interface
interface Beverage {
    double cost();
    String getDescription();
}

// ConcreteComponent class
class Espresso implements Beverage {
    @Override
    public double cost() {
        return 1.99;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}

// Decorator class
abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

// ConcreteDecorator classes
class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}

class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        Beverage mochaEspresso = new Mocha(espresso);
        Beverage soyMochaEspresso = new Soy(mochaEspresso);
        System.out.println(soyMochaEspresso.getDescription());
        System.out.println(soyMochaEspresso.cost());
        System.out.println(new Soy(new Mocha(new Espresso())).cost());
    }
}