
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/Game"})
public class Game extends HttpServlet {
    Q_collection Qc = new Q_collection(); String verdict; String save_verdict;
    String user;    boolean printed; String cookie;
    String address;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        DefaultPrint p = new DefaultPrint(); 
        this.address = getServletContext().getRealPath("Save")+"List_game.dat";      
        p.Head(request, response);
        p.Menu(request, response);
        load(); printed = false;
        save(); cookie ="";
        save_collection();
        
        if( request.getParameter("LogIn") != null )
        {   printLogIn(request, response); }
        if( request.getCookies() != null && request.getParameter("user_name") == null )
        {
            Cookie[] c = request.getCookies();
            for(int i=0; i<c.length; i++)
            {
                if( c[i].getName().equals("name"))
                {   this.user = c[i].getValue();    
                    printUser(request, response);   break;
                }
            }
        }
        if( request.getParameter("user_name") == null || request.getParameter("password") == null)
        { printLogIn(request, response);  }
        else
        {   if( request.getParameter("user_name").length()<1 || request.getParameter("password").length()<1)
            {  printLogIn(request, response); }
            else
            {
                if( request.getParameter("user_name").equals("admin") &&
                        request.getParameter("password").equals("admin"))
                {
                    printAdmin(request, response);
                }
                else
                {
                    if( request.getParameter("remember") != null )
                    {
                        Cookie c = new Cookie("name", request.getParameter("user_name"));
                        response.addCookie(c);
                        cookie="Coockie saved, User name will not change when you go to About or OtherGames links";
                    }
                    this.user = request.getParameter("user_name");
                    printUser(request, response);
                }
            }
        }
        p.Bottom(request, response);
        
    }
    
    protected void printLogIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(printed) return;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
        out.println("<form method=\"POST\" action=\"Game\">");
        out.println("<p>Type your new/old user name, Please fill ALL the fields</p>");
        out.println("User name : <input type=\"text\" name=\"user_name\"><br>");
        out.println("Password : <input type=\"password\" name=\"password\"><br>");
        out.println("<input type=\"radio\" name=\"remember\" value=\"remember\"> Remember me<br>");
        out.println("<input type=\"submit\" name=\"submit\" value=\"submit\">");
        out.println("</form>");
        out.println("</div>");
        printed = true;
    }
    
    protected void printAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(printed) return;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
            out.println("<form method=\"GET\">");
                out.println("<h1> Play the game... </h1>");
                out.println("<p>"+verdict+"</p>");
                out.println("<p>"+save_verdict+"</p>");
                out.println("<p>list is empty = "+Qc.is_Empty()+"</p><br>");
                out.println("<a href=\"Add_Questions?enter\">Add new Questions</a><br>");
                out.println("<a href=\"RemoveQuestion?enter\">Remove a Question</a><br>");
                out.println("<a href=\"Run_game?enter=new\">Run the Game</a>");
                out.println("<p>"+this.address+"</p>");
        out.println("</form>");
        out.println("</div>");
        printed = true;
    }
    
    protected void printUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(printed) return;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
            out.println("<form method=\"GET\">");
                out.println("<h1> Play the game... </h1>");
                out.println("<p>"+verdict+"</p>");
                out.println("<p>"+save_verdict+"</p>");
                out.println("<p>list is empty = "+Qc.is_Empty()+"</p><br>");
                out.println("<p>User name :"+user+"</p>");
                out.println("<p>"+cookie+"</p>");
                out.println("<a href=\"Run_game?enter="+user+"\">Run the Game</a>");
                out.println("<p>"+this.address+"</p>");
                out.println("<a href=\"Game?LogIn=true\">Log in as someone else</a>");
        out.println("</form>");
        out.println("</div>");
        printed = true;
    }
    
    
    public void load()
    {
        try
        {
            FileInputStream FIS = new FileInputStream(getServletContext().getRealPath("Save")+"List.dat");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            this.Qc = (Q_collection)OIS.readObject();
            verdict = "Load collection been successful";
        }
        catch (IOException | ClassNotFoundException | InputMismatchException e)
        {
            this.Qc = new Q_collection();
            verdict= "Load Failed, new Collection created";
        }
        finally
        {}
    }
    
    public void save()
    {
        try
        {
            FileOutputStream FOS = new FileOutputStream(getServletContext().getRealPath("Save")+"List.dat");
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(this.Qc);
            save_verdict="Save been successful";
        }
        catch( IOException e )
        {
            save_verdict="Save been unsuccessful";
        }
        finally{}
    }
    
    public void save_collection() throws IOException
    {
        Qc.Save_Collection(this.Qc);
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
