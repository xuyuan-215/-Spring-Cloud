package com.soft1851.course.center.service;

import com.soft1851.course.center.dao.CourseMapper;
import com.soft1851.course.center.domain.dto.CourseDto;
import com.soft1851.course.center.domain.dto.UserDto;
import com.soft1851.course.center.domain.entity.Course;
import com.soft1851.course.center.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService {
    private final CourseMapper courseMapper;
    private final RestTemplate restTemplate;


    public UserDto getAllByUserId(int userId){
        ResponseEntity<User> userEntity = restTemplate.exchange(
                "http://47.98.162.206:8081/user/one/"+userId,
                HttpMethod.GET, null, new ParameterizedTypeReference<User>(){}
        );
//        restTemplate.getForObject("http://47.98.162.206:8081/user/one/{?}",User.class,userId);
        User user = userEntity.getBody();
        UserDto userDto = new UserDto();
        assert user != null;
        userDto.setAvatar(user.getAvatar());
        userDto.setNickName(user.getNickName());
        Example example = new Example(Course.class);
        example.createCriteria().andEqualTo("userId",userId);
        List<Course> courses = courseMapper.selectByExample(example);
        List<CourseDto> list = new ArrayList<>();
        for (Course c:courses){
            CourseDto courseDto = CourseDto.builder()
                    .courseName(c.getCourseName())
                    .img(c.getImg())
                    .introduction(c.getIntroduction())
                    .status(c.getStatus())
                    .build();
            list.add(courseDto);
        }
        userDto.setCourseDos(list);
        return userDto;
    }
}
