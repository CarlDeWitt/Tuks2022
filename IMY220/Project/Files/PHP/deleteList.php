<?php
    require "master.php";

    $LID = $_POST["LID"];

    $query = "DELETE FROM list WHERE id = '$LID'";
    $result = mysqli_query($mysqli, $query);
    $query2 = "DELETE FROM list_events WHERE list_id = '$LID'";
    $result2 = mysqli_query($mysqli, $query2);
?>