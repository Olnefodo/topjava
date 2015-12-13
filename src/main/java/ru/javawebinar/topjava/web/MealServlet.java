package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.InMemoryUserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


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
        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("meals", UserMealsUtil.getWithExceed(repository.getAll(), 2000));
            req.getRequestDispatcher("mealList.jsp").forward(req, resp);
        }else if (action.equals("delete")){
            String id = req.getParameter("id");
            repository.delete(Integer.valueOf(id));
            resp.sendRedirect("/mealList");
        }else {
            UserMeal meal = action.equals("create") ?
                    new UserMeal(LocalDateTime.now(), " ", 1000) :
                    repository.get(Integer.valueOf(req.getParameter("id")));
            req.setAttribute("meal", meal);
            req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        repository.save(new UserMeal(id.isEmpty() ? null : Integer.valueOf(id), LocalDateTime.parse(req.getParameter("timeDate")),
                req.getParameter("description"), Integer.valueOf(req.getParameter("calories"))));
        resp.sendRedirect("/mealList");
    }
}
