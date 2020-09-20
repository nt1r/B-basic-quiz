package com.gtb.quiz.repository;

import com.gtb.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);
    /*public final static Map<Long, User> userMap = new HashMap<>();
    public final static AtomicLong autoIncreaseId = new AtomicLong(0);

    public User save(User user) {
        user.setId(autoIncreaseId.incrementAndGet());
        userMap.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        if (!isUserIdValid(id)) {
            throw new UserNotFoundException(id);
        }

        return userMap.get(id);
    }

    private boolean isUserIdValid(Long id) {
        return userMap.containsKey(id);
    }*/
}
