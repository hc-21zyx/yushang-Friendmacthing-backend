package org.example.yupao.demos.service;

import org.example.yupao.demos.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void searchUsersByTags() {
        User user = new User();

        List<String> tagNameList = Arrays.asList("Java","python","C++","kun");
        List<User> userlist = userService.searchUsersByTags(tagNameList);
        Assert.assertNotNull(userlist);
    }
}
//    @Test
//    void userRegister() {
//        String userAccount = "yushang";
//        String userPassword = "";
//        String checkPassword = "123456";
//        String planetCode = "1";
//        long result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
//        Assertions.assertEquals(-1,result  );
//
//        userAccount = "yu";
//        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
//        Assertions.assertEquals(-1,result);
//
//        userAccount = "yupi";
//        userPassword = "123456";
//        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
//        Assertions.assertEquals(-1,result);
//
//        userAccount = "Yu pi";
//        userPassword = "12345678";
//        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
//        Assertions.assertEquals(-1,result);
//
//        checkPassword = "123456789";
//        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
//        Assertions.assertEquals(-1,result);
//
//        userAccount = "dogYupi";
//        checkPassword = "12345678";
//        Assertions.assertEquals(-1,result);
//        userAccount = "dogYupigggg";
//        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
//        Assertions.assertEquals(-1,result);
//    }