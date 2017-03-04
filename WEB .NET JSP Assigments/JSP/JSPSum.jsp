בסיסי

	Integer.toString(number)
	Integer.parseInt(String)
	הערות
	// Session can't read int convert the int to String then
		// put it on session then convert it back to int
			// can be any object and array[] תנסה אצלי היה בעיה עם Int
	
הדפסת שגיאה
	דוגמא לקריאה
		String id,FormerPage;
		printError(request, response, new String[]{"this is",id,"is wrong",FormerPage});
		return;		// exit the session
	שיטה
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
						לרשום פה הוספה של קריאה שמחזירה לעמוד הקודם
						מקבל את השם של העמוד במערך
						out.println("</body>");
						out.println("</html>"); 
				}
			}

Session
	זיהוי אובייקט לפי השם שניתן לו בהכנסה
	הכנסת נתונים
		request.getSession().setAttribute("Object Name in session", object);
	עדכון נתונים
		request.getSession().removeAttribute("Object Name in session");
		request.getSession().setAttribute("Object Name in session", object);
	לקיחת נתונים
		HttpSession sessionX = request.getSession();
		String accessCount = (String)sessionX.getAttribute("accessCount");
		object accessCount = (object)sessionX.getAttribute("Object Name in session");
		
***		קצר יותר
		type accessCount = (type)request.getSession().getAttribute("Object Name in session");
		דוגמא
		String accessCount = (String)request.getSession().getAttribute("accessCounting");
		דוגמא ב
		Questions[] doneQuestions = (Questions[])request.getSession().getAttribute("FormerQuestionsArray");

in JSP file
	לקבלת הערך של אובייקט שיוצג בעמוד
		<%=number%>
		<%=String%>
		<%=request.getSession().getAttribute("uN")%>
	להכנסת קוד
	<%	for(int i=1; i<=5;i++){
        %> <input type="radio" name="index" value="<%=i%>"> <%=i%> <% }
        }else{	%>
CSS
	הכרזה על שימוש בקבוץ בעמוד
	בתוך <head>
		<link rel="stylesheet" type="text/css" href="Styles/styles.css">
												// ^ css file location
		</head>
Request
	פשוט
	request.getParameterValues("Answer");
	למחרוזת מ- textbox
		// for requests from TextBox, after checking that its not null
			// check if the String is empty
	if(request.getParameterValues("Answer").trim().equals(""))
		{ then its empty }
	לקיחה מ-checkbox
	או כל דבר שם אחר שיש לו כמה ערכים
	String[] answers = request.getParameterValues("Answer");

Forms
		<textarea rows="3" cols="25" wrap="hard"
		style="width: 200px; height: 50px;" 
			form="form1" name="Answer"></textarea>
		<input type="radio" name="index" value="<%=i%>">
		
		// put info in Request with java code
		<input type="hidden" name="type" value="<%=Object in java%>" form="form1">
											// ^
Cookies
	הכנס חדש למחשב של המשתמש
	Cookie c = new Cookie("cName", String);
	response.addCookie(c);
	לקיחה או בדיקה שיש לו
		// check if user has a cookie named 'cName'
	for(int i=0; i < request.getCookies().length; i++)
    {
		if( request.getCookies()[i].getName().equals("cName"))
		{
			cName = request.getCookies()[i].getValue();
            break;
			// user got the cookie already visited this site
         }
    }

	
