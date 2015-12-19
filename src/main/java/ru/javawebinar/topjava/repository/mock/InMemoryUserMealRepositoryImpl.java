package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Pack200;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    public static final Comparator<UserMeal> COMPARE_BY_TIME = (um1, um2) -> um2.getDateTime().compareTo(um1.getDateTime());
    private Map<Integer, Map<Integer, UserMeal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500), InMemoryUserRepositoryImpl.USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000), InMemoryUserRepositoryImpl.USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500), InMemoryUserRepositoryImpl.USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000), InMemoryUserRepositoryImpl.USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500), InMemoryUserRepositoryImpl.USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510), InMemoryUserRepositoryImpl.USER_ID);

        save(new UserMeal(LocalDateTime.of(2015, Month.JUNE, 30, 10, 0), "Завтрак", 500), InMemoryUserRepositoryImpl.ADMIN_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.JUNE, 30, 10, 0), "Завтрак", 500), InMemoryUserRepositoryImpl.ADMIN_ID);


    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        Integer mealId = userMeal.getId();
        if (userMeal.isNew()) {
            mealId = counter.incrementAndGet();
            userMeal.setId(mealId);
        }else if (get(mealId, userId) == null) {
            return null;
        }
        Map<Integer, UserMeal> userMeals = repository.computeIfAbsent(userId, ConcurrentHashMap::new);
        userMeals.put(mealId, userMeal);

        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, UserMeal> userMeal = repository.get(userId);
        return userMeal != null && userMeal.remove(id) != null;
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        Map<Integer, UserMeal> meals = repository.get(userId);
        return meals == null ? null : meals.get(mealId);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.get(userId).values().stream().sorted(COMPARE_BY_TIME).collect(Collectors.toList());
    }

    @Override
    public Collection<UserMeal> getBetween(int userId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return getAll(userId).stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime().toLocalTime(), startDateTime.toLocalTime(), endDateTime.toLocalTime()))
                .sorted(COMPARE_BY_TIME)
                .collect(Collectors.toList());
    }
}

