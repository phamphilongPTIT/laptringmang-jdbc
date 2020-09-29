package view;

import model.Department;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DepartmentView {
    Scanner scan;

    public DepartmentView() {
        scan = new Scanner(System.in);
    }

    public void showMessage(String smg) {
        System.out.println("-----------");
        System.out.println(smg);
        System.out.println("-----------");
    }

    public int menu(){
        System.out.println("1. Hien thi tat ca department");
        System.out.println("2. Hien thi department theo ten");
        System.out.println("3. Them department");
        System.out.println("4. Sua department");
        int choice = 0;
        choice = scan.nextInt();
        return choice;
    }

    public Department input(int choice){
        switch (choice) {
            case 2:
                BufferedReader scan2 = new BufferedReader(new InputStreamReader(System.in));
                Department department = new Department();
                System.out.println("Nhap bo phan can tim: ");
                String str;
                try {
                    str = scan2.readLine();
                    department.setDeptName(str);
                    return department;
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            case 3:

                try {
                    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

                    Department insertD = new Department();
                    System.out.println("Them moi Department");

                    System.out.print("DepartmentID: ");
                    insertD.setDeptId(Integer.parseInt(scan.readLine()));

                    System.out.println("DepartmentName: ");
                    insertD.setDeptName(scan.readLine());

                    System.out.println("DepartmentNo:");
                    insertD.setDeptNo(scan.readLine());

                    System.out.println("Location");
                    insertD.setLocation(scan.readLine());

                    return insertD;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return null;

                }

            case 4:
                try {
                    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

                    Department insertD = new Department();
                    System.out.println("Sua department");

                    System.out.print("DepartmentID: ");
                    insertD.setDeptId(Integer.parseInt(scan.readLine()));

                    System.out.println("DepartmentName: ");
                    insertD.setDeptName(scan.readLine());

                    System.out.println("DepartmentNo:");
                    insertD.setDeptNo(scan.readLine());

                    System.out.println("Location");
                    insertD.setLocation(scan.readLine());
                    return insertD;
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
