<%-- 
    Document   : Score_page
    Created on : 24-Jan-2016, 23:38:35
    Author     : Shb
--%>

<%@page import="Servlets.Q_collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Score page</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body style="text-align: center">
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">
                <%=request.getSession().getAttribute("uN")%> Score</h1>
                <% String correct = "Wrong";
                if( request.getSession().getAttribute("result") != null )
                {
                    correct = (String)request.getSession().getAttribute("result");
                }
                else{ correct = "null"; } %>
            <h1><%=correct%></h1>
            <% Q_collection q_c = (Q_collection)request.getSession().getAttribute("collection");
                String [] log = q_c.CollectionScore.get_Log();
                String s = q_c.CollectionScore.get_score_string();
            %>
            <p style="text-decoration: underline">final score : <%=s%></p><br>
            <a href="NewGame.jsp" > Next Question >> </a>
            <%
                for(String l : log)
                {   %>
                <p> <%=l%> </p>    
            <%  }   %>  
    </body>
</html>
