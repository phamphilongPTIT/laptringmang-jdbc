package controller.dao;

import model.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class DAODepartment extends IDAO<Department>{

    public DAODepartment(Connection conn) {
        this.conn = conn;
        try {
            this.statement = this.conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department[] selectAll() {
        Vector<Department> departments = new Vector<>();
        Department[] result;
        try {
            String sql = "Select * from Department";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                Department d = new Department(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                departments.add(d);

                i++;
            }
            result = new Department[i];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return departments.toArray(result);
    }

    @Override
    public Department[] selectByName(String name) {
        Vector<Department> departments = new Vector<>();
        Department[] result;
        try {
            String sql = "Select * from Department where DEPT_NAME='" + name +"'";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                Department d = new Department(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                departments.add(d);

                i++;
            }
            result = new Department[i];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return departments.toArray(result);
    }

    @Override
    public int insert(Department object) {
        String sql = "INSERT INTO DEPARTMENT VALUES (?,?,?,?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, object.getDeptId());
            this.preStatement.setString(2, object.getDeptName());
            this.preStatement.setString(3, object.getDeptNo());
            this.preStatement.setString(4, object.getLocation());
            int rowCount=this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;

        }
    }

    @Override
    public int update(Department object) {
        String sql = "UPDATE DEPARTMENT SET DEPT_NAME = ?, DEPT_NO = ?, LOCATION = ? WHERE DEPT_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, object.getDeptName());
            this.preStatement.setString(2, object.getDeptNo());
            this.preStatement.setString(3, object.getLocation());
            this.preStatement.setInt(4, object.getDeptId());

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
