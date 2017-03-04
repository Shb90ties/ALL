<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" 
    CodeFile="Singup_Check.aspx.cs" Inherits="Check_Pages_Singup_Check" Title="Signup Error!" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p style="text-decoration:underline; "><b>Signup error...</b></p>
    <br />
    <p><b>the following errors might have occurred :</b></p>
    <p>1) Fields cannot be empty</p>
    <p>2) Username cannot be "end"</p>
    <p>3) Username might already exists</p>
    <p>4) There was a problem with the database</p>
    <p>5) There cannot be a '|' character in the name</p>
    <p>6) Maximum length can be up to 20 chars</p>
    <a href="../Login.aspx"><b>Go back to the Login page</b></a><br />
    <a href="../SignUp.aspx"><b>Go back to the Signup page and try again</b></a>
 
</asp:Content>
