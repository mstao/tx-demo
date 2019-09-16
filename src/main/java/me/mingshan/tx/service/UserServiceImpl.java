package me.mingshan.tx.service;

import lombok.extern.slf4j.Slf4j;
import me.mingshan.tx.dao.UserDao;
import me.mingshan.tx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Long insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    @Transactional
    @Override
    public Integer update(User user) {
        log.info("更新。。");

        log.info("获取用户 - 开始。。");
        User existUser = userDao.selectByName(user.getName());
        log.info(existUser.toString());
        log.info("获取用户 - 结束。。");

        if (existUser != null) {
            log.info("更新用户 - 开始。。");
            existUser.setAge(user.getAge());
            Integer update = userDao.update(existUser);
            log.info("更新用户 - 结束 - {}。。", update);
            if (update == 0)
                throw new RuntimeException("update = " + update);
            return update;
        }

        return 0;
    }
}
