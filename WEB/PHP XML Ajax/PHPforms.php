<html>
<body>

	<!-- POST request, name = key in a request parameter -->
	<hr>
	<h1>POST type form</h1>
	<form action="PHPforms.php" method="post">
	Name: <input type="text" name="name"><br>
	E-mail: <input type="text" name="email"><br>
	<input type="submit">
	</form>

	<p><b>
		<?php
				// trim request virables remove spaces ect..
			function test_input($data) {
			  $data = trim($data);
			  $data = stripslashes($data);
			  $data = htmlspecialchars($data);
			  return $data;
			}
			
			if ($_SERVER["REQUEST_METHOD"] == "POST"){
				$name = test_input($_POST["name"]);
				$email = test_input($_POST["email"]);
				echo 'POST name value : '.$name.' email value : '.$email.'<br>';
			}
		?>
	</b></p>
	<hr>

</body>
</html>