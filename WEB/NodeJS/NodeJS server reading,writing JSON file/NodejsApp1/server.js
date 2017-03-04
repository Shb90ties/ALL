var express = require('express');
var app = express();
var port = 12345;   // static virable
app.listen(port);   // force this server to run on '12345' port
                        // server address will be http://localhost:12345/ insert requests
console.log('Server running on port ' + port);

var jsonFile = require('jsonfile');
var file = __dirname + '\\data.json';
writeJSONthenReadJSON();

app.get('/', function (request, response)
{
    console.log('recieved request : ' + request);

        // Get Request parameters from request object
    var firstNumber = parseInt(request.query.first);
    var secondNumber = parseInt(request.query.second);
    var operation = request.query.action;

    var result = actionPlusMinus(operation, firstNumber, secondNumber);

    console.log('sending response : ' + result.toString());
    response.send(result.toString());
});


function actionPlusMinus(operation, first, second)
{
    if (operation == "Plus")
        return first + second;
    return first - second;
}

function writeJSONthenReadJSON()
{
    var obj = new Object();
    // send JSON as a string :: var JSONstring3 = JSON.stringify(objJSON);
    obj.name = "Jo";
    obj.Narray = [0, 1, 2, 3, 4];
    jsonFile.writeFile(file, obj, function (err)
    {
        if (!err)
        {
            console.log('successfully written');
            // ____Reading from JSON
            readJSON();
        }
        else
            console.log(err);
    });
}

function readJSON()
{
    var fs = require('fs');
    var obj;
    fs.readFile('data.json', 'utf8', function (err, data)
    {
        if (!err)
        {
            obj = JSON.parse(data);
            console.log(obj.name);
            for (var i = 0; i < obj.Narray.length; i++)
                console.log(obj.Narray[i]);
        }
        else
            console.log(err);
    });
}
