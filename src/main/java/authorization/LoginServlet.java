package authorization;

import entities.User;
import qualifiers.Users;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Inject
    @Users
    HashSet<User> clients;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        User clientToCheck = clients.stream().filter(c -> c.getUsername().equals(username)).findFirst().orElse(null);

        if (clientToCheck != null) {
            if (clientToCheck.getPassword().equals(password)) {
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession newSession = request.getSession(true);
                newSession.setMaxInactiveInterval(5 * 60);

                if (clientToCheck.getUsername().equals("admin")) {
                    Cookie message = new Cookie("message", "Admin-profile");
                    response.addCookie(message);
                    response.sendRedirect("/AdminServlet");
                } else {
                    Cookie message = new Cookie("client", clientToCheck.getUsername());
                    response.addCookie(message);
                    response.sendRedirect("/ClientServlet");
                }

            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginPage.html");
                PrintWriter pw = response.getWriter();
                pw.println("<font color=red>Either username or password is wrong.</font>");
                rd.include(request, response);
            }

        }
    }

}