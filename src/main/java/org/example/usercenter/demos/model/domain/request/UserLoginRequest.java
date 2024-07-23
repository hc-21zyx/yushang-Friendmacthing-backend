package org.example.usercenter.demos.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author yupi
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 319124171637120793L;

    private String userAccount;

    private String userPassword;

}