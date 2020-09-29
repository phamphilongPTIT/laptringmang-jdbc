package demo;

import controller.EmployeeControl;
import controller.TimeKeeperControl;
import view.EmployeeView;
import view.TimeKeeperView;

public class TestMVCTimeKeeper {
    public static void main(String[] args) {
        // Lấy ra đối tượng Connection kết nối vào DB.
        TimeKeeperView v = new TimeKeeperView();
        TimeKeeperControl control = new TimeKeeperControl(v);
        control.run();
        control.exit();
    }
}
