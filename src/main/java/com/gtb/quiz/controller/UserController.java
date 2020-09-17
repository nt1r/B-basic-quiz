package com.gtb.quiz.controller;

import com.gtb.quiz.entity.Education;
import com.gtb.quiz.entity.User;
import com.gtb.quiz.service.EducationService;
import com.gtb.quiz.service.UserService;
import com.gtb.quiz.vo.EducationVo;
import com.gtb.quiz.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final EducationService educationService;

    public UserController(UserService userService, EducationService educationService) {
        this.userService = userService;
        this.educationService = educationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addOneUser(@RequestBody @Valid UserVo userVo) {
        return userService.addOneUser(userVo);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/{userId}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public Education addOneEducation(@PathVariable Long userId, @RequestBody @Valid EducationVo educationVo) {
        return educationService.addOneEducation(userId, educationVo);
    }

    @GetMapping("/{userId}/educations")
    public List<Education> getEducationListByUserId(@PathVariable Long userId) {
        return educationService.getEducationListByUserId(userId);
    }
}
