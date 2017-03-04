<?php
	echo '<strong>2D array</strong><br>';
	$cars = array(
			  array("Volvo",22,18),
			  array("BMW",15,13) );
	$n = count($cars);
	$k = count($cars[0]);
	for($i=0;$i<$n;$i++){
		echo '[';
		for($j=0;$j<$k;$j++){
			echo $cars[$i][$j].',';
		}
		echo ']<br>';
	}
	echo '<hr><strong>DATE styles</strong><br>'; //_____________________//
		echo "Today is " . date("Y/m/d") . "<br>";
		echo "Today is " . date("Y.m.d") . "<br>";
		echo "Today is " . date("Y-m-d") . "<br>";
		echo "Today is " . date("l");	// name of day
		echo '<br>'.date("Y"); // year
		echo "The time is " . date("h:i:sa").'<br>';
	echo '<hr><strong>Outside file</strong><br>'; //_____________________//
		// Outside file 
	include 'includeFileIN_basicsADVANCE.php';	// include/import
	echo 'calling function from outside file : <br>';
	echo 'Var drom outside file : '.$outsideVar;
	printFromFile();
		// import with ability to use outside file virables
		// require 'outSideFile.php'
		// echo $outsideVirable;
	echo ' (from TXT file) '.readfile('readTEXTfile_basicsADVANCE.txt').'<br>';
	echo 'read TXT by characters : <br>';
	$myfile = fopen("readTEXTfile_basicsADVANCE.txt", "r")
		or die("Unable to open file!");
	$ch = 0;
	while(!feof($myfile)) {
		$ch++;
		echo 'char['.$ch .']="'.fgetc($myfile).'",';
	}
	fclose($myfile);
	echo '<br><hr>';
?>