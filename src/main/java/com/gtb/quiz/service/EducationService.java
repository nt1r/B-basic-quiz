package com.gtb.quiz.service;

import com.gtb.quiz.entity.Education;
import com.gtb.quiz.repository.EducationRepository;
import com.gtb.quiz.util.Converter;
import com.gtb.quiz.vo.EducationVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public Education addOneEducation(Long userId, EducationVo educationVo) {
        // GTB: - userId 不存在时怎么处理？
        Education education = Converter.convertEducationVo2Education(educationVo, userId);
        return educationRepository.save(education);
    }

    public List<Education> getEducationListByUserId(Long userId) {
        return educationRepository.findByUserId(userId);
    }
}
