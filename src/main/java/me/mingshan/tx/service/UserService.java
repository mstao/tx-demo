package me.mingshan.tx.service;

import me.mingshan.tx.model.User;

/**
 * @author 明山
 */
public interface UserService {

    Long insert(User user);

    User selectById(Long id);

    Integer update(User user);
}
