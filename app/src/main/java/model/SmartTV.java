package model;

public class SmartTV extends SmartDevice implements Switchable, Connectable {
    private int channel;
    private int volume;
    private String status;
    private KONEKSI koneksi;

    public SmartTV(String id, String nama, double daya, int channel, int volume, KONEKSI koneksi) {
        super(id, nama, daya);
        this.channel = channel;
        this.volume = volume;
        this.status = "Mati";
        this.koneksi = koneksi;
    }

    @Override
    public void turnOn() {
        this.status = "Menyala";
    }

    @Override
    public void turnOf() {
        this.status = "Mati";
    }

    @Override
    public void connect() {
        if (this.koneksi == null) {
            this.koneksi = KONEKSI.WIFI;
        }
    }

    @Override
    public void disconnect() {
        this.koneksi = null;
    }

    @Override
    public String getDeviceDetails() {
        String koneksiStr = (koneksi != null) ? koneksi.name() : "Tidak Terhubung";
        return String.format("Smart TV [%s] (ID: %s) - Daya: %.1fW | Status: %s | Koneksi: %s | Channel: %d | Volume: %d",
                getNama(), getId(), getDaya(), status, koneksiStr, channel, volume);
    }
}
