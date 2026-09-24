package controller;

import model.*;
import view.DeviceView;
import view.InputUtil;
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
            int pilihan = InputUtil.readInt("Pilih menu: ");

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
        int subPilihan = InputUtil.readInt("Pilih tipe perangkat: ");

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
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double daya = InputUtil.readDouble("Masukkan Daya (W): ");
        int channel = InputUtil.readInt("Masukkan Channel: ");
        int volume = InputUtil.readInt("Masukkan Volume: ");

        String connInput = InputUtil.readString("Pilih Koneksi (WIFI/BLUETOOTH): ");
        KONEKSI koneksi = connInput.equalsIgnoreCase("BLUETOOTH") ? KONEKSI.BLUETOOTH : KONEKSI.WIFI;

        SmartTV tv = new SmartTV(id, nama, daya, channel, volume, koneksi);

        String st = InputUtil.readString("Nyalakan perangkat sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            tv.turnOn();
        } else {
            tv.turnOf();
        }

        listDevice.add(tv);
        view.showMessage("Smart TV berhasil ditambahkan!");
    }

    private void tambahSmartSpeaker() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double daya = InputUtil.readDouble("Masukkan Daya (W): ");
        int volume = InputUtil.readInt("Masukkan Volume: ");

        String connInput = InputUtil.readString("Pilih Koneksi (WIFI/BLUETOOTH): ");
        KONEKSI koneksi = connInput.equalsIgnoreCase("WIFI") ? KONEKSI.WIFI : KONEKSI.BLUETOOTH;

        SmartSpeaker speaker = new SmartSpeaker(id, nama, daya, volume, koneksi);

        String st = InputUtil.readString("Nyalakan perangkat sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            speaker.turnOn();
        } else {
            speaker.turnOf();
        }

        listDevice.add(speaker);
        view.showMessage("Smart Speaker berhasil ditambahkan!");
    }

    private void tambahSmartDoorLock() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double daya = InputUtil.readDouble("Masukkan Daya (W): ");
        String pin = InputUtil.readString("Masukkan PIN asli: ");

        SmartDoorLock lock = new SmartDoorLock(id, nama, daya, pin);

        String st = InputUtil.readString("Kunci pintu sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            lock.lock();
        } else {
            lock.unlock();
        }

        listDevice.add(lock);
        view.showMessage("Smart Door Lock berhasil ditambahkan!");
    }
}