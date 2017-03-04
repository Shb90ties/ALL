<%@ Page Language="C#" AutoEventWireup="true" CodeFile="~/Default.aspx.cs" Inherits="Ass3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
    <script lang="javascript" type="text/javascript">
        var empty;
        var empty_available = true;
        var on_the_move = false;
        var current_ID = null;
        var counter = 0;
        var OriginalLeft = 0;
        var OriginalTop = 0;

        // mouse virables
        var OffsetX = 0;
        var OffsetY = 0;
        var CurrentMethod = null;
        document.onmousedown = mouseDownFunction;
        document.onmouseup = mouseUpFunction;

        function build()
        {
            var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16];
            nums = shuffle(nums);
            for (var row = 0; row < 4; row++)
            {
                for (var col = 0; col < 4; col++)
                {
                    var buttn = document.createElement('input');
                    buttn.type = 'button';
                    buttn.value = nums[(row * 4 + col)];
                    buttn.id = (row * 4 + col).toString();
                    buttn.style.height = '50px';
                    buttn.style.width = '50px';
                    buttn.style.position = 'absolute';
                    buttn.style.top = (10 + row * 50).toString() + 'px';
                    buttn.style.left = (10 + col * 50).toString() + 'px';
                    buttn.style.backgroundColor = getRandomColor();
                    //buttn.style.border = 'groove';
                    if (buttn.value == '16')
                    {
                        buttn.style.display = 'none';
                        empty = buttn;
                    }
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
            for (var i = 0; i < ranNums.length; i++)
            {
                if (ranNums[i] == 16)
                {
                    num = ranNums[i];
                    index = i;
                    break;
                }
            }
            if (ranNums[15] != 16)
            {
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
            for (var i = 0; i < 6 ; i++)
            {
                color += letters[Math.floor(Math.random() * 16)];
            }
            return color;
        }

        function mouseUpFunction() // when mouse is lifted
        {
            if (on_the_move == false) { return; }
            var button = document.getElementById(current_ID);
            if (counter <= switchValue)
            {
                button.style.left = OriginalLeft + 'px';
                button.style.top = OriginalTop + 'px';
                switch_with_empty(button);
                clear(); winner_check(); return;
            }
            if (counter >= returnValue)
            {
                button.style.left = OriginalLeft + 'px';
                button.style.top = OriginalTop + 'px';
                clear(); return;
            }
            document.onmousemove = null;
            on_the_move = false;
        }

        function switch_with_empty(Button)
        {
            empty.style.backgroundColor = Button.style.backgroundColor;
            var temp = empty.value;
            empty.value = Button.value;
            empty.style.display = Button.style.display;
            Button.value = temp;
            Button.style.display = 'none';
            empty = Button;
        }

        function clear()    // after movment is finished
        {
            current_ID = null;
            empty_available = true;
            document.onmousemove = null;
            counter = 0;
            on_the_move = false;
        }

        function mouseDownFunction() // when clicked
        {
            if( empty_available == true )
            {
                var SelectedButton = event.srcElement;
                if( getPosition(SelectedButton.style.left, SelectedButton.style.top) != 0 )
                {
                    counter = 0;
                    OffsetX = event.offsetX;
                    OffsetY = event.offsetY;
                    empty_available = false;
                    current_ID = SelectedButton.id;
                    OriginalLeft = parseInt(SelectedButton.style.left);
                    OriginalTop = parseInt(SelectedButton.style.top);
                    document.onmousemove = CurrentMethod;
                }
            }
            else
            {
                if( event.srcElement.id == current_ID )
                {
                    document.onmousemove = CurrentMethod;
                }
            }
        }

        var switchValue, returnValue// virables for confirming in mouseUpFunction()
        function moveUp() // when mouse is moving in a move up situation 
        {
            on_the_move = true;
            var moveButton = document.getElementById(current_ID);
            counter = [OriginalTop - (event.clientY - OffsetY)];
            if (counter >= 0 && counter <= 50) {
                moveButton.style.pixelTop = event.clientY - OffsetY;
            }
            switchValue = (-35); returnValue = (-15); counter = (-counter);
            return false;
        }

        function moveDown() // when mouse is moving in a move down situation 
        {
            on_the_move = true;
            switchValue = 15; returnValue = 35;
            var moveButton = document.getElementById(current_ID);
            counter = [50 + OriginalTop - (event.clientY - OffsetY)];
            if (counter >= 0 && counter <= 50) {
                moveButton.style.pixelTop = event.clientY - OffsetY;
            }
            return false;
        }
        
        function moveRight() // when mouse is moving in a move right situation 
        {
            on_the_move = true;
            switchValue = 15; returnValue = 35;
            var moveButton = document.getElementById(current_ID);
            counter = [50 + OriginalLeft - (event.clientX - OffsetX)];
            if (counter >= 0 && counter <= 50) {
                moveButton.style.pixelLeft = event.clientX - OffsetX;
            }
            return false;
        }

        function moveLeft() // when mouse is moving in a move left situation 
        {
            on_the_move = true;
            var moveButton = document.getElementById(current_ID);
            counter = [OriginalLeft - (event.clientX - OffsetX)];
            if (counter >= 0 && counter <= 50) {
                moveButton.style.pixelLeft = event.clientX - OffsetX;
            }
            switchValue = (-35); returnValue = (-15);   counter = (-counter);
            return false;
        }

        function getPosition(left,top) // return 0=cannot be moved, 1=move up, 2=move down, 3=move right, 4=move left
        {
            if( parseInt(left) == parseInt(empty.style.left) )
            {
                if (parseInt(top) == [(parseInt(empty.style.top)) + 50]) { CurrentMethod = moveUp;  return 1; }
                if (parseInt(top) == [(parseInt(empty.style.top)) - 50]) { CurrentMethod = moveDown; return 2; }
            }
            if( parseInt(top) == parseInt(empty.style.top) )
            {
                if (parseInt(left) == [(parseInt(empty.style.left)) + 50]) { CurrentMethod = moveLeft; return 4; }
                if (parseInt(left) == [(parseInt(empty.style.left)) - 50]) { CurrentMethod = moveRight; return 3; }
            }
            return 0;
        }

        
        function winner_check()
        {
            var winner = false; // for original score that counts every button
            //for (var i = 0; i < 15; i++) {
            // var s = (document.getElementById(i.toString()));
            //if( parseInt(s.value) != (i+1) )
            // {
            //    winner = false;
            // }
            //}
            if (document.getElementById('0').value == '1' && document.getElementById('1').value == '2') {
                winner = true;
            }
            if (winner == true) {
                var c = confirm("new game?");
                if (c == true) {
                    location.reload();
                }
                else {
                    this.close();
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

    </form>
</body>
</html>
