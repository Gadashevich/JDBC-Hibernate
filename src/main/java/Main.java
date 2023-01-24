import dao.UserDaoJDBCImpl;

public class Main {

    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
    }

}
