package org.example.yupao.demos.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.yupao.demos.model.domain.Team;
import org.example.yupao.demos.model.domain.User;

/**
 * 队伍服务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public interface TeamService extends IService<Team> {
    long addTeam(Team team, User loginuser);
}
