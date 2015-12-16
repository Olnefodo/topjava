package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by Oleksandr on 15.12.15.
 */
public interface UserMealRepository {

    UserMeal save(UserMeal userMeal);
    void delete(int id);
    List<UserMeal> getAll();

}
