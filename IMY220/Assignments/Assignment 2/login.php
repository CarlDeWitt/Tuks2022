<?php
// See all errors and warnings
error_reporting(E_ALL);
ini_set('error_reporting', E_ALL);

$mysqli = mysqli_connect("localhost", "root", "", "dbuser");

/**
 * 
 */
$email = isset($_POST["email"]) ? $_POST["email"] : null;
$pass = isset($_POST["pass"]) ? $_POST["pass"] : null;
// If email and/or pass POST values are set, set the variables to those values, otherwise make them false


/**
 * delete
 */
if (isset($_POST["del"]) && $_POST["del"] != "") {
	$delName = $_POST["del"];
	$delID = $_POST["uID"];
	/**
	 * get the event ID from the table
	 */
	$queryGetid = "SELECT event_id FROM tbevents WHERE name = '$delName' AND user_id = '$delID'";
	$queryGetidResult =	$mysqli->query($queryGetid);
	$eventID = $queryGetidResult->fetch_assoc();
	$numeventID = (int) $eventID['event_id'];

	/**
	 * delete the event from the table	 
	 */
	$delQuery = "DELETE FROM tbevents WHERE  name = '$delName' AND user_id = '$delID'";
	$mysqli->query($delQuery);

	/**
	 * get the galery ID from the table
	 */
	$delQuery = "DELETE FROM tbgallery WHERE event_id = '$numeventID'";
	$mysqli->query($delQuery);

	$_POST["del"] = "";
}


/**
 * gets the upload file for file this is to check if it exsist and not for id it is valid
 */
if (isset($_FILES['picToUpload']))
	$uploadFile = $_FILES['picToUpload'];
else
	$uploadFile = "";


/**
 * DO CHECK HERE TO SEE IF VALUES ARE SET
 */
if (
	isset($uploadFile['name'][0]) && $uploadFile['name'][0] != "" &&
	isset($_POST['eventDate']) && $_POST['eventDate'] != "" &&
	isset($_POST['eventName']) && $_POST['eventName'] != "" &&
	isset($_POST['eventDescription']) && $_POST['eventDescription'] != ""
) {

	/**
	 * get the uplaoded file 
	 */
	$uploadFile = $_FILES['picToUpload'];
	$uploadFileCount = count($uploadFile["name"]);

	/**
	 * check if the file is correct
	 */
	for ($i = 0; $i < $uploadFileCount; $i++) {
		if ($uploadFile["type"][$i] == "image/jpeg" || $uploadFile["type"][$i] == "image/pjpeg" && $uploadFile["size"][$i] < 1000000) {
			// echo "valid file";
			/**
			 * try to upload images to folder
			 */
			if ($uploadFile != "") {
				$destinationPath = "gallery/";
				$target_path = $destinationPath . $uploadFile['name'][0];
				move_uploaded_file($uploadFile['tmp_name'][0], $target_path);
			}
		} else {
			echo "There is a something wrong with your uploaded file";
		}
	}


	/**
	 * get the event date from the table
	 */
	$name = $_POST["eventName"];
	$description = $_POST["eventDescription"];
	$date = $_POST["eventDate"];
	$uID = $_POST["uID"];


	/**
	 * this function will check if the event name is already in the table if it is the number of rows will be greater than 0
	 */
	$queryCheck = "SELECT * FROM tbevents WHERE name = '$name' AND user_id = '$uID'";
	$mysqli->query($queryCheck);
	$resCheck = $mysqli->query($queryCheck);
	if (mysqli_num_rows($resCheck) > 0) {
		// echo ('Event Already exists');
	} else {
		/**
		 * there is no double event in so insert the event into the evenets table
		 */
		$query = "INSERT INTO tbevents (user_id, name, description, date) VALUES ('$uID','$name', '$description','$date')";
		$mysqli->query($query);


		/**
		 * this gets the event id of the event just created so we can link the correct event id to the gallery
		 */
		$queryGetid = "SELECT event_id FROM tbevents WHERE name = '$name'";
		$queryGetidResult =	$mysqli->query($queryGetid);
		$eventID = $queryGetidResult->fetch_assoc();
		$numeventID = (int) $eventID['event_id'];
		$img  = $uploadFile["name"][0];


		/**
		 * this will insert the event id into the gallery table
		 */
		$queryImages = "INSERT INTO tbgallery (event_id, image_name) VALUES ('$numeventID', '$img')";
		$mysqli->query($queryImages);
	}
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


			echo 	"<form action='login.php' method='POST' enctype='multipart/form-data'>
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

			/**
			 * this pulls data from db and displays it in a table
			 */
			$queryEvents = "SELECT * FROM tbevents WHERE user_id = '$userID'";
			$resE = $mysqli->query($queryEvents);


			echo "<h2>Upcoming Events</h2>";
			echo "<div class='container'><div class='row'>";
			/**
			 *  this loops through the events and displays them in a table
			 */
			while ($rowE = mysqli_fetch_array($resE)) {
				/**
				 * this gets the correcponding image that is needed to be displayed and it gets pulled from gallery db
				 */
				$queryGallery = "SELECT * FROM tbgallery WHERE event_id = '$rowE[event_id]'";
				$resG = $mysqli->query($queryGallery);
				$rowG = mysqli_fetch_array($resG);

				/**
				 * here i just display the event name and description
				 */
				echo  "	<div class='col-3'>					
							<div class='card'>
								<div class='card-header'>
									$rowE[date]
								</div>
								<div class='card-body'>
									<img src='./gallery/$rowG[image_name]' alt='./gallery/$rowG[image_name]' class='card-img'>
									<p class='card-text'>$rowE[name]</p>
									<p class='card-text'>$rowE[description]</p>
									<form action='login.php' method='POST' enctype='multipart/form-data'>
										<button type='submit' class='btn btn-danger' name='del' value='$rowE[name]'>Delete</button>
										<input type='hidden' name='email' value='$email'/>
										<input type='hidden' name='pass' value='$pass'/>
										<input type='hidden' name='uID' value='$userID'/>
									</form>
								</div>
							</div>
						</div>";
			}
			echo "</div></div>";
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