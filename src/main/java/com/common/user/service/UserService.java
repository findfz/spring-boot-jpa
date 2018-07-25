package com.common.user.service;

import com.common.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Author：xiongzhan
 * Description：用户接口
 * Date: 2018-07-25 23:22
 */
public interface UserService {

    Page<User> findAll(Pageable pageable);

}
