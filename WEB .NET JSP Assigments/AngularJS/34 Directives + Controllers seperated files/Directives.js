angular.module('myApp')
.directive('directiveOne', function () {
    return {
        template: '<p>{{rootText}}</p>'
    };
})
.directive('directiveTwo', function () {
    return {
        template: '<p>{{rootText}} second</p>'
    };
});