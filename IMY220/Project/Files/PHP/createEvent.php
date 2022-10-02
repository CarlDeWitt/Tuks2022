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
    isset($_FILES["fileToUpload"]) && $_FILES["fileToUpload"] != ""
) {
    $name = $_POST["Ename"];
    $location = $_POST["Elocaction"];
    $date = $_POST["Edate"];
    $hastags = $_POST["Ehastags"];
    $description = $_POST["Edescription"];
    $img = $_FILES["fileToUpload"]["name"];
    $likes = 0;
    // file uplaod

    $target_dir = "../Media/Images/events/";
    $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
    
    // Check if image file is a actual image or fake image
    if(isset($_POST["submit"])) {
      $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
      if($check !== false) {
        echo "File is an image - " . $check["mime"] . ".";
        $uploadOk = 1;
      } else {
        echo "File is not an image.";
        $uploadOk = 0;
      }
    }
    
    // Check if file already exists
    if (file_exists($target_file)) {
      echo "Sorry, file already exists.";
      $uploadOk = 0;
    }
    
    // Check file size
    if ($_FILES["fileToUpload"]["size"] > 500000) {
      echo "Sorry, your file is too large.";
      $uploadOk = 0;
    }
    
    // Allow certain file formats
    if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
    && $imageFileType != "gif" ) {
      echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
      $uploadOk = 0;
    }
    
    // Check if $uploadOk is set to 0 by an error
    if ($uploadOk == 0) {
      echo "Sorry, your file was not uploaded.";
    // if everything is ok, try to upload file
    } else {
      if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
        echo "The file ". htmlspecialchars( basename( $_FILES["fileToUpload"]["name"])). " has been uploaded.";
      } else {
        echo "Sorry, there was an error uploading your file.";
      }
    } 

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
