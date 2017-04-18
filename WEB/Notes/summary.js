Cordova

	inAppBrowser 
	// in MainController or app.js
	$rootScope.$on('$cordovaInAppBrowser:exit', function(e, event){
		// actions when browser is closing
	});
		
	$cordovaInAppBrowser.open("http://..../", "_blank");
	// _blank (browser in app)
	// _self (browser is a self window)
	
	
Angular
	
	in HTML
	ng-class="{'class1': (msg.type == 'text') , 'class2': (msg.type != 'text')}
							^ condition// boolean
							

Bash/Git command
	
		// get platforms/... folder
	sudo ionic build ios
	sudo ionic build android

