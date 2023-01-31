package util;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Util {
    static final String URL = "jdbc:mysql://localhost:3306/test";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static SessionFactory sessionFactory;

    public static Connection getJDBCConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            System.out.println("Соединение успешно открыто");
        } catch (SQLException e) {
            System.out.println("Произошла ошибка соединения, соединение не установлено");
            throw new RuntimeException();
        }

        return connection;
    }

    public static SessionFactory getHibernateConnection() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL,URL);
                properties.put(Environment.USER,USERNAME);
                properties.put(Environment.PASS,PASSWORD);
                properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.SHOW_SQL,"true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO,"create-drop");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactory;

    }

}
