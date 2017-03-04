<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" 
    CodeFile="Login.aspx.cs" Inherits="Login" Title="Login Page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p style="text-decoration:underline; "><b>Login Page</b></p>
    <br />
    User name : 
    <asp:TextBox ID="UserName_TB" runat="server"></asp:TextBox><br />
    Password : 
    <asp:TextBox ID="Password_TB" runat="server"></asp:TextBox><br />
    <asp:Button ID="login_button" Text="Login" runat="server" OnClick="login_button_Click" /><br />
    <a href="SignUp.aspx"><b>Create Account!</b></a>
    <br />
    <script type = "text/javascript">
        window.onload = test;
        function test()
        {
        }
    </script>
</asp:Content>