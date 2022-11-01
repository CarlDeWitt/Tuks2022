<?php
    require 'master.php';
    $UID = $_POST["UID"];
    $EID = $_POST["EID"];

    if($UID == 4){
        $sql = "DELETE FROM e_event WHERE id = '$EID'";
        $result = mysqli_query($mysqli, $sql);
        // return;      
    }else{

        $query = $S_e_events . " WHERE user_id = '$UID' AND id = '$EID'";
        // echo $query;
        $result = mysqli_query($mysqli, $query);
        
        if(true){
            $query2 = "DELETE FROM e_event WHERE user_id = $UID AND id = $EID;";
            $result2 = mysqli_query($mysqli, $query2);
            $query3 = "DELETE FROM list_events WHERE event_id = $EID;";
            $result3 = mysqli_query($mysqli, $query3);
            echo "success";
        }
    }
        
    // echo "fail";
?>