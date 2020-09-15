package com.gtb.quiz.controller;

import com.gtb.quiz.entity.User;
import com.gtb.quiz.service.UserService;
import com.gtb.quiz.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
}
