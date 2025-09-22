// File: SmartHomeDemo.java
import java.util.*;

interface Controllable {
    void turnOn();
    void turnOff();
    boolean isOn();
}

abstract class Appliance implements Controllable {
    private String id;
    private boolean on;
    private int powerWatts; // private internal setting

    public Appliance(String id, int powerWatts) {
        this.id = id;
        this.powerWatts = powerWatts;
    }

    public int getPowerWatts() { return powerWatts; }

    public void setPowerWatts(int p) { powerWatts = p; }

    public String getId() { return id; }

    @Override
    public boolean isOn() { return on; }

    protected void setOn(boolean on) { this.on = on; }

    public abstract void status(); // polymorphic behavior
}

class Light extends Appliance {
    private int brightness; // 0-100

    public Light(String id, int powerWatts) {
        super(id, powerWatts);
        this.brightness = 100;
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("Light " + getId() + " turned on at brightness " + brightness + "%");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Light " + getId() + " turned off");
    }

    @Override
    public void status() {
        System.out.println("Light " + getId() + " - power " + getPowerWatts() + "W, on=" + isOn());
    }
}

class AC extends Appliance {
    private double temperature;

    public AC(String id, int powerWatts, double temperature) {
        super(id, powerWatts);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("AC " + getId() + " cooling to " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("AC " + getId() + " turned off");
    }

    @Override
    public void status() {
        System.out.println("AC " + getId() + " - set " + temperature + "°C, on=" + isOn());
    }
}

class Controller {
    private Map<String, Appliance> devices = new HashMap<>();

    public void register(Appliance a) { devices.put(a.getId(), a); }

    public void toggle(String id) {
        Appliance a = devices.get(id);
        if (a == null) { System.out.println("No device " + id); return; }
        if (a.isOn()) a.turnOff(); else a.turnOn();
    }

    public void statusAll() {
        devices.values().forEach(Appliance::status);
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        Light l1 = new Light("L1", 10);
        AC ac1 = new AC("AC1", 1200, 24.5);

        ctrl.register(l1);
        ctrl.register(ac1);

        ctrl.toggle("L1");
        ctrl.toggle("AC1");
        ctrl.statusAll();
    }
}
