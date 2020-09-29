package demo;


import controller.EmployeeControl;
import controller.SalaryGradeControl;
import model.SalaryGrade;
import view.EmployeeView;
import view.SalaryGradeView;

public class TestMVC {
	public static void main(String[] args) {
		//Lấy ra đối tượng Connection kết nối vào DB.
		EmployeeView v = new EmployeeView();
		EmployeeControl control = new EmployeeControl(v);
	}
}
