package edu.matc.controller;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name="login",
        urlPatterns = {"/login"}
)
public class LogIn extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ServletContext servletContext;


        String userVal = req.getRemoteUser();
       // logger.info("~~~~~~~~~~~~~~~~~~~~~USERVAL: ~~~~~~~~~~~~~~~~~~~~~~~~~" + userVal + "~~(IN DOGET)~~~");

        // identifyUser(req);

       // logger.info("~~~~~~~~~~~~~~~~~~~~~USERVAL: ~~~~~~~~~~~~~~~~~~~~~~~~~" + userVal + "~~(IN ID USER)[jk]~~~");
        GenericDao<User> localDao = new GenericDao<>(User.class);
      //  GenericDao<Role> roleDao = new GenericDao<>(Role.class);
        int id = localDao.getByPropertyLike("email", userVal).get(0).getId();
        User user = localDao.getById(id);
        Role role = user.getRoles().iterator().next();;
        int roleId = role.getId();
        String roleName = role.getRoleName();

        logger.info("~~~~~~~~~~~~~~~~~~~~~ROLE ID: ~~~~~~~~~~~~~~~~~~~~~~~~~" + roleId + "~~~~~" + roleName);
        servletContext = getServletContext();
        servletContext.setAttribute("userId", id);
        servletContext.setAttribute("role", roleName);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }
}
