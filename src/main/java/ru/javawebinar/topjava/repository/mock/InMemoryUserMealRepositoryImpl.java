package ru.javawebinar.topjava.repository.mock;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by Oleksandr on 16.12.15.
 */
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private static Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    AtomicInteger counter = new AtomicInteger(0);
    {
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    private Integer userID;

    @Override
    public UserMeal save(UserMeal userMeal) {
        if (userMeal.isNew()){
            userMeal.setId(counter.incrementAndGet());
        }
        return repository.put(userID, userMeal);
    }

    @Override
    public UserMeal get(int id) {
        return repository.get(id);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        return repository.values();
    }

    @Override
    public Collection<UserMeal> getFilteredByTimeWithExceeded(Collection<UserMeal> userMeals) {
        return userMeals.stream().collect(Collectors.groupingBy()
    }
}
