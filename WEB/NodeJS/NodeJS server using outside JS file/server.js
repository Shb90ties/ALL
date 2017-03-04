var express = require('express');
var app = express();
var port = 12345;   // static virable
app.listen(port);   // force this server to run on '12345' port
                        // server address will be http://localhost:12345/ insert requests
console.log('Server running on port ' + port);

var tools = require('./tools.js');
useJS_fileFunctions();


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


function useJS_fileFunctions()
{
    tools.Void_function();

    console.log(tools.Return_function());

    tools.FunctionCallFunction();

    console.log(tools.FunctionGetsVirable(5, 4));
	
	console.log(tools.OutsideFunction);
}
