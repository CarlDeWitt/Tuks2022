<?php
require "master.php";
session_start();
$UID = $_SESSION['UserIndex'];

if (
    isset($_POST["Ename"]) && $_POST["Ename"] != "" &&
    isset($_POST["Elocaction"]) && $_POST["Elocaction"] != "" &&
    isset($_POST["Edate"]) && $_POST["Edate"] != "" &&
    isset($_POST["Ehastags"]) && $_POST["Ehastags"] != "" &&
    isset($_POST["Edescription"]) && $_POST["Edescription"] != "" &&
    isset($_POST["Eimg"]) && $_POST["Eimg"] != ""
) {
    $name = $_POST["Ename"];
    $location = $_POST["Elocaction"];
    $date = $_POST["Edate"];
    $hastags = $_POST["Ehastags"];
    $description = $_POST["Edescription"];
    $img = $_POST["Eimg"];
    $likes = 0;

    // testing
    $e = $S_e_events . " WHERE name = '$name'";
    $result = mysqli_query($mysqli, $e);


    if (mysqli_num_rows($result) == 0) {
        $query2 = $I_e_events . " (user_id, name, description, img, date,location, hastags, likes) VALUES ('$UID', '$name', '$description', '$img', '$date', '$location', '$hastags', '$likes')";
        echo $query2;
        $res = mysqli_query($mysqli, $query2);
    }
} else
    echo "error";

header('Location: ../home.php');
exit;
