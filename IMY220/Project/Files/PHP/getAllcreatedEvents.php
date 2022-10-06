<?php
    require './master.php';

    $UID = $_POST['UID'];
    $Type = $_POST['Type'];

    if($Type == "M"){
        $query = $S_e_events . " WHERE user_id = $UID";
        $result = mysqli_query($mysqli, $query);
        echo json_encode(mysqli_fetch_all($result, MYSQLI_ASSOC));
    }else if($Type == "PI"){
        $query = $S_pfp . " WHERE userID = $UID";
        $result = mysqli_query($mysqli, $query);
        $result = mysqli_fetch_all($result, MYSQLI_ASSOC);
        echo json_encode($result);
    }
    else{
        $query = $S_e_events . " WHERE id = $UID";
        $result = mysqli_query($mysqli, $query);
        $result = mysqli_fetch_assoc($result);
        echo json_encode($result);
    }
?>