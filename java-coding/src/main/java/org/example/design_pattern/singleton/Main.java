package org.example.design_pattern.singleton;

enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Singleton using Enum");
    }
}


public class Main {
    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.doSomething();
        singletonEnum.doSomething();
    }
}
