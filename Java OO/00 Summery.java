Basics
{
->	Types (byte -> short -> int -> long -> float -> double)
	Types (char -> String)    Types (boolean)
->	(inside {}) Local/Instance   (out of {}) Class/Static/final
->	Operators : (+,-,*,/,%,++,-) , (==,!=,>,<,>=,<=) , (&&,||,!)
				 (>>,<<,>>>>,~,&,^,|) , (=,+=,-=,*=,/=,%=,>>=,&=,^=,|=)
->	Keywords : abstract,assert,break,case,catch,const,continue,default,do
				else,enum,extends,final,finally,for,goto,if,implements,import
				instanceof,interface,native,new,package,private,protected,throws
				try,volatile,while,transient,synchronized
->	Class types : Encapsulation,Inheritance,Polymorphism,Abstraction
	class X extends Y extends Z /* Z is abstract (has full functions and signatures doesn't force them on subClass) */
	class X implements F /* F is an interface (has only functions signature force on subClass to have all the functions) */
}
interface
{
	import java.lang.*;
	access interface_name{
		return-type method1(parameter list);
		return-type method2(parameter list);
		type final-varName1=value;
	}
	//_____JAVA program__________//
	import java.util.*;
	import java.lang.*;
	import java.io.*;
	
	interface shapeX
	{
		public String base="shape1";
		public void Draw();
	}
	interface shapeY extends shapeX
	{
		public String base="shape2";
		public void Draw2();
	}
	class shapeG implements shapeY
	{
		public String base="shape3";
		public void Draw() {
		System.out.println("Drawing Circle here:"+base);
	}}
	
	@Override
	public void Draw2() {
	   System.out.println("Drawing Circle here:"+base);
	}
	
	public class Main {
		public static void main(String[] args) {
		shapeG circleshape=new shapeG();
		circleshape.Draw();
		circleshape.Draw();
	}
	}
}
Packages
{
	import package1.package2.....
	// file 1
	package weapons;
	interface ammo { method A,B..... }
	
	// file 2
	package weapons;
	public class arms implements Ammo{ must have methods A,B..... }
	
	// Bash
	$javac -d .  file1.java
	$javac -d . file2.java
}
Aggregation
{
	class Student{
		....
	}
	
	class college{
		public void move(){...}
	}
	
	class univ extends college{
		public void move(){ ... }
	}
	
	public static void main(String args[])
	{
		college a = new college();
		college b = new univ();
		a.move();
		b.move();
   }
}
enum, enumeration
{
	enum month{ jan,feb,apr }
	
	enum Xox{ Bx,Cx,Ax }
	
	Xox myEnu;
	myEnu = Xox.Bx;
	
	public static enum-type[ ] values()
	public static enum-types valuesOf (string str)
}
enum example
{
	enum PLtypes {
		highlevel, machinelevel, assembly, middlelevel
	}
	class enum {
		public static void main(String args[]) {
			PLtypes lang;
			System.out.println(" Here are lists of constants");
			PLtypes alltypes[] = PLtypes.values();
			for (PLtypes a: alltypes)
				System.out.println(a);
			System.out.println();
			lang = PLtypes.valueOf("assembly");
			System.out.println("Value is:" + lang);
		}
	}
}
for
{
	for(int a: numbers){ print a }
}
Exception
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, InputMismatchException{
		...........}
	// on every method that it might happen in
	IOException
	ClassNotFoundException
	InputMismatchException
}
Scan from keyboard
{
	public int scan_int(int min, int max) /*insert 0~n-1*/
    {
        Scanner scan_n = new Scanner(System.in);
        int num = min -1;
        while( num < min || num > max )
        {
            try
            {
                num = scan_n.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please type a number...");
                scan_n.next();
            }
            finally
            {
                if( num < min || num > max )
                {
                    System.out.println("Please enter a number between "+min+" ~ "+max);
                }
            }
        }
        return num;
    }
}
save object to file
{
	FileOutputStream FOS = new FileOutputStream("List.dat");
    ObjectOutputStream OOS = new ObjectOutputStream(FOS);
    OOS.writeObject(object);
}
load object from file
{
	Project_One methods = new Project_One();
	Q_collection Q_c;
	try
	{
		FileInputStream FIS = new FileInputStream("List.dat");
		ObjectInputStream OIS = new ObjectInputStream(FIS);
		Q_c = (Q_collection)OIS.readObject();
	}
	catch (IOException e)
	{
		Q_c = new Q_collection();
		System.out.println("no list file was found, stats new list");
	}
	finally{}
}
servelet
{
	import java.io.IOException;
	import java.io.PrintWriter;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import java.util.*;
	import java.io.*;

	@WebServlet(urlPatterns = {"/ServletFileName"})
	public class Run_game extends Game 
	{	
		protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			if( request.getParameter("enter") == null )
			{
				if( request.getParameter("previous") != null )
				{ ....... }
			}
			else{   load_game();   }
			DefaultPrint p = new DefaultPrint();
			p.Head(request, response);
			p.Menu(request, response);
			if( error ...){ out.println("<h1>ERROR!</h1>"); }
			p.Bottom(request, response);
		}
		
		@Override
		public void load()
		{		// run automatically when servlet get called
			try{ ..... }
			catch (IOException | ClassNotFoundException | InputMismatchException e){ .... }
			finally
			{}
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

}
servlet RESPONSE
{
	response.sendRedirect("Login.jsp");
}
JSP
{
	<%-- 
    Document   : ErrorPage
    Created on : 23-Jan-2016, 22:35:47
    Author     : Shb
	--%>
	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<html ....
	<body style="text-align: center">
        <% if( request.getParameter("success") != null )
        { %> <p> <% out.print("somthing"); %> </p> <% } %>
	
	// if( request.getParameter("type") != null )
	// HttpSession s = request.getSession();
	// if( s.getAttribute("uN").equals("admin") )
	// out.print(s.getAttribute("uN"));
	
		// nevagation to Servelet LoginS, with request new_user=new
	<a href="LoginS?new_user=new">Log in as someone else</a>
}
cookies / session
{
	request.getSession().setAttribute("uN", uName);
    request.getSession().setAttribute("ps", Password);
	
	
	Cookie c = new Cookie("cName", uName);
    response.addCookie(c);
}
DB in Servlet
{
	
}
DB Agent
{
	
}
DB SQL format, has to fit fields in columns
{
}