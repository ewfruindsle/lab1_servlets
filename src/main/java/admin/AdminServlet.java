package admin;

import entities.Payment;
import entities.Service;
import entities.User;
import org.jetbrains.annotations.NotNull;
import qualifiers.Payments;
import qualifiers.Services;
import qualifiers.Users;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Inject @Users
    HashSet<User> users;

    @Inject @Services
    ArrayList<Service> services;

    @Inject @Payments
    ArrayList<Payment> payments;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<form action=\"/SearchServlet\" method=\"post\">\n" +
                "<div align=\"center\">\n" +
                "Name: <input type=\"text\" name=\"name\">\n" +
                "Service: <input type=\"text\" name=\"service\">\n" +
                "Date: <input type=\"date\" name=\"date\">\n" +
                "<input type=\"submit\" value=\"Search\" name=\"search\"> <br>\n" +
                "</div>\n" +
                "</form>");

        //PAYMENTS
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Payments</caption>");
        pw.println("<tr><th>ID</th><th>Client</th><th>Service</th><th>Date</th><th>Payment</th></tr>");
        for (Payment payment : payments) {
            pw.println("<tr>");
            pw.println("<td>" + payment.getIdPayment() + "</td>");
            pw.println("<td>" + payment.getClientUsername() + "</td>");
            pw.println("<td>" + payment.getSevice() + "</td>");
            pw.println("<td>" + payment.getDateOfPayment() + "</td>");
            pw.println("<td>" + payment.getSumOfPayment() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table><br><br>");

        // USERS
        req.setAttribute("users", users);
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Users</caption>");
        pw.println("<tr><th>Name</th><th>Username</th></tr>");
        for (User client : users) {
            pw.println("<tr>");
            pw.println("<td>" + client.getName() + "</td>");

            pw.println("<td>" + client.getUsername() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table><br>");
        pw.println("<form action=\"/editUser.jsp\" method=\"post\" align=\"center\">\n" +
                "<input type=\"submit\" value=\"Edit table 'Users'\" name=\"editClients\"> <br>\n" +
                "</form>");

        //SERVICES
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Services</caption>");
        pw.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        for (Service services : services) {
            pw.println("<tr>");
            pw.println("<td>" + services.getId() + "</td>");
            pw.println("<td>" + services.getName() + "</td>");
            pw.println("<td>" + services.getPrice() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table><br>");

        pw.println("<form action=\"/LogoutServlet\" method=\"post\" align = \"center\">\n" +
                "<input type=\"submit\" value=\"Logout\" >\n" +
                "</form>");
        pw.println("</html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        if(req.getAttribute("usersAdded") != null){
            users = (HashSet<User>) req.getAttribute("usersAdded");
        }
        if(req.getAttribute("usersEdited") != null){
            users = (HashSet<User>) req.getAttribute("usersEdited");
        }
        pw.println("<html>");
        pw.println("<form action=\"/SearchServlet\" method=\"post\">\n" +
                "<div align=\"center\">\n" +
                "Name: <input type=\"text\" name=\"name\">\n" +
                "Service: <input type=\"text\" name=\"service\">\n" +
                "Date: <input type=\"date\" name=\"date\">\n" +
                "<input type=\"submit\" value=\"Search\" name=\"search\"> <br>\n" +
                "</div>\n" +
                "</form>");

        //PAYMENTS
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Payments</caption>");
        pw.println("<tr><th>ID</th><th>Client</th><th>Service</th><th>Date</th><th>Payment</th></tr>");
        for (Payment payment : payments) {
            pw.println("<tr>");
            pw.println("<td>" + payment.getIdPayment() + "</td>");
            pw.println("<td>" + payment.getClientUsername() + "</td>");
            pw.println("<td>" + payment.getSevice() + "</td>");
            pw.println("<td>" + payment.getDateOfPayment() + "</td>");
            pw.println("<td>" + payment.getSumOfPayment() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table><br><br>");

        // USERS
        req.setAttribute("users", users);
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Users</caption>");
        pw.println("<tr><th>Name</th><th>Username</th></tr>");
        for (User client : users) {
            pw.println("<tr>");
            pw.println("<td>" + client.getName() + "</td>");

            pw.println("<td>" + client.getUsername() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table><br>");
        pw.println("<form action=\"/editUser.jsp\" method=\"post\" align=\"center\">\n" +
                "<input type=\"submit\" value=\"Edit table 'Users'\" name=\"editClients\"> <br>\n" +
                "</form>");

        //SERVICES
        pw.println("<table border = '1' align = 'center'>");
        pw.println("<caption><b>Services</caption>");
        pw.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        for (Service services : services) {
            pw.println("<tr>");
            pw.println("<td>" + services.getId() + "</td>");
            pw.println("<td>" + services.getName() + "</td>");
            pw.println("<td>" + services.getPrice() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table><br>");

        pw.println("<form action=\"/LogoutServlet\" method=\"post\" align = \"center\">\n" +
                "<input type=\"submit\" value=\"Logout\" >\n" +
                "</form>");
        pw.println("</html>");
    }
}

