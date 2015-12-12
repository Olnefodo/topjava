package ru.javawebinar.topjava.UserMealRepository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;

/**
 * Created by Oleksandr on 11.12.15.
 */
public interface UserMealRepository {
    UserMeal save (UserMeal userMeal);
    void delete (int id);
    UserMeal get (int id);
    Collection<UserMeal> getAll();

}
