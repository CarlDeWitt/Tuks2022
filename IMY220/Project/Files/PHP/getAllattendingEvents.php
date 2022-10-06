<?php
    require './master.php';

    $query = $S_attending_events;
    $result = mysqli_query($mysqli, $query);
    echo json_encode(mysqli_fetch_all($result, MYSQLI_ASSOC));
?>