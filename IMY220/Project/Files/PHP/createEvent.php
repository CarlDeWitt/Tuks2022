<?php
    require "master.php";
    session_start();
    $UID = $_SESSION['UserIndex'];
    print_r($_POST);

    if(isset($_POST["Ename"]) && $_POST["Ename"] != "" &&
        isset($_POST["Elocaction"]) && $_POST["Elocaction"] != "" &&
        isset($_POST["Edate"]) && $_POST["Edate"] != "" &&
        isset($_POST["Ehastags"]) && $_POST["Ehastags"] != "" &&
        isset($_POST["Edescription"]) && $_POST["Edescription"] != "" &&
        isset($_POST["Eimg"]) && $_POST["Eimg"] != ""){
        $name = $_POST["Ename"];
        $location = $_POST["Elocaction"];
        $date = $_POST["Edate"];
        $hastags = $_POST["Ehastags"];
        $description = $_POST["Edescription"];
        $img = $_POST["Eimg"];

        $query= $S_e_events . " WHERE name = '$name' ;";
        $result = mysqli_query($mysqli, $query);
        if(mysqli_num_rows($result) == 0){
            $query = $I_e_events . "(user_id, name, description, img, date,location, hastags) VALUES ($UID, '$name', '$description', '$img', '$date', '$location', '$hastags');";
            mysqli_query($mysqli, $query);
        }
        
    }else
        echo "error";

        header('Location: ../home.php');
        exit;

?>