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
import za.ac.tut.model.bl.ClientFacadeLocal;
import za.ac.tut.model.entities.Client;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

     @EJB ClientFacadeLocal cfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Long phone = Long.parseLong(request.getParameter("phone"));
        String password = request.getParameter("password");
        
        session.setAttribute("password", password);
        session.setAttribute("phone", phone);
        
        Client client = cfl.login(phone, password);
        
        if(client  != null){
            session.setAttribute("client", client);
            session.setAttribute("username", client.getUsername());
            RequestDispatcher disp = request.getRequestDispatcher("dashboard.jsp");
            disp.forward(request, response);
        }else{
            response.sendRedirect("LoginError.jsp");
        }
       
    }


   

}
