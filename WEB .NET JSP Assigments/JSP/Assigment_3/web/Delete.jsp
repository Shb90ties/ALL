<%-- 
    Document   : Delete
    Created on : 23-Jan-2016, 16:40:40
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
        <% if( request.getParameter("after_delte") == null )
        { %>
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">Delete Questions</h1>
        <p>pick the question you want to delete</p>
        <form id="form1" method="Get" action="DeleteS">
            <input type="hidden" name="before_delete" value="true" form="form1">
        <%
            String [] codes = (String[])request.getSession().getAttribute("codes");
            String [] questions = (String[])request.getSession().getAttribute("questions");
            String [] categories = (String[])request.getSession().getAttribute("category");
            for(int i=0; i < codes.length; i++)
            {   %>
            <input type="checkbox" name="picked_questions" value="<%=codes[i]%>" ><%=codes[i]%> , <%=questions[i]%> , <%=categories[i]%> <br>
            <% } %>
            <br>
            <input type="submit" name="submit" value="delete" form="form1">
        </form>
        <% } else { %>
        <p>lost page...</p>
        <% } %>
    </body>
</html>
