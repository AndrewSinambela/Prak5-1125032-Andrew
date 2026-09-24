package view;

import model.SmartDevice;
import java.util.List;
import java.util.Scanner;

public class DeviceView {
    private final Scanner scanner = new Scanner(System.in);

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

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat!");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka desimal!");
            }
        }
    }
}