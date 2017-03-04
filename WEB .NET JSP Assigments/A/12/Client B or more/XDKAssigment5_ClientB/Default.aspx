<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
    <script lang="javascript">
        window.onload = onLoadJavaScript;
        //window.onunload = closePage;
        var xmlHttp, xmlHttpRegister, xmlHttpRegister, xmlHttpExtra, xmlHttpWin, xmlHttpBG, xmlHttpNewG;
                        // launch the Handler.ashx copy the url address
                            // launch the default.aspx on the server and the default.aspx here           
        var addrss = "http://localhost:16083/Handler.ashx";
        var guID; var OrgnTop, OrgnLeft, empty; var lock = false; var Game;

        function onLoadJavaScript()
        {
            try
            {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                xmlHttpRegister = new ActiveXObject("Microsoft.XMLHTTP");
                xmlHttpUpdate = new ActiveXObject("Microsoft.XMLHTTP");
                xmlHttpExtra = new ActiveXObject("Microsoft.XMLHTTP");
                xmlHttpWin = new ActiveXObject("Microsoft.XMLHTTP");
                xmlHttpBG = new ActiveXObject("Microsoft.XMLHTTP");
                xmlHttpNewG = new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch (exception)
            {
                try
                {
                    xmlHttp = new XMLHttpRequest();
                    xmlHttpRegister = new XMLHttpRequest();
                    xmlHttpUpdate = new XMLHttpRequest();
                    xmlHttpExtra = new XMLHttpRequest();
                    xmlHttpWin = new XMLHttpRequest();
                    xmlHttpBG = new XMLHttpRequest();
                    xmlHttpNewG = new XMLHttpRequest();
                }
                catch (exception) {
                    alert("unkown error : cannot create XML Http Request");
                }
            }
            xmlHttpRegister.open("GET", addrss+"?request=Register", true);
            xmlHttpRegister.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlHttpRegister.onreadystatechange = setGuID;
            xmlHttpRegister.send();
            GetNumbers_and_Colors();
        }


        function setGuID()
        {
            if (xmlHttpRegister.readyState == 4)
            {
                guID = xmlHttpRegister.responseText;
                document.getElementById('guIDLabel').innerText += guID;
            }
        }

        function GetNumbers_and_Colors()
        {
            xmlHttpNewG.open("GET", addrss + "?request=GetGame", true);
            xmlHttpNewG.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlHttpNewG.onreadystatechange = onRequestTextAndColorInit;
            xmlHttpNewG.send();
        }

        function onRequestTextAndColorInit()
        {
            if (xmlHttpNewG.readyState == 4)
            {
                if (xmlHttpNewG.responseText == "") { alert("game wasn't delivered"); return; }
                Game = eval(xmlHttpNewG.responseText);
                for (var r = 0; r < 4; r++)
                {
                    for (var c = 0; c < 4; c++)
                    {
                        var i = ((r * 4) + c);
                        var buttn = document.createElement('input');
                        buttn.type = 'button';
                        buttn.value = Game[i].num;
                        if (buttn.value == '0')
                        {
                            buttn.style.display = 'none';
                            empty = i;
                        }
                        buttn.id = i;
                        buttn.style.height = '60px';
                        buttn.style.width = '60px';
                        buttn.style.position = 'absolute';
                        buttn.style.top = (100 + r * 60).toString() + 'px';
                        buttn.style.left = (100 + c * 60).toString() + 'px';
                        buttn.style.backgroundColor = Game[i].HTMLcolorCode;
                        buttn.onclick = function () { myClick(this); };
                        form1.appendChild(buttn);
                    }
                }
                UpdateClient();
            }
        }

        function closePage()
        {
            xmlHttpRegister.open("GET", addrss + "?request=Remove&guID="+guID, true);
            xmlHttpRegister.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlHttpRegister.send();
        }

        function UpdateClient()
        {
            var url = addrss+"?request=Update&from=Web";
            xmlHttpUpdate.open("POST", url, true);
            xmlHttpUpdate.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlHttpUpdate.onreadystatechange = updateGame;
            xmlHttpUpdate.send();
        }

        var GameFinished = false; var newBGColor = "#ffffff";
        function updateGame()
        {
            if (xmlHttpUpdate.readyState == 4)
            {
                if (xmlHttpUpdate.responseText != "0" && xmlHttpUpdate.responseText != "")
                {
                    document.getElementById('gg').innerHTML = xmlHttpUpdate.responseText;
                    var result = GetPart(xmlHttpUpdate.responseText);
                    if (result[0] == "switch" || result[0] == "switchFinish")
                    {
                        OrgnTop = document.getElementById(result[2]).style.top;
                        OrgnLeft = document.getElementById(result[2]).style.left;
                        lock = true;
                        animateS(parseInt(result[2]));
                        if (result[0] == "switchFinish") { GameFinished = true; }
                        newBGColor = result[3];
                    }
                }
                UpdateClient();
            }
        }

        function animateS(myID)
        {
            if (empty == (myID + 4))
            {
                direction = 1; buttnMoving = document.getElementById(myID); stop = 0;
                vertical();
            }
            if (empty == (myID - 4))
            {
                direction = -1; buttnMoving = document.getElementById(myID); stop = 0;
                vertical();
            }
            if (empty == (myID + 1))
            {
                direction = 1; buttnMoving = document.getElementById(myID); stop = 0;
                horizontal();
            }
            if (empty == (myID - 1))
            {
                direction = -1; buttnMoving = document.getElementById(myID); stop = 0;
                horizontal();
            }      
        }

        var direction; var buttnMoving; var stop;
        function vertical()
        {
            if(stop < 30)
            {
                buttnMoving.style.pixelTop += direction*2;
                window.setTimeout("vertical()", 4);
                stop++;
            }
            else { swap_(buttnMoving.id); }
        }

        function horizontal()
        {
            if (stop < 30)
            {
                buttnMoving.style.pixelLeft += direction*2;
                window.setTimeout("horizontal()", 4);
                stop++;
            }
            else { swap_(buttnMoving.id); }
        }

        function swap_(myID)
        {
            var clicked = document.getElementById(myID);
            clicked.style.left = OrgnLeft;
            clicked.style.top = OrgnTop;
            var emptyB = document.getElementById(empty);
            emptyB.value = clicked.value;
            emptyB.style.display = clicked.style.display;
            emptyB.style.backgroundColor = clicked.style.backgroundColor;
            clicked.style.display = 'none';
            clicked.value = '0';
            empty = myID;
            lock = false;
            document.body.style.backgroundColor = newBGColor;
            if (GameFinished)
            {
                if (confirm('Game over! Start a new game?'))
                {
                    window.location.reload();
                }
                else
                {
                    for (var i = 0; i < 16; i++)
                    { document.getElementById(i).disabled = true; }
                }
            }
        }

        function CSScolorToHTML(colorval)
        {
            var parts = colorval.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
            delete (parts[0]);
            for (var i = 1; i <= 3; ++i) {
                parts[i] = parseInt(parts[i]).toString(16);
                if (parts[i].length == 1) parts[i] = '0' + parts[i];
            }
            color = '#' + parts.join('');
            return color;
        }

        function myClick(sender)
        {
            if (lock == true) { return; }
            var ColorBG = CSScolorToHTML(document.body.style.backgroundColor);
            xmlHttp.open("POST", addrss+"?request=Move&number="+sender.value+"&BGcolor="+ColorBG, true);
            xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlHttp.send();
        }

        function GetPart(string_)
        {
            var array = string_.split("|");
            return array;
        }
        
    </script>
<body style="background-color:#ffffff">
    <form id="form1" runat="server">
    <div>
        <p id="guIDLabel"></p>
        <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
        <p id="gg"></p>
        <p id="ffs"></p>
        <asp:Button ID="rest" OnClick="rest_Click" Text="reset virables" runat="server"/><br />
    </div>
    </form>
</body>
</html>
