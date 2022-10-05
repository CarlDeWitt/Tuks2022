<!-- 38 Carl de Witt u21444928 -->
<!DOCTYPE html>
<html>
  <head>
    <title>Profile</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="Media/CSS/ProfilePage.css" />

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
  <?php
session_start();
require './PHP/master.php';

// $UID = $_SESSION['UserIndex'];
$actualUID = $_SESSION['UserIndex'];
$UID = $_GET['UID'];
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
    <div class="container outside">
      <div class="row">
        <!-- left side -->
        <div class="col-md-6 col-sm-12 leftCont">
          <div class="container leftside pannel">
            <!-- profile Img -->
            <div class="row backbtn">
              <div class="col-12 imgDiv centerDiv">
                <a id="Alogo" onclick="history.back()" class="hoverClass"
                  ><i class="fa-solid fa-arrow-left" id="logo"></i
                ></a>
                <i
                  class="fa-solid fa-house hoverClass"
                  onclick="window.location.href = './home.php'"
                  id="homeBTN"
                ></i>
                
                <!-- <i class="fa-solid fa-user-pen" ></i> -->
                <i class="fa-solid fa-pen"id="editBTN" onclick="editBTN()"></i>
                <img
                  src="Media/Images/profile/pfp.jpg"
                  alt="Profile Image"
                  class="profileImg"
                />
              </div>
            </div>

            <!-- HR TAG -->
            <div class="col-10 offset-1 hrTag"></div>
            <!-- user Info -->
            <div class="row">
              <!-- Name -->
              <div class="col-12 UserName centerDiv">
                <?php echo $name ?>
              </div>

              <!-- HR TAG -->
              <div class="col-10 offset-1 hrTag"></div>

              <div class="col-12 btns">
                <button type="button" id="chatOut">
                  <i id="chatBTN" class="fa-regular hoverClass fa-comment"></i
                  >chat
                </button>
                <button type="button" id="followOut">
                  <i id="followBTN" class="fa-solid hoverClass fa-tag"></i>
                  <p id="followtxt">Follow</p>
                  <p></p>
                </button>
              </div>

              <div class="col-10 offset-1 hrTag"></div>
              <!-- description -->
              <div class="col-12 UserDescription centerDiv">
                add description here
              </div>
            </div>
          </div>
          <!-- Left bottem -->
          <div class="container leftside leftBottem pannel">
            <div class="row">
              <!-- Num events -->

              <!-- Num friends -->
              <div class="col-md-5 col-sm-12 offset-md-1 NumFriends centerDiv">
                <div class="userInfoHalfs">
                  <div class="title">Followers</div>
                  <div id="followers" class="value">420</div>
                </div>
              </div>

              <!-- Num friends -->
              <div class="col-md-5 col-sm-12 NumFriends centerDiv">
                <div class="userInfoHalfs">
                  <div class="title">Following</div>
                  <div id="following" class="value">420</div>
                </div>
              </div>
            </div>
          </div>

          <!-- friends -->
          <div class="container leftside pannel">
            <div class="row appendFriends"></div>
          </div>
        </div>

        <!-- right side -->
        <div class="col-md-6 col-sm-12">
          <div class="container rightside pannel">
            <div class="row appendCE">
              <!-- created events header-->
              <div class="col-12 rightsideHead">Created Events</div>
              <!-- created events -->
            </div>
          </div>

          <div class="container rightside pannel AEPannel">
            <div class="row appendAE">
              <!-- created events header-->
              <div class="col-12 rightsideHead">Attending Events</div>
              <!-- created events -->
            </div>            
          </div>
          
        </div>
      </div>
    </div>

    <!-- MODAL -->

    <div id="myModal2" class="modal2">

        <!-- Modal content -->
        <div class="modal-content2">
          <span class="close2">&times;</span>
          <div class="container CreateReview">
            <div class="row">
              <div class="col-12 CRHead">Edit Profile</div>
              <form action="./PHP/updatePF.php" method="POST" enctype="multipart/form-data">
                <input type="hidden" id="UID" name="UID" value="<?php echo $UID;?>">
                
                <div class="col-6 offset-3 CRInput">
                  
                  <label for="Decsription">Description:</label>
                  <input type="text" id="Decsription" name="Decsription" placeholder="was a good event"/>
                  
                </div>
                
                <div class="col-6 offset-3 CRInput">
                  
                  <label for="Rateimg">Profile Image:</label>
                  <input type="file" class="form-control" name="Rateimg" id="fileToUpload" />
                  
                </div>
                
                <div class="col-3 offset-3 CRSub">
                  
                  <button type="submit" class="sendBTN">
                    Submit <i class="fa-solid fa-paper-plane"></i>
                  </button>
                </div>
              </form>

              
            </div>
          </div>
        </div>
  </body>
  <script>
    AOS.init();
    const UID = <?php echo $UID ?>;
    const actualUID = <?php echo $actualUID ?>;
  </script>
  <script src="./Media/Script/ProfilePage.js"></script>
</html>
