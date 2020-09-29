package controller;

import controller.dao.DAODepartment;
import controller.utils.ConnectionUtils;
import model.Department;
import view.DepartmentView;

import java.sql.SQLException;
import java.util.Objects;

public class DepartmentControl {
    DepartmentView view;
    DAODepartment dao;
    Department[] departments;

    public DepartmentControl(DepartmentView view) {
        try {
            dao = new DAODepartment(ConnectionUtils.getMyConnection());
            this.view = view;

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.dao.closeConnection();
            System.exit(0);
        }
    }

    public void run(){
        int choice = -1;
        do {
            choice = view.menu();
            switch (choice) {
                case 1:
                    departments = this.displayAll();
                    if(Objects.nonNull(departments)){
                        for (Department department : departments) {
                            this.view.showMessage(department.toString());
                        }
                    }
                    break;

                case 2:
                    Department d = this.view.input(2);
                    departments = this.displayByName(d.getDeptName());
                    if(Objects.nonNull(departments)){
                        for (Department department : departments) {
                            this.view.showMessage(department.toString());
                        }
                    }
                    break;
                case 3:
                    Department insertD = this.view.input(3);
                    int rowCout = this.dao.insert(insertD);
                    this.view.showMessage(rowCout+ " row has been inserted");
                    break;
                case 4:
                    Department upD = this.view.input(4);
                    int updateCount = this.dao.update(upD);
                    this.view.showMessage(updateCount+ " row has been inserted");
                    break;
                case 5:
                    Department deleteD = this.view.input(5);
                    int deleteCount = this.dao.delete(deleteD);
                    this.view.showMessage(deleteCount+ " row has been deleted");
                    break;
                default:
                    break;
            }
        } while (choice!=0);
    }

    private Department[] displayAll(){
        return this.dao.selectAll();
    }
    private Department[] displayByName(String name){
        return this.dao.selectByName(name);
    }
    public void exit(){
        this.dao.closeConnection();
        this.view.exit();
    }
}
