
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
        
@WebServlet(urlPatterns = {"/About"})
public class About extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        DefaultPrint p = new DefaultPrint();
        p.Head(request, response);
        p.Menu(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
            out.println("<h1 style=\"text-decoration: underline\">About the game</h1>");
            out.println("<p>The Name of the Editor of this project is Shay butbul</p>");
            out.println("<p>A student in Netanya college student of Computer science</p>");
            out.println("<p>Thank you for using this Trivia Game</p><br>");
            out.println("<p style=\"color: red; text-decoration: underline\">");
            out.println("In order to delete or create new questions user need to log as admin username=\"admin\" password=\"admin\"</p>");
            out.println("<p>Log with any other name and it will show you the name on the result board</p>");
            out.println("<p>by clicking REMEMBER ME cookie will be saved and the user name will be there</p>");
            out.println("<p>when or if the user leave the page</p>");
        out.println("</div>");        
        p.Bottom(request, response);
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
