package org.example.yupao.demos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.yupao.demos.mapper.UserTeamMapper;
import org.example.yupao.demos.model.domain.UserTeam;
import org.example.yupao.demos.service.UserTeamService;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
        implements UserTeamService {

}

