package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;

/**
 * Created by Oleksandr on 12.12.15.
 */
public interface UserMealRepository {
    UserMeal save(UserMeal meal);
    void delete(int id);
    Collection<UserMeal> getAll();
}
