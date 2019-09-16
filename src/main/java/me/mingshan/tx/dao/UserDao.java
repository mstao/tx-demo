package me.mingshan.tx.dao;

import me.mingshan.tx.model.User;

/**
 * @author 明山
 */
public interface UserDao {

    Long insert(User user);

    User selectById(Long id);

    User selectByName(String name);

    Integer update(User note);
}
