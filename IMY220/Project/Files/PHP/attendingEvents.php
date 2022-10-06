<?php
    require "master.php";
    session_start();

    if(isset($_POST["action"]) && $_POST["action"] != ""){
        if($_POST["action"] == "getAttending"){
            $EID = $_POST["EID"];
            $query = $S_attending_events . " WHERE event_id = '$EID'";
            $result = mysqli_query($mysqli, $query);
            $result = mysqli_fetch_all($result, MYSQLI_ASSOC);
            echo json_encode($result);
        } else if ($_POST["action"] == "setAttending"){
            $EID = $_POST["EID"];
            $data = $_POST["data"];
            $data = implode(",",$data);
            $data = "[".$data."]";
            $query2 = $U_attending_events . " SET user_ids = ('$data') WHERE event_id = '$EID' ";
            $result2 = mysqli_query($mysqli, $query2);
            echo $result2;
            
        }else if ($_POST["action"] == "insertAttending"){
            $EID = $_POST["EID"];
            $data = $_POST["data"];
            $data = implode(",",$data);
            $data = "[".$data."]";
            $query2 = $I_attending_events . " (user_ids, event_id) VALUES ('$data', '$EID')";
            $result2 = mysqli_query($mysqli, $query2);
            echo $result2;
        }
    }
?>