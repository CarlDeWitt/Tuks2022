<?php
	// See all errors and warnings
	error_reporting(E_ALL);
	ini_set('error_reporting', E_ALL);

	
	$mysqli = mysqli_connect("localhost", "root", "", "dbuser");

	$name = $_POST["fname"];
	$surname = $_POST["lname"];
	$email = $_POST["email"];
	$date = $_POST["date"];
	$pass = $_POST["pass"];

	$query = "INSERT INTO tbusers (name, surname, email, birthday, password) VALUES ('$name', '$surname', '$email', '$date', '$pass');";

	$res = mysqli_query($mysqli, $query) == TRUE;
?>

<!DOCTYPE html>
<html>
<head>
	<title>IMY 220 - Assignment 2</title>
	<meta charset="utf-8" />	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">	
</head>
<body>
	<div class="container">
		<?php 
			if($res)
				echo '<div class="alert alert-primary mt-3" role="alert">
  						The account has been created
  					</div>';
  			else
  				echo '<div class="alert alert-danger mt-3" role="alert">
  						The account could not be created
  					</div>';
		?>
	</div>
</body>
</html>