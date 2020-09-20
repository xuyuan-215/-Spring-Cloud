package com.soft1851.user.center.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;
}
