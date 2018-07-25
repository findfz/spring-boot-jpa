package com.common.user.service.impl;

import com.common.user.entity.User;
import com.common.user.repository.UserRepository;
import com.common.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * Author：xiongzhan
 * Description：用户接口实现
 * Date: 2018-07-25 23:22
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> findAll(Pageable pageable) {
        User user = new User();
        user.setName("子");
        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<User> example = Example.of(user, matcher);
        Page<User> userPage = userRepository.findAll(example, pageable);
        return userPage;
    }
}
