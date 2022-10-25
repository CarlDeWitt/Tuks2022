<?php 
    require "master.php";

    if($_POST["type"] == "users"){

       
        $query = $S_e_users;
        $result = mysqli_query($mysqli, $query);
        // $row = mysqli_fetch_assoc($result);
        echo json_encode(mysqli_fetch_all($result, MYSQLI_ASSOC));
    }else{
        $query = $S_e_events;
        $result = mysqli_query($mysqli, $query);
        echo json_encode(mysqli_fetch_all($result, MYSQLI_ASSOC));
    }
?>