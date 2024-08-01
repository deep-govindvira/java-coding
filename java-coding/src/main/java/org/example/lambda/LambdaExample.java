package org.example.lambda;

@FunctionalInterface
interface Function {
    Double operation(Double a, Double b);
}

public class LambdaExample {

    public static Double calculate(Function f, Double a, Double b) {
        return f.operation(a, b);
    }

    public static void main(String[] args) {
        Function add = (a, b) -> a + b;
        System.out.println(add.operation(3.0, 5.0));
        System.out.println(calculate((a, b) -> a + b, 3.0, 5.0));
    }
}
