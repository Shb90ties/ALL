
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Other_Games"})
public class Other_Games extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String s = request.getParameter("site");
        PrintWriter out = response.getWriter();
        DefaultPrint p = new DefaultPrint();
        p.Head(request, response);
        p.Menu(request, response);
        if( s == null )
        {
            out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
                out.println("<form method=\"GET\" action=\"Other_Games\">");
                    out.println("<a href=\"Other_Games?site=http://www.triviaplaza.com/\">");
                        out.println("Trivia PlazA! </a><br>");
                    out.println("<a href=\"Other_Games?site=http://www.funtrivia.com/\">");
                        out.println("Fun Trivia </a><br>");
                    out.println("<a href=\"Other_Games?site=http://www.vins.co.il/game/Trivia-king\">");
                        out.println("Trivia KING </a> ");
                out.println("</form>");
            out.println("</div>");
        }
        else
        {
            out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
                out.println("<iframe src=\""+s+"\"");
                    out.println("style=\"width: 100%; height: 900px\"></iframe>");
            out.println("</div>");
        }
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
