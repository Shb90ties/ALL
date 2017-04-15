 / js / controllers / patients / AddController.js

{
    // A
        // in init
        $scope.$on('$locationChangeStart', function( event ) {
				console.log('here');
				
                frequenciesActionsStop();
                toggleScan(true);
                //if($scope.scan.playing) {
                    // without ^
            });
    // B 
        // put ^ outside of init but after init as function

    // C 
        $scope.$on('$ionicView.beforeLeave', function(){ frequenciesActionsStop(); toggleScan(true); });
            // או
        $scope.$on('$ionicView.leave', function(){ frequenciesActionsStop(); toggleScan(true); });
    // D 
        $scope.$on('$locationChangeStart', function(){ frequenciesActionsStop(); toggleScan(true); });
        $scope.$on("$destroy", .... );
        window.onbeforeunload = function (){.....}
    // E
    function init() {
        console.log('hereeeee666');


        if( $scope.scan.playing !== 'undefined')
            if( $scope.scan.playing )
                toggleScan(true);
    }
}