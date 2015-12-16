package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.service.UserService;

/**
 * Created by Oleksandr on 15.12.15.
 */
@Controller
public class AdminUserRestController {
    @Autowired
    private UserService service;
}
