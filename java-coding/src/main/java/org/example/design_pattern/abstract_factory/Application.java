package org.example.design_pattern.abstract_factory;

// Abstract Product A
interface Button {
    void render();
}

// Abstract Product B
interface Checkbox {
    void render();
}

// Concrete Product A1
class WindowsButton implements Button {
    public void render() {
        System.out.println("Render Windows Button");
    }
}

// Concrete Product B1
class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Render Windows Checkbox");
    }
}

// Concrete Product A2
class MacButton implements Button {
    public void render() {
        System.out.println("Render Mac Button");
    }
}

// Concrete Product B2
class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Render Mac Checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        GUIFactory factory;

        // Switch this to MacFactory to change UI
        factory = new WindowsFactory();
        Application app = new Application(factory);
        app.renderUI();

        System.out.println("---");

        factory = new MacFactory();
        app = new Application(factory);
        app.renderUI();
    }
}
