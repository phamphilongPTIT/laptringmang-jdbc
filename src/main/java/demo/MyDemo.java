package demo;

import controller.EmployeeControl;
import controller.EmployeeManagementControl;
import view.EmployeeManagementView;
import view.EmployeeView;

public class MyDemo {
    public static void main(String[] args) {
        EmployeeManagementView v = new EmployeeManagementView();
        EmployeeManagementControl control = new EmployeeManagementControl(v);
        control.run();
        control.exit();
    }
}
