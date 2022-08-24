<?php
    require "master.php";
    $userID = 2;
    if(isset($_POST["listName"]) && $_POST["listName"] != "" && isset($userID)){
        $LN = $_POST["listName"];
        $query = $I_list . "(ListName, user_id) VALUES ('$LN', '$userID');";
        $result = mysqli_query($mysqli, $query);
        header('Location: ../home.php');
        exit;
    }
?>