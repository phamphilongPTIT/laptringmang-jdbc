package view;

import model.Employee;
import model.Timekeeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TimeKeeperView {
    Scanner scan;
    public TimeKeeperView() {
        scan = new Scanner(System.in);
    }
    public void showMessage(String smg) {
        System.out.println("-----------");
        System.out.println(smg);
        System.out.println("-----------");
    }

    public int menu(){
        System.out.println("1. Hien thi tat ca timekeeper");
        System.out.println("2. Hien thi timekeeper theo ten");
        System.out.println("3. Them timekeeper");
        System.out.println("4. Sua timekeeper");
        int choice = 0;
        choice = scan.nextInt();
        return choice;
    }
    public Serializable input(int choice){
        switch (choice) {
            case 2:
                BufferedReader scan2 = new BufferedReader(new InputStreamReader(System.in));
                Timekeeper timekeeper= new Timekeeper();
                System.out.println("Nhap trang thai in out can tim: ");
                String str;
                try {
                    str = scan2.readLine();
                    timekeeper.setIn_Out(str);
                    return timekeeper;
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            case 3:

                try {
                    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

                    Employee insertE = new Employee();
                    System.out.println("Them moi employee");

                    System.out.print("EmpID: ");
                    insertE.setEmpId(Integer.parseInt(scan.readLine()));

                    System.out.println("EmpName: ");
                    insertE.setEmpName(scan.readLine());

                    System.out.println("EmpNo:");
                    insertE.setEmpNo(scan.readLine());

                    System.out.println("HireDate (dd/mm/yyyy)");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                    insertE.setHireDate(formatter.parse(scan.readLine()));

                    System.out.println("Job");
                    insertE.setJob(scan.readLine());

                    System.out.println("Salary");
                    insertE.setSalary(Float.parseFloat(scan.readLine()));

                    System.out.println("Dept_Id");
                    insertE.setDeptId(Integer.parseInt(scan.readLine()));

                    System.out.println("Mng_id");
                    insertE.setMngId(BigInteger.valueOf((Long.parseLong(scan.readLine()))));
                    return insertE;
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    return null;

                }

            case 4:
                try {
                    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

                    Employee insertE = new Employee();
                    System.out.println("Sua employee");

                    System.out.print("EmpID: ");
                    insertE.setEmpId(Integer.parseInt(scan.readLine()));

                    System.out.println("EmpName: ");
                    insertE.setEmpName(scan.readLine());

                    System.out.println("EmpNo:");
                    insertE.setEmpNo(scan.readLine());

                    System.out.println("HireDate (dd/mm/yyyy)");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                    insertE.setHireDate(formatter.parse(scan.readLine()));

                    System.out.println("Job");
                    insertE.setJob(scan.readLine());

                    System.out.println("Salary");
                    insertE.setSalary(Float.parseFloat(scan.readLine()));

                    System.out.println("Dept_Id");
                    insertE.setDeptId(Integer.parseInt(scan.readLine()));

                    System.out.println("Mng_id");
                    insertE.setMngId(BigInteger.valueOf((Long.parseLong(scan.readLine()))));
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
