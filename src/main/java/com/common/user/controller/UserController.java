package com.common.user.controller;

import com.common.user.entity.User;
import com.common.user.service.UserService;
import com.common.util.CustomPageableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：xiongzhan
 * Description：用户操作
 * Date: 2018-07-25 23:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public Page findAll(int pageNum, int pageSize){
        //两种分页参数传递方式，1.自定义Pageable实现
//        CustomPageableImpl customPageable = new CustomPageableImpl(pageNum,pageSize);
        //2.使用PageRequest
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<User> page = userService.findAll(pageable);
        return page;
    }

}
