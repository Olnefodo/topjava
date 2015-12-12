package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.repository.InMemoryUserMeal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Oleksandr on 07.12.15.
 */
public class MealServlet extends HttpServlet {
    private InMemoryUserMeal repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserMeal();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("meals", repository.getAll());
        req.getRequestDispatcher("mealList.jsp").forward(req, resp);
    }
}
