package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findAllWithDetail();
    User findById(Long id);
    User findByUsername(String userName);
    List<User> findByUserNameSimilarTo(String userName);
    User save(User user);
    void delete(User user);
    void delete(Long id);
}
