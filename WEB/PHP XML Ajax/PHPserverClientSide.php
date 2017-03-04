<?php
	// server side details static virables ___________________________
	echo '<h1> Server side Details : </h1>';
	echo $_SERVER['PHP_SELF'];
	echo "<br>";
	echo $_SERVER['SERVER_NAME'];
	echo "<br>";
	echo $_SERVER['HTTP_HOST'];
	echo "<br><strong>Http address : </strong>";
	echo $_SERVER['HTTP_REFERER'];
	echo "<br>";
	echo $_SERVER['HTTP_USER_AGENT'];
	echo "<br>";
	echo $_SERVER['SCRIPT_NAME']; // file name + address
	echo '<hr>';	// _______________________________________________
?>

<!-- PHP client side that deals with requests -->
<!-- PHP $_REQUEST (POST type RECOMMANDED)______________________________________
	
	 post a POST-request to the server
		PHP_SELF = post a request to this server
						refresh page with the request values-->
			
	<form method="post" 
		action="<?php 
					echo $_SERVER['PHP_SELF'];
						?>">
	  POST request value: <input type="text" name="myRequest">
								<!-- NOT /?myRequest='input value'
											ONLY in GET types ^-->
	  <input type="submit" value="post to this server">
	</form>
	
	<!-- Catch POST type requests -->
	<?php
		if($_SERVER["REQUEST_METHOD"] == "POST"){
			$get_Request_value = $_REQUEST['myRequest'];
			if(empty($get_Request_value)){
				echo "'myRequest' value is empty, ''<br>";
			}
			else{
				echo "Catched Request, 'myRequest' = ".$get_Request_value.'<br>';
			}
		}
		else{
			echo 'no POST type request detected..<br>';
		}
	?>
	
	<hr>

<!-- PHP $_REQUEST (GET type)______________________________________
	GET type request, /?myReq=sdgsfdg&myName=.... -->
	<?php
		$GETaddrs = $_SERVER['SCRIPT_NAME'].'/?GETrequest=5555';
	?>
	
	<a href="<?php echo $GETaddrs; ?>">Refresh this page with ?GETrequest=5555</a><br>
	
	<?php
		$myGETval = $_GET['GETrequest'];
		if($myGETval != null){
			echo '"?GETrequest" value = '.$myGETval.'<br>';
		}
		else{
			echo 'NO GET parameters under "?GETrequest"<br>';
		}
	?>
	
<!-- PHP COOKIES______________________________________ -->
	<?php
		// Make cookie
			/* (key,value,experation date) ^ 1 hour
									86400*30 = 1 day */
		$visits = 'Visits : +1,';
		if(isset($_COOKIE['cookie_KEY'])){
			$var = $_COOKIE['cookie_KEY'];
			$var = $var.'+1,';
			setcookie('cookie_KEY', $var, time() + (86400 * 30), "/");
			$visits = $var;			//exparation^ time,(86400 * 30) = 1 day //
		}else{						// 3600 = 1 hour //
			setcookie('cookie_KEY', $visits, time() + (86400 * 30), "/");
		}
		echo $visits;
		
		function delete_Cookie(){
			setcookie('cookie_KEY', '0', time() - 3600,"/");
		}
		// delete_Cookie(); 
	?>

<!-- PHP SESSION___________________________________________ -->
	<?php
		session_start();
		$_SESSION["aaa"] =  "aaa value!!";
		print '<br>Session key[aaa] = "'.$_SESSION["aaa"].'"';
		// session_unset();  (RESET session)
		// session_destroy();  (KILL session)
	?>