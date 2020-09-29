package controller;

import controller.dao.DAOEmployee;
import controller.dao.DAOTimeKeeper;
import controller.utils.ConnectionUtils;
import model.Employee;
import model.Timekeeper;
import view.EmployeeView;
import view.TimeKeeperView;

import java.sql.SQLException;

public class TimeKeeperControl {
    TimeKeeperView view;
    DAOTimeKeeper dao;
  Timekeeper[] timekeepers;
    public TimeKeeperControl(TimeKeeperView view) {
        try {
            dao = new DAOTimeKeeper(ConnectionUtils.getMyConnection());
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
                    timekeepers=this.displayAll();
                    if(!timekeepers.equals(null)){
                        for (int i = 0; i < timekeepers.length; i++) {
                            this.view.showMessage(timekeepers[i].toString());
                        }
                    }
                    break;

                case 2:
                    Timekeeper e = (Timekeeper) this.view.input(2);
                    timekeepers=this.displayByName(e.getIn_Out());
                    if(!timekeepers.equals(null)){
                        for (int i = 0; i < timekeepers.length; i++) {
                            this.view.showMessage(timekeepers[i].toString());
                        }
                    }
                    break;
                case 3:
                    Timekeeper insertE = (Timekeeper) this.view.input(3);
                    int rowCout = this.dao.insert(insertE);
                    this.view.showMessage(rowCout+ " row has been inserted");
                    break;
                case 4:
                    Timekeeper upT = (Timekeeper) this.view.input(4);
                    int updateCount = this.dao.update(upT);
                    this.view.showMessage(updateCount+ " row has been inserted");
                    break;
                default:
                    break;
            }
        } while (choice!=0);
    }

    private Timekeeper[] displayAll(){
        return this.dao.selectAll();
    }
    private Timekeeper[] displayByName(String in_out){
        return this.dao.selectByName(in_out);
    }
    public void exit(){
        this.dao.closeConnection();
        this.view.exit();
    }
}
