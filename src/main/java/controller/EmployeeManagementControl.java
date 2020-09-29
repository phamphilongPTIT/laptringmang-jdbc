package controller;

import view.EmployeeManagementView;
import view.EmployeeView;

public class EmployeeManagementControl {
    EmployeeManagementView view;

    public EmployeeManagementControl (EmployeeManagementView view) {
        this.view = view;
    }

    public void run(){
        int choice = -1;
        do {
            choice = view.menu();
            switch (choice) {
                case 1:
                    EmployeeView v = new EmployeeView();
                    EmployeeControl control = new EmployeeControl(v);
                    control.run();
                    control.exit();
                    break;
                case 2:
//                    Employee e = this.view.input(2);
//                    emlopyees=this.displayByName(e.getEmpName());
//                    if(!emlopyees.equals(null)){
//                        for (int i = 0; i < emlopyees.length; i++) {
//                            this.view.showMessage(emlopyees[i].toString());
//                        }
//                    }
                    break;
                case 3:
//                    Employee insertE = this.view.input(3);
//                    int rowCout = this.dao.insert(insertE);
//                    this.view.showMessage(rowCout+ " row has been inserted");
                    break;
                case 4:
//                    Employee upE = this.view.input(4);
//                    int updateCount = this.dao.update(upE);
//                    this.view.showMessage(updateCount+ " row has been inserted");
                    break;
                default:
                    break;
            }
        } while (choice!=0);
    }

    public void exit(){
        this.view.exit();
    }
}
