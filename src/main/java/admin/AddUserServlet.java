package admin;

import entities.User;
import qualifiers.Users;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Inject @Users
    HashSet<User> users;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = users.size();
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        users.add(new User(count+1, name, username,pwd));
        request.setAttribute("usersAdded", users);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AdminServlet");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
