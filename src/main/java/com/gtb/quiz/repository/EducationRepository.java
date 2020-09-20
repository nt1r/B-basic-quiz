package com.gtb.quiz.repository;

import com.gtb.quiz.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM cv_education WHERE user_id = :userId")
    List<Education> findAllByUserId(@Param("userId") Long userId);
    /*public final static Map<Long, Education> educationMap = new HashMap<>();
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
    }*/
}
