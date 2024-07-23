package org.example.usercenter.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.usercenter.demos.model.domain.User;

/**
* @author rainsXZ
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2024-07-10 13:30:50
* @Entity generator.domain.user
*/

@Mapper
public interface UserMapper extends BaseMapper<User> {

}




