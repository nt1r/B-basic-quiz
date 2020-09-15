package com.gtb.quiz.service;

import com.gtb.quiz.entity.User;
import com.gtb.quiz.exception.UserNotFoundException;
import com.gtb.quiz.repository.UserRepository;
import com.gtb.quiz.util.Converter;
import com.gtb.quiz.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addOneUser(UserVo userVo) {
        User user = Converter.convertUserVo2User(userVo);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
