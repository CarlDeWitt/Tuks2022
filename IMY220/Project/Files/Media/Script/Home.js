/*--------create functionallity ----------*/
const createButton = document.querySelector(".createSub");
const rows = document.querySelectorAll(".createRows");

let click = true;

createButton.onclick = function () {
  if (click) {
    rows.forEach((e) => {
      e.classList.toggle("Dsnone");

      e.classList.add("animationOpacity");
    });
  } else {
    rows.forEach((e) => {
      e.classList.remove("animationOpacity2");
      e.classList.add("animationOpacity2");
      setTimeout(function () {
        e.classList.remove("animationOpacity2");
        e.classList.toggle("Dsnone");
      }, 800);
    });
  }
  click ? (click = false) : (click = true);
};
/*--------END create functionallity ----------*/

// LOGOUT
Logout = () => {
  location.href = "./PHP/logout.php";
};

// description stuff
let click2 = true;

// function descAnimation(e) {
//   if (click2) {
//     e.classList.add("animationOpacity");
//   } else {
//     e.classList.remove("animationOpacity");
//     e.classList.add("animationOpacity2");
//     setTimeout(function () {
//       e.classList.remove("animationOpacity2");
//     }, 800);
//   }
//   click2 ? (click2 = false) : (click2 = true);
// }
{
  /* <a href=\"DSE.html?EID=@$rowE2[id]\"> */
}

/*--------Nav bar ----------*/
const navButton1 = document.querySelector("#NavBtn1"); //global variable
const navButton2 = document.querySelector("#NavBtn2"); //Profile
const navButton3 = document.querySelector("#NavBtn3"); //Logout

navButton2.onclick = function () {
  navButton2.classList.add("navActive");
  navButton3.classList.remove("navActive");
};

navButton3.onclick = function () {
  navButton3.classList.add("navActive");
  navButton2.classList.remove("navActive");
};
/*--------END Nav bar ----------*/

/*------End Events like and add--------*/

var modal = document.getElementById("myModal");

// Get the button that opens the modal
// var btn = document.querySelectorAll(".Radd");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
// btn.onclick = function () {
//   modal.style.display = "block";
// };

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

/*-------Events like and add--------*/
let EventID = -1;
function heart(name, element) {
  element.classList.toggle("click");
  setTimeout(function () {
    element.classList.toggle("click");
  }, 500);
  console.log(name);
}

function add(name, element) {
  EventID = name;
  element.classList.toggle("click");
  setTimeout(function () {
    element.classList.toggle("click");
  }, 500);
  modal.style.display = "block";
  console.log(name);
}

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

//diplay Description
function red(e) {
  // var x = element.querySelector(".description");
  // var y = element.querySelector(".Rdel");
  // x.classList.toggle("descHide");
  // y.classList.toggle("delHide");
  console.log(e);
  window.location.replace("DSE.php?EID=" + e);
}

// function deleteEvent(eventid, element, userid) {
//   console.log(eventid, userid);
//   $.ajax({
//     type: "POST", // Method type GET/POST
//     url: "./PHP/deleteEvent.php", //Ajax Action url
//     data: { UID: userid, EID: eventid }, //Form Data
//     success: function (data, textStatus, jqXHR) {
//       console.log(data);
//     },
//   });
//   location.reload();
// }

//likeBTN
//List delete
function showList(element) {
  element.querySelector(".fa-trash-can").classList.toggle("delHide");
  element.querySelector(".fa-angle-down").classList.toggle("delHide");
}

function deleteList(listid) {
  // console.log(listid);
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/deleteList.php", //Ajax Action url
    data: { LID: listid }, //Form Data
    success: function (data, textStatus, jqXHR) {
      console.log(data);
    },
  });
  location.reload();
}

const srchBtn = document.querySelector(".srchtxt");

// goToProfile

GoToProfile = (userid) => {
  console.log(userid);
  location.href = "./profilePage.php?UID=" + userid;
};
