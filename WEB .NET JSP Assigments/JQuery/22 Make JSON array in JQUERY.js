var JSONarr = '{"myArr":[{"val1":"upDown","val2":"DOO"},{"val1":"leftrigh","val2":"HOO"}]}';
var Arr = JSON.parse(JSONarr);
alert(Arr.myArr[0].val1 + "," + Arr.myArr[1].val2);



// get request inside JQuery
		// parameter name bac , cannot be 2 parameters
            var requestVal = GetPart(window.location.href,"bac=");
            var temmmp = requestVal[1].replace(/%22/g,'"');
            document.getElementById('kk').innerHTML = temmmp;
            var Arr = JSON.parse(temmmp);
            alert(Arr.myArr[0].val1 + "," + Arr.myArr[1].val2);
        }
            
        function GetPart(string_,splitBy)
        {
            var array = string_.split(splitBy);
            return array;
        }