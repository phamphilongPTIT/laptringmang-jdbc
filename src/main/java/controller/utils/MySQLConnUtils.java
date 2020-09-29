package controller.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
 
 // Kết nối vào MySQL.
 public static Connection getMySQLConnection() throws SQLException,
         ClassNotFoundException {
     String hostName = "127.0.0.1";
 
     String dbName = "contactdb";
     String userName = "root";
     String password = "sandstorm";
     return getMySQLConnection(hostName, dbName, userName, password);
 }
 
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
     // Khai báo class Driver cho DB MySQL
     // Việc này cần thiết với Java 5
     // Java6 tự động tìm kiếm Driver thích hợp.
     // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
     //Class.forName("com.mysql.jdbc.Driver");
 
     // Cấu trúc URL Connection dành cho Oracle
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}
