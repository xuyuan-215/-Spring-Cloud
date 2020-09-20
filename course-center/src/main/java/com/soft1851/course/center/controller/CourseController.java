package com.soft1851.course.center.controller;

import com.soft1851.course.center.domain.dto.UserDto;
import com.soft1851.course.center.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/course")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {
    private final CourseService courseService;

    @GetMapping(value = "/list/{userId}")
    public UserDto getCourseListByUserId(@PathVariable int userId){
        return courseService.getAllByUserId(userId);
    }
}
