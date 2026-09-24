package model;

public class SmartDoorLock extends SmartDevice implements Lockable {
    private String pin;
    private String status;

    public SmartDoorLock(String id, String nama, double daya, String pin) {
        super(id, nama, daya);
        this.pin = pin;
        this.status = "Terkunci";
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public void lock() {
        this.status = "Terkunci";
    }

    @Override
    public void unlock() {
        this.status = "Terbuka";
    }

    private String getMaskedPin() {
        if (pin == null || pin.isEmpty()) return "****";
        return "*".repeat(pin.length());
    }

    @Override
    public String getDeviceDetails() {
        return String.format("Smart Door Lock [%s] (ID: %s) - Daya: %.1fW | Status: %s | PIN: %s",
                getNama(), getId(), getDaya(), status, getMaskedPin());
    }
}
