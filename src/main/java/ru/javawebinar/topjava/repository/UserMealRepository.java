package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;
import java.util.Collection;

/**
 * Created by Oleksandr on 15.12.15.
 */
public interface UserMealRepository {

    UserMeal save(UserMeal userMeal);

    UserMeal get(int id);

    void delete(int id);

    Collection<UserMeal> getAll();

}
