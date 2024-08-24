package org.example.observerPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class MessageSubscriber implements Observer {
    private String name;

    public MessageSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class MessagePublisher {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyUpdate(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public static void main(String[] args) {
        Observer observer = new MessageSubscriber("Deep");
        MessagePublisher messagePublisher = new MessagePublisher();
        messagePublisher.attach(observer);
        observer = new MessageSubscriber("Dhiraj");
        observer.update("Updated");
        messagePublisher.attach(observer);
        messagePublisher.notifyUpdate("Hello");
    }
}
