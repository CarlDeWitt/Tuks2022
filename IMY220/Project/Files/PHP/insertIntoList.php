<?php
    require "master.php";
    if(isset($_POST["EID"]) && isset($_POST["LID"]) && isset($_POST["UID"])){
        $EID = $_POST["EID"];
        $LID = $_POST["LID"];
        $UID = $_POST["UID"];
        $query = $S_list_events . " WHERE event_id = '$EID' AND list_id = '$LID' AND user_id = '$UID';";
        $result = mysqli_query($mysqli, $query);
        if(mysqli_num_rows($result) == 0){
            $query = $I_list_events ."(list_id, event_id, user_id) VALUES ('$LID', '$EID', '$UID');";
            $result = mysqli_query($mysqli, $query);            
        }
        echo "success";
    }        
    else{
        echo "not nice";
    }
?>