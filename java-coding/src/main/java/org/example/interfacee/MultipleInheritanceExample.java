package org.example.interfacee;

interface Interface1 {
    default void doSomething() {
        System.out.println("I1");
    }
}

interface Interface2 {
    default void doSomething() {
        System.out.println("I2");
    }
}

public class MultipleInheritanceExample implements Interface1, Interface2 {
    @Override
    public void doSomething() {
        Interface1.super.doSomething();
        Interface2.super.doSomething();
    }

    public static void main(String[] args) {
        MultipleInheritanceExample multipleInheritanceExample = new MultipleInheritanceExample();
        multipleInheritanceExample.doSomething();
    }
}

