package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.UserMealWithExceed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr on 07.12.15.
 */
public class MealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserMealWithExceed> list = new ArrayList<>();
        list.add(new UserMealWithExceed());
        req.getRequestDispatcher("mealList.jsp").forward(req, resp);
    }
}
