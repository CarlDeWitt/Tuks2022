<?php
require "master.php";
if (isset($_SESSION["UserIndex"])) {
  $userid = $_SESSION["UserIndex"];
  $query = $S_list . " WHERE user_id = $userid";
  $result = mysqli_query($mysqli, $query);

  while ($rowE = mysqli_fetch_array($result)) {
    // echo "hello" . $rowE["id"] . "<br>";
    // echo $rowE["id"];  
    // echo print_r($rowE);
    $Lid = $rowE["id"];
    $LN = $rowE["ListName"];
    echo "<div onclick='showList(this)' class=\"col-6 offset-3 ListHead\" >$LN <i class=\"fa-solid fa-angle-down\"></i><i class=\"fa-solid fa-trash-can delHide\" style=\"margin:0 0 0 10px;\" onclick='deleteList($Lid)'></i></div>";
    echo "<div class=\"row evenstDisp\">";
    $query3 = $S_list_events . " WHERE list_id = '$Lid' AND user_id = '$userid'";
    $result3 = mysqli_query($mysqli, $query3);

    $count = 0;
    while ($rowD = mysqli_fetch_array($result3)) {
      $id = $rowD["event_id"];
      $query2 = $S_e_events . " WHERE id = '$id'";
      $result2 = mysqli_query($mysqli, $query2);
      while ($rowE2 = mysqli_fetch_array($result2)) {
        echo "<div class='col-md-4'>
                    <div class='card' style='width: 18rem'>
                      <img
                        src='Media/Images/$rowE2[img]'
                        class='card-img-top imgCont'
                        alt='Event img'
                      />
                      <i
                        class='fa-solid fa-heart Rheart'
                        onclick='heart(\"$rowE2[id]\",this)'
                      ></i>
                      <i
                        class='fa-solid fa-plus Radd'
                        onclick='add(\"$rowE2[id]\",this)'
                      ></i>
                      <div class='Rdate'>$rowE2[date]</div>
                      <div class='card-body EB' onclick=(red($rowE2[id]))>
                        <div class='card-text Ecard'>
                          <h2 class='Ename'>$rowE2[name]</h2>
                          <div class='innerbody'>
                            <p class='Eloaction'><i style=\"margin:0 10px 0 0\" class=\"fa-solid fa-map-pin\"></i>$rowE2[location]</p>
                            <p class='description descHide'><i style=\"margin:0 10px 0 0\" class=\"fa-solid fa-angles-right\"></i>$rowE2[description]</p>
                            <i class=\"fa-solid fa-trash-can Rdel delHide\" style=\"margin:10px 0 10px 0px;\" onclick='deleteEvent(\"$rowE2[id]\",this,$_SESSION[UserIndex])'></i>
                            <p class='Ehas'>$rowE2[hastags]</p>                  
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>";
      }
    }
    echo "</div>";
  }
}
