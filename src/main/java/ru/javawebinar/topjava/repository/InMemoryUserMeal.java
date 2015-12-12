package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Oleksandr on 12.12.15.
 */
public class InMemoryUserMeal implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510));
    }
    @Override
    public UserMeal save(UserMeal meal) {
        if (meal.isNew(meal)){
            meal.setId(counter.incrementAndGet());
        }

        return repository.put(meal.getId(), meal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        return repository.values();
    }
}
