<?php
	echo 'hello world!!<br>';
	
	$myVar = 'My string';
	$intVar = 55;
	
	if($myVar == 'my string'){
		echo 'compared but ignored capslock<br>';
	}
	else{
		echo 'compared without ignoring capslock<br>';
		if(strtolower($myVar) == 'my string'){
			echo 'compared by removing capslock<br>';
			if($intVar > 50){
				$temp = 50;
				echo '<strong>bigger than '.$temp.'</strong><br>';
				print '<strong>print is the same as echo</strong><br>';
			}
		}
	}
	// comments .... making html elements
	/*
		comments longer than one line
	*/
	echo '<input type="text" name="txtName" value="type here"/>';
	echo '<button>click</button><br>';
	// while              ___________________________________
	$counter = 0;
	while($counter < 3){
		echo $counter.'<br>';
		$counter ++;
	}
	// for             ___________________________________
	for($i=0;$i<3;$i++){
		echo $i.',';
	}
	echo '<br>';
	// switch               ___________________________________
	$switchVAR = 55;
	switch($switchVAR){
		case 1:
			echo 'Switch equals 1<br>'; break;
		case 2:
			echo 'Switch equals 2<br>'; break;
		case 'string':
			echo 'switch is a string<br>'; break;
		default:
			echo 'nothing was recognized<br>'; break;
	}
	// string length
	$temp = '0123456789';
	echo strlen($temp).'<br>';
	// strings                ___________________________________
		// word count
	echo str_word_count('one two three').'<br>';
		// reverse
	echo strrev('Reverse').'<br>';
		// word position in text
	echo 'index of ef start : '.strpos('abcdefg','ef').'<br>';
		// replace word1 with word2
	echo str_replace('word1','word2','this is word1').'<br>';
	
	// function with define    ___________________________________
	define('funcVal','A function value...');
	
	function myFunc(){
		echo funcVal;
		echo '<br>';
	}
	
	function myARGSfunc($argument){
		echo 'function that takes an argument  ('.$argument.')';
		echo '<br>';
	}
	
	myFunc();
	myARGSfunc("MY_args");
	
	// array           ___________________________________
	$myArr = array('hello',5);
	echo 'indx 0 : '.$myArr[0].'indx 1 : '.$myArr[0].'<br>';
	for($i=0;$i<count($myArr);$i++){
		echo $myArr[$i];
		echo '<br>';
	}
	
	// do while          ___________________________________
	$n = count($myArr);
	$j = 0;
	do{
		echo 'do while loop element = '.$myArr[$j].'<br>';
		$j++;
	}while($j<$n);
	
	
	// MATH              ___________________________________
	function sum($x,$y){
		return ($x+$y);
	}
	
	echo 'Import Math : 5 + 10 = '.sum(5,10).'<br>';
	
	// string index in Array ___________________________________
	$arrTemp['one'] = 55;
	$arrTemp['two'] = 'eight';
	echo 'string index one : '.$arrTemp['one'].',';
	echo 'string index two : '.$arrTemp['two'].'<br>';
	
	
	// sort array        ___________________________________
	function printArr($array){
		for($k=0;$k<count($array);$k++){
			echo $array[$k].',';
		}
		echo '<br>';
	}
	
	echo '<hr>';
	$numbers = array(5,2,1,8,7,3,11);
	echo 'before sorting : '; 
	printArr($numbers);
	sort($numbers);
	echo 'after sorting : ';
	printArr($numbers);
	
		// special array key,value
	echo '<strong>special array AGE key/value <br></strong>';
	$age = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");
	echo 'sort by key : <br>';
	ksort($age); // sort by key
	// reverse key sort : krsort($age);
	foreach($age as $x => $x_value) {
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "<br>";
	}
	echo 'sort by value : <br>';
	arsort($age); // sort by value 
	foreach($age as $x => $x_value) {
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "<br>";
	}
	
	// GLOBAL virables 
	$globalX = '"X_is_a_Global_virable"';
	function showGlobal(){
		echo 'global virable : '.$GLOBALS['globalX'].'<br>';
	}
	showGlobal();
?>
	<hr>
	inserting php to html :<br>
	<p> $myVar = <?php echo $myVar ?></p>
	
<?
	echo 'another way to define php';
?>