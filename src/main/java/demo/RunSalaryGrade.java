package demo;

import controller.SalaryGradeControl;
import model.SalaryGrade;
import view.SalaryGradeView;

public class RunSalaryGrade {
    public static void main(String[] args) {
        SalaryGradeView salaryGradeView=new SalaryGradeView();
        SalaryGradeControl control=new SalaryGradeControl(salaryGradeView);
        control.run();
        control.exit();
    }
}
