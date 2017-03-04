<?php
	/* AJAX will send the whole page output back
		can make a page in php and present it in a div in client */
		// get request parameters
	$q = $_REQUEST["q"];
	
	switch($q){
		case '555':
			echo 'user sent 555 to PHP_server';
			break;
		case 'headline':
			echo '<h1>client requested a headline</h1><hr>';
			break;
	}
	echo '<p>PHP server recieved : '.$q.'</p>';
?>