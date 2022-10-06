<?php
require "master.php";

$query = $S_e_events . " ORDER BY date ASC;";
$result = mysqli_query($mysqli, $query);

// display data

while ($rowE = mysqli_fetch_array($result)) {
  echo "<div class='col-md-4'>
                    <div class='card' style='width: 18rem'>
                      <img
                        src='Media/Images/events/$rowE[img]'
                        class='card-img-top imgCont'
                        alt='Event img'
                      />
                      <i
                        class='fa-solid fa-heart Rheart'
                        onclick='heart(\"$rowE[id]\",this)'
                      ></i>
                      <i
                        class='fa-solid fa-plus Radd'
                        onclick='add(\"$rowE[id]\",this)'
                      ></i>
                      <div class='Rdate'>$rowE[date]</div>
                      <div class='card-body EB' onclick=(red($rowE[id]))>
                        <div class='card-text Ecard'>
                          <h2 class='Ename'>$rowE[name]</h2>
                          <div class='innerbody'>
                            <p class='Eloaction'><i style=\"margin:0 10px 0 0\" class=\"fa-solid fa-map-pin\"></i>$rowE[location]</p>
                            <p class='description descHide'><i style=\"margin:0 10px 0 0\" class=\"fa-solid fa-angles-right\"></i>$rowE[description]</p>
                            <i class=\"fa-solid fa-trash-can Rdel delHide\" style=\"margin:10px 0 10px 0px;\" onclick='deleteEvent(\"$rowE[id]\",this,$_SESSION[UserIndex])'></i>
                            <p class='Ehas'>$rowE[hastags]</p>                  
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>";
}
