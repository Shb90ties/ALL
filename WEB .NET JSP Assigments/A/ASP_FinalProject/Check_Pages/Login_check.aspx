<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" 
    CodeFile="Login_check.aspx.cs" Inherits="Check_Pages_Login_check" Title="Login Error!" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p style="text-decoration:underline; "><b>Login error...</b></p>
    <br />
    <p>Either the password or username are incorrect</p>
    <a href="../Login.aspx"><b>Go back</b></a>

</asp:Content>