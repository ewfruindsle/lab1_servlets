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

@WebServlet("/EditUsersServlet")
public class EditUsersServlet extends HttpServlet {
    @Inject @Users
    HashSet<User> users;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usernameToEdit = req.getParameter("user");
        User userToEdit = users.stream().filter(u -> u.getUsername().equals(usernameToEdit)).findFirst().orElse(null);
        String newName = req.getParameter("name");
        String newUsername = req.getParameter("username");
        if(userToEdit != null) {
            userToEdit.setName(newName);
            userToEdit.setUsername(newUsername);
        }
        req.setAttribute("usersEdited", users);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AdminServlet");
        requestDispatcher.forward(req, resp);
    }
}
