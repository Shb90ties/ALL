<%@ Page Language="C#" AutoEventWireup="true"  CodeFile="Default.aspx.cs" Inherits="_Default" %>

<%@ Register assembly="System.Web.Extensions, Version=3.5.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI" tagprefix="asp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:ScriptManager ID="ScriptManager1" runat="server">
        </asp:ScriptManager>
    <asp:UpdatePanel ID="UpdatePanel1" runat="server"  >
        <ContentTemplate>
            <asp:Timer ID="Timer1" runat="server" Enabled="False" Interval="10" ontick="Timer1_Tick" />
            <asp:HiddenField ID="HiddenField1" runat="server" Value="0" />
        </ContentTemplate>
    </asp:UpdatePanel>
        </div>
        <asp:Table ID="Table1" runat="server">
        </asp:Table>
        <asp:Label ID="labl" Text="sss" runat="server"></asp:Label>
    </form>
</body>
</html>
