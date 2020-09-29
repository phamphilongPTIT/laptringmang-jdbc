package view;

import model.SalaryGrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SalaryGradeView {
    Scanner scan;
    public SalaryGradeView() {
        scan = new Scanner(System.in);
    }
    public void showMessage(String smg) {
        System.out.println("-----------");
        System.out.println(smg);
        System.out.println("-----------");
    }

    public int menu(){
        System.out.println("1. Hien thi tat ca bac luong");
        System.out.println("2. Them bac luong");
        System.out.println("3. Sua bac luong");
        int choice = 0;
        choice = scan.nextInt();
        return choice;
    }
    public SalaryGrade input(int choice){
        switch (choice) {
            case 2:

                try {
                    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

                    SalaryGrade insertE = new SalaryGrade();
                    System.out.println("Them moi Bac luong");

                    System.out.print("Grade: ");
                    insertE.setGrade(Integer.parseInt(scan.readLine()));

                    System.out.println("High Salary: ");
                    insertE.setHighSalary(Float.parseFloat(scan.readLine()));

                    System.out.println("Low Salary:");
                    insertE.setLowSalary(Float.parseFloat(scan.readLine()));

                    return insertE;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return null;

                }

            case 3:
                try {
                    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

                    SalaryGrade insertE = new SalaryGrade();
                    System.out.println("Sua Bac luong");

                    System.out.print("Grade: ");
                    insertE.setGrade(Integer.parseInt(scan.readLine()));

                    System.out.println("High Salary: ");
                    insertE.setHighSalary(Float.parseFloat(scan.readLine()));

                    System.out.println("Low Salary:");
                    insertE.setLowSalary(Float.parseFloat(scan.readLine()));
                    return insertE;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return null;

                }
            default:
                break;
        }
        return null;
    }
    public void exit(){
        this.scan.close();
    }
}
