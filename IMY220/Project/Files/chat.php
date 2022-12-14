<!-- <?php 
    require './PHP/master.php';
    session_start();
    $AID = $_SESSION['UserIndex']; // the user who is logged in
    $UID = $_GET['UID']; // the user who is being viewed or sent the message to

    // echo "AID: ", $AID, " UID: ", $UID;

    $TOquery = $S_pfp . " WHERE userID = $UID";
    $TOresult = mysqli_query($mysqli, $TOquery);
    $TOrow = mysqli_fetch_assoc($TOresult);
    $TOname = $TOrow['userName'];

    $TOimg = $TOrow['pfpImg'];

    $FROMquery = $S_pfp . " WHERE userID = $AID";
    $FROMresult = mysqli_query($mysqli, $FROMquery);
    $FROMrow = mysqli_fetch_assoc($FROMresult);
    $FROMname = $FROMrow['userName'];

    $FROMimg = $FROMrow['pfpImg'];



    echo $TOname, $FROMname;

    
?> -->

<!-- 38 Carl de Witt u21444928 -->
<!DOCTYPE html>
<html>
  <head>
    <title>Chat</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="Media/CSS/Chat.css" />

    <script
      src="https://code.jquery.com/jquery-3.6.1.min.js"
      integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
      crossorigin="anonymous"
    ></script>

    <link
      rel="apple-touch-icon"
      sizes="180x180"
      href="Media/Fav/apple-touch-icon.png"
    />
    <link
      rel="icon"
      type="image/png"
      sizes="32x32"
      href="Media/Fav/favicon-32x32.png"
    />
    <link
      rel="icon"
      type="image/png"
      sizes="16x16"
      href="Media/Fav/favicon-16x16.png"
    />
    <link rel="manifest" href="Media/Fav/site.webmanifest" />

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Exo+2&family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap"
      rel="stylesheet"
    />

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Exo+2&family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />
    <!-- AOS -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <!-- font Awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
      integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- PopperJS -->
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"
      integrity="sha512-2rNj2KJ+D8s1ceNasTIex6z4HWyOnEYLVC3FigGOmyQCZc2eBXKgOxQmo3oKLHyfcj53uz4QMsRCWNbLd32Q1g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
    />
    <!-- JavaScript Bundle with Popper -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
  <div class="menu">
            <div class="back"><i class="fa fa-chevron-left" onclick="GoBack()"></i> <img src="./Media/Images/profile/<?php echo $TOimg; ?>" draggable="false"/></div>
            <div class="name"><?php echo $TOname;?></div>
            <div class="last">18:09</div>
        </div>
    <ol class="chat">
    <!-- <li class="other">
        <div class="avatar"><img src="./Media/Images/profile/<?php echo $TOimg; ?>" draggable="false"/></div>
      <div class="msg">
        <p>Hello!</p>
        <time>20:17</time>
      </div>
    </li>
    <li class="self">
        <div class="avatar"><img src="./Media/Images/profile/<?php echo $FROMimg; ?>" draggable="false"/></div>
      <div class="msg">
        <p>Hellooooo ????</p>
        <time>20:18</time>
      </div>
    </li> -->
   
    </ol>
    <input class="textarea" type="text" placeholder="Type here!"/></div>
  </body>
  <script>
    AOS.init();
    const UID = <?php echo $UID ?>;
    const actualUID = <?php echo $AID ?>;
    const TOIMG = "<?php echo $TOimg ?>";
    const FROMIMG = "<?php echo $FROMimg ?>";
  </script>
  <script src="./Media/Script/Chat.js"></script>
</html>
