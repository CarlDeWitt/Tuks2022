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
