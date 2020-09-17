package com.gtb.quiz.util;

import com.gtb.quiz.entity.Education;
import com.gtb.quiz.entity.User;
import com.gtb.quiz.vo.EducationVo;
import com.gtb.quiz.vo.UserVo;

// GTB: + 有 Converter
public class Converter {
    public static User convertUserVo2User(UserVo userVo) {
        return User.builder()
                .name(userVo.getName())
                .age(userVo.getAge())
                .avatar(userVo.getAvatar())
                .description(userVo.getDescription())
                .build();
    }

    public static Education convertEducationVo2Education(EducationVo educationVo, Long userId) {
        return Education.builder()
                .userId(userId)
                .year(educationVo.getYear())
                .title(educationVo.getTitle())
                .description(educationVo.getDescription())
                .build();
    }
}
