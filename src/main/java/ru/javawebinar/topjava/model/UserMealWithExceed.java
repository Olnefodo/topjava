package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMealWithExceed {
    protected final LocalDateTime dateTime;

    protected List<UserMealWithExceed> listWithExceed = new ArrayList<>();

    protected final String description;

    protected final int calories;

    protected final boolean exceed;

    public LocalDateTime getDateTime(){return this.dateTime;}
    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    public static List<UserMealWithExceed> getUserMealWithExceed (List<UserMeal> meals, int caloriesPerDay){
        Map<LocalDate, Integer> calSumByDate = meals.stream().
                collect(Collectors.groupingBy(um -> um.getDateTime().toLocalDate(), Collectors.summingInt(UserMeal::getCalories)));
        return meals.stream().map(um -> new UserMealWithExceed(um.getDateTime(), um.getDescription(), um.getCalories(),
                calSumByDate.get(um.getDateTime().toLocalDate()) > caloriesPerDay)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
