<%-- 
    Document   : index
    Created on : 22-Jan-2016, 21:47:59
    Author     : Shb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A Trivia Game</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body>
        <div id="header">
            <img src="Images/Banner.png" style="width: 100px;height: 100px;" align="left">
            <h1 style="text-decoration: underline" align="left">Trivia Game!!!</h1>
        </div>
        <div>
            <div style="width: 20%; float: left; text-align: center; background: midnightblue; height: 900px;">
                <h1 style="text-decoration: underline; color: white;">Menu</h1>
                <a href="About.jsp" style="color: white" target="MainFrame">About</a><br>
                <a href="MoreGames.jsp" style="color: white" target="MainFrame">More Games</a><br>
                <a href="LoginS?enter=menu" style="color: white" target="MainFrame">Game page</a>
            </div>
                <div style="width: 77%; float: left; text-align: center; height: 900px; background-color: midnightblue;">
                    <iframe name="MainFrame" style="width: 99%; height: 99%; background-color: white;"
                            src="About.jsp"></iframe>
                </div>
            </div>
            <div style="width: 3%; float: right; height: 900px; background-color: midnightblue;"></div>
        <div id="bottom" style="float: bottom">© Copyright Shay Butbul</div>
    </body>
</html>
