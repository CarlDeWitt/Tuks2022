<!DOCTYPE html>
<html>
<?php
$namesArray = array();

$myfile = fopen("names.txt", "r") or die("Unable to open file!");
if ($myfile) {
	while (($line = fgets($myfile)) !== false) {
		array_push($namesArray, $line);
	}
	fclose($myfile);
}



if (isset($_GET['split']) && $_GET['split'] != "") {
	$split = true;
	$numRows = 1;
} else {
	$split = true;
	$numRows = 1;
}

if (isset($_GET['numRows']) && $_GET['numRows'] != "") {
	$numRows = $_GET['numRows'];
} else {
	$numRows = 1;
}

if ($split) {
	$namesArray1 = array();
	$namesArray2 = array(); //reverse this one

	$numArray = count($namesArray) / 2;

	for ($i = 0; $i < $numArray; $i++) {
		array_push($namesArray1, $namesArray[$i]);
	}

	for ($i = 5; $i < $numArray * 2; $i++) {
		if (!empty($namesArray[$i])) {
			array_push($namesArray2, $namesArray[$i]);
		}
	}

	$namesArray2 = array_reverse($namesArray2);
}

?>

<head>
	<title>IMY 220 - Prac 2</title>
	<meta charset="utf-8" />
	<!-- Carl de Witt u21444928 -->
</head>

<body>

	<form action="index.php" method="GET">
		<label for="nRows">Number of rows: </label>
		<input type="number" id="nRows" name="numRows" />
		<input type="submit" name="" value="Change" />
		<input type="submit" name="split" value="Split and group" />
	</form>

	<?php
	echo "</br>
	<table style='border:1px solid black;'>
	";
	$numTD = count($namesArray) / $numRows;
	for ($i = 0; $i < $numRows; $i++) {
		echo "<tr style='border:1px solid black;'>";
		for ($m = 0; $m < $numTD; $m++) {
			if (!empty($namesArray)) {
				echo "<td style='border:1px solid black;'>" . array_shift($namesArray) . "</td>";
			}
		}
		echo "</tr>";
	}

	echo "</table>";

	if ($split) {
		echo "</br>
		<table style='border:1px solid black;'>
		";
		for ($i = 0; $i < $numArray; $i++) {
			echo "<tr style='border:1px solid black;'>";
			echo "<td style='border:1px solid black;'>";
			echo $namesArray1[$i];
			if (!empty($namesArray2[$i])) {
				echo 'and ' . $namesArray2[$i];
			}
			echo "</td>";
			echo "</tr>";
		}

		echo "</table>";
	}

	?>
</body>

</html>