
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Question_open"})
public class Question_open extends Game {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DefaultPrint p = new DefaultPrint();
        p.Head(request, response);
        p.Menu(request, response);
        out.println("<div style=\"width: 80%; float: right; text-align: center; height: 900px;\">");
            out.println("<form method=\"POST\" action=\"Question_checkSave\" id=\"qForm\">");
            out.println("<div style=\"width: 50%; float: left; text-align: center; height: 900px;\">");
                out.println("<input type=\"hidden\" name=\"idd\" value=\"Open_Question\">");
                out.println("<h1>Pick a subject</h1><br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"Math\">Math<br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"History\">History<br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"Politics\">Politics<br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"Literature\">Literature<br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"Science\">Science<br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"Movies\">Movies<br>");
                    out.println("<input type=\"radio\" name=\"subject\" value=\"Animals\">Animals<br>");
                out.println("<h1>Pick a difficulty level</h1><br>");
                    out.println("<input type=\"radio\" name=\"Difficulty\" value=\"Hard\">Hard<br>");
                    out.println("<input type=\"radio\" name=\"Difficulty\" value=\"Medium\">Medium<br>");
                    out.println("<input type=\"radio\" name=\"Difficulty\" value=\"Easy\">Easy<br>");
                    out.println("<br><br>");
                out.println("<center><input type=\"submit\" name=\"submit\" value=\"submit\"></center>");
            out.println("</div>");
            out.println("<div style=\"width: 50%; float: right; text-align: center; height: 900px;\">"); 
                    out.println("<h1>Type the question</h1><br>");
                    out.println("<textarea rows=\"3\" cols=\"25\" wrap=\"hard\" style=\"width: 200px; height: 50px;\"");
                        out.println("form=\"qForm\" name=\"question\"></textarea><br>");
                    out.println("<h1>Type the Answer</h1><br>");
                    out.println("<textarea rows=\"3\" cols=\"25\" wrap=\"hard\" style=\"width: 200px; height: 50px;\"");
                        out.println("form=\"qForm\" name=\"answer\"></textarea><br>");
            out.println("</div>");
            out.println("</form>");
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
