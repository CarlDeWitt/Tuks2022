<?php 
// session_start();
require 'master.php';
$_SESSION["UserIndex"] = 2;

if(isset($_SESSION["UserIndex"])){
    $userid = $_SESSION["UserIndex"];
    $query = $S_e_events . " WHERE user_id = $userid ORDER BY date ASC;";
    $result = mysqli_query($mysqli, $query);


    // display data
   
    while ($rowE = mysqli_fetch_array($result)) {
        Helpdisplay($rowE);            
    }
     
}

function Helpdisplay($data){
    echo "<div class='col-md-4'>
    <div class='card' style='width: 18rem' onclick=(desc(this))>
      <img
        src='Media/Images/eventplacholder.jpg'
        class='card-img-top imgCont'
        alt='Event img'
      />
      <i
        class='fa-solid fa-heart Rheart'
        onclick='heart(\"$data[id]\",this)'
      ></i>
      <i
        class='fa-solid fa-plus Radd'
        onclick='add(\"$data[id]\",this)'
      ></i>
      <div class='Rdate'>$data[date]</div>
      <div class='card-body EB'>
        <div class='card-text Ecard'>
          <h2 class='Ename'>$data[name]</h2>
          <div class='innerbody'>
            <p class='Eloaction'>$data[location]</p>
            <p class='description descHide'>$data[description]</p>
            <p class='Ehas'>$data[hastags]</p>
          </div>
        </div>
      </div>
    </div>
  </div>";
}



?>
