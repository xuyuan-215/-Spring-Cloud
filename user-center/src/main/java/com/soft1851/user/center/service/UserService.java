package com.soft1851.user.center.service;

import com.soft1851.user.center.dao.UserMapper;
import com.soft1851.user.center.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    public User getUserByUerId(int userId){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("userId",userId);
        return userMapper.selectOneByExample(example);
    }
}
