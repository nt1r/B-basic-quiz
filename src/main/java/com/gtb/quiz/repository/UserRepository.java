package com.gtb.quiz.repository;

import com.gtb.quiz.entity.User;
import com.gtb.quiz.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserRepository {
    public final static Map<Long, User> userMap = new HashMap<>();
    public final static AtomicLong autoIncreaseId = new AtomicLong(0);

    public User save(User user) {
        user.setId(autoIncreaseId.incrementAndGet());
        userMap.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        if (!isUserIdValid(id)) {
            throw new UserNotFoundException("User id not found: " + id);
        }

        return userMap.get(id);
    }

    private boolean isUserIdValid(Long id) {
        return userMap.containsKey(id);
    }
}
