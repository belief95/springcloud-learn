package com.itmayiedu.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String name;

    public UserEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
