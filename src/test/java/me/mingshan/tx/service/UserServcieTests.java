package me.mingshan.tx.service;

import me.mingshan.tx.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServcieTests {

    @Autowired
    private UserService userService;

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("Walker3");
        user.setAge(20);
        userService.insert(user);
    }

    @Test
    public void updateTest() {
        int count = 10;
        ExecutorService executor = Executors.newFixedThreadPool(count);

        AtomicInteger CR = new AtomicInteger(1);

        for (int i = 0; i < count; i++) {
            Future<Integer> future = executor.submit(() -> {
                User user = new User();
                user.setName("Walker");
                user.setAge(CR.getAndIncrement());
                return userService.update(user);
            });

            try {
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
