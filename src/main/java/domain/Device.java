package domain;

public class Device {

    private String name;
    private Type type;
    private int amount;

    public Device(String name, Type type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }
}
