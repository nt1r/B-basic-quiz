package com.gtb.quiz.service;

import com.gtb.quiz.entity.Education;
import com.gtb.quiz.entity.User;
import com.gtb.quiz.exception.UserNotFoundException;
import com.gtb.quiz.repository.EducationRepository;
import com.gtb.quiz.repository.UserRepository;
import com.gtb.quiz.util.Converter;
import com.gtb.quiz.vo.EducationVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final UserRepository userRepository;

    public EducationService(EducationRepository educationRepository, UserRepository userRepository) {
        this.educationRepository = educationRepository;
        this.userRepository = userRepository;
    }

    public Education addOneEducation(Long userId, EducationVo educationVo) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(userId);
        }

        Education education = Converter.convertEducationVo2Education(educationVo, userOptional.get());
        return educationRepository.save(education);
    }

    public List<Education> getEducationListByUserId(Long userId) {
        return educationRepository.findAllByUserId(userId);
    }
}
