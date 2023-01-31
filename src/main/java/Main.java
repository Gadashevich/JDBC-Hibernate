import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;
import model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        scriptHibernate();
    }

    private static void scriptJDBC() {
        UserDao userDao = new UserDaoJDBCImpl();
        // userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("IVAN","lastName",(byte)20);
        userDao.saveUser("PETR","PETROV",(byte)17);
        userDao.saveUser("DIMA","DIMA",(byte)23);
        userDao.saveUser("SEREJA","Serg",(byte)21);
        userDao.saveUser("Shrek","lolo",(byte)36);
        userDao.saveUser("ARTUR","King",(byte)57);
        List<User> allUsers = userDao.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }

    private static void scriptHibernate() {
        UserDao userDao = new UserDaoHibernateImpl();
        // userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("IVAN","lastName",(byte)20);
        userDao.saveUser("PETR","PETROV",(byte)17);
        userDao.saveUser("DIMA","DIMA",(byte)23);
        userDao.saveUser("SEREJA","Serg",(byte)21);
        userDao.saveUser("Shrek","lolo",(byte)36);
        userDao.saveUser("ARTUR","King",(byte)57);
        List<User> allUsers = userDao.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }




}
