package org.example.usercenter.demos.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.example.usercenter.demos.model.domain.User;
import org.example.usercenter.demos.model.domain.request.UserLoginRequest;
import org.example.usercenter.demos.model.domain.request.UserRegisterRequest;
import org.example.usercenter.demos.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.usercenter.demos.contant.UserConstant.ADMIN_ROLE;
import static org.example.usercenter.demos.contant.UserConstant.USER_LOGIN_STATE;

@RestController
@RequestMapping("user/")

public class UserController {
     @Resource
     private UserService userService;

     @PostMapping("/register")
     public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }

        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();

        if (StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)) {
            return null;
        }
        return userService.userRegister(userAccount,userPassword,checkPassword);
     }

     @PostMapping("/login")
     public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }

        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        //System.out.println(userAccount + userPassword);
        if (StringUtils.isAnyBlank(userAccount,userPassword)) {
            return null;
        }

        return userService.userLogin(userAccount,userPassword,request);
    }

    @PostMapping("/logout")
    public Integer userLogout(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return userService.userLogout(request);
    }

    @GetMapping("/search")
    public List<User> searchUsers(String username,HttpServletRequest request) {
        if (!isAdmin(request)) {
            return new ArrayList<>();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("username",username);
        }

        List<User> userlist = userService.list(queryWrapper);
        return userlist.stream().map(user ->
          userService.getSafetyUser(user)
        ).collect(Collectors.toList());
    }

    @GetMapping("/current")
    public User getCurrentUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null) {
            return null;
        }
        long userId = currentUser.getId();
        //校验用户是否合法
        User user = userService.getById(userId);
        return userService.getSafetyUser(user);
    }

    @PostMapping("/delete")
    public boolean deleteUser(@RequestBody long id,HttpServletRequest request) {
        if (!isAdmin(request)) {
            return false;
        }
        if (id <= 0) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     *
     * @param request 是否为管理员
     * @return
     */
    private boolean isAdmin(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        if (user == null || user.getUserRole() != ADMIN_ROLE) {
            return false;
        }
        return true;
    }
}
