/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shb
 */
@WebServlet(name = "DeleteS", urlPatterns = {"/DeleteS"})
public class DeleteS extends HttpServlet {

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
        UserDB user = new UserDB();
        if( request.getParameter("before_delete") == null )
        {
            printQuestions(request, response, user);
        }
        else
        {
            if( request.getParameter("picked_questions") != null)
            { 
                String[] codes = request.getParameterValues("picked_questions");
                for(String c : codes)
                {
                    if( !c.trim().equals(""))
                    {
                        user.deleteSQL_Q(c);
                        user.deleteSQL_A(c);
                    }
                }
            }
            printQuestions(request, response, user);
        }
        
    }
    
    protected void printQuestions(HttpServletRequest request, HttpServletResponse response,UserDB user)
            throws ServletException, IOException 
    {
            List<SQL_Q> temp_list = user.get_ALL_questions();
            String[] codes = new String[temp_list.size()];
            String[] questions = new String[temp_list.size()];
            String[] category = new String[temp_list.size()];
            int i=0;
            for( SQL_Q q : temp_list )
            {
                codes[i] = q.getCode();
                questions[i] = q.getQuestion();
                category[i] = q.getCategory();
                i++;
            }
            HttpSession s = request.getSession();
            s.setAttribute("codes", codes);
            s.setAttribute("questions", questions);
            s.setAttribute("category", category);
            response.sendRedirect("Delete.jsp");
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
