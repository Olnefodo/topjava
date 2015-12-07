package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr on 07.12.15.
 */
public class Dao {
    public static List<UserMeal> list = new ArrayList<>();
    static {
            list.add(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500));
            list.add(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000));
            list.add(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500));
            list.add(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000));
            list.add(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500));
            list.add(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510));
    }
    public void add(LocalDateTime t, String description, int calories){list.add(new UserMeal(t, description, calories));}
    public void delete(UserMealWithExceed user){list.remove(user);}
}
