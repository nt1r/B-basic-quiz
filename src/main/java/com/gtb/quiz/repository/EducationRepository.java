package com.gtb.quiz.repository;

import com.gtb.quiz.entity.Education;
import com.gtb.quiz.exception.EducationNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class EducationRepository {
    public final static Map<Long, Education> educationMap = new HashMap<>();
    public final static AtomicLong autoIncreaseId = new AtomicLong(0);


    public Education save(Education education) {
        education.setId(autoIncreaseId.incrementAndGet());
        educationMap.put(education.getId(), education);
        return education;
    }

    public List<Education> findByUserId(Long userId) {
        List<Education> educationList = new ArrayList<>();
        educationMap.forEach((id, education) -> {
            if (education.getUserId().equals(userId)) {
                educationList.add(education);
            }
        });

        if (educationList.isEmpty()) {
            throw new EducationNotFoundException("Education not found, userId = " + userId);
        }

        return educationList;
    }
}
