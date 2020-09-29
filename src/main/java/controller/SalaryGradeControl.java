package controller;

import controller.dao.DAOSalaryGrade;
import controller.utils.ConnectionUtils;
import model.SalaryGrade;
import view.SalaryGradeView;

import java.sql.SQLException;

public class SalaryGradeControl {
    SalaryGradeView view;
    DAOSalaryGrade dao;
    SalaryGrade[] salaryGrades;
    public SalaryGradeControl(SalaryGradeView view) {
        try {
            dao = new DAOSalaryGrade(ConnectionUtils.getMyConnection());
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
                    salaryGrades =this.displayAll();
                    if(!salaryGrades.equals(null)){
                        for (int i = 0; i < salaryGrades.length; i++) {
                            this.view.showMessage(salaryGrades[i].toString());
                        }
                    }
                    break;

//                case 2:
//                    SalaryGrade e = this.view.input(2);
//                    salaryGrades =this.displayByName(e.getGrade());
//                    if(!salaryGrades.equals(null)){
//                        for (int i = 0; i < salaryGrades.length; i++) {
//                            this.view.showMessage(salaryGrades[i].toString());
//                        }
//                    }
//                    break;
                case 2:
                    SalaryGrade insertE = this.view.input(2);
                    int rowCout = this.dao.insert(insertE);
                    this.view.showMessage(rowCout+ " row has been inserted");
                    break;
                case 3:
                    SalaryGrade upE = this.view.input(3);
                    int updateCount = this.dao.update(upE);
                    this.view.showMessage(updateCount+ " row has been inserted");
                    break;
                default:
                    break;
            }
        } while (choice!=0);
    }

    private SalaryGrade[] displayAll(){
        return this.dao.selectAll();
    }
    private SalaryGrade[] displayByName(String name){
        return this.dao.selectByName(name);
    }
    public void exit(){
        this.dao.closeConnection();
        this.view.exit();
    }
}
