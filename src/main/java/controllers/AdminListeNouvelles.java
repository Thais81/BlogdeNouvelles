package controllers;

import dao.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jopaups
 */
@WebServlet("/adminNouvelles")
public class AdminListeNouvelles extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nouvelles", DAOFactory.getNouvelleDAO().list());
        req.getRequestDispatcher("WEB-INF/adminListeNouvelles.jsp").forward(req, resp);
    }

}
