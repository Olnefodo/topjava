package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Oleksandr on 15.12.15.
 */
@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private Map<Integer, User> userRepository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    {
        save(new User (1, "User", "user@yandex.ru", "password", Role.ROLE_USER));
        save (new User (2, "Admin", "olneofdo@student.jyu.fi", "pass", Role.ROLE_ADMIN));
    }

    @Override
    public User save(User user) {
        if (user.isNew()){
            user.setId(counter.incrementAndGet());
        }
        return userRepository.put(user.getId(), user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.remove(id) != null;
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return  getAll().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.values().stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
    }
}
