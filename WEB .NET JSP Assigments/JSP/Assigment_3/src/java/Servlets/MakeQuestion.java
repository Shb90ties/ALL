/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shb
 */
@WebServlet(name = "MakeQuestion", urlPatterns = {"/MakeQuestion"})
public class MakeQuestion extends HttpServlet {
    String[] answers; String answer;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        if( !normal_fields_check(request, response) || !answer_fields_check(request, response))
        {
            response.sendRedirect("ErrorPage.jsp?type="+request.getParameter("type"));
            return;
        }
        Random rand = new Random();
        String code = Integer.toString(rand.nextInt(5000)+1000);
        SQL_Q temp = new SQL_Q(code, Integer.parseInt(request.getParameter("type")), 
                Integer.parseInt(request.getParameter("difficulty")),
                request.getParameter("Question"), request.getParameter("category"));
        UserDB user = new UserDB();
        while( !user.addSQL_Q(temp) )
        {
            code = Integer.toString(rand.nextInt(5000)+1000);
            temp.setCode(code);
        }
        if( !request.getParameter("type").equals("2") )
        {
            SQL_A temp_ans = new SQL_A(code, Integer.parseInt(request.getParameter("type")), answer);
            user.addSQL_A(temp_ans);
        }
        else
        {
            for(String i : answers)
            {
                SQL_A temp_ans = new SQL_A(code, Integer.parseInt(request.getParameter("type")), i,
                   Integer.parseInt(request.getParameter("index")) );
                user.addSQL_A(temp_ans);
            }
        }
        response.sendRedirect("ErrorPage.jsp?success=true");
    }
    
    protected boolean normal_fields_check(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if( request.getParameter("category") == null ){ return false; }
        if( request.getParameter("difficulty") == null ){ return false; }
        if( request.getParameter("Question") == null){ return false; }
        else{   if ( request.getParameter("Question").equals("")
                || request.getParameter("Question").trim().equals("") ){ return false; } }
        return true;
    }
    
    protected boolean answer_fields_check(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if( request.getParameter("type").equals("1"))
        {
            if( request.getParameter("Answer") == null){ return false; }
            else{   if ( request.getParameter("Answer").equals("")
                            || request.getParameter("Answer").trim().equals("") ){ return false; } }
            this.answer = request.getParameter("Answer");
            return true;
        }
        if( request.getParameter("type").equals("3") )
        {
            if(request.getParameter("Answer") == null){ return false; }
            this.answer = request.getParameter("Answer");
            return true;
        }
        return options_answer_check(request, response);
    }
    
    protected boolean options_answer_check(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if( request.getParameter("index") == null ){ return false; }
        boolean previous_empty = false;
        if( request.getParameter("Answer") == null){ return false; }
        String[] answers = request.getParameterValues("Answer");
        List<String> temp = new ArrayList<>();
        for(int i=0; i < answers.length; i++)
        {
            if( answers[i].trim().equals(""))
            {
                if( i < 2 ){ return false; }
                previous_empty = true;
            }
            else
            {
                if( previous_empty ){ return false; }
                temp.add(answers[i]);
            }
        }
        int index = (Integer.parseInt(request.getParameter("index")))-1;
        answers = new String[temp.size()]; int count =0;
        for( String i: temp ){ answers[count] = i; count++; }
        if(index >= answers.length){ return false; }
        this.answers = answers;
        return true;
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
