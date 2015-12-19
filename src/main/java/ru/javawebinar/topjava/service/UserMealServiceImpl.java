package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.repository.UserMealRepository;

/**
 * Created by Oleksandr on 15.12.15.
 */
@Service
public class UserMealServiceImpl {
    @Autowired
    private UserMealRepository repository;
}
