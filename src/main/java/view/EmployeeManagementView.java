package view;

import java.util.Scanner;

public class EmployeeManagementView {
    Scanner scan;

    public EmployeeManagementView() {
        scan = new Scanner(System.in);
    }

    public void showMessage(String smg) {
        System.out.println("-----------");
        System.out.println(smg);
        System.out.println("-----------");
    }

    public int menu() {
        System.out.println("1. Quan ly thong tin nhan vien");
        System.out.println("2. Quan ly thong tin phong ban");
        System.out.println("3. Quan ly thong tin cham cong");
        int choice = 0;
        choice = scan.nextInt();
        return choice;
    }

    public void exit() {
        this.scan.close();
    }
}
