package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        try {

            userService.saveUser("Agatha", "Stone", (byte) 45);
            userService.saveUser("Nikita", "Petrusenko", (byte) 26);
            userService.saveUser("Tregul", "Zaurov", (byte) 30);
            userService.saveUser("Neil", "Alishev", (byte) 29);

        } catch (Exception e) {
            e.printStackTrace();
        }
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeConnection();
    }
}
