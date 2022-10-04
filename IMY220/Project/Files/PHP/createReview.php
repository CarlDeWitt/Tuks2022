<?php

require "master.php";

if(isset($_POST["EID"])  && $_POST["UID"] && $_POST["Rating"] && $_POST["Decsription"] && $_FILES["Rateimg"]){
    $EID = $_POST["EID"];
    $UID = $_POST["UID"];
    $rating = $_POST["Rating"];
    $desc = $_POST["Decsription"];
    $img = $_FILES["Rateimg"];


    $qry = $S_review . " WHERE  user_id = $UID AND event_id = $EID AND review_img = '$img[name]'";
    $res = mysqli_query($mysqli, $qry);

    if(mysqli_num_rows($res) == 0){
       
    

    $target_dir = "../Media/Images/reviews/";
    $target_file = $target_dir . basename($_FILES["Rateimg"]["name"]);
    $uploadOk = 1;
    $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
    
    // Check if image file is a actual image or fake image
    if(isset($_POST["submit"])) {
      $check = getimagesize($_FILES["Rateimg"]["tmp_name"]);
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
    if ($_FILES["Rateimg"]["size"] > 500000) {
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
      if (move_uploaded_file($_FILES["Rateimg"]["tmp_name"], $target_file)) {
        echo "The file ". htmlspecialchars( basename( $_FILES["Rateimg"]["name"])). " has been uploaded.";
      } else {
        echo "Sorry, there was an error uploading your file.";
      }
    } 



    $query = $I_review . " (`user_id`, `event_id`, `rating`, `description`, `review_img`) VALUES ('$UID', '$EID', '$rating', '$desc', '$img[name]')";
    $result = mysqli_query($mysqli, $query);   
    } else{
        echo "You have already reviewed this event";
    }

    header('Location: ../DSE.php?EID='.$EID);
}

?>