package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.repository.Dao;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Oleksandr on 07.12.15.
 */
public class MealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", UserMealsUtil.getMealsWithExceeded(Dao.list, 2000));
        req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
    }
}
