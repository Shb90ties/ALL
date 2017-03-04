<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" 
    CodeFile="SignUp.aspx.cs" Inherits="SignUp" Title="Signup page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p style="text-decoration:underline; "><b>Sign up!</b></p>
    <br />
    <b>Enter User name :</b><br />
    <asp:TextBox ID="userName_TB" runat="server"></asp:TextBox><br />
    <b>Enter Password :</b><br />
    <asp:TextBox ID="password_TB" runat="server"></asp:TextBox><br />
    <asp:Button ID="signup" Text="Sign up!" runat="server" OnClick="signup_Click" /><br />
    <a href="Login.aspx">Go back to the Login page</a>
</asp:Content>