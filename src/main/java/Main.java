import dao.UserDaoJDBCImpl;

public class Main {

    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("IVAN","lastName",(byte)20);
    }

}
