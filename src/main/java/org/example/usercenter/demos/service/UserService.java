package org.example.usercenter.demos.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.usercenter.demos.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rainsXZ
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2024-07-10 13:30:50
 */
public interface UserService extends IService<User> {
//    /**
//     *
//     */
//    String USER_LOGIN_STATE = "userLoginState";
    /**
     * @param userAccount   用户账户
     * @param userPassword  密码
     * @param checkPassword 验证密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     *
     * @param userAccount 登录账户
     * @param userPassword 登录密码
     * @return 登录状态
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    User getSafetyUser(User orginUser);

    int userLogout(HttpServletRequest request);
}
