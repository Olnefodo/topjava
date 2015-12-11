package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.Dao;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Created by Oleksandr on 07.12.15.
 */
public class MealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", UserMealsUtil.getMealsWithExceeded(Dao.list, 2000));
        req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String date = req.getParameter("date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        */
        req.setCharacterEncoding("UTF-8");
        String descr = req.getParameter("description");
        String cal = req.getParameter("calories");
        Dao.add(LocalDateTime.of(LocalDate.now(), LocalTime.now()), descr, Integer.parseInt(cal));

        req.setAttribute("list", UserMealsUtil.getMealsWithExceeded(Dao.list, 2000));
        req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
    }
}
