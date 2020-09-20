package com.soft1851.course.center.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String avatar;
    private String nickName;
    List<CourseDto> courseDos;

}
