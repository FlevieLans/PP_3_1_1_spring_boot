package app.pp_3_1_1_spring_boot.dao;

import app.pp_3_1_1_spring_boot.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

}
