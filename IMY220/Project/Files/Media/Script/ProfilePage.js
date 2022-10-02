getProfileInfo();

// console.log(UID);
// console.log(actualUID);

function getProfileInfo() {
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/getPFinfo.php", //Ajax Action url
    data: { Type: "G", UID: UID },
    success: function (data, textStatus, jqXHR) {
      data = JSON.parse(data);
      data = data[0];

      //   data
      const pfpImg = data.pfpImg;
      const followers = data.followers;
      const following = data.following;
      let friends = data.friends;
      const description = data.description;
      getFriends();

      $(`.profileImg`).attr("src", `./Media/images/profile/${pfpImg}`);
      $(`.UserDescription`).html(description);
      $(`#followers`).html(followers);
      $(`#following`).html(following);

      friends = JSON.parse(friends);

      $(`.appendFriends`).empty();
      $(`.appendFriends`).append(
        `<div class="col-12 friends friendTitle centerDiv">Friends</div>`
      );

      // console.log(friends);
      for (let i = 0; i < friends.length; i++) {
        // get Friends PFP
        $.ajax({
          type: "POST", // Method type GET/POST
          url: "./PHP/getAllcreatedEvents.php", //Ajax Action url
          data: { Type: "PI", UID: friends[i] },
          success: function (data, textStatus, jqXHR) {
            data = JSON.parse(data);
            // console.log(data);
            $(`.appendFriends`).append(`
            <div class="col-lg-6 col-md-12 friendsTiles outerCenter hoverClass" data-aos="fade-down" onclick="JumpToUser(${data[0].userID})">
                <img
                    src="./Media/Images/profile/${data[0].pfpImg}"
                    class="friendspfp"
                    alt="pfp"
                />
                <p class="friendsName">${data[0].userName}</p>
            </div>
        `);
          },
        });
      }
    },
  });
}

createdEvents();

function createdEvents() {
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/getAllcreatedEvents.php", //Ajax Action url
    data: { Type: "M", UID: UID },
    success: function (data, textStatus, jqXHR) {
      data = JSON.parse(data);
      // console.log(data);
      for (let i = 0; i < data.length; i++) {
        $(`.appendCE`).append(`
        <div class="col-10 offset-1 Events hoverClass" data-aos="fade-left" onclick="DSEJump(${data[i].id})">
            <img src="Media/Images/events/${data[i].img}"
            alt="Profile Image" class="eventImg"/>  
            <p>${data[i].name}</p>
        </div>
        `);
      }
    },
  });
}

UserAttendingEvents();

function UserAttendingEvents() {
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/getAllattendingEvents.php", //Ajax Action url
    data: {},
    success: function (data, textStatus, jqXHR) {
      data = JSON.parse(data);
      // console.log(data);

      const attending = new Array();
      for (let i = 0; i < data.length; i++) {
        attending.push(JSON.parse(data[i].user_ids));
      }

      // console.log(attending);

      for (let i = 0; i < attending.length; i++) {
        for (let j = 0; j < attending[i].length; j++) {
          if (attending[i][j] == UID) {
            let EID = data[i].event_id;
            $.ajax({
              type: "POST", // Method type GET/POST
              url: "./PHP/getAllcreatedEvents.php", //Ajax Action url
              data: { Type: "S", UID: EID },
              success: function (data, textStatus, jqXHR) {
                data = JSON.parse(data);
                // console.log(data);
                $(`.appendAE`).append(`
                <div class="col-10 offset-1 Events hoverClass" data-aos="fade-left" onclick="DSEJump(${data.id})">
                    <img src="Media/Images/events/${data.img}"
                    alt="Profile Image" class="eventImg"/>  
                    <p>${data.name}</p>
                </div>
                `);
              },
            });
          }
        }
      }
    },
  });
}

DSEJump = (EID) => {
  window.location.href = `./DSE.php?EID=${EID}`;
};

JumpToUser = (UID) => {
  // console.log(UID);
  window.location.href = `./ProfilePage.php?UID=${UID}`;
};

// Check if user if following
let isfriend = false;

function checkFollowing(ID, AID, friendsArr) {
  console.log(ID, AID, friendsArr);
  if (ID != AID) {
    for (let i = 0; i < friendsArr.length; i++) {
      if (friendsArr[i] == AID) {
        $(`#followOut`).addClass("active");
        $(`#followtxt`).text("Following");
        isfriend = true;
        return;
      }
    }
  }
}

$(`#followOut`).on("click", function () {
  if (UID == actualUID) {
    return;
  }
  if (isfriend) {
    $(`#followOut`).removeClass("active");
    $(`#followtxt`).text("Follow");
    isfriend = false;
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/getPFinfo.php", //Ajax Action url
      data: { Type: "GF", UID: UID },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);
        data = data[0];
        let followers = parseInt(data.followers);
        let friends = data.friends;
        friends = JSON.parse(friends);
        if (friends.length == 1) {
          friends = [];
        } else {
          friends.splice(friends.indexOf(UID), 1);
        }
        followers -= 1;
        // console.log(followers);
        friends = JSON.stringify(friends);
        $.ajax({
          type: "POST", // Method type GET/POST
          url: "./PHP/getPFinfo.php", //Ajax Action url
          data: {
            Type: "UD",
            UID: UID,
            FOL: followers,
            FRI: friends,
            AID: actualUID,
          },
          success: function (data, textStatus, jqXHR) {
            console.log("UD" + data);
            getProfileInfo();
          },
        });
      },
    });
  } else {
    $(`#followOut`).addClass("active");
    $(`#followtxt`).text("Following");
    isfriend = true;
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/getPFinfo.php", //Ajax Action url
      data: { Type: "GF", UID: UID },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);
        data = data[0];
        let followers = parseInt(data.followers);
        let friends = data.friends;
        friends = JSON.parse(friends);
        friends.push(actualUID);
        followers += 1;
        // console.log(followers);
        friends = JSON.stringify(friends);
        $.ajax({
          type: "POST", // Method type GET/POST
          url: "./PHP/getPFinfo.php", //Ajax Action url
          data: {
            Type: "UI",
            UID: UID,
            FOL: followers,
            FRI: friends,
            AID: actualUID,
          },
          success: function (data, textStatus, jqXHR) {
            console.log("UI" + data);
            getProfileInfo();
          },
        });
      },
    });
  }
});

function getFriends() {
  if (UID == actualUID) {
  } else {
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/getPFinfo.php", //Ajax Action url
      data: { Type: "GF", UID: UID },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);
        data = data[0];
        // console.log(data);
        let friends = data.friends;
        friends = JSON.parse(friends);
        // console.log(friends);
        checkFollowing(UID, actualUID, friends);
      },
    });
  }
}