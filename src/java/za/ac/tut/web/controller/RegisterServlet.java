/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import za.ac.tut.model.bl.ClientFacadeLocal;
import za.ac.tut.model.entities.Client;

/**
 *
 * @author user
 */
public class RegisterServlet extends HttpServlet {

    @EJB ClientFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Long phone = Long.parseLong(request.getParameter("phone"));
        
        Client client = createClient(username,password,phone);
        cfl.create(client);
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("phone", phone);
        
        RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
        disp.forward(request, response);
    }

    private Client createClient(String username, String password, Long phone) {
       
       Client ct = new Client();
       ct.setId(phone);
       ct.setPassword(password);
       ct.setUsername(username);
       ct.setCreationDate(new Date());
       
       return ct;
    }

   

}
