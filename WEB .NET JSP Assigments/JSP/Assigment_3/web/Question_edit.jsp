<%-- 
    Document   : Question_edit
    Created on : 23-Jan-2016, 17:49:27
    Author     : Shb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit Page</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body style="text-align: center">
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">
            Edit Page</h1>
        <form id="form1" method="Get" action="MakeQuestion">
            <div style="width: 50%; height: 400px; float: left">
                <p style="text-decoration: underline;">Pick a category</p>
                <input type="radio" name="category" value="Animals"> Animals <br>
                <input type="radio" name="category" value="History"> History <br>
                <input type="radio" name="category" value="Literature"> Literature <br>
                <input type="radio" name="category" value="Math"> Math <br>
                <input type="radio" name="category" value="Medicine"> Medicine <br>
                <input type="radio" name="category" value="Movies"> Movies <br>
                <input type="radio" name="category" value="Politics"> Politics <br>
                <input type="radio" name="category" value="Science"> Science <br> 
                <p style="text-decoration: underline;">Pick a difficulty level</p>
                <input type="radio" name="difficulty" value="1"> Easy <br>
                <input type="radio" name="difficulty" value="2"> Medium <br>
                <input type="radio" name="difficulty" value="3"> Hard <br>
            </div>
            <div style="width: 50%; height: 400px; float: right">
                <p style="text-decoration: underline;">Type the question</p>
                <textarea rows="3" cols="25" wrap="hard"
                          style="width: 200px; height: 50px;" form="form1" name="Question"></textarea><br>
                <p style="text-decoration: underline;">The answer?</p>
                <%
                    String type = "1";
                    if( request.getParameter("type") != null && 
                            !request.getParameter("type").trim().equals("") )
                    {
                        type = request.getParameter("type");
                    }
                    %> <input type="hidden" name="type" value="<%=type%>" form="form1"> <%
                    if( type.equals("1"))
                    {   %>
                    <textarea rows="3" cols="25" wrap="hard"
                              style="width: 200px; height: 50px;" form="form1" name="Answer"></textarea><br>
                    <%  }
                    else
                    {
                        if( type.equals("2"))
                        {
                            %><p>Fill in between 3 and 5 answers</p><%
                            for(int i=1; i<=5;i++)
                            {
                            %><%=i%>) <input type="text" name="Answer" style="width: 200px;"><br> <%
                            }
                            %><p style="text-decoration: underline">The right answer?</p><%
                            for(int i=1; i<=5;i++)
                            {
                                %> <input type="radio" name="index" value="<%=i%>"> <%=i%> <%
                            }
                        }
                        else
                        {   %>
                        <input type="radio" name="Answer" value="YES"> YES <br>
                        <input type="radio" name="Answer" value="NO"> NO
                        <%  }
                    }
                %>
            </div>
            <input type="submit" value="send the Question" name="submit">
        </form>
    </body>
</html>