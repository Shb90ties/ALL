https://www.tutorialspoint.com

// Baisc example
<ng-app="sdfasd">
	<ion-pane>
		<ion-header-bar class="bar-stable">
			....
		</ion-header-bar>
		<ion-content>
			...
		</ion-content>
	</ion-pane>

	
// Already made css IONIC tampletes
	ionicframework.com
		Docs
			CSS components


// Header
	<ion-header-bar class="bar-light/bar-stable...">
		// read about built in classes on Docs ^
		// make further adjustments on the class
			// scss/css
				.bar-light {....}
	// CREATE BY DIV ONLY
	<div class="bar bar-header">
		....
	</div>
	// with color
	<div class="bar bar-header bar-positive">
	   <h1 class="title">Header</h1>
	</div>

// Tabs
	<div class="tabs tab-dark">
	<div class="tabs tabs-icon-only">
	
	
// Icons
	<i class="icon ion-home"></i>
		// <i> already exists
	<i class="icon ion-star"></i>
	<i class = "icon ion-planet"></i>
	<i class = "icon icon ion-happy-outline"></i>
	<i class = "icon icon ion-star"></i>
	<i class = "icon icon ion-compass"></i>
	<i class = "icon icon ion-planet"></i>
	<i class = "icon icon ion-ios-analytics"></i>
	<i class = "icon icon ion-ios-eye"></i>

// Images containers
	// avatar
	<div class="item item-avatar">
      <img src="my-image.png">
      <h3>Avatar</h3>
   </div>
   // thumbnail
   <div class="item item-thumbnail-left">
      <img src="my-image.png">
      <h3>Thumbnail</h3>
   </div>
   // regular image container
   <img class="full-image" src="my-image.png"> 
		
// Buttons
	// for header
		<button class="button icon ion-navicon"></button>
		<button class="button icon ion-home"></button>
	// for footers
		<button class="button icon ion-navicon"></button>
		<button class="button icon ion-home"></button>
		<button class="button icon ion-star"></button>
		<button class="button icon ion-checkmark-round"></button>
		<button class="button icon ion-navicon pull-right"></button>
	// BLOCK-BUTTONS
		// with width 100%/ display block
			<button class="button button-block">
			<button class="button button-full">
	// BUTTONS-SIZES
		<button class="button button-small">
		<button class="button button-large">
			// colored
		<button class="button button-assertive">
			// colored  border
		<button class="button button-assertive button-outline">
		<button class="button button-assertive button-clear">
			// icons
				// button icon position type
				<button class="button icon icon-left ion-home">
				<button class="button icon icon-right ion-home">
	// Button-bar
		<div class="button-bar">
		   <a class="button button-positive">1</a>
		   <a class="button button-assertive">2</a>
		   <a class="button button-energized">3</a>
		   <a class="button">4</a>
		</div>
		

// Sub-Header
	<div class="bar bar-subheader bar-assertive">
	   <h2 class="title">Sub Header</h2>
	</div>

// CONTENT
	// everything that is not in a tab must be in content
	<ion-content class="padding has-subheader">

// LIST
	<div class="list">
	   <div class="item">Item 1</div>
	   <div class="item">Item 2</div>
	   <div class="item">Item 3</div>
	</div>
	// LIST-Divider
		<div class="item item-divider">Item Divider 2</div>

// CARDS // has item types in it
	<div class="card">
		<div class="item">...</
		<div class="item item-text-wrap">...
		<div class="item item-divider">...
		<div class="item item-text-wrap">...
		<div class="item item-body">
			<img class="full-image" src="my-image.png"> ... </

// TEXT container with labels
	<label class="item item-input">
		<input type="text" placeholder="Placeholder 1">
	</label>									// 2,3....
	
	<label class="item item-input item-stacked-label">
	   <span class="input-label">Label 1</span>
	   <input type="text" placeholder="Placeholder 1">
   </label>
			
			
// Toggle // checkbox
	<label class="toggle">
		 <input type="checkbox">
		 <div class="track">
			 <div class="handle"></div>
		 </div>
	 </label>
	// in a list 
		<ul class="list">
			<li class="item item-toggle">
				 Toggle Light
				 <label class="toggle  toggle-light">
					 <input type="checkbox">
					 <div class="track">
						 <div class="handle"></div>
					 </div>
				 </label>
			 </li>
	// V type , on different colors
		<label class="checkbox">
		   <input type="checkbox">
		</label>

		
// RANGE
	<div class = "item range">
	   <input type = "range" name = "range1">
	</div>
	
// SELECT
	   <div class = "input-label">
			  Select
		   </div>
			
		   <select>
			  <option>Option 1</option>
			  <option selected>Option 2</option>
			  <option>Option 3</option>
		   </select>
		</label>
	
	
// TABLE
	<div class = "row">
	   <div class = "col">col 1</div>
	   <div class = "col">col 2</div>
	   <div class = "col">col 3</div>
	   <div class = "col">col 4</div>
	   <div class = "col">col 5</div>
	</div>	// sizes split automatically
	// col-{size_persent}
		<div class = "col col-50">col 1</div> // 50%
	// col-offset-{size_persent}
		// makes gaps between cols
			<div class = "col col-offset-25">col 2</div>
	// col-positioning
		// col-position // y_position
			<div class = "col col-top">col 1</div>
			<div class = "col col-center">col 2</div>
			<div class = "col col-bottom">col 3</div>
	
// PADDING
	<div class = "button button-block padding">Padding</div>
		padding-vertical
		padding-horizontal
		padding-top , padding-right , padding-bottom , padding-left

// KEYBOARD
	// focus on label when clicked to keyboard
	<label class = "item item-input">
	   <input type = "text" placeholder = "Input 1">
	</label>

	<button class = "button button-block hide-on-keyboard-open">
	   button
	</button>
		
// FOOTER
	<div class="bar bar-footer">
	   <h1 class="title">Footer</h1>
	</div>
	
	// colored
	<div class="bar bar-footer bar-assertive">
	   <h1 class="title">Footer</h1>
	</div>
	
	<ion-footer-bar align-title="center" class="bar-assertive">
	  <h1 class="title">Title!</h1>
	</ion-footer-bar