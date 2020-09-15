package com.gtb.quiz.repository;

import com.gtb.quiz.entity.Education;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
}
