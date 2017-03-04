
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

@WebServlet(urlPatterns = {"/Run_Question"})
public class Run_Question extends Run_game {
    Q_collection questions; String s; String uName;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {   /*request.getParameter("subject")*/
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        s="";
        load_game();
        DefaultPrint p = new DefaultPrint();
        p.Head(request, response);
        p.Menu(request, response);
        if( request.getParameter("uName") == null )
        {
            this.uName = "No user name been found";
        }
        else
        {
            this.uName = request.getParameter("uName");
        }
        if( request.getParameter("answer") != null )
        {
            got_Answer(request, response);
        }
        else
        {
            if( request.getParameter("category") == null || request.getParameter("difficulty") == null )
            {
                Error(request, response);
            }
            else
            {
                writeQuestion(request, response);
            }
        }

        p.Bottom(request, response);
    }
    
    protected void got_Answer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String answ = request.getParameter("answer");
        String code = request.getParameter("code");
        String result = " Wrong!!";
        if( answ.equals(this.questions.get_Answer_by_code(code)))
        {
            result = "Correct!!";
            this.questions.CollectionScore.Add_score(this.questions.get_question_by_code(code), true);
        }
        else
        {
            this.questions.CollectionScore.Add_score(this.questions.get_question_by_code(code), false);
        }
        this.questions.delete_by_code(code);
        save_game();
        out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
        out.println("<form method=\"Get\">");
        out.println("<p>Answer was : "+result+"</p>");
        out.println("<p>Score : "+this.questions.CollectionScore.get_score()+" User name : "+uName+"</p>");
        out.println("<a href=\"Run_game?previous="+uName+"\">Go back</a>");
        out.println("<p> Questions answered </p>");
        String[] questions_ = this.questions.CollectionScore.get_Log();
        for(int i=0; i<questions_.length; i++)
        {
            out.println("<p>"+questions_[i]+"</p>");
        }
        out.println("</form>");
        out.println("</form>");
        out.println("</div>");
    }
    
    protected void Error(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
        out.println("<form method=\"Get\">");
        out.println("<p>Error there are either no more questions left on these subjects on that difficulty level</p>");
        out.println("<p>Or some of the fields in the previous page were left unchecked</p>");
        out.println("<a href=\"Run_game?previous="+uName+"\">Go back</a>");
        out.println("</form>");
        out.println("</div>");     
    }
    
    @SuppressWarnings("null")
    protected void writeQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String[] subjects = request.getParameterValues("category");
        String diff = request.getParameter("difficulty");
        Difficulty diffc;
        if( diff.equals("Easy")){   diffc = new Difficulty(1);  }
        else{   if(diff.equals("Medium")){  diffc = new Difficulty(2);  }
        else { diffc = new Difficulty(3);   }   }
         Question temp = null; boolean s_t; s_t = true; 
        if( !this.questions.Still_got_questions_subject_difficulty(subjects, diffc))
        {
            Error(request, response); return; 
        }
        try
        {
            temp = this.questions.Question_from_subjects_with_diff(subjects, diffc);
        }
        catch(NullPointerException ex)
        {
            s_t = false;
        }
        finally{}
        if( !s_t ){ Error(request, response); return; }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
        out.println("<h1>Question number : "+temp.getCode()+"</h1>");
        out.println("<p>"+temp.toString()+"</p>");
        out.println("<form method=\"GET\" id=\"qForm\" action=\"Run_Question\">");
        out.println("<input type=\"hidden\" name=\"code\" value=\""+temp.getCode()+"\">");
        out.println("<input type=\"hidden\" name=\"uName\" value=\""+uName+"\">");
        if(temp.get_my_Type() == 1)
        {
            out.println("<textarea rows=\"3\" cols=\"25\" wrap=\"hard\" style=\"width: 200px; height: 50px;\"");
            out.println("form=\"qForm\" name=\"answer\"></textarea><br><br>");
            out.println("<input type=\"submit\" name=\"submit\" value=\"submit\">");
        }
        else
        {
            if(temp.get_my_Type() == 2)
            {
                String[] ans = temp.get_complex_Answers();
                for(int i=0; i<ans.length;i++)
                {
                    out.println("<input type=\"radio\" name=\"answer\" value=\""+ans[i]+"\">"+ans[i]+"<br>");
                }
                out.println("<br><br>");
                out.println("<input type=\"submit\" name=\"submit\" value=\"submit\">");
            }
            else
            {
                out.println("<input type=\"radio\" name=\"answer\" value=\"YES\">Yes");
                out.println("<input type=\"radio\" name=\"answer\" value=\"NO\">No");
                out.println("<br><br>");
                out.println("<input type=\"submit\" name=\"submit\" value=\"submit\">");
            }
        }
        out.println("</form>");
        out.println("</div>");
    }
    
    @Override
    public void load_game()
    {
        try
        {
            FileInputStream FIS = new FileInputStream(getServletContext().getRealPath("Save")+"List_game.dat");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            this.questions = (Q_collection)OIS.readObject();
            s="Load successfuly";
        }
        catch (IOException | ClassNotFoundException | InputMismatchException e)
        {
            this.questions  = new Q_collection();
            s="Load unsuccessfuly";
        }
        finally
        {}
    }
    
    @Override
    public void save_game()
    {
        try
        {
            FileOutputStream FOS = new FileOutputStream(getServletContext().getRealPath("Save")+"List_game.dat");
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(this.questions);
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
