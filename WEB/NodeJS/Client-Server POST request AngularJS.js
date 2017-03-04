//____________Client side (AngularJS)_______________//

angular.module('myApp', [])
.controller('PlusMinusCtrl', ['$scope', '$http',function ($scope, $http) 
{
	$scope.myClick = function(event)
    {
		var path = "http://localhost:12345/" ;
        $http.post(path, 'abccc')
        .then(function (result) 
        {
			$scope.answerServer = result.data;
        })
        .catch(function (data, status, headers, config) 
        { $scope.ErrorServer = "SERVER ERROR :: " + data + status + header + config; });   
    }
}]);


//________________Server side NODE JS_________________//

var port = "12345";
var http = require("http");	// npm install http


http.createServer(function(request, response)
{
    request.on("data", function (temp)
    {
        console.log("Request came in with values = " + temp);
        counter++;
    });
	response.end(counter.toString())
}).listen(port);