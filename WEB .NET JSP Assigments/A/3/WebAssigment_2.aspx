<%@ Page Language="C#" AutoEventWireup="true" CodeFile="WebAssigment_2.aspx.cs" Inherits="WebAssigment_2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server" style="align-self:center; text-align:center;">
        <table style="align-content:center">
            <tr>
                <td style="width: 1px">
                    <asp:Table ID="table_" runat="server"
                        Width="100px" Height="100px">
                    </asp:Table>
                </td>
            </tr>
        </table>
        <asp:Button ID="quick" Text="Fast count" runat="server" OnClick="Fast_counting"/>
    </form>
</body>
</html>
