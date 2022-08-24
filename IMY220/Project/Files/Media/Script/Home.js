/*--------create functionallity ----------*/
const createButton = document.querySelector(".createSub");
const rows = document.querySelectorAll(".createRows");

createButton.onclick = function () {
  rows.forEach((e) => {
    e.classList.toggle("Dsnone");

    e.classList.toggle("animationOpacity");
  });
};
/*--------END create functionallity ----------*/

/*--------Nav bar ----------*/
const navButton1 = document.querySelector("#NavBtn1"); //global variable
const navButton2 = document.querySelector("#NavBtn2"); //Profile
const navButton3 = document.querySelector("#NavBtn3"); //Logout

navButton1.onclick = function () {
  navButton1.classList.add("navActive");
  navButton2.classList.remove("navActive");
  navButton3.classList.remove("navActive");
};

navButton2.onclick = function () {
  navButton2.classList.add("navActive");
  navButton1.classList.remove("navActive");
  navButton3.classList.remove("navActive");
};

navButton3.onclick = function () {
  navButton3.classList.add("navActive");
  navButton2.classList.remove("navActive");
  navButton1.classList.remove("navActive");
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
}

//diplay Description
function desc(element) {
  var x = element.querySelector(".description");
  x.classList.toggle("descHide");
}

//likeBTN
