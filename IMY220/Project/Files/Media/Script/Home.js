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

/*-------Events like and add--------*/
function heart(name, element) {
  element.classList.toggle("click");
  setTimeout(function () {
    element.classList.toggle("click");
  }, 500);
  console.log(name);
}

function add(name, element) {
  element.classList.toggle("click");
  setTimeout(function () {
    element.classList.toggle("click");
  }, 500);
  console.log(name);
}

/*------End Events like and add--------*/
