package org.example.all_design_pattern;

import java.util.*;

// ==================== CREATIONAL PATTERNS ====================

// Singleton
class HomeController {
    private static HomeController instance = new HomeController();
    private HomeController() {}
    public static HomeController getInstance() { return instance; }
    public void showStatus() { System.out.println("HomeController active"); }
}

// Factory
interface Device { void turnOn(); }
class Light implements Device { public void turnOn() { System.out.println("Light ON"); } }
class Thermostat implements Device { public void turnOn() { System.out.println("Thermostat ON"); } }
class DeviceFactory {
    public static Device createDevice(String type) {
        switch(type){
            case "Light": return new Light();
            case "Thermostat": return new Thermostat();
            default: return null;
        }
    }
}

// Builder
class DeviceConfig {
    String color; int brightness;
    DeviceConfig(String c, int b){ color=c; brightness=b; }
    public String toString(){ return "Color:"+color+", Brightness:"+brightness; }
}
class DeviceConfigBuilder {
    private String color; private int brightness;
    public DeviceConfigBuilder setColor(String c){ color=c; return this; }
    public DeviceConfigBuilder setBrightness(int b){ brightness=b; return this; }
    public DeviceConfig build(){ return new DeviceConfig(color, brightness); }
}

// Prototype
class DevicePrototype implements Cloneable {
    String name;
    DevicePrototype(String n){ name=n; }
    public DevicePrototype clone() throws CloneNotSupportedException { return (DevicePrototype) super.clone(); }
    public String toString(){ return "Device: "+name; }
}

// ==================== STRUCTURAL PATTERNS ====================

// Adapter
interface SmartSpeaker { void playMusic(); }
class ThirdPartySpeaker { void start(){ System.out.println("Playing music"); } }
class SpeakerAdapter implements SmartSpeaker {
    ThirdPartySpeaker speaker = new ThirdPartySpeaker();
    public void playMusic(){ speaker.start(); }
}

// Decorator
class DeviceDecorator implements Device {
    protected Device device;
    DeviceDecorator(Device d){ device=d; }
    public void turnOn(){ device.turnOn(); System.out.println("Extra feature added"); }
}

// Composite
interface DeviceComponent { void turnOn(); }
class DeviceLeaf implements DeviceComponent {
    Device device; DeviceLeaf(Device d){ device=d; }
    public void turnOn(){ device.turnOn(); }
}
class DeviceGroup implements DeviceComponent {
    List<DeviceComponent> components = new ArrayList<>();
    public void add(DeviceComponent c){ components.add(c); }
    public void turnOn(){ components.forEach(DeviceComponent::turnOn); }
}

// Proxy
class SecurityCamera implements Device {
    public void turnOn(){ System.out.println("Camera ON"); }
}
class SecurityCameraProxy implements Device {
    SecurityCamera camera = new SecurityCamera();
    boolean authorized = false;
    public void setAuthorized(boolean a){ authorized=a; }
    public void turnOn(){ if(authorized) camera.turnOn(); else System.out.println("Access Denied"); }
}

// Facade
class HomeFacade {
    List<Device> devices = new ArrayList<>();
    public void addDevice(Device d){ devices.add(d); }
    public void turnOnAll(){ devices.forEach(Device::turnOn); }
}

// ==================== BEHAVIORAL PATTERNS ====================

// Observer
interface Observer { void update(String msg); }
interface Subject { void attach(Observer o); void notifyObservers(String msg); }
class DeviceSubject implements Subject {
    List<Observer> observers = new ArrayList<>();
    public void attach(Observer o){ observers.add(o); }
    public void notifyObservers(String msg){ observers.forEach(o -> o.update(msg)); }
}

// Strategy
interface EnergyStrategy { void apply(); }
class EcoMode implements EnergyStrategy { public void apply(){ System.out.println("Eco Mode applied"); } }
class NormalMode implements EnergyStrategy { public void apply(){ System.out.println("Normal Mode applied"); } }
class DeviceContext {
    EnergyStrategy strategy;
    public void setStrategy(EnergyStrategy s){ strategy=s; }
    public void execute(){ strategy.apply(); }
}

// Command
interface Command { void execute(); }
class TurnOnCommand implements Command {
    Device device;
    TurnOnCommand(Device d){ device=d; }
    public void execute(){ device.turnOn(); }
}
class RemoteControl {
    Command command;
    public void setCommand(Command c){ command=c; }
    public void pressButton(){ command.execute(); }
}

// State
interface DeviceStateBehavior { void handle(); }
class OnState implements DeviceStateBehavior { public void handle(){ System.out.println("Device is ON"); } }
class OffState implements DeviceStateBehavior { public void handle(){ System.out.println("Device is OFF"); } }
class StatefulDevice {
    DeviceStateBehavior state;
    public void setState(DeviceStateBehavior s){ state=s; }
    public void request(){ state.handle(); }
}

// Template Method
abstract class DeviceOperation {
    public final void operate(){ turnOn(); perform(); turnOff(); }
    abstract void turnOn(); abstract void perform(); abstract void turnOff();
}
class LightOperation extends DeviceOperation {
    void turnOn(){ System.out.println("Light ON"); }
    void perform(){ System.out.println("Light performing task"); }
    void turnOff(){ System.out.println("Light OFF"); }
}

// ==================== MAIN DEMO ====================
public class SmartHomeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== Singleton ===");
        HomeController.getInstance().showStatus();

        System.out.println("\n=== Factory ===");
        Device light = DeviceFactory.createDevice("Light");
        Device thermostat = DeviceFactory.createDevice("Thermostat");
        light.turnOn(); thermostat.turnOn();

        System.out.println("\n=== Builder ===");
        DeviceConfig config = new DeviceConfigBuilder().setColor("Red").setBrightness(75).build();
        System.out.println(config);

        System.out.println("\n=== Prototype ===");
        DevicePrototype proto = new DevicePrototype("SmartLight");
        DevicePrototype cloned = proto.clone();
        System.out.println(cloned);

        System.out.println("\n=== Adapter ===");
        SmartSpeaker speaker = new SpeakerAdapter();
        speaker.playMusic();

        System.out.println("\n=== Decorator ===");
        Device decorated = new DeviceDecorator(light);
        decorated.turnOn();

        System.out.println("\n=== Composite ===");
        DeviceGroup group = new DeviceGroup();
        group.add(new DeviceLeaf(light));
        group.add(new DeviceLeaf(thermostat));
        group.turnOn();

        System.out.println("\n=== Proxy ===");
        SecurityCameraProxy cam = new SecurityCameraProxy();
        cam.turnOn();
        cam.setAuthorized(true);
        cam.turnOn();

        System.out.println("\n=== Facade ===");
        HomeFacade facade = new HomeFacade();
        facade.addDevice(light); facade.addDevice(thermostat);
        facade.turnOnAll();

        System.out.println("\n=== Strategy ===");
        DeviceContext context = new DeviceContext();
        context.setStrategy(new EcoMode()); context.execute();
        context.setStrategy(new NormalMode()); context.execute();

        System.out.println("\n=== Command ===");
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new TurnOnCommand(light));
        remote.pressButton();

        System.out.println("\n=== State ===");
        StatefulDevice sd = new StatefulDevice();
        sd.setState(new OnState()); sd.request();
        sd.setState(new OffState()); sd.request();

        System.out.println("\n=== Template Method ===");
        DeviceOperation op = new LightOperation();
        op.operate();
    }
}
