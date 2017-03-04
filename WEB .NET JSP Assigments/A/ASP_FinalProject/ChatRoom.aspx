<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" 
    CodeFile="ChatRoom.aspx.cs" Inherits="ChatRoom" Title="Chat Room" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <p style="text-decoration:underline; "><b>Chat Room</b></p>
    <br />
    <p id="headline"><b>Chat room for : </b></p>
    <hr />
    <p id="chat">Chat : </p>
    <hr />
    <input type="text" id="message" style="width:500px; height:30px;" /><br />
    <input type="button" id="sendMSG" value="send" onclick="sendMSG_click()" />

    <script type = "text/javascript">
        var headlin = document.getElementById("headline");
        var chat = document.getElementById("chat");
        var textBox = document.getElementById("message");
        var myID; var myChatID; var otherID; var otherChatID;
        var verifyWithOther = "no";

        var XMLHttpSignIn;
        var XMLHttpSend;
        var XMLHttpUpdate;

        function launch_Chat()
        {
            myID = document.getElementById("RI").value;
            otherID = document.getElementById("SI").value;
            headlin.innerHTML += myID + " and " + otherID;
            if (document.getElementById("NS").value == "confirmed_chat")
            {
                verifyWithOther = "yes";
                otherChatID = document.getElementById("RGI").value;
                headline.innerHTML += "<br>Other's Chat ID: " + otherChatID;
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
            XMLHttpSignIn.open("POST", "Handler.ashx?cmd=AddChat", true);
            XMLHttpSignIn.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpSignIn.onreadystatechange = GetMyChatID;
            XMLHttpSignIn.send();
        }

        function GetMyChatID()
        {
            if (XMLHttpSignIn.readyState == 4)
            {
                myChatID = XMLHttpSignIn.responseText;
                headlin.innerHTML += "<br>Chat ID: " + myChatID;
                updates();
                sendOtherMyChatID();
            }
        }

        function ArgumentsClassJSON(command, sender, reciever, text)
        {
            var Arguments = new Object();
            Arguments.command_ = command;
            Arguments.sender_ = sender;
            Arguments.reciever_ = reciever;
            Arguments.text_ = text;
            return JSON.stringify(Arguments);
        }

        function sendOtherMyChatID()
        {
            var reciever = otherID;
            if (verifyWithOther == "yes") { reciever = otherChatID; }
            var url = "Handler.ashx?cmd=Send&ARGS=" + ArgumentsClassJSON("ConfirmChat", myID, reciever, myChatID);
            XMLHttpSend.open("POST", url, true);
            XMLHttpSend.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpSend.send();
        }

        function updates()
        {
            var url = "Handler.ashx?cmd=Update&user=" + myChatID;
            XMLHttpUpdate.open("POST", url, true);
            XMLHttpUpdate.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpUpdate.onreadystatechange = anylize_update;
            XMLHttpUpdate.send();
        }

        function anylize_update()
        {
            if (XMLHttpUpdate.readyState == 4)
            {
                var response = XMLHttpUpdate.responseText;
                if (GetPart(response, 0) == "ConfirmChat")
                {
                    otherChatID = GetPart(response, 3);
                    headlin.innerHTML += "<br>Other's Chat ID: " + otherChatID;
                }
                if (GetPart(response, 0) == "Message")
                {
                    chat.innerHTML += "<br>" + GetPart(response, 3);
                }
                updates();
            }
        }

        function GetPart(string_, index)
        {
            var array = string_.split("|");
            return array[index];
        }

        function sendMSG_click()
        {
            var legitTEXT = checkTEXT();
            if (legitTEXT == false) { alert("Text cannot have '|' or be empty"); return; }
            var messg = myID + " : " + textBox.value;
            var url = "Handler.ashx?cmd=Send&ARGS=" + ArgumentsClassJSON("Message", myChatID, otherChatID, messg);
            chat.innerHTML += "<br>" + messg;
            XMLHttpSend.open("POST", url, true);
            XMLHttpSend.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            XMLHttpSend.send();
            textBox.value = "";
        }

        function checkTEXT()
        {
            var stream = textBox.value; var i;
            for(i=0; i<stream.length; i++)
            {
                if (stream[i] == "|") { return false; }
            }
            if (i == 0) { return false; }
            return true;
        }

        window.onunload = removeClient;
        function removeClient()
        {
            var url = "Handler.ashx?cmd=RemoveChat&user=" + myChatID;
            XMLHttpSignIn.open("POST", url, true);
            XMLHttpSignIn.send();
        }

    </script> 
</asp:Content>
