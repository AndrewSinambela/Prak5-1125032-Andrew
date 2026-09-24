package view;
import controller.DeviceController;
import view.DeviceView;

public class Main {
    public static void main(String[] args) {
        DeviceView view = new DeviceView();
        DeviceController controller = new DeviceController(view);
        controller.start();
    }
}