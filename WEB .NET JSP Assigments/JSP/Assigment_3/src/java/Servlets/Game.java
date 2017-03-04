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
@WebServlet(name = "Game", urlPatterns = {"/Game"})
public class Game extends HttpServlet {

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
        if( request.getParameter("start") != null )
        {
            runCategoris(request, response, "NewGame.jsp?pick=true");
            return;
        }
        if( request.getParameter("after_pick") != null )
        {
            if( request.getParameter("category") == null ||
                    request.getParameter("difficulty") == null)
            {
                request.getSession().setAttribute("wrong", "true");
                runCategoris(request, response, "NewGame.jsp?pick=true");
                return;
            }
            UserDB user = new UserDB();
            String[] categoris = request.getParameterValues("category");
            int difficulty = Integer.parseInt(request.getParameter("difficulty"));
            List<SQL_Q> temp = user.get_manyQ_Category_difficulty(categoris, difficulty);
            Q_collection Q_c = new Q_collection();
            for( SQL_Q q : temp )
            {
                Q_c.add_question(q.to_bat_Question());
            }
            request.getSession().setAttribute("collection", Q_c);
            response.sendRedirect("NewGame.jsp");
        }
        if( request.getParameter("game_take_place") != null )
        {
            String ans = "null";
            if( request.getParameter("Answer") != null )
            {
                ans = request.getParameter("Answer");
            }
            Question q = (Question)request.getSession().getAttribute("the_question");
            boolean correct = q.getAnswer().equals(ans);
            Q_collection q_c = (Q_collection)request.getSession().getAttribute("collection");
            q_c.CollectionScore.Add_score(q, correct);
            request.getSession().setAttribute("collection", q_c);
            String result = "wrong!";
            if( correct ){  result = "correct"; }
            request.getSession().setAttribute("result", result);
            response.sendRedirect("Score_page.jsp");
        }
    }
    
    protected void runCategoris(HttpServletRequest request, HttpServletResponse response,String address)
            throws ServletException, IOException
    {
        UserDB user = new UserDB();
        List<SQL_Q> temp = user.get_ALL_questions();
        Q_collection Q_C = new Q_collection();
        for( SQL_Q q : temp )
        {
            Q_C.add_question(q.to_bat_Question());
        }
        request.getSession().setAttribute("collection", Q_C);
        response.sendRedirect(address);
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
