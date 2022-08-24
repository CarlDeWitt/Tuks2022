<!-- 38 Carl de Witt u21444928 -->
<!DOCTYPE html>
<html>
  <head>
    <title>IMY220 - Project</title>
    <meta charset="utf-8" />

    <!-- font Awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
      integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- PopperJS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
    <!-- AOS -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <link rel="stylesheet" href="Media/CSS/home.css" />



    <!-- Include Bootstrap and style.css here -->
  </head>
  <body>
    <div class="container">
      <!-- Navigation -->
      <div class="row headRow">
        <div class="col-md-6">
          <p>Event Sureley</p>
        </div>
        <div class="col-md-5 offset-md-1">
          <div class="container-fluid navCont">
            <div class="row">
              <div id="NavBtn1" class="col-md-4 navContT navActive">
                <i class="fa-solid fa-earth-americas"></i>Global
              </div>
              <div id="NavBtn2" class="col-md-4 navContT">
                <i class="fa-solid fa-bars"></i>Profile
              </div>
              <div id="NavBtn3" class="col-md-4 navContT">
                <i class="fa-solid fa-arrow-right-from-bracket"></i>Logout
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- images -->
      <div class="row">
        <div class="col-12">
          <img src="Media/Images/eventplacholder.jpg" />
        </div>
      </div>

      <!-- Search -->
      <div class="row">
        <div class="col-10 offset-1">
          <!-- inner container -->
          <div class="container cont2">
            <div class="row">
              <!-- Name -->
              <div class="col-md-4">
                <label for="Ename">Event Name:</label>
                <input
                  type="text"
                  id="Ename"
                  class="form-control"
                  placeholder="Hazelwood"
                  name="Ename"
                />
              </div>

              <!-- Date -->
              <div class="col-md-4">
                <label for="Edate">Event Date:</label>
                <input
                  type="date"
                  id="Edate"
                  class="form-control"
                  name="Edate"
                />
              </div>

              <!-- time -->
              <div class="col-md-4 searchBTNParent">
                <button type="submit" class="searchBTN">
                  Search <i class="fa-solid fa-paper-plane"></i>
                </button>
              </div>
            </div>

            <div class="row">
              <!-- button -->
              <div class="col-md-4 offset-md-4">
                <button type="submit" class="createSub">
                  Create <i class="fa-solid fa-paper-plane"></i>
                </button>
              </div>
            </div>

            <!-- Name and Location -->
            <form action="./PHP/createEvent.php" method="POST">
              <div class="row createRows Dsnone">
                <div class="col-md-6">
                  <label for="Ename">Event Name:</label>
                  <input
                    type="text"
                    id="Ename"
                    class="form-control"
                    placeholder="Spoeg wolf"
                    name="Ename"
                  />
                </div>
                <div class="col-md-6">
                  <label for="Elocaction">Location:</label>
                  <input
                    type="text"
                    id="Elocaction"
                    class="form-control"
                    placeholder="33 lynwood road"
                    name="Elocaction"
                  />
                </div>
              </div>

              <!-- date and hastags -->
              <div class="row createRows Dsnone">
                <div class="col-md-6">
                  <label for="Edate">Date:</label>
                  <input
                    type="date"
                    id="Edate"
                    class="form-control"
                    name="Edate"
                  />
                </div>
                <div class="col-md-6">
                  <label for="Ehastags">Hastags:</label>
                  <input
                    type="text"
                    id="Ehastags"
                    class="form-control"
                    placeholder="#goodVibes"
                    name="Ehastags"
                  />
                </div>
              </div>

              <!-- img and description -->
              <div class="row createRows Dsnone">
                <div class="col-md-6">
                  <label for="Edescription">Description:</label>
                  <input
                    type="text"
                    id="Edescription"
                    class="form-control"
                    placeholder="Description of the event"
                    name="Edescription"
                  />
                </div>
                <div class="col-md-6">
                  <label for="Eimg">Event Image:</label>
                  <input
                    type="file"
                    class="form-control"
                    name="Eimg"
                    id="Eimg"
                  /><br />
                </div>
              </div>

                <!-- submitbutton -->                
                <div class="row createRows Dsnone">
                <div class="col-md-6">
                  </div>
                    <button type="submit" class="sendBTN">
                      Submit <i class="fa-solid fa-paper-plane"></i>
                    </button>
                  </div>
            </form>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <p id="typeEvent">Local</p>
        </div>
      </div>
      <div id="myModal" class="modal">

  <!-- Modal content -->
      <div class="modal-content">
        <div class="modal-header">
          <span class="close">&times;</span>
          <h2>Your Lists</h2>
        </div>
        <div class="modal-body">
          <div class="container listCont">
            <div class="row rowlist">
              <div class="col-md-6 col-12">
                <form action="./PHP/createList.php" method="post">
                <label for="listName" class="listhead">List Name:</label>
                <input type="text" id="listName" name="listName" class="form-control" placeholder="List Name" />
                <input type="submit" value="Create List" class="createSub" />
                </form> 
              </div>
              <div class="col-md-6 col-12">
                <p class="listhead" id="Mylist" >My Lists</p>
                <?php
                  require "./PHP/list.php";
                ?>
              </div>
            </div>
          </div>
          
          
        </div>
        <div class="modal-footer">
        </div>
      </div>

</div>
      <!-- Data Elemets -->
      <div class="row">  
        <?php 
        require 'PHP/display.php';
        ?>
      </div>
      
    </div>
    <script src="Media/Script/Home.js"></script>
    <footer>
      <div class="container-fluid">
        <div class="row">
          <div
            class="col-md-3 offset-md-1 col-sm-5 offset-sm-1 col-lg-2 offset-lg-2"
          >
            <a href="https://www.instagram.com">
              <i class="bottemI fa-brands fa-instagram"></i>Instagram
            </a>
          </div>
          <div class="col-md-3 col-sm-5 col-lg-2">
            <a href="https://twitter.com/?lang=en-za">
              <i class="bottemI fa-brands fa-twitter"></i>Twitter
            </a>
          </div>
          <div class="col-sm-5 offset-sm-1 col-md-3 offset-md-0 col-lg-2">
            <a href="https://www.youtube.com">
              <i class="bottemI fa-brands fa-youtube"></i>Youtube
            </a>
          </div>
          <div class="col-md-3 offset-md-1 col-sm-5 col-lg-2 offset-lg-0">
            <a href="https://www.facebook.com">
              <i class="bottemI fa-brands fa-facebook"></i>Facebook
            </a>
          </div>
        </div>
      </div>
    </footer>

  </body>
</html>
