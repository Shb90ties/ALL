-> inject $ionicActionSheet to angular controller
	.controller('myCtrl', function($scope, $ionicActionSheet)

-> access it with $scope.showActionSheet()
	$scope.triggerActionSheet = function() {....}

-> .show // creates the html element with objects saved by json
	$ionicActionSheet.show({
		buttons : [{ text : 'dsfgsdf'},...],
		destructiveText : 'sdfsdf',
		titleText : 'sdfsdaf',
		cancelText : 'sdfsdf',
		cancel : function () { .... },
		buttonClicked : function(index){....},
		cancelOnStateChange : if true will cancel action
	})
	
-> overlay // backdrop
	inject => $ionicBackdrop
		function($scope, $ionicBackdrop,...
		
		$scope.showBackdrop = function() {
		  $ionicBackdrop.retain();
			
		  $timeout(function() {
			 $ionicBackdrop.release();
		  }, 3000);
		};
	
-> checkbox
	<ion-checkbox ng-model="checkboxModel.value1">Checkbox 1</ion-checkbox>
	<ion-checkbox ng-model="checkboxModel.value2">Checkbox 2</ion-checkbox>
	
	$scope.checkboxModel = {
	   value1 : false,
	   value2 : false
	};
	
-> toggle
	<ion-toggle ng-model = "toggleModel.value1">Toggle 1</ion-toggle>...
	
	$scope.toggleModel = {
	  value1 : true,...
	};
	
	
-> EVENTS
	on-hold // it touch is more than 500 mili seconds
	on-tap // not click only tap
	on-double-tap
	on-touch
	on-release
	on-drag
	on-drag-up|right|left|down
	on-swipe
	on-swipe-up|right|left|down
		example :
		<button on-touch = "onTouchFunction()" class="button">Test</button>
		
		$scope.onTouchFunction = function() {
		   // Do something...
		}
	
-> MOVING LIST ITEM
	<ion-list show-reorder = "true">
	<ion-item ng-repeat = "item in items">
	  Item {{item.id}}
	  <ion-reorder-button class = "ion-navicon" on-reorder = "moveItem(item, $fromIndex, $toIndex)"></ion-reorder-button>
	</ion-item>
	
	$scope.items = [
	   {id: 1},
	   {id: 2},
	   {id: 3},
	   {id: 4}
	];

	$scope.moveItem = function(item, fromIndex, toIndex) {
	   $scope.items.splice(fromIndex, 1);
	   $scope.items.splice(toIndex, 0, item);
	};
</ion-list>


$scope.showLoading = function() {
  $ionicLoading.show({
	 template: 'Loading...'
  });
};

$scope.hideLoading = function(){
  $ionicLoading.hide();
};
   
