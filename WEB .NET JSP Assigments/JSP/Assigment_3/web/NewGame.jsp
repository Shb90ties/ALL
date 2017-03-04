
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Servlets.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Game</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body style="text-align: center">
        <% if( request.getParameter("pick") != null ) { %>
        <form id="form1" method="Get" action="Game">
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">New Game</h1>
        <input type="hidden" name="after_pick" value="true" form="form1">
        <% if( request.getSession().getAttribute("wrong") != null ){ %>
        <p style="color: red">Please fill all the fields</p>
        <% } %>
        <% 
            HttpSession s = request.getSession();
            Q_collection q_c = (Q_collection)s.getAttribute("collection");
            String[] collection = q_c.get_subjects();
            for(String c : collection)
            {
        %>
        <input type="checkbox" name="category" value="<%=c%>" style="background-color: midnightblue">
        <img src="Images/<%=c%>.png"> : <%=c%> <br>
        <% } %>
        <p>Default difficulty is at Easy</p>
        <input type="radio" name="difficulty" value="1">Easy 
        <input type="radio" name="difficulty" value="2">Medium  
        <input type="radio" name="difficulty" value="3">Hard  <br><br>
        <input type="submit" name="submit" value="start" form="form1"><br><br>
        <%=request.getSession().getAttribute("uN")%>
        </form>
        <% }    else {  
            HttpSession s = request.getSession();
            Q_collection q_c = (Q_collection)s.getAttribute("collection");
            if( q_c.is_Empty() )
            {   %>
            <h1 style="text-decoration: underline; color: white; background-color: midnightblue">No more questions left</h1>
            <p style="text-decoration: underline"><%=request.getSession().getAttribute("uN")%> final score : <%=q_c.CollectionScore.get_score()%></p>
            <% }
            else
            {
                Question q = q_c.get_random_question_and_delete();
                request.getSession().setAttribute("collection", q_c);
                request.getSession().setAttribute("the_question", q);    %>
            <h1 style="text-decoration: underline; color: white; background-color: midnightblue">Question code :<%=q.getCode()%></h1>
            <p><%=q.toString()%>??</p>
            <form id="form1" method="Get" action="Game">
                <input type="hidden" name="game_take_place" value="true" form="form1">
                <% if( q.get_my_Type() == 1 ){  %>
                <textarea rows="3" cols="25" wrap="hard"
                          style="width: 200px; height: 50px;" form="form1" name="Answer"></textarea><br><br>
            <%    }else{
                if( q.get_my_Type() == 2 ){
                    String[] options = q.get_complex_Answers();
                    for(int i=0; i< options.length;i++){ %>
                    <input type="radio" name="Answer" value="<%=options[i]%>" form="form1"> <%=(i+1)%>) <%=options[i]%> <br>
                <%  }
                } else { %>
                <input type="radio" name="Answer" value="YES"> Yes
                <input type="radio" name="Answer" value="NO"> No <br>
            <%  }             
            } %>
            <input type="submit" name="submit" value="Answer it" form="form1">
            </form>
         <%   }
           }  %>
    </body>
</html>
