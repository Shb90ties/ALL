<%-- 
    Document   : Add
    Created on : 23-Jan-2016, 16:40:33
    Author     : Shb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Question</title>
        <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    </head>
    <body style="text-align: center">
        <h1 style="text-decoration: underline; color: white; background-color: midnightblue">
            Pick the type of question
        </h1>
        <a href="Question_edit.jsp?type=1">An open Question</a><br>
        <a href="Question_edit.jsp?type=2">Question with options</a><br>
        <a href="Question_edit.jsp?type=3">Yes No Question</a>
    </body>
</html>
