<?php
// See all errors and warnings
error_reporting(E_ALL);
ini_set('error_reporting', E_ALL);

$mysqli = mysqli_connect("localhost", "root", "", "dbuser");

$canConnect = false; //this will be used to see if all values are set



$email = isset($_POST["email"]) ? $_POST["email"] : null;
$pass = isset($_POST["pass"]) ? $_POST["pass"] : null;
// If email and/or pass POST values are set, set the variables to those values, otherwise make them false

// echo "email is " . $email . " and pass " . $pass;

/*---------DO CHECK HERE TO SEE IF VALUES ARE SET------------*/
if (isset($_FILES['picToUpload']) && isset($_POST['eventDate']) && isset($_POST['eventName']) && isset($_POST['eventDescription'])) {
	$canConnect = true;
	$uploadFile = $_FILES['picToUpload'];
	$uploadFileCount = count($uploadFile["name"]);
	// echo $uploadFileCount;
	// echo $uploadFile["name"][0];

	for ($i = 0; $i < $uploadFileCount; $i++) {
		if ($uploadFile["type"][$i] == "image/jpeg" || $uploadFile["type"][$i] == "image/pjpeg" && $uploadFile["size"][$i] < 1000) {
			// echo "valid file";
		} else {
			echo "There is a something wrong with your uploaded file";
		}
	}
	$name = $_POST["eventName"];
	$description = $_POST["eventDescription"];
	$date = $_POST["eventDate"];
	// $uID = $_POST["uID"];
	// echo $uID;

	$query = "INSERT INTO tbevents (user_id, name, description, date) VALUES (1,'$name', '$description','$date')";

	$mysqli->query($query);
}

?>

<!DOCTYPE html>
<html>

<head>
	<title>IMY 220 - Assignment 2</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css" />
	<meta charset="utf-8" />
	<meta name="author" content="Carl de Witt u21444928">
	<!-- Replace Name Surname with your name and surname -->
</head>

<body>
	<div class="container">
		<?php
		$query = "SELECT * FROM tbusers WHERE email = '$email' AND password = '$pass'";
		$res = $mysqli->query($query);
		if ($row = mysqli_fetch_array($res)) {
			$userID = $row["user_id"];
			// echo $userID;
			echo 	"<table class='table table-bordered mt-3'>
							<tr>
								<td>Name</td>
								<td>" . $row['name'] . "</td>
							<tr>
							<tr>
								<td>Surname</td>
								<td>" . $row['surname'] . "</td>
							<tr>
							<tr>
								<td>Email Address</td>
								<td>" . $row['email'] . "</td>
							<tr>
							<tr>
								<td>Birthday</td>
								<td>" . $row['birthday'] . "</td>
							<tr>
						</table>";


			echo 	"<form action='' method='POST' enctype='multipart/form-data'>
							<div class='form-group'>
								
								<label for='eventName'>Event Name:</label><br>
								<input type='text' class='form-control' name='eventName' /><br>								
								<label for='eventDescription'>Event Description:</label><br>
								<input type='text' class='form-control' name='eventDescription' /><br>

								<label for 'eventDate'>Event date:</label><br>
								<input type='date' class='form-control' name='eventDate' /><br>	

								<input type='file' class='form-control' name='picToUpload[]' id='picToUpload' multiple='multiple' /><br/>		
								
								<input type='hidden' name='email' value='$email'/>

								<input type='hidden' name='pass' value='$pass'/>

								<input type='hidden' name='uID' value='$userID'/>

								<input type='submit' class='btn-standard' value='Upload event' name='submit' />
							</div>
					  	</form>";
		} //end if

		else {
			echo 	'<div class="alert alert-danger mt-3" role="alert">
  							You are not registered on this site!
  						</div>';
		} //end else
		?>
	</div>
</body>

</html>