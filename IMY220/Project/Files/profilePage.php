<!-- 38 Carl de Witt u21444928 -->
<!DOCTYPE html>
<html>

<head>
  <title>Profile</title>
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

$UID = $_SESSION['UserIndex'];
if(isset($UID) && $UID != ""){
  

    $query = $S_e_users . " WHERE id = $UID";
    $result = mysqli_query($mysqli, $query);
    $row = mysqli_fetch_assoc($result);
    $name = $row['name'];
    $surname = $row['surname'];
    $email = $row['email'];
    $DOB = $row['DOB'];
    // echo $name, $surname, $email, $DOB;
}

?>

<body>
  
  <h1>HELLO <?php echo $name ?></h1>

</body>
  <script>
    AOS.init();
  </script>
  <!-- <script src="./Media/Script/DSE.js"></script> -->

</html>