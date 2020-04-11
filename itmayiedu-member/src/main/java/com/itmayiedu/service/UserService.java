package com.itmayiedu.service;

import com.itmayiedu.dao.UserDao;
import com.itmayiedu.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserEntity> getAllUser() {
        return userDao.getAllUser();
    }

    public UserEntity getUser(Integer id) {
        List<UserEntity> allUser = getAllUser();
        for(UserEntity userEntity: allUser) {
            if (userEntity.getId().equals(id)) {
                return userEntity;
            }
        }
        return null;
    }
}
