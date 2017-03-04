
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

@WebServlet(urlPatterns = {"/Run_game"})
public class Run_game extends Game {
    Q_collection user_collection; Q_collection Qc_t; boolean new_game;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        load(); String s; s="";
        String userName;
        if( request.getParameter("enter") == null )
        {
            new_game = false;
            if( request.getParameter("previous") != null )
            {
                userName = request.getParameter("previous");
            }
            else
            {
                userName = "no user name been entered";
            }
        }
        else
        {   
            new_game = true;
            userName = request.getParameter("enter");
        }
        if( new_game )
        { 
            if( Qc_t != null && !Qc_t.is_Empty() ){ user_collection = Qc_t.duplicate();}
            else{   user_collection = new Q_collection();   }
            save_game(); s="new Game";
        }
        else{   load_game();   }
        DefaultPrint p = new DefaultPrint();
        save_game();
        p.Head(request, response);
        p.Menu(request, response);
        String emp="";
        out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
        out.println("<form method=\"Get\" action=\"Run_Question\" id=\"formA\">");
        out.println("<h1> pick a Category </h1>");
        out.println("<p>"+s+" "+userName+"<p>");
        String[] subjects = user_collection.get_subjects();
        if( subjects.length < 1 || user_collection.is_Empty())
        {   emp="There are no questions left log as admin and add questions";    }
        else
        {
            for (String subject : subjects) 
            {
                out.println("<div id=\"category\" style=\"float: left\">");
                out.println("<img src=\"Images/"+subject+".png\" alt=\""+subject+"\"> - "+subject+"");
                out.println("<input type=\"checkbox\" name=\"category\" value=\""+subject+"\">");
                out.println("</div>");
            }
        }
        out.println("<p>"+emp+"</p>");
        out.println("<div style=\"width: 100%; float: left\">");
        out.println("<p>Difficulty?</p>");
        out.println("<input type=\"radio\" name=\"difficulty\" value=\"Easy\">Easy");
        out.println("<input type=\"radio\" name=\"difficulty\" value=\"Medium\">Medium");
        out.println("<input type=\"radio\" name=\"difficulty\" value=\"Hard\">Hard<br><br>");
        out.println("<input type=\"hidden\" name=\"uName\" form=\"formA\" value=\""+userName+"\">");
        out.println("<input type=\"submit\" name=\"submit\" form=\"formA\"  value=\"submit\">");
        out.println("</div>");
        out.println("</form>");  
        out.println("</div>");  
        p.Bottom(request, response);
    }
    
    @Override
    public void load()
    {
        try
        {
            FileInputStream FIS = new FileInputStream(getServletContext().getRealPath("Save")+"List.dat");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            this.Qc_t = (Q_collection)OIS.readObject();
        }
        catch (IOException | ClassNotFoundException | InputMismatchException e)
        {
            this.Qc_t = new Q_collection();
        }
        finally
        {}
    }
    
    public void load_game()
    {
        try
        {
            FileInputStream FIS = new FileInputStream(getServletContext().getRealPath("Save")+"List_game.dat");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            this.user_collection = (Q_collection)OIS.readObject();
        }
        catch (IOException | ClassNotFoundException | InputMismatchException e)
        {
            this.user_collection  = new Q_collection();
        }
        finally
        {}
    }
    
    public void save_game()
    {
        try
        {
            FileOutputStream FOS = new FileOutputStream(getServletContext().getRealPath("Save")+"List_game.dat");
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(this.user_collection);
        }
        catch( IOException e )
        {
            save_verdict="Save been unsuccessful";
        }
        finally{}
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
