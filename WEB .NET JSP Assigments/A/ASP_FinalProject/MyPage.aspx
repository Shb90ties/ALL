<%@ Page Language="C#" AutoEventWireup="true" CodeFile="MyPage.aspx.cs" Inherits="MyPage"
    Title="MyPage" MasterPageFile="~/MasterPage.master" %>

<asp:Content ID="MyContent" runat="server" ContentPlaceHolderID="ContentPlaceHolder1">
    <p style="text-decoration:underline; "><b>My Page</b></p>
    <p id="header"><b>Welcome : </b></p>
    <p id="guID_p">GUID : </p>
    <p id="temp">Nothing new...</p>
    <hr />
    <p style="color:red">Closing this windows = user going offline</p>
    <p>Users from your contact list who are online right now : </p>
    <p id="inviteBox"></p>
    <p>
        Add new users : <input type="text" id="newUSER_TB" />
        <input type="button" value="Add" onclick="Add_user()" />
    </p>
    <p>
        Remove a user from the list : <input type="text" id="RemoveUSER_TB" />
        <input type="button" value="Remove" onclick="Remove_User()" />
    </p>
    <hr />
    <a href="Login.aspx">Login with a different account</a>

    <script type = "text/javascript">
        var userName = "null";
        var guID;
        var XMLHttpSignIn;
        var XMLHttpSend;
        var XMLHttpUpdate;
            // temp peragraphs
        var temp = document.getElementById("temp");
        var temp2 = document.getElementById("temp2");
        var temp3 = document.getElementById("temp3");
        var temp4 = document.getElementById("temp4");

        function insert_Username()
        {
            var header = document.getElementById("header");
            header.innerHTML += document.getElementById("UN").value;
            userName = document.getElementById("UN").value;
            Get_contacts();
            var Add_delete = document.getElementById("Add_Delete");
            if( Add_delete.value != "null" )
            {
                alert(Add_delete.value);
            }
            instllize_Requests();
        }

        function instllize_Requests()
        {
            try
            {
                XMLHttpSignIn = new ActiveXObject("Microsoft.XMLHTTP");
                XMLHttpUpdate = new ActiveXObject("Microsoft.XMLHTTP");
                XMLHttpSend = new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch(exception)
            {
                try
                {
                    XMLHttpSend = new XMLHttpRequest();
                    XMLHttpUpdate = new XMLHttpRequest();
                    XMLHttpSignIn = new XMLHttpRequest();
                }
                catch(exception)
                {
                    alert("Error cannot contact the server...");
                }
            }
            XMLHttpSignIn.open("POST", "Handler.ashx?cmd=Add&user="+userName, true);
            XMLHttpSignIn.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpSignIn.onreadystatechange = setGuID;
            XMLHttpSignIn.send();
        }

        function setGuID()
        {
            if(XMLHttpSignIn.readyState == 4)
            {
                guID = XMLHttpSignIn.responseText;
                document.getElementById("guID_p").innerHTML = guID;
                updates();
            }
        }


        function updates()
        {
            var url = "Handler.ashx?cmd=Update&guID=" + guID + "&user=" + userName;
            XMLHttpUpdate.open("POST", url, true);
            XMLHttpUpdate.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpUpdate.onreadystatechange = anylize_update;
            XMLHttpUpdate.send();
        }

        function anylize_update()
        {
            if( XMLHttpUpdate.readyState == 4 )
            {
                var response = XMLHttpUpdate.responseText;
                if( GetPart(response,0) == "Invite" && GetPart(response,1) != userName )
                {   // if(its an invite && you are not the sender)
                    var chat = confirm(GetPart(response, 1) + " has invited you to a chat \n" + "Start a chat with " + GetPart(response, 1));
                    if( chat == true )
                    {
                        var win = window.open("ChatRoom.aspx?sender=" + GetPart(response, 1) + "&reciever=" + userName);
                        win.focus();
                    }
                }
                if (GetPart(response, 0) == "ConfirmChat")
                {
                    var win = window.open("ChatRoom.aspx?sender=" + GetPart(response, 1) + "&reciever=" + userName + "&other=" + GetPart(response, 3));
                    win.focus();
                    document.getElementById("temp").innerHTML = "Opened chat with " + GetPart(response, 1);
                }
                updates();
            }
        }

        function ArgumentsClassJSON(command,sender,reciever,text)
        {
            var Arguments = new Object();
            Arguments.command_ = command;
            Arguments.sender_ = sender;
            Arguments.reciever_ = reciever;
            Arguments.text_ = text;
            return JSON.stringify(Arguments);
        }

        function GetPart(string_,index)
        {
            var array = string_.split("|");
            return array[index];
        }

        function Get_contacts()
        {
            var inviteBox = document.getElementById("inviteBox");
            var i = 0; 
            while (true)
            {
                var HiddenField_I = document.getElementById(i);
                if (HiddenField_I.value == "end") { break; }
                i++;
                var contactName = HiddenField_I.value;
                inviteBox.innerHTML += "<input type=\"button\" id=\"" + contactName + "\" onclick=\"" + "clickContact(this)" + "\" style=\"border-style:solid; border-color:lightseagreen; background-color:aqua\" value=\"" + "invite "+ contactName + " to a chat" + "\" /><br />";
            }
        }

        function clickContact(contact)
        {
            var url = "Handler.ashx?cmd=Send&ARGS=" + ArgumentsClassJSON("Invite", userName, contact.id, "null");
            XMLHttpSend.open("POST", url, true);
            XMLHttpSend.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpSend.send();
            document.getElementById("temp").innerHTML = "waiting for " + contact.id;
        }

        function Add_user()
        {
            var user_to_add = document.getElementById("newUSER_TB");
            window.location.href = "MyPage.aspx?user=" + userName + "&Add_User=" + user_to_add.value;
        }

        function Remove_User()
        {
            var user_to_remove = document.getElementById("RemoveUSER_TB");
            window.location.href = "MyPage.aspx?user=" + userName + "&Remove_User=" + user_to_remove.value;
        }

        window.onunload = removeClient;
        function removeClient()
        {
            var url = "Handler.ashx?cmd=Remove&user=" + userName;
            XMLHttpSignIn.open("POST", url, true);
            XMLHttpSignIn.send();
        }

    </script>


</asp:Content>
