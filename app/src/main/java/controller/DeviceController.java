package controller;

import model.*;
import view.DeviceView;
import java.util.ArrayList;
import java.util.List;

public class DeviceController {
    private final List<SmartDevice> listDevice;
    private final DeviceView view;

    public DeviceController(DeviceView view) {
        this.listDevice = new ArrayList<>();
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMainMenu();
            int pilihan = view.readInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahPerangkatFlow();
                    break;
                case 2:
                    view.printDeviceList(listDevice);
                    break;
                case 3:
                    running = false;
                    view.showMessage("Terima kasih telah menggunakan sistem Smart Home.");
                    break;
                default:
                    view.showMessage("Pilihan tidak valid!");
            }
        }
    }

    private void tambahPerangkatFlow() {
        view.showSubMenu();
        int subPilihan = view.readInt("Pilih tipe perangkat: ");

        switch (subPilihan) {
            case 1:
                tambahSmartTV();
                break;
            case 2:
                tambahSmartSpeaker();
                break;
            case 3:
                tambahSmartDoorLock();
                break;
            default:
                view.showMessage("Tipe perangkat tidak ditemukan!");
        }
    }

    private void tambahSmartTV() {
        String id = view.readString("Masukkan ID: ");
        String nama = view.readString("Masukkan Nama: ");
        double daya = view.readDouble("Masukkan Daya (W): ");
        int channel = view.readInt("Masukkan Channel: ");
        int volume = view.readInt("Masukkan Volume: ");

        String connInput = view.readString("Pilih Koneksi (WIFI/BLUETOOTH): ");
        KONEKSI koneksi = connInput.equalsIgnoreCase("BLUETOOTH") ? KONEKSI.BLUETOOTH : KONEKSI.WIFI;

        SmartTV tv = new SmartTV(id, nama, daya, channel, volume, koneksi);

        String st = view.readString("Nyalakan perangkat sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            tv.turnOn();
        } else {
            tv.turnOf();
        }

        listDevice.add(tv);
        view.showMessage("Smart TV berhasil ditambahkan!");
    }

    private void tambahSmartSpeaker() {
        String id = view.readString("Masukkan ID: ");
        String nama = view.readString("Masukkan Nama: ");
        double daya = view.readDouble("Masukkan Daya (W): ");
        int volume = view.readInt("Masukkan Volume: ");

        String connInput = view.readString("Pilih Koneksi (WIFI/BLUETOOTH): ");
        KONEKSI koneksi = connInput.equalsIgnoreCase("WIFI") ? KONEKSI.WIFI : KONEKSI.BLUETOOTH;

        SmartSpeaker speaker = new SmartSpeaker(id, nama, daya, volume, koneksi);

        String st = view.readString("Nyalakan perangkat sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            speaker.turnOn();
        } else {
            speaker.turnOf();
        }

        listDevice.add(speaker);
        view.showMessage("Smart Speaker berhasil ditambahkan!");
    }

    private void tambahSmartDoorLock() {
        String id = view.readString("Masukkan ID: ");
        String nama = view.readString("Masukkan Nama: ");
        double daya = view.readDouble("Masukkan Daya (W): ");
        String pin = view.readString("Masukkan PIN asli: ");

        SmartDoorLock lock = new SmartDoorLock(id, nama, daya, pin);

        String st = view.readString("Kunci pintu sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            lock.lock();
        } else {
            lock.unlock();
        }

        listDevice.add(lock);
        view.showMessage("Smart Door Lock berhasil ditambahkan!");
    }
}