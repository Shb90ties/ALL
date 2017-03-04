<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
    <script type="text/javascript" lang="javascript">
        var empty;

        function install_position() {
            for (var i = 0; i < 4; i++) {
                for (var j = 0; j < 4; j++) {
                    var k = (i * 4 + j);
                    var buttn = document.getElementById(k.toString() + 'b');
                    buttn.style.position = 'absolute';
                    buttn.style.top = (10 + i * 60).toString() + 'px';
                    buttn.style.left = (10 + j * 60).toString() + 'px';
                    var hiddn = document.getElementById(k.toString() + 't');
                    if (hiddn.value == "client") {
                        buttn.style.display = 'none';
                        var cButtn = document.createElement('input');
                        cButtn.type = 'button';
                        cButtn.value = buttn.value;
                        cButtn.id = k.toString();
                        cButtn.style.height = '60px';
                        cButtn.style.width = '60px';
                        cButtn.style.position = 'absolute';
                        cButtn.style.top = (10 + i * 60).toString() + 'px';
                        cButtn.style.left = (10 + j * 60).toString() + 'px';
                        cButtn.style.backgroundColor = buttn.style.backgroundColor;
                        cButtn.style.fontSize = 'Medium';
                        cButtn.onclick = function () { client_click(this.id); };
                        form1.appendChild(cButtn);
                        if (buttn.value == "16") {
                            empty = cButtn;
                            empty.style.display = 'none';
                        }
                    }
                }
            }
        }

        function client_click(index)
        {
            var buttn = document.getElementById(index);
            if( getPosition(buttn.style.left,buttn.style.top) != 0 )
            {
                switch_with_empty(buttn);
                check_winner();
            }
        }

        function getPosition(left, top) // return 0=cannot be moved, 1=move up, 2=move down, 3=move right, 4=move left
        {
            if (parseInt(left) == parseInt(empty.style.left)) {
                if (parseInt(top) == [(parseInt(empty.style.top)) + 60]) { return 1; }
                if (parseInt(top) == [(parseInt(empty.style.top)) - 60]) { return 2; }
            }
            if (parseInt(top) == parseInt(empty.style.top)) {
                if (parseInt(left) == [(parseInt(empty.style.left)) + 60]) { return 4; }
                if (parseInt(left) == [(parseInt(empty.style.left)) - 60]) { return 3; }
            }
            return 0;
        }

        function switch_with_empty(Button)
        {
            empty.style.backgroundColor = Button.style.backgroundColor;
            var temp = empty.value;
            empty.value = Button.value;
            empty.style.display = Button.style.display;
            empty.style.fontSize = Button.style.fontSize;
            Button.value = temp;
            Button.style.display = 'none';
            document.getElementById(get_empty_index() + 'f').value = empty.value;
            document.getElementById(Button.id + 'f').value = Button.value;
            var clientString = document.getElementById(get_empty_index() + 't').value;
            document.getElementById(get_empty_index() + 't').value = document.getElementById(Button.id + 't').value;
            document.getElementById(Button.id + 't').value = clientString;
            empty = Button;
        }

        function get_empty_index()
        {
            for (var i = 0; i < 16; i++) {
                var hfild = document.getElementById(i.toString() + 'f');
                if (hfild.value == "16") { return i; }
            }
        }
        function check_winner()
        {
            var first = document.getElementById("0f");
            var second = document.getElementById("1f");
            if( (first.value == "1") && (second.value == "2") )
            {
                var r = confirm("start a new game?");
                if( r == true )
                {
                    location.reload();
                }
                else
                {
                    this.close();
                }
            }
        }
    </script>
<body>
    <form id="form1" runat="server">
       
    </form>
</body>
</html>
