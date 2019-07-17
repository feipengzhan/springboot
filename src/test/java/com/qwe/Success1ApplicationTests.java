package com.qwe;

import com.qwe.pojo.User;
import com.qwe.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Success1Application.class)
public class Success1ApplicationTests {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        List<User> allUser = userService.getAllUser();
        System.out.println(allUser);
    }

}
