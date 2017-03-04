<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Assgmnt3.aspx.cs" Inherits="Ass3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
    <script lang="javascript" type="text/javascript">
        var empty;
        function build()
        {
            var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16];
            nums = shuffle(nums);
            for (var row = 0; row < 4; row++) {
                for (var col = 0; col < 4; col++) {
                    var buttn = document.createElement('input');
                    buttn.type = 'button';
                    buttn.value = nums[(row * 4 + col)];
                    buttn.id = (row * 4 + col).toString();
                    buttn.style.height = '60px';
                    buttn.style.width = '60px';
                    buttn.style.position = 'absolute';
                    buttn.style.top = (100 + row * 60).toString() + 'px';
                    buttn.style.left = (100 + col * 60).toString() + 'px';
                    buttn.style.backgroundColor = getRandomColor();
                    buttn.style.border = 'groove';
                    if (buttn.value == '16')
                    {
                        buttn.style.display = 'none';
                        empty = buttn;
                    }
                    buttn.onclick = function () { clicked(this); };
                    form1.appendChild(buttn);
                }
            }
        }
        function shuffle(nums)
        {
           ranNums = [],
           i = nums.length,
           j = 0;
           var num, index, temp;
            while (i--)
            {
                j = Math.floor(Math.random() * (i + 1));
                ranNums.push(nums[j]);
                nums.splice(j, 1);
            }
            for (var i = 0; i < ranNums.length; i++) {
                if (ranNums[i] == 16) {
                    num = ranNums[i];
                    index = i;
                    break;
                }
            }
            if (ranNums[15] != 16) {
                temp = ranNums[15];
                ranNums[15] = 16;
                ranNums[index] = temp;
            }
            return ranNums
        }
        function getRandomColor()
        {
            var letters = '0123456789ABCDEF'.split('');
            var color = '#';
            for (var i = 0; i < 6 ; i++) {
                color += letters[Math.floor(Math.random() * 16)];
            }
            return color;
        }
        var stop = 0;
        var move_ID, prevLeft, prevTop, sender_b;
        function clicked(sender)
        {
            var button = document.getElementById('try');
            move_ID = sender.id;
            prevLeft = sender.style.left;
            prevTop = sender.style.top;
            sender_b = sender;
            parseInt(empty.style.left);
            button.innerText = 'sL:' + parseInt(sender.style.left) + ' eL:' + parseInt(empty.style.left) + ' || sT:' + parseInt(sender.style.top) + 'eT:' + parseInt(empty.style.top);
            if (parseInt(sender.style.left) == parseInt(empty.style.left))
            {
                if( [(parseInt(sender.style.top))+60] == parseInt(empty.style.top) )
                {
                    stop = 0;
                    moveDown();
                }
                if( [(parseInt(sender.style.top))-60] == parseInt(empty.style.top)  )
                {
                    stop = 0;
                    moveUp();
                }
            }
            if( parseInt(sender.style.top) == parseInt(empty.style.top) )
            {
                if( [(parseInt(sender.style.left))+60] == parseInt(empty.style.left))
                {
                    stop = 0;
                    moveRight();
                }
                if( [(parseInt(sender.style.left))-60] == parseInt(empty.style.left) )
                {
                    stop = 0;
                    moveLeft();
                }
            }
        }
        function switched(sender)
        {
            if (stop == 60)
            {
                empty.style.backgroundColor = sender.style.backgroundColor;
                var temp = empty.value;
                empty.value = sender.value;
                empty.style.display = sender.style.display;
                sender.value = temp;
                sender.style.display = 'none';
                empty = sender;
            }
        }
        function restore()
        {
            var b = document.getElementById(move_ID);
            b.style.top = prevTop;
            b.style.left = prevLeft;
        }
        function moveDown()
        {
            var b = document.getElementById(move_ID);
            if( stop < 60 )
            {
                b.style.pixelTop += 1;
                window.setTimeout("moveDown()", 4);
                stop++;
            }
            else
            {
                restore();
                switched(sender_b);
                winner_check();
            }
        }
        function moveLeft()
        {
            var b = document.getElementById(move_ID);
            if (stop < 60) {
                b.style.pixelLeft -= 1;
                window.setTimeout("moveLeft()", 4);
                stop++;
            }
            else {
                restore();
                switched(sender_b);
                winner_check();
            }
        }
        function moveRight()
        {
            var b = document.getElementById(move_ID);
            if (stop < 60) {
                b.style.pixelLeft += 1;
                window.setTimeout("moveRight()", 4);
                stop++;
            }
            else {
                restore();
                switched(sender_b);
                winner_check();
            }
        }
        function moveUp()
        {
            var b = document.getElementById(move_ID);
            if (stop < 60) {
                b.style.pixelTop -= 1;
                window.setTimeout("moveUp()", 4);
                stop++;
            }
            else {
                restore();
                switched(sender_b);
                winner_check();
            }
        }
        function winner_check()
        {
            var winner = false;
            //for (var i = 0; i < 15; i++) {
               // var s = (document.getElementById(i.toString()));
                //if( parseInt(s.value) != (i+1) )
               // {
                //    winner = false;
               // }
            //}
            if (document.getElementById('0').value == '1' && document.getElementById('1').value == '2')
            {
                winner = true;
            }
            if(winner == true )
            {
                var c = confirm("new game?");
                if( c == true )
                {
                    location.reload();
                }
                else
                {
                    this.close();
                }
            }
        }
        function score()
        {
            var me = document.getElementById('try');
            me.value = "";
            for (var i = 0; i < 15; i++)
            {
                var s = (document.getElementById(i.toString()));
                me.value += ' ' + s.value;
            }    
        }
        function installation() {
            var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16];
            nums = shuffle(nums);
            for (var row = 0; row < 4; row++) {
                for (var col = 0; col < 4; col++) {
                    var buttn = document.getElementById((row * 4 + col).toString());
                    buttn.value = nums[(row * 4 + col)];
                    buttn.style.backgroundColor = getRandomColor();
                    buttn.style.display = "";
                    if (buttn.value == '16') {
                        buttn.style.display = 'none';
                        empty = buttn;
                    }
                }
            }
        }
    </script>
<body>
    <form id="form1" runat="server">
    <div>
    </div>
    </form>
    <form id="game">
        <input type="button" id="test" value="s" style="top:500px; position:absolute;" onclick="build()" />
        <input type="button" id="try" value="t" style="top:500px; left:100px; position:absolute; width:600px;" onclick="score()" />
        <input type="button" id="install" value="install" onclick="installation()" style="display:none; border:groove" />
    </form>
</body>
</html>
