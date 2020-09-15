package com.gtb.quiz.repository;

import com.gtb.quiz.entity.User;
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
}
