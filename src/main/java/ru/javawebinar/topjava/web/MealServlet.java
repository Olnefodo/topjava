package ru.javawebinar.topjava.web;

import javax.servlet.http.HttpServlet;


/**
 * Created by Oleksandr on 07.12.15.
 */
public class MealServlet extends HttpServlet {
    /*
    private InMemoryUserMealRepository repository= new InMemoryUserMealRepository();
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserMealRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("list", UserMealsUtil.getWithExceeded(repository.getAll(), 2000));
            LOG.debug("redirect to userlist");
            req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
        }
        else if ("delete".equals(action)){
            repository.delete(Integer.parseInt(request(req)));
            resp.sendRedirect("/mealList");
        }
        else {
            String id = request(req);
            UserMeal meal = action.equals("create")?
                    new UserMeal(LocalDateTime.now(), "", 1000):
                    repository.get(Integer.parseInt(id));
            req.setAttribute("meal", meal);
            req.getRequestDispatcher("/mealEdit.jsp").forward(req, resp);

        }

    }
    public String request(HttpServletRequest req){
        return req.getParameter("id");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String dateTime = req.getParameter("dateTime");
        UserMeal meal = new UserMeal(id.isEmpty() ? null : Integer.valueOf(id), LocalDateTime.parse(dateTime),
                req.getParameter("Description"), Integer.valueOf(req.getParameter("Calories")));
        repository.save(meal);

        req.setAttribute("list", UserMealsUtil.getWithExceeded(repository.getAll(), 2000));
        req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
    }
    */
}
