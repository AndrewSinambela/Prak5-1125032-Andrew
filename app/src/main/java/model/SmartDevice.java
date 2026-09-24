package model;

public abstract class SmartDevice {
    private String id;
    private String nama;
    private double daya;

    public SmartDevice(String id, String nama, double daya) {
        this.id = id;
        this.nama = nama;
        this.daya = daya;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getDaya() {
        return daya;
    }

    public abstract String getDeviceDetails();
}
