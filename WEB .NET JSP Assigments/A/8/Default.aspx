<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
     <script language="javascript">
         var emptyI = 3, emptyJ = 3;
         var emptyileft = 1 + (15 % 4) * 70, emptyitop = 35 + Math.floor((15 / 4)) * 70;
         emptyileft += 'px';
         emptyitop += 'px';
         var templeft = emptyileft, temptop = emptyitop;
         var myJSON_Object;
         var xmlHttp;        
         var t6;
         function onLoadJavaScript() {
             try {
                 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
             }
             catch (e) {
                 try {
                     xmlHttp = new XMLHttpRequest();
                 }
                 catch (e) {
                 }
             }            
             textingAndColoring();
         }
         function textingAndColoring()
         {            
             var url = "Handler.ashx";
             xmlHttp.open("POST", url, true);
             xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
             xmlHttp.onreadystatechange = onRequestTextAndColorInit;
             xmlHttp.send("cmd=TextAndColorInit");
         }
         function onRequestTextAndColorInit() {            
             if (xmlHttp.readyState == 4) {            
                 var myJSON_Text = xmlHttp.responseText;
                 myJSON_Object = eval(myJSON_Text);
                 for (i = 0; i < 15; i++) {
                     document.getElementById(i).value = myJSON_Object[i].texttt;
                     document.getElementById(i).style.backgroundColor = myJSON_Object[i].strHtmlColor;
                 }
             }
         }
         function myClick(b) {
             var i = Math.floor(b.tabIndex / 4);
             var j = b.tabIndex % 4;
             if ((Math.abs(i - emptyI) + Math.abs(j - emptyJ)) == 1) {
                 var temp1 = b.value;
                 sendarray(temp1);
                 b.tabIndex = emptyI * 4 + emptyJ;
                 templeft = b.style.left;
                 temptop = b.style.top;
                 emptyI = i;
                 emptyJ = j;
                 move(b);
             }
         }
         function move(b) {
             function frame1() {
                 var s1 = b.style.left.substring(0, b.style.left.length - 2);
                 var s2 = emptyileft.substring(0, emptyileft.length - 2);
                 if (parseInt(s1) < parseInt(s2)) {
                     s1 = parseInt(s1) + 1;
                 }
                 else if (parseInt(s1) > parseInt(s2)) {
                     s1 = parseInt(s1) - 1;
                 }
                 s1 += 'px';
                 b.style.left = s1;
                 if (b.style.left == emptyileft) {
                     clearInterval(id);
                     emptyileft = templeft;
                     emptyitop = temptop;
                     eg();
                 }
             }
             function frame2() {
                 var s1 = b.style.top.substring(0, b.style.top.length - 2);
                 var s2 = emptyitop.substring(0, emptyitop.length - 2);
                 if (parseInt(s1) < parseInt(s2)) {
                     s1 = parseInt(s1) + 1;
                 }
                 else if (parseInt(s1) > parseInt(s2)) {
                     s1 = parseInt(s1) - 1;
                 }
                 s1 += 'px';
                 b.style.top = s1;
                 if (b.style.top == emptyitop) {
                     clearInterval(id2);
                     emptyitop = temptop;
                     emptyileft = templeft;
                     eg();
                 }
             }

             if (b.style.left != emptyileft) {
                 var id = setInterval(frame1, 5);
             }
             else {
                 var id2 = setInterval(frame2, 5);
             }
         }
         function sendarray(t5)
         {
            t6 = t5;
            var myJsonString_0 = JSON.stringify(myJSON_Object);
            var myJsonString_1 = JSON.stringify(t5);
            var url = "Handler.ashx";
            xmlHttp.open("POST", url, true);
            xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xmlHttp.onreadystatechange = onRequestTextAndColorChange;
            xmlHttp.send("cmd=TextAndColorChange&JSON_Object_0=" + myJsonString_0 + "&JSON_Object_1=" + myJsonString_1);            
         }
         function onRequestTextAndColorChange()
         {    
             if (xmlHttp.readyState == 4) {
                 var myJSON_Text = xmlHttp.responseText;
                 myJSON_Object = eval(myJSON_Text);
                 doBgc();
             }           
         }
         function doBgc()
         {
             var bg = new Object();
             bg.texttt = "bg";
           
             bg.strHtmlColor = rgb2hex(document.body.style.backgroundColor);
            
             for (i = 0; i < 16; i++)
             {                 
                 if (myJSON_Object[i].texttt == t6)
                 {
                   
                     var myJsonString_3 = JSON.stringify(bg);
                     var myJsonString_2 = JSON.stringify(myJSON_Object[i]);
                     var url = "Handler.ashx";
                     xmlHttp.open("POST", url, true);
                     xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                     xmlHttp.onreadystatechange = onRequestbgc;
                    
                     xmlHttp.send("cmd=bgc&JSON_Object_2=" + myJsonString_2 + "&JSON_Object_3=" + myJsonString_3);
                     
                     break;
                     
                 }
             }
         }
         function onRequestbgc() {            
             if (xmlHttp.readyState == 4) {               
                 var myJSON_Text = xmlHttp.responseText;               
                 document.body.style.backgroundColor = eval(myJSON_Text);
             }
         }
         function rgb2hex(rgb) {
             if (rgb != "") {
                 rgb = rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
                 return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
             }
             return "#111111";
         }
         function hex(x) {
             return ("0" + parseInt(x).toString(16)).slice(-2);
         }
         function eg() {
             var myJsonString_0 = JSON.stringify(myJSON_Object);             
             var url = "Handler.ashx";
             xmlHttp.open("POST", url, true);
             xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
             xmlHttp.onreadystatechange = onRequestEndGame;
             xmlHttp.send("cmd=endgame&JSON_Object_e=" + myJsonString_0);
         }
         function onRequestEndGame()
         {
             if (xmlHttp.readyState == 4) {               
                 var myJSON_Text = xmlHttp.responseText;
                 var result = eval(myJSON_Text);                
                 if (result == 1)
                 {
                     var r = confirm("Game Over!!, New Game?!?");
                     if (r == true) {
                         window.location.reload();
                     }
                     else {
                         window.close();
                     }
                 }
             }
             
         }
         window.onload = onLoadJavaScript;
		</script>

<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
    </form>
</body>
</html>
