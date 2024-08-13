package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;

public final class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASS = "root";
    private static Properties props;

    static {
        props = new Properties();
        props.put("hibernate.driver_class","org.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", URL);
        props.put("hibernate.connection.username",USERNAME);
        props.put("hibernate.connection.password",PASS);

        props.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        props.put("hibernate.show_sql","true");
        props.put("hibernate.current_session_context_class","thread");
    }

    private Util(){

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class<Driver> driverClass = Driver.class;
        return DriverManager.getConnection(URL, USERNAME, PASS);
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        Configuration config =new Configuration();
        return config.setProperties(props)
               .addAnnotatedClass(User.class).buildSessionFactory();
    }
}
