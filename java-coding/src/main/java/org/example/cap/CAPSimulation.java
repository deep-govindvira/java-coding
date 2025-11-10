package org.example.cap;

import java.util.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CAPSimulation {

    static class ATM {
        String name;
        AtomicInteger balance;
        boolean available;
        ATM neighbor; // the other ATM

        ATM(String name, int initialBalance) {
            this.name = name;
            this.balance = new AtomicInteger(initialBalance);
            this.available = true;
        }

        void connect(ATM other) {
            this.neighbor = other;
            other.neighbor = this;
        }

        void setAvailable(boolean status) {
            this.available = status;
        }

        synchronized void withdraw(int amount) {
            System.out.println(Thread.currentThread().getName() + " entered");
            if (!available) {
                System.out.println(name + " is DOWN! (Partition Tolerance lost, Availability lost)");
                return;
            }

            while (true) {
                int current = balance.get();
                if (current < amount) {
                    System.out.println(name + " - Insufficient funds! (Consistency maintained)");
                    return;
                }
                if (balance.compareAndSet(current, current - amount)) {
                    System.out.println(name + " - Withdrawal " + amount + " successful. New balance: " + balance.get()
                            + " (Consistency maintained, Availability OK)");

                    // propagate to neighbor if available
                    if (neighbor != null) {
                        if (neighbor.available) {
                            neighbor.balance.set(balance.get());
                            System.out.println("Updated " + neighbor.name + " balance to " + neighbor.balance.get() + " (Consistency propagated)");
                        } else {
                            System.out.println(neighbor.name + " not reachable (Partition) - balance not updated");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " leaving");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ATM atm1 = new ATM("ATM1", 1000);
        ATM atm2 = new ATM("ATM2", 1000);

        // connect the two ATMs
        atm1.connect(atm2);

        System.out.println("=== Initial Balances ===");
        System.out.println(atm1.name + ": " + atm1.balance.get());
        System.out.println(atm2.name + ": " + atm2.balance.get() + "\n");

        // Concurrent withdrawals
        Thread t1 = new Thread(() -> atm1.withdraw(700));
        Thread t2 = new Thread(() -> atm2.withdraw(400));

//        t1.start();
//        t2.start();

        t1.join();
        t2.join();

        System.out.println("\n--- Simulate Partition: ATM2 down ---");
        atm2.setAvailable(false);

        // More withdrawals
        Thread t3 = new Thread(() -> atm1.withdraw(200));
        Thread t4 = new Thread(() -> atm2.withdraw(100)); // down

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("\n=== Final Balances ===");
        System.out.println(atm1.name + ": " + atm1.balance.get());
        System.out.println(atm2.name + ": " + atm2.balance.get());
    }
}
