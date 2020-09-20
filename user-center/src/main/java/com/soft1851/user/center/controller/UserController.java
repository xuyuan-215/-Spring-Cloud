package com.soft1851.user.center.controller;

import com.soft1851.user.center.domain.entity.User;
import com.soft1851.user.center.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/one/{userId}")
    public User getUserByUserId(@PathVariable int userId){
        return userService.getUserByUerId(userId);
    }
}
