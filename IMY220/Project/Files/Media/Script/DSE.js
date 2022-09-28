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
  const icon = document.querySelector(".fa-bell-concierge");
  if (icon.style.color == "gold") {
    icon.style.color = "#7848f4";
  } else {
    icon.style.color = "gold";
    icon.classList.add("bounce");
    setTimeout(function () {
      icon.classList.remove("bounce");
    }, 800);
  }
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

      $.ajax({
        type: "POST", // Method type GET/POST
        url: "./PHP/attendingEvents.php", //Ajax Action url
        data: {
          action: `${insertAttending == true ? "insert" : "set"}Attending`,
          EID: eventid,
          data: data,
        },
        success: function (data, textStatus, jqXHR) {
          console.log(data);
        },
      });

      // get the array then add the user id to it then send it back to the database
    },
  });
};
