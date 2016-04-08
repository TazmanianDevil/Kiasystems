package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.User;

import java.util.List;

public interface UserEJBRemote {
    String getName();
    List<User> getAllUsers();
    void addUser(User user);
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(User user);
}
