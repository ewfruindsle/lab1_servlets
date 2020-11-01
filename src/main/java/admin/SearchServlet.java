package admin;

import entities.Payment;
import qualifiers.Payments;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    @Inject
    @Payments
    ArrayList<Payment> payments;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientUsername = request.getParameter("name");
        String service = request.getParameter("service");
        String date = request.getParameter("date");
        ArrayList<Payment> listOfPaymentsFound = payments;
        if (!clientUsername.equals("")){
            listOfPaymentsFound = listOfPaymentsFound.stream().filter(p -> p.getClientUsername().equals(clientUsername)).collect(
                    ArrayList::new,
                    ArrayList::add,
                    ArrayList::addAll);
        }
        if(!service.equals("")){
            listOfPaymentsFound = listOfPaymentsFound.stream().filter(p -> p.getSevice().equals(service)).collect(
                    ArrayList::new,
                    ArrayList::add,
                    ArrayList::addAll);
        }
        if(!date.equals("")){
            listOfPaymentsFound = listOfPaymentsFound.stream().filter(p -> p.getDateOfPayment().equals(LocalDate.parse(date))).collect(
                    ArrayList::new,
                    ArrayList::add,
                    ArrayList::addAll);
        }
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        pw.println("<table border=\"1\" align = \"center\">\n" +
                "<caption>Payments found</caption>\n" +
                "<tr><th>ID</th><th>Client</th><th>Service</th><th>Date</th><th>Payment</th></tr>");
        listOfPaymentsFound.forEach(p -> pw.println("<tr><td>"+ p.getIdPayment() +
                "</td><td>"+ p.getClientUsername() + "</td><td>" + p.getSevice() +
                "</td><td>" + p.getDateOfPayment() + "</td><td>" + p.getSumOfPayment() +
                "</td></tr>"));
        pw.println("</table><br>");
        pw.println("<form action=\"/AdminServlet\" method=\"get\">\n" +
                "<div align=\"center\">\n" +
                "<input type=\"submit\" value=\"Back\" name=\"back\"> <br>\n" +
                "</div>\n" +
                "</form>");
        pw.println("</body></html>");
    }
}
