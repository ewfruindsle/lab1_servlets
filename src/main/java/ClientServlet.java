
import entities.Payment;
import qualifiers.Payments;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

    @Inject @Payments
    ArrayList<Payment> payments;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        Cookie[] cookies = request.getCookies();
        String currentUser = null;
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("client")) {
                    currentUser = cookie.getValue();
                }
            }
        }
        pw.println("<html>");
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Payments</caption>");
        pw.println("<tr><th>ID</th><th>Client</th><th>Service</th><th>Date</th><th>Payment</th></tr>");
        for (Payment payment : payments)  {
            if(payment.getClientUsername().equals(currentUser)) {
                pw.println("<tr>");
                pw.println("<td>" + payment.getIdPayment() + "</td>");
                pw.println("<td>" + payment.getClientUsername() + "</td>");
                pw.println("<td>" + payment.getSevice() + "</td>");
                pw.println("<td>" + payment.getDateOfPayment() + "</td>");
                pw.println("<td>" + payment.getSumOfPayment() + "</td>");
                pw.println("</tr>");
            }
        }
        pw.println("</table><br><br>");
        pw.println("<form action=\"/LogoutServlet\" method=\"post\" align = \"center\">\n" +
                "<input type=\"submit\" value=\"Logout\" >\n" +
                "</form>");
        pw.println("</html>");
        pw.println("</html>");
    }
}
