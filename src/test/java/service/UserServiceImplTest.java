package service;

import model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private final UserService userService = new UserServiceImpl();

    private final String testName = "Ivan";
    private final String testLastName = "Ivanov";
    private final byte testAge = 20;

    @Test
    void createUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            fail("При тестировании создания таблицы произошла ошибка \n" + e.getMessage());
        }
    }

    @Test
    void dropUsersTable() {
        try {
            userService.dropUsersTable();
        } catch (Exception e) {
            fail("При тестировании удаления таблицы произошла ошибка\n" + e.getMessage());
        }

    }

    @Test
    void saveUser() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            User user = userService.getAllUsers().get(0);
            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()) {
                fail("Не корректно заполнены данные в базу");
            }

        } catch (Exception e) {
            fail("Ошибка при сохранении пользователя\n" + e.getMessage());
        }
    }

    @Test
    void removeUserById() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.removeUserById(1L);
        } catch (Exception e) {
            fail("Ошибка удаления пользователя по id\n" + e.getMessage());
        }
    }

    @Test
    void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            List<User> allUsers = userService.getAllUsers();
            if (allUsers.size() != 1) {
                fail("Не корректная работа создания пользователей");
            }

        } catch (Exception e) {
            fail("Ошибка получения списка пользователей\n" + e.getMessage());
        }
    }

    @Test
    void cleanUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.cleanUsersTable();
            if (userService.getAllUsers().size() != 0) {
                fail("Очистка не работает");
            }
        } catch (Exception e) {
            fail("Не корректная работа очистки пользователей в таблице\n" + e.getMessage());
        }
    }
}