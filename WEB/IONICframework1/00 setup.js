https://www.tutorialspoint.com/ionic/ionic_js_modal.htm
http://ionicframework.com/docs/v1/


-> $ npm install -g cordova ionic
		// at first install it -g , global
-> ionic start project_name tabs
		// tabs, gives already made tampletes
			// tabs alternative : blank,sidemenu
-> ionic start project_name blank
-> cd project_name
-> ionic serve
	// gives addresses to run project on
		// usually pick localhost
			// type number of option

// Folder built ________________________________//
Folders :
	-> hooks
		// bundles the packages of the application
	-> plugins
		// ionic plugins...
	-> scss
		// save scss files for the application
	-> www
		// app folder
		-> css
		-> js
			// all the js with app.js and controllers and services
		-> templates
			// html popups and other things to insert to the project
		-> bowerrc....gulpfile,ionic.project....

		
// IONIC elemets on html _________________________//
works under Angular1
	<body ng-app="dsfsd">
		<ion-pane>
			<ion-header-bar class="dsfsd">
	// ion-* , works like directives on Angular1

	
// SAVED colors in classes
light : white
stable : gray
positive : blue
calm : light blue
balanced : green
energized : yellow
assertive : red
royal : violet light purple
dark : light black