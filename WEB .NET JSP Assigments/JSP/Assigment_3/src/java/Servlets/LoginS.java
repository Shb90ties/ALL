/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shb
 */
@WebServlet(name = "LoginS", urlPatterns = {"/LoginS"})
public class LoginS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String cName = "no_cockies";    String cPassword = "no_cookies";
        if( request.getCookies() != null && request.getParameter("new_user") == null &&
                request.getParameter("fromGamePage") == null )
        {    
            for(int i=0; i < request.getCookies().length; i++)
            {
                if( request.getCookies()[i].getName().equals("cName"))
                {
                    cName = request.getCookies()[i].getValue();
                    break;
                }
            }
            for(int i=0; i < request.getCookies().length; i++)
            {
                if( request.getCookies()[i].getName().equals("cPassword"))
                {
                    cPassword = request.getCookies()[i].getValue();
                    break;
                }
            }
        }
        if( !cName.equals("no_cockies") && !cPassword.equals("no_cockies"))
        {
            request.getSession().setAttribute("uN", cName);
            request.getSession().setAttribute("ps", cPassword);
            response.sendRedirect("Login.jsp");
        }
        else
        {
            if( request.getParameter("fromGamePage") != null )
            {
                request.getSession().removeAttribute("uN");
                request.getSession().removeAttribute("ps");
                new_login(request, response);
            }
            else
            {
                response.sendRedirect("GamePage.jsp");
            }
        }

    }
    
    protected void new_login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String uName = "null";
        if( (request.getParameter("userName") != null ) &&
                (!request.getParameter("userName").trim().equals("")))
        {
            uName = request.getParameter("userName");
        }        
        String Password = "null";
        if( (request.getParameter("password") != null ) &&
                (!request.getParameter("password").trim().equals("")))
        {
            Password = request.getParameter("password");
        }
        if( request.getParameter("remember_me") != null )
        {
            Cookie c = new Cookie("cName", uName);
            response.addCookie(c);
            Cookie c1 = new Cookie("cPassword", Password);
            response.addCookie(c1);
        }
        request.getSession().setAttribute("uN", uName);
        request.getSession().setAttribute("ps", Password);
        response.sendRedirect("Login.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
