package org.example.yupao.demos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.yupao.demos.mapper.TeamMapper;
import org.example.yupao.demos.model.domain.Team;
import org.example.yupao.demos.model.domain.User;
import org.example.yupao.demos.service.TeamService;
import org.springframework.stereotype.Service;

@Service

public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {
    @Override
    public long addTeam(Team team, User loginuser) {
        //1. 请求参数是否为空
        //2.
        return 0;
    }
}
