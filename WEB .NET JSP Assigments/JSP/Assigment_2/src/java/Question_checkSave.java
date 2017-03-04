
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

@WebServlet(urlPatterns = {"/Question_checkSave"})
public class Question_checkSave extends Game {
    int type; String typ; String[] ans; boolean yes; int correctAns; String tempErr; String code;
    Q_collection Qc_t;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        this.type = getType(request, response);
        tempErr = "";
        load();
        if( !Question_check(request,response) )
        {
            incorrent(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            DefaultPrint p = new DefaultPrint();
            p.Head(request, response);
            p.Menu(request, response);
            Add_Question(request, response);
            out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
                out.println("<p>The Question is now in the collection</p><br>");
                out.println("<p>Question code : "+this.code+"</p><br>");
                out.println("<div style=\"width: 100%; text-align: left; height: 600px; overflow: scroll\">");
                Question[] temp = Qc_t.get_Q_Collection();
                for(int i=0; i<temp.length;i++)
                {
                    out.println("<p>"+(i+1)+") "+temp[i].getCode()+" "+temp[i].toString()+" "+
                            temp[i].get_Subject()+" "+temp[i].getDifficulty()+"</p>");
                }
                out.println("</div>");
            out.println("</div>");
            p.Bottom(request, response); 
        }
    }
    
    protected void Add_Question(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String s = request.getParameter("Difficulty");
        Difficulty dif;
        if( s.equals("Hard")){  dif = new Difficulty(3); }
        else{   if(s.equals("Medium")){ dif = new Difficulty(2);    }
        else{   dif = new Difficulty(1);    }
        }
        if(type == 1)
        {
            Question temp = new Question(request.getParameter("question"),
                    request.getParameter("answer"), dif, request.getParameter("subject"));
            this.code = temp.getCode();
            this.Qc_t.add_question(temp);
            save();
        }
        else
        {
            if(type == 2)
            {
                Complex_Question temp = new Complex_Question(request.getParameter("question"),
                        this.ans, this.correctAns, dif, request.getParameter("subject"));
                this.code = temp.getCode();
                this.Qc_t.add_question(temp);
                save();
            }
            else
            {
                YesNo_Question temp = new YesNo_Question(request.getParameter("question")
                        , this.yes, dif, request.getParameter("subject"));
                this.code = temp.getCode();
                this.Qc_t.add_question(temp);
                save();
            }
        }
    }
    
    protected void incorrent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        DefaultPrint p = new DefaultPrint();
        p.Head(request, response);
        p.Menu(request, response);
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
            out.println("<h1 style=\"color: red\">Error not all the fields were filled</h1>");
            out.println("<form method=\"POST\" action=\""+typ+"\">");
                out.println("<a href=\""+typ+"\" >Go back</a>");
                out.println("<br><p>"+tempErr+"</p>");
            out.println("</form>");
        out.println("</div>");
        p.Bottom(request, response);
    }
    
    protected boolean Question_check(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if( request.getParameter("subject") == null )
        {
            return false;
        }
        if(request.getParameter("Difficulty") == null )
        {
            return false;
        }
        if(request.getParameter("question").length() < 1 )
        {
            return false;
        }
        return check_answer(request, response);
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
    @Override
    public void save()
    {
        try
        {
            FileOutputStream FOS = new FileOutputStream(getServletContext().getRealPath("Save")+"List.dat");
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(this.Qc_t);
        }
        catch( IOException e )
        {}
        finally{}
    }
    
    protected int getType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(request.getParameter("idd").equals("Open_Question"))
        {   this.typ="Question_open"; return 1;   }
        if(request.getParameter("idd").equals("Options_Question"))
        {   this.typ="Question_options"; return 2;   }
        this.typ="Question_YESNO"; return 3;
    }
    
    protected boolean check_answer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(type == 1)
        {
            if( request.getParameter("answer").length() < 1 ){ return false; }
            else
            {   return true;    }
        }
        if(type == 2)
        {
            this.ans = request.getParameterValues("answer");
            String[] temp = new String[0];
            int count;  count = 0;
            boolean[] exists = new boolean[5];
            for(int i=0; i<5;i++){  exists[i]=false;    }
            for(int i=0; i< ans.length;i++)
            {
                if(ans[i].length() > 0)
                {
                    count++;
                    temp = add(temp, ans[i]);
                    exists[i] = true;
                }
            }
            if( request.getParameter("ans")== null)
            {   return false;   }
            int ans_i = Integer.parseInt(request.getParameter("ans"));
            if( exists[ans_i-1] == false ){   tempErr="Answer miss-match"; return false;   }
            if( count >= 3 )
            {   
                for(int i=0; i<temp.length; i++)
                {   if( temp[i].equals(ans[ans_i-1])){ this.correctAns = i;   }   }
                this.ans = temp;    return true;
            }
            else
            {   return false;   }
        }
        if( request.getParameter("answer") == null )
        {
            return false;
        }
        else
        {
            if( request.getParameter("answer").equals("yes") )
            {   this.yes=true;  }
            else{   this.yes=false; }
            return true;
        }
    }
    
    private String[] add(String[] s,String w)
    {
        String[] temp = new String[s.length+1];
        for(int i=0; i<s.length;i++)
        {
            temp[i] = s[i];
        }
        temp[s.length] = w;
        return temp;
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
