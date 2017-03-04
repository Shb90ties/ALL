<%-- 
    Document   : GamePage
    Created on : 22-Jan-2016, 23:54:46
    Author     : Shb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game page</title>
    </head>
    <body style="text-align: center">
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">Game page</h1>
        <form id="form1" method="Get" action="LoginS">
            <p style="color: red">To login as Admin, Password and user name = 'admin'</p>
            <input type="hidden" name="fromGamePage" value="true" form="form1">
            <input type="text" name="userName"> : User name <br><br>
            <input type="password" name="password"> : Password <br><br>
            <input type="radio" name="remember_me" value="true"> : Remember me <br><br>
            <input type="submit" name="submit" value="Log-in" form="form1">
        </form>
    </body>
</html>
