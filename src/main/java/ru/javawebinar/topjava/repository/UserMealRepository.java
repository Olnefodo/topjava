package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Oleksandr on 15.12.15.
 */
public interface UserMealRepository {

    UserMeal save(UserMeal userMeal, int userId);

    UserMeal get(int userId, int mealId);

    boolean delete(int id, int mealId);

    Collection<UserMeal> getAll(int userId);
    Collection<UserMeal> getBetween(int userId, LocalDateTime startDateTime, LocalDateTime endDateTime);

}
