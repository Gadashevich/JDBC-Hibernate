import dao.UserDaoJDBCImpl;
import model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.dropUsersTable();
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
    }

}
