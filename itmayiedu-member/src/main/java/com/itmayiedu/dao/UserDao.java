package com.itmayiedu.dao;

import com.itmayiedu.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public List<UserEntity> getAllUser() {
        List<UserEntity> listUser = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listUser.add(new UserEntity(i, "name:" + i));
        }
        return listUser;
    }
}
