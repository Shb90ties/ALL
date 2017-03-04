
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/RemoveQuestion"})
public class RemoveQuestion extends Game {
    String[] _questions; Q_collection Qc_t;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DefaultPrint p = new DefaultPrint();
        p.Head(request, response);
        p.Menu(request, response);
        load();
        String s = "not empty";
        if( this.Qc_t != null )
        {
            if(this.Qc_t.is_Empty())
            {
                s="EMPTY!";
            }
            else{   s="EMPTY!"; }
        }
        if( request.getParameterValues("Question") == null )
        {
            out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
            out.println("<form method=\"POST\" action=\"RemoveQuestion\" id=\"Remov\">");
            out.println("<h1>Pick Questions you want to delete</h1>");
            out.println("<p>No Question been selected...Collection List = "+s+"</p><br>");
            if( this.Qc_t != null && !this.Qc_t.is_Empty() )
            {
                Question[] temp = Qc_t.get_Q_Collection();
                for(int i=0; i<temp.length;i++)
                {
                    out.println("<input type=\"checkbox\" name=\"Question\" value=\""+temp[i].getCode()
                            +"\">"+(i+1)+")"+temp[i].toString()+" Code:"+temp[i].getCode()+" Subject:"+
                            temp[i].get_Subject()+"<br>");
                }
            }
            out.println("<center><input type=\"submit\" name=\"submit\" value=\"submit\"></center>");
            out.println("</form>");
            out.println("</div>");
        }
        else
        {
            String[] qstns = request.getParameterValues("Question");
            for (String qstn : qstns) 
            {
                this.Qc_t.delete_by_code(qstn);
            }
            save();
            out.println("<div style=\"width: 80%; float: right; text-align: left; height: 900px; overflow: scroll\">");
            out.println("<p>Questions were removed </p><br>");
            out.println("</div>");
        }
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
