<?php
    require 'master.php';
    $id=2;

    $query = $S_list . " WHERE user_id = '$id';";
    $result = mysqli_query($mysqli, $query);

    while ($row = mysqli_fetch_array($result)) {
        echo "<div class='card' onclick=\"getListName('$row[user_id]','$row[id]',this)\">
        <div class='card-body cardName'>
           $row[ListName]
        </div>
        </div> ";
            
            
            
    }
?>