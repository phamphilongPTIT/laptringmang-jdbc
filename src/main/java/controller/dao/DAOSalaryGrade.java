package controller.dao;

import model.SalaryGrade;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class DAOSalaryGrade extends IDAO<SalaryGrade> {
    public DAOSalaryGrade(Connection conn) {
        this.conn = conn;
        try {
            this.statement = this.conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public SalaryGrade[] selectAll() {
        Vector<SalaryGrade> ee = new Vector<SalaryGrade>();
        SalaryGrade[] result;
        try {
            String sql = "Select * from salary_grade";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                SalaryGrade e = new SalaryGrade(
                        rs.getInt(1),
                        rs.getFloat(2),
                        rs.getFloat(3));
                ee.add(e);

                i++;
            }
            result = new SalaryGrade[i];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return ee.toArray(result);
    }

    @Override
    public SalaryGrade[] selectByName(String name) {
        return new SalaryGrade[0];
    }

//    @Override
//    public Employee[] selectByName(String name) {
//        Vector<Employee> ee = new Vector<Employee>();
//        Employee[] result;
//        try {
//            String sql = "Select * from Employee where Emp_Name='" + name+"'" ;
//
//            rs = statement.executeQuery(sql);
//            int i = 0;
//            while (rs.next()) {
//                Employee e = new Employee(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getDate(4),
//                        rs.getBytes(5),
//                        rs.getString(6),
//                        rs.getFloat(7),
//                        rs.getInt(8),
//                        BigInteger.valueOf(rs.getInt(9)));
//                ee.add(e);
//
//                i++;
//            }
//            result = new Employee[i];
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//
//        return ee.toArray(result);
//    }

    @Override
    public int insert(SalaryGrade e) {
        String sql = "INSERT INTO `contactdb`.`salary_grade` (`GRADE`, `HIGH_SALARY`, `LOW_SALARY`) VALUES (?,?,?);";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, e.getGrade());
            this.preStatement.setFloat(2, e.getHighSalary());
            this.preStatement.setFloat(3, e.getLowSalary());

            int rowCount=this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;

        }

    }

    @Override
    public int update(SalaryGrade e) {
        String sql = "UPDATE `contactdb`.`salary_grade` SET `HIGH_SALARY` = ?, `LOW_SALARY` = ? WHERE (`GRADE` = ?);";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setFloat(1, e.getHighSalary());
            this.preStatement.setFloat(2, e.getLowSalary());
            this.preStatement.setInt(3, e.getGrade());
            int rowCount=this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;

        }
    }

    @Override
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
