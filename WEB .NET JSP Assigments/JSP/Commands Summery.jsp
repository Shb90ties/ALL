__________Basic Internet Key Lines__________
.............................................
//structure//
	keep track of users in the system
	in users database table there will be a logged in Column
	when logs if logged in = false
	remove his row and add A new one with logged in = true,
	give also option for log out

//basics//
Integer.toString(number)
Integer.parseInt(String)
// putting int and not String into session can cause problems //
	// put String = "0" to session
insert newly made String for a method
	new String[]{"how ",id,"exists"}
print error with an array
//command//......................................................//
printError(request, response, new String[]{"how ",id,"exists"});
//method//.......................................................//
    protected void printError
	(HttpServletRequest request, HttpServletResponse response,String[] print)
	throws ServletException, IOException
    {
        try (PrintWriter out = response.getWriter()) 
        {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");            
                out.println("</head>");
                out.println("<body style=\"text-align: center\">");
                for(String s : print)
                {
                    out.println("<h1>"+s+"</h1>");
                }
                out.println("</body>");
                out.println("</html>"); 
        }
    }
	
	
//.............................................................//

// Forms //
	<textarea rows="3" cols="25" wrap="hard"
		style="width: 200px; height: 50px;" 
			form="form1" name="Answer"></textarea>
	<input type="radio" name="index" value="<%=i%>">
		// Radio buttons of the same group will have the same name
			//and only one can be picked
				// for multiple picks, checkbox type
	<input type="hidden" name="type" value="<%=type%>" form="form1">
		// hidden must have the form name
	<input type="submit" name="submit" value="Answer it" form="form1">
										//^ the name of the button
	

	// request parameter with " " not with ' ' // 
Integer.parseInt(request.getParameter("type"));
!request.getParameter("type").equals("2");
request.getParameterValues("Answer");
request.getParameterValues("Answer").trim().equals("");
String[] answers = request.getParameterValues("Answer");
if( request.getParameter("picked_questions") )
{
	String[] codes = request.getParameterValues("picked_questions");
}


	// move from Servlets to JSP //

response.sendRedirect("Score_page.jsp");
response.sendRedirect("ErrorPage.jsp?success=true");
					// with values ^
					
	// check if text was null or empty //	
( request.getParameter("Question").equals("")
	|| request.getParameter("Question").trim().equals("") )

// Get from session //

HttpSession session = request.getSession();
Integer accessCount = (Integer)session.getAttribute("accessCount");
object accessCount = (object)session.getAttribute("object");
request.getSession().setAttribute("object", object);

// Set from session //

request.getSession().setAttribute("object", object);

	// update session //
	
	request.getSession().removeAttribute("object");
	request.getSession().setAttribute("object", object);
	
// in JSP page //
	// import above the page //
	<%@page import="Servlets.*"%>
					// package ^
					// methods must be public
	// to use classes MUST import the package //
	// if posting the value of an object in the html //
	<%=number%>
	<%=String%>
	<%=request.getSession().getAttribute("uN")%>
	
	<% Java code %>
	
	<%	for(int i=1; i<=5;i++){
        %> <input type="radio" name="index" value="<%=i%>"> <%=i%> <% }
        }else{	%>
//......................................................................//
// CSS files //
	// include it //
	<link rel="stylesheet" type="text/css" href="Styles/styles.css">
		// needs to be in the 'Web Pages' folder
		// in the WEB-INF/jsp/index.jsp , 	won't work!
a
{
	text-decoration: none;
}
a:hover
{
	text-decoration: underline;
}
h1
{
	color or something
}
//Class//
#DivClassName
{
	.....
}
#DivClassName : hover
{
	.....
}
//........................................................................//

// cookie //..............................................................//
	Cookie c = new Cookie("cName", uName);
	response.addCookie(c);
	for(int i=0; i < request.getCookies().length; i++)
    {
		if( request.getCookies()[i].getName().equals("cName"))
		{
			cName = request.getCookies()[i].getValue();
            break;
         }
    }
//.........................................................................//
// Get form SQL //

//Make Table example //
	CREATE TABLE students
	(
		id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY 
		(START WITH 1, INCREMENT BY 1),
		name VARCHAR(24) NOT NULL,
		address VARCHAR(1024),
		CONSTRAINT primary_key PRIMARY KEY (id)
	);
	// another example//.................................................//
	CREATE TABLE Questions
	(
		num INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY 
		(START WITH 1, INCREMENT BY 1),
		question VARCHAR(100) NOT NULL UNIQUE,
        typ INTEGER NOT NULL,
        answer1 VARCHAR(100) NOT NULL,
        answer2 VARCHAR(100),
		answer3 VARCHAR(100),
        index INTEGER
	);

List<SQL_Q> temp = user.get_ALL_questions();
// if table got an auto increment row command for statement should be like this... //
pStatement = connection.prepareStatement("INSERT INTO ROOT.QUESTIONS (QUESTION, TYP, ANSWER1, ANSWER2, ANSWER3, INDEX) VALUES (?, ?, ?, ?, ?, ?)");


UserDB user = new UserDB();
	while( !user.addSQL_Q(temp) )
		// in addSQL_Q if catch exception return false

//.......................................................................//
        Row[] list = SQL.getAllRows();
        String[] rows = new String[list.length]; int i=0;
        for(Row r : list)
        {
            rows[i] = r.toString();
            i++;
        }
        printError(request, response, rows);
//.......................................................................//