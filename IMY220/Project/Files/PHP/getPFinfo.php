<?php
    require './master.php';
    session_start();
    // $UID = $_SESSION['UserIndex'];
    $UID = $_POST['UID'];
    $Type = $_POST['Type'];

    // $Type = "UI";


    if($Type == "G"){        
        $query = $S_pfp . " WHERE userID = $UID";
        $result = mysqli_query($mysqli, $query);
        $result = mysqli_fetch_all($result, MYSQLI_ASSOC);
        echo json_encode($result);
    }else if ($Type == "GF"){
        // $query = "SELECT friends FROM profilepage WHERE userID = $UID";
        $query = $S_pfp . " WHERE userID = $UID";
        $result = mysqli_query($mysqli, $query);
        $result = mysqli_fetch_all($result, MYSQLI_ASSOC);
        echo json_encode($result);       
    }else if($Type == "UD"){
        $fri = $_POST['FRI'];
        $followers = $_POST['FOL'];
        $AID = $_POST['AID'];

        $qry = $S_pfp . " WHERE userID = $AID";
        $res = mysqli_query($mysqli, $qry);
        $res = mysqli_fetch_assoc($res);
        $follwoing = $res['following'];
        $follwoing = intval($follwoing);
        $follwoing = $follwoing - 1;

        $qry2 = "UPDATE profilepage SET following = $follwoing WHERE userID = $AID";
        $res2 = mysqli_query($mysqli, $qry2);
        

        $query = "UPDATE profilepage SET friends = '$fri', followers = '$followers' WHERE userID = $UID";
        // $query = "UPDATE profilepage SET friends = '$fri' WHERE userID = $UID";
        $result = mysqli_query($mysqli, $query);
        echo "done";
    }else if($Type == "UI"){
        $fri = $_POST['FRI'];
        $followers = $_POST['FOL'];
        $AID = $_POST['AID'];


        $qry = $S_pfp . " WHERE userID = $AID";
        $res = mysqli_query($mysqli, $qry);
        $res = mysqli_fetch_assoc($res);
        $follwoing = $res['following'];
        $follwoing = intval($follwoing);
        $follwoing = $follwoing + 1;

        $qry2 = "UPDATE profilepage SET following = $follwoing WHERE userID = $AID";
        $res2 = mysqli_query($mysqli, $qry2);
   
        // $res = json_encode($res);
        // var_dump($res);
        

        $query = "UPDATE profilepage SET friends = '$fri', followers = '$followers' WHERE userID = $UID";
        // $query = "UPDATE profilepage SET friends = '$fri' WHERE userID = $UID";
        $result = mysqli_query($mysqli, $query);
        echo "done";
    }
?>