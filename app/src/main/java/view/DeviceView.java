package view;

import model.SmartDevice;
import java.util.List;

public class DeviceView {

    public void showMainMenu() {
        System.out.println("\n=== MENU UTAMA SMART HOME ===");
        System.out.println("1. Tambah Perangkat");
        System.out.println("2. Print Semua Perangkat");
        System.out.println("3. Keluar");
    }

    public void showSubMenu() {
        System.out.println("\n--- TAMBAH PERANGKAT ---");
        System.out.println("1. Smart TV");
        System.out.println("2. Smart Speaker");
        System.out.println("3. Smart Door Lock");
    }

    public void printDeviceList(List<SmartDevice> devices) {
        System.out.println("\n=== DAFTAR PERANGKAT SMART HOME ===");
        if (devices.isEmpty()) {
            System.out.println("Belum ada perangkat yang terdaftar.");
            return;
        }

        for (SmartDevice device : devices) {
            System.out.println("• " + device.getDeviceDetails());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}