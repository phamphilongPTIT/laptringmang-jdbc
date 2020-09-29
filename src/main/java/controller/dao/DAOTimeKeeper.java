package controller.dao;

import model.Employee;
import model.Timekeeper;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class DAOTimeKeeper extends IDAO<Timekeeper> {
    public DAOTimeKeeper(Connection conn) {
        this.conn = conn;
        try {
            this.statement = this.conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Timekeeper[] selectAll() {
        Vector<Timekeeper> ee = new Vector<Timekeeper>();
        Timekeeper[] result;
        try {
            String sql = "Select * from timekeeper";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
               Timekeeper e = new Timekeeper(
                                       rs.getString(1),
                                       rs.getDate(2),
                       BigInteger.valueOf(rs.getInt(4)),
                       rs.getString(3));
                ee.add(e);

                i++;
            }
            result = new Timekeeper[i];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return ee.toArray(result);
    }

    @Override
    public Timekeeper[] selectByName(String in_out) {
        Vector<Timekeeper> ee = new Vector<Timekeeper>();
        Timekeeper[] result = new Timekeeper[10000];
        try {
            String sql = "Select * from Timekeeper where In_Out='" + in_out+"'" ;

            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Timekeeper e = new Timekeeper(
                                        rs.getString(1),
                                        rs.getDate(2),
                        BigInteger.valueOf(rs.getInt(4)),
                        rs.getString(3));

                ee.add(e);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return (Timekeeper[]) ee.toArray();
    }

    @Override
    public int insert(Timekeeper e) {
        String sql = "INSERT INTO TIMEKEEPER (TIMEKEEPER_ID,"+
                "DATE_TIME,"+
                "IN_OUT,"+
                "EMP_ID"+
                "VALUES (?,?,?,?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, e.getTimekeeper_Id());
            this.preStatement.setDate(2, new java.sql.Date(e.getDate_Time().getTime()));
            this.preStatement.setString(3, e.getIn_Out());
            this.preStatement.setLong(4, e.getEmpId().longValue());
            int rowCount=this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;

        }

    }

    @Override
    public int update(Timekeeper e) {
        String sql = "UPDATE TIMEKEEPER set "+
                "DATE_TIME = ?,"+
                "IN_OUT = ?,"+
                "EMP_ID= ? "+
                "Where TIMEKEEPER_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setDate(1, new java.sql.Date(e.getDate_Time().getTime()));
            this.preStatement.setString(2, e.getIn_Out());
            this.preStatement.setLong(3, e.getEmpId().longValue());
                    this.preStatement.setString(4, e.getTimekeeper_Id());


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
