<%-- 
    Document   : ErrorPage
    Created on : 23-Jan-2016, 22:35:47
    Author     : Shb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body style="text-align: center">
        <% if( request.getParameter("success") != null )
        { %>
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">SUCCESS!</h1>
        The question is now in the Database <%
        }
        else{   %>    
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">Error</h1>
        Either some of the fields were not filled properly<br>
        if its an options Questions, cannot skip between numbers <br>
        Or the given answer index miss-matched with the given answers
        <%
            String type = "1";
            if( request.getParameter("type") != null )
            {
                type = request.getParameter("type");
            }
        %>
        <br><a href="Question_edit.jsp?type=<%=type%>">Go back to the Editing page</a> 
        <% } %>
    </body>
</html>
