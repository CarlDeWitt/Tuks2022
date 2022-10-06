<?php
    session_start();
    require  "master.php" ;

    $EID = $_POST['EID'];

    if(isset($_POST['Name']) && $_POST['Name'] != ""){
        $Name = $_POST['Name'];
        $query = $U_e_events . " SET `Name` = '$Name' WHERE `id` = '$EID'";
        $result = mysqli_query($mysqli, $query);
    }
    if(isset($_POST['Decsription']) && $_POST['Decsription'] != ""){
        $Decsription = $_POST['Decsription'];
        $query = $U_e_events . " SET `description` = '$Decsription' WHERE `id` = '$EID'";
        $result = mysqli_query($mysqli, $query);
    }
    if(isset($_POST['Date']) && $_POST['Date'] != ""){
        $Date = $_POST['Date'];
        $query = $U_e_events . " SET `date` = '$Date' WHERE `id` = '$EID'";
        $result = mysqli_query($mysqli, $query);
    }
    if(isset($_POST['Location']) && $_POST['Location'] != ""){
        $Location = $_POST['Location'];
        $query = $U_e_events . " SET `location` = '$Location' WHERE `id` = '$EID'";
        $result = mysqli_query($mysqli, $query);
    }
    if(isset($_POST['hashtag']) && $_POST['hashtag'] != ""){
        $hashtag = $_POST['hashtag'];
        $query = $U_e_events . " SET `hastags` = '$hashtag' WHERE `id` = '$EID'";
        $result = mysqli_query($mysqli, $query);
    }

    header('Location: ../DSE.php?EID='.$EID);
    
?>