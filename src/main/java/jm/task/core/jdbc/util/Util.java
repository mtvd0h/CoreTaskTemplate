package jm.task.core.jdbc.util;

import java.sql.*;

public final class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class<Driver> driverClass = Driver.class;
        return DriverManager.getConnection(URL, USERNAME, PASS);
    }
    private Util(){

    }

}
