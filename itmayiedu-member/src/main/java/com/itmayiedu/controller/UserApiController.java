package com.itmayiedu.controller;

import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public UserEntity getUser(Integer userId) {
        return userService.getUser(userId);
    }
}
