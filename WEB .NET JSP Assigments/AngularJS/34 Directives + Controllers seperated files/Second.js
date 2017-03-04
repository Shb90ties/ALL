angular.module('myApp')
.controller('second', function ($scope, $rootScope, $compile) {
    $scope.bigBang = "Kull";
    $scope.myClick = function () {
        $scope.bigBang = $rootScope.rootText;
        $rootScope.rootText = $rootScope.rootText + "2";

        var el = '<div directive-two></div>';
        var element = angular.element(document.querySelector('#spaceT'));
        var generated = element.html(el);
        $compile(generated.contents())($scope);
    };
});