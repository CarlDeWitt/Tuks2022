<?php 
    require "master.php";

    if($_POST["type"] == "get"){

        $from_UID = $_POST['from_UID'];
        $to_UID = $_POST['to_UID'];
        
        $query = $S_chat . " WHERE from_uid = $from_UID AND to_uid = $to_UID";
        $result = mysqli_query($mysqli, $query);
        // $row = mysqli_fetch_assoc($result);
        echo json_encode(mysqli_fetch_all($result, MYSQLI_ASSOC));
    }else{
        $from_UID = $_POST['from_UID'];
        $to_UID = $_POST['to_UID'];
        $message = $_POST['message'];
        $time = $_POST['time'];
        $query = "INSERT INTO chat (from_uid, to_uid, message,time) VALUES ('$from_UID', '$to_UID', '$message', '$time')";
        $result = mysqli_query($mysqli, $query);
        echo "success";
    }
?>