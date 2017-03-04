<?php
	/* DatabaseName : test00
			under Xampp
				user = 'root'
				pass = ''
				database = 'test00'
		Guide : https://www.youtube.com/watch?v=ueWpNe0PG34
	*/
	$user = 'root';
	$pass = '';
	$db = 'test00';
	
	$db_ = new mysqli('localhost',$user,$pass,$db) 
					or die("unable to connect");
	if($db_->connect_error){
		die('Database connection failure..<br>');
	}
	
/*	$command = "INSERT INTO `temp` (`id_`, `about`)".
					"VALUES ('newTemp', 'GGHfffff');";
	if($db_->query($command) === TRUE){
		echo "new record created!<br>";
	}else{
		echo "ERROR: ".$db_->error.'<br>';
	} */
	
	$command = "SELECT * FROM `temp` WHERE id_ = 'newTemp'";
	$result = $db_->query($command);
	
	echo $command.'<br>';
	
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){
			echo '[id_ : '.$row["id_"].
					' | about : '.$row["about"].']<br>';
		}
	}else{
		echo '0 results<br>';
	}
	
	$command = "SELECT * FROM `temp` WHERE id_ = 'doesnt exist'";
	$result = $db_->query($command);
	
	echo $command.'<br>';
	
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){
			echo '[id_ : '.$row["id_"].
					' | about : '.$row["about"].']<br>';
		}
	}else{
		echo '0 results<br>';
	}

	echo "Database working!!<br>";
	
	//__ close connection__//
	$db_->close();
?>