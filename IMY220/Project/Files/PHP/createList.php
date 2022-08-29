<?php
    require "master.php";
    session_start();
    $userID =  $_SESSION["UserIndex"];
    if(isset($_POST["listName"]) && $_POST["listName"] != "" && isset($userID)){
        $LN = $_POST["listName"];
        $query = $I_list . "(ListName, user_id) VALUES ('$LN', '$userID');";
        $result = mysqli_query($mysqli, $query);
        header('Location: ../home.php');
        exit;
    }
?>