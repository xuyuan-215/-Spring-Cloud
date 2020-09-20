package com.soft1851.course.center.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String avatar;
    private String nickName;
    private String account;
    private String password;
}
