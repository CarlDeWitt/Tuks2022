// console.log(EID);
openAttending(EID);
getReviews(EID);

heart = () => {
  const heart = document.querySelector(".fa-heart");
  if (heart.style.color == "red") {
    heart.style.color = "#7848f4";
  } else {
    heart.style.color = "red";
    heart.classList.add("bounce");
    setTimeout(function () {
      heart.classList.remove("bounce");
    }, 800);
  }
};
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the moda
let EventID = -1;
addlist = (e) => {
  //   console.log(e);
  EventID = e;
  modal.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
  modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

function getListName(userID, listID, element) {
  element.classList.toggle("click");
  setTimeout(function () {
    element.classList.toggle("click");
  }, 500);
  if (EventID == -1) {
    alert("Please select an event");
    return;
  }
  console.log("userID" + userID, "ListID" + listID, "EventID" + EventID);

  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/insertIntoList.php", //Ajax Action url
    data: { UID: userID, LID: listID, EID: EventID }, //Form Data
    success: function (data, textStatus, jqXHR) {
      console.log(data);
    },
  });
  location.reload();
}

const h = document.querySelector(".exit");
setTimeout(function () {
  h.classList.toggle("exit");
}, 10000);

//DElete Event
Del = (eventid, userid) => {
  // function deleteEvent(eventid, element, userid) {
  console.log(eventid, userid);
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/deleteEvent.php", //Ajax Action url
    data: { UID: userid, EID: eventid }, //Form Data
    success: function (data, textStatus, jqXHR) {
      console.log(data);
    },
  });
  location.reload();
  location.href = "./home.php";
  // }
};

// Attend Function
attend = (eventid, userid) => {
  // console.log(eventid, userid);

  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/attendingEvents.php", //Ajax Action url
    data: { action: "getAttending", EID: eventid },
    success: function (data, textStatus, jqXHR) {
      let insertAttending = true;
      if (data != "[]") {
        //make into json
        data = JSON.parse(data);
        // only take the first element since there will only be one
        data = data[0].user_ids;
        insertAttending = false;
      }

      // make the object a json object
      data = JSON.parse(data);
      // console.log(data);

      // check if data contains -1
      if (data.includes(-1)) {
        data.splice(data.indexOf(-1), 1);
      }

      // check if the user is already attending
      if (data.includes(userid)) {
        // remove the user from the list
        for (let i = 0; i < data.length; i++) {
          if (data[i] == userid) {
            data.splice(i, 1);
          }
        }
        if (data.length == 0) {
          data.push(-1);
        }
      } else {
        // add the user to the list
        data.push(userid);
      }

      checkifAttending(userid, data);

      $.ajax({
        type: "POST", // Method type GET/POST
        url: "./PHP/attendingEvents.php", //Ajax Action url
        data: {
          action: `${insertAttending == true ? "insert" : "set"}Attending`,
          EID: eventid,
          data: data,
        },
        success: function (data, textStatus, jqXHR) {
          // console.log(data);
        },
      });

      // get the array then add the user id to it then send it back to the database
    },
  });
};

checkifAttending = (UID, data) => {
  const icon = document.querySelector(".fa-bell-concierge");
  if (data.includes(UID)) {
    icon.style.color = "gold";
    icon.classList.add("bounce");
    setTimeout(function () {
      icon.classList.remove("bounce");
    }, 800);
  } else {
    icon.style.color = "#7848f4";
    icon.classList.add("bounce");
    setTimeout(function () {
      icon.classList.remove("bounce");
    }, 800);
  }
};

// userOpens page check if they are attending

function openAttending(eventid) {
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/attendingEvents.php", //Ajax Action url
    data: { action: "getAttending", EID: eventid },
    success: function (data, textStatus, jqXHR) {
      data = JSON.parse(data);
      data = JSON.parse(data[0].user_ids);
      3;
      // console.log(data);
      checkifAttending(UID, data);
    },
  });
}

// go to profile page
GoToProfile = (userid) => {
  // console.log(userid);
  location.href = "./profilePage.php?UID=" + userid;
};

// Create review MODAL
var modal2 = document.getElementById("myModal2");

// Get the button that opens the modal
var btn2 = document.getElementById("myBtn2");

// Get the <span> element that closes the modal
var span2 = document.getElementsByClassName("close2")[0];

// When the user clicks the button, open the modal
btn2.onclick = function () {
  modal2.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span2.onclick = function () {
  modal2.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal2) {
    modal2.style.display = "none";
  }
};

// DISPLAY REVIEWS

function getReviews(EID) {
  $.ajax({
    type: "POST",
    url: "./PHP/getReview.php",
    data: { TYPE: "GR", EID: EID },
    success: function (data, textStatus, jqXHR) {
      if (data == "No reviews") {
        return;
      }
      data = JSON.parse(data);
      console.log(typeof data);
      if (data.length > 0) {
        for (let i = 0; i < data.length; i++) {
          let review = data[i].description;
          let rating = data[i].rating;
          let user = data[i].user_id;
          getUserName(user).then((name) => {
            console.log(name);
            // var username =
            // console.log("after getUserName");
            let imgstrGold = "";
            for (let i = 1; i <= 5; i++) {
              if (rating >= i) {
                imgstrGold += `<i class="fa-solid fa-star STR${i}"></i>`;
              } else {
                imgstrGold += `<i class="fa-solid fa-star"></i>`;
              }
            }
            let img = data[i].review_img;
            $(`.appendReview`)
              .append(`<div class="col-lg-5 col-md-12 ReviewsEvent">
            <div class="ReviewL">  
            <img src="Media/Images/reviews/${img}" class="ReviewsIMG"/>
            <div class="ReviewsRating">${imgstrGold}</div>
            </div>
            <div class="ReviewR">
            <div class="ReviewName">${name}</div>
            <div class="Reviewtext">${review}</div>
            <i class="fa-solid fa-trash ReviewDel" onclick="DelReview(${data[i].id})"></i>
            </div>
            </div>`);
          });
        }
      } else if (typeof data == "object") {
        let review = data.description;
        let rating = data.rating;
        let user = data.user_id;
        getUserName(user).then((name) => {
          let img = data.review_img;
          $(`.appendReview`)
            .append(`<div class="col-lg-6 col-md-12 ReviewsEvent">
          <div class="ReviewL">  
          <img src="Media/Images/reviews/${img}" class="ReviewsIMG"/>
          <div class="ReviewsRating"><i class="fa-solid fa-star STR1"></i><i class="fa-solid fa-star STR2"></i><i class="fa-solid fa-star STR4"></i><i class="fa-solid fa-star STR4"></i><i class="fa-solid fa-star STR5"></i></div>
          </div>
          <div class="ReviewR">
          <div class="ReviewName">${name}</div>
          <div class="Reviewtext">${review}</div>
          <i class="fa-solid fa-trash ReviewDel" onclick="DelReview(${data.id})"></i>
          </div>
          </div>`);
        });
      }
    },
  });
}

function getUserName(UID) {
  return new Promise((resolve, reject) => {
    $.ajax({
      type: "POST",
      url: "./PHP/getReview.php",
      data: { TYPE: "GU", UID: UID },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);
        data = data.name;
        // console.log(data);
        resolve(data);
      },
    });
  });
}

DelReview = (RID) => {
  console.log(RID);
  $.ajax({
    type: "POST",
    url: "./PHP/getReview.php",
    data: { TYPE: "DR", RID: RID },
    success: function (data, textStatus, jqXHR) {
      location.reload();
    },
  });
};
