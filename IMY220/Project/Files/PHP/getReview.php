<?php 

require "master.php";

    $EID = $_POST["EID"];
    $query = $S_review . " WHERE event_id = $EID";
    $result = mysqli_query($mysqli, $query);
    if(mysqli_num_rows($result) == 0){
        echo "No reviews";
    }else if(mysqli_num_rows($result) == 1){
        $result = mysqli_fetch_assoc($result);
        echo json_encode($result);
    }else{
        $result = mysqli_fetch_all($result, MYSQLI_ASSOC);
        echo json_encode($result);
    }
?>