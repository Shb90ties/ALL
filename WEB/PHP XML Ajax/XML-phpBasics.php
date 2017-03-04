<?php
		// get XML values from argument
	$myXMLData =
	"<?xml version='1.0' encoding='UTF-8'?>
		<person category=\"CHILDREN\">
			<name>GGGG</name>
			<age>55</age>
		</person>";

	$xml=simplexml_load_string($myXMLData) 
		or die("Error: Cannot create object");
	print_r($xml);
	echo '<br>'.$xml->name;
	
		// get XML values from xml file
	$xmlF=simplexml_load_file("XMLperson.xml")
		or die("Error: Cannot create object");
		/* in XML file , people -> person
					skip on^ the people */
	print_r($xmlF);
	echo '<hr>';
	echo 'getting values from XML:<br><br>';
	foreach($xmlF->person as $p){
		echo 'Name : '.$p->name.'<br>';
		echo 'Age : '.$p->age.'<br>';
		echo 'Group : '.$p['group_'].'<br><br>';
	}
	
		// DOM praser, takes all the values in TREE order //
	$xmlDoc = new DOMDocument();
	$xmlDoc->load("XMLperson.xml");
	
	echo 'All xml values : <br>'.$xmlDoc->saveXML();
		// get elements
	$elms_container = $xmlDoc->documentElement;
	echo '<br>DOM seperated by elements : <br>';
	foreach($elms_container->childNodes as $elm){
		print 'Element name : ('.$elm->nodeName.')';
		print ' Element value : ('.$elm->nodeValue.')<br>';
	}
?>