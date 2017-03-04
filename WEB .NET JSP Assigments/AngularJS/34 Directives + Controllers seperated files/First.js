angular.module('myApp')
.controller('first', function ($scope, $rootScope,$compile)
{
    $scope.bigBang = "null";
    $scope.myClick = function ()
    {
        $scope.bigBang = $rootScope.rootText;
        $rootScope.rootText = $rootScope.rootText + "1";

        var el = '<div directive-one></div>';
        var element = angular.element(document.querySelector('#spaceO'));
        var generated = element.html(el);
        $compile(generated.contents())($scope);
    };
});