package model;

public class SmartSpeaker extends SmartDevice implements Switchable, Connectable {
    private int volume;
    private String status;
    private KONEKSI koneksi;

    public SmartSpeaker(String id, String nama, double daya, int volume, KONEKSI koneksi) {
        super(id, nama, daya);
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
            this.koneksi = KONEKSI.BLUETOOTH;
        }
    }

    @Override
    public void disconnect() {
        this.koneksi = null;
    }

    @Override
    public String getDeviceDetails() {
        String koneksiStr = (koneksi != null) ? koneksi.name() : "Tidak Terhubung";
        return String.format("Smart Speaker [%s] (ID: %s) - Daya: %.1fW | Status: %s | Koneksi: %s | Volume: %d",
                getNama(), getId(), getDaya(), status, koneksiStr, volume);
    }
}
