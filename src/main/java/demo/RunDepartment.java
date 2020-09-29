package demo;

import controller.DepartmentControl;
import view.DepartmentView;

public class RunDepartment {
    public static void main(String[] args) {
        DepartmentView v = new DepartmentView();
        DepartmentControl control = new DepartmentControl(v);
        control.run();
        control.exit();
    }
}
