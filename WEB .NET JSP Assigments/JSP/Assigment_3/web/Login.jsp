<%-- 
    Document   : Login
    Created on : 23-Jan-2016, 15:12:26
    Author     : Shb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log-in</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body style="text-align: center">
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">
            <% 
                HttpSession s = request.getSession();
                out.print(s.getAttribute("uN"));
            %> Game!
        </h1>
        <a href="LoginS?new_user=new">Log in as someone else</a>
        <br><br>
        <%
           if( s.getAttribute("uN").equals("admin")
                   && s.getAttribute("ps").equals("admin"))
           {
               %>   <a href="Add.jsp">Add a Question</a><br>
                    <a href="DeleteS">Delete Questions</a><br><%
           }
            %> <a href="Game?start=true">New Game</a> <%
        %>
    </body>
</html>
