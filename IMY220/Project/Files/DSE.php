<!-- 38 Carl de Witt u21444928 -->
<!DOCTYPE html>
<html>

<head>
  <title>Event</title>
  <meta charset="utf-8" />
  <link rel="stylesheet" href="Media/CSS/home.css" />
  <link rel="stylesheet" href="Media/CSS/DSE.css" />

  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

  <link rel="apple-touch-icon" sizes="180x180" href="Media/Fav/apple-touch-icon.png" />
  <link rel="icon" type="image/png" sizes="32x32" href="Media/Fav/favicon-32x32.png" />
  <link rel="icon" type="image/png" sizes="16x16" href="Media/Fav/favicon-16x16.png" />
  <link rel="manifest" href="Media/Fav/site.webmanifest" />

  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Exo+2&family=Roboto:wght@100&display=swap" rel="stylesheet" />

  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet" />

  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Exo+2&family=Roboto:wght@100&display=swap" rel="stylesheet" />
  <!-- AOS -->
  <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
  <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
  <!-- font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <!-- PopperJS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js" integrity="sha512-2rNj2KJ+D8s1ceNasTIex6z4HWyOnEYLVC3FigGOmyQCZc2eBXKgOxQmo3oKLHyfcj53uz4QMsRCWNbLd32Q1g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous" />
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<?php
session_start();
require './PHP/master.php';

// /

// echo $_GET['EID'];
$EID = $_GET['EID'];
$query = $S_e_events . " WHERE id = " . $EID;
$result = mysqli_query($mysqli, $query);
$row = mysqli_fetch_assoc($result);

$query2 = $S_e_users . " WHERE id = " . $row['user_id'];
$result2 = mysqli_query($mysqli, $query2);
$row2 = mysqli_fetch_assoc($result2);
// echo $row["name"] ;
?>

<body>
  <div class="container outer">
    <a href="home.php"><i class="fa-solid fa-arrow-left" id="logo"></i></a>
    <div class="row imgTxt">
      <!-- name -->
      <div class="col-12 data name"><?php echo $row["name"] ?></div>
      <!-- img -->
      <div class="col-lg-8 col-sm-12" id="img">
        <img src="Media/Images/<?php echo $row["img"] ?>" />
      </div>
      <!-- contaienr name -->
      <div class="col-lg-4 col-sm-12">
        <div class="container-fluid inner">
          <!-- user name -->
          <div class="row">
            <div class="col-10 offset-1 data">
              <i class="fa-solid fa-user spacer"></i><?php echo $row2["name"] ?>
            </div>
          </div>
          <!-- date -->
          <div class="row">
            <div class="col-10 offset-1 data">
              <i class="fa-solid fa-calendar-days spacer"></i><?php echo $row["date"] ?>
            </div>
          </div>
          <!-- location -->
          <div class="row">
            <div class="col-10 offset-1 data">
              <i class="fa-solid fa-map-pin spacer"></i><?php echo $row["location"] ?>
            </div>
          </div>

          <!-- # -->
          <div class="row">
            <div class="col-10 offset-1 data">
              <i class="fa-solid fa-hashtag spacer"></i></i><?php
                                                      $str =  $row["hastags"];
                                                      echo substr($str, 1, strlen($str));
                                                      ?>
            </div>
          </div>

          <!-- Buttons -->
          <div class="row">
            <div class="col-10 offset-1 data buttons">
              <i class="fa-solid fa-heart" onclick="heart()"></i><i class="fa-solid fa-clipboard-user" onclick="addlist(<?php echo $EID; ?>)"></i>
              <i class="fa-solid fa-trash" onclick="Del(<?php echo $EID;?>,<?php echo $_SESSION['UserIndex'];?>)"></i>
              <i class="fa-solid fa-bell-concierge" onclick="attend(<?php echo $EID;?>,<?php echo $_SESSION['UserIndex'];?>)"></i>
            </div>
          </div>
        </div>
      </div>
      <!-- description -->
      <div class="col-md-12 data desc">
        <i class="fa-solid fa-comment-dots spacer"></i><?php echo $row["description"] ?>
      </div>
    </div>
  </div>

  <div id="myModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
      <div class="modal-header close">
        <div class="YourLists">Your Lists</div>
      </div>
      <div class="modal-body">
        <div class="container listCont">
          <div class="row rowlist">
            <div class="col-md-5 col-12 listcol">
              <form action="./PHP/createList.php" method="post">
                <label for="listName" class="listhead">Make List:</i></label>
                <input type="text" id="listName" name="listName" class="form-control fc2" placeholder="List Name" />
                <input type="submit" value="Create List" id="createSub3"></input>
              </form>
            </div>
            <div class="col-md-5 offset-md-1 col-12 offset-0 listcol">
              <p class="listhead" id="Mylist">Your Lists:</p>
              <?php
              require "./PHP/list.php";
              ?>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer"></div>
    </div>
  </div>

  <script>
    AOS.init();
  </script>
  <script src="./Media/Script/DSE.js"></script>
</body>

</html>