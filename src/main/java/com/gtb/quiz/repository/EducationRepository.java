package com.gtb.quiz.repository;

import com.gtb.quiz.entity.Education;
import com.gtb.quiz.exception.EducationNotFoundException;
import com.gtb.quiz.exception.UserNotFoundException;
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
        if (!isUserIdValid(education.getUserId())) {
            throw new UserNotFoundException(education.getUserId());
        }
        education.setId(autoIncreaseId.incrementAndGet());
        educationMap.put(education.getId(), education);
        return education;
    }

    private boolean isUserIdValid(Long userId) {
        return !findByUserId(userId).isEmpty();
    }

    public List<Education> findByUserId(Long userId) {
        List<Education> educationList = new ArrayList<>();
        educationMap.forEach((id, education) -> {
            if (education.getUserId().equals(userId)) {
                educationList.add(education);
            }
        });

        return educationList;
    }
}
