
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/DefaultPrint"})
public class DefaultPrint extends HttpServlet {

    protected void Head(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Trivia Game</title>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Styles/styles.css\">");
            out.println("</head>");
            out.println("<body>");
                out.println("<div id=\"header\">");
                    out.println("<img src=\"Images/Banner.png\" alt=\"Banner\" align=\"left\">");
                    out.println("<h1>A Trivia Game!!</h1>");
                out.println("</div>");        
    }
    
    protected void Menu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<div>");
            out.println("<div style=\"width: 20%; float: left; text-align: center; background: papayawhip; height: 900px;\">");
                out.println("<h1 style=\"text-decoration: underline\">Menu</h1>");
                out.println("<form method=\"GET\">");
                    out.println("<a href=\"About?enter\">About</a><br><br>");
                    out.println("<a href=\"Other_Games?enter\">Other Trivia games</a><br><br>");
                    out.println("<a href=\"Game?enter\">New Game</a>");
                out.println("</form>");
        out.println("</div>");
    }
    
    protected void Bottom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                out.println("</div>");
                    out.println("<div id=\"bottom\">");
                        out.println("© Copyright Shay Butbul");
                    out.println("</div>");
            out.println("</body>");
        out.println("</html>");
        
    }
    
    /**
     *
     * @param address
     * @return
     */
    public String shortPath(String address)
    {
        String temp = ""; boolean over=false;
        char[] addrss = address.toCharArray();
        for(int i=0; i<addrss.length;i++ )
        {
            temp += addrss[i];
            if( over ){ break; }
            if( addrss[i] == '2'){  over = true;    }
        }
        return temp;
    }

}
