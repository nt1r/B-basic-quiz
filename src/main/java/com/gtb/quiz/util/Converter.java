package com.gtb.quiz.util;

import com.gtb.quiz.entity.User;
import com.gtb.quiz.vo.UserVo;

public class Converter {
    public static User convertUserVo2User(UserVo userVo) {
        return User.builder()
                .name(userVo.getName())
                .age(userVo.getAge())
                .avatar(userVo.getAvatar())
                .description(userVo.getDescription())
                .build();
    }
}
