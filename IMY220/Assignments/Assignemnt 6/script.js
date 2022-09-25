$(document).ready(() => {
  $("#submitBtn").on("click", () => {
    const username = $("#username").val();
    const password = $("#password").val();

    getUsersDB("users.json", username, password);

    // console.log(`Username: ${username} Password: ${password}`);
  });

  getUsersDB = (URL, u, p) => {
    return new Promise((res, rej) => {
      $.getJSON(URL, (data) => {
        res(data);
      });
    }).then((data) => {
      verifyUser(data, u, p);
    });
  };

  verifyUser = (data, username, password) => {
    return new Promise((res, rej) => {
      data.forEach((element) => {
        if (
          element["username"] == username &&
          element["password"] == password
        ) {
          const userID = element.userID;
          $(`#loginForm`).hide();
          $(`.events`).addClass("row");
          $(`.events`).append(`<div class="col-12">
            <p><b>Hi</b>, ${username}</p>
            <p>Here are your upcoming events</p>
            <div>`);
          matchEvents(userID);
          return;
        }
      });
    });
  };

  matchEvents = (userID) => {
    return new Promise((res, rej) => {
      $.getJSON(`events.json`, (data) => {
        res(data);
      });
    }).then((data) => {
      data.forEach((element) => {
        element.attending.forEach((user) => {
          if (user == userID) {
            // console.log("hit");
            $(".events").append(`<div class="card col-sm-4"> 
            <div class="card-header">${element.title}</div>
            <div class="card-body">
               <p>${element.description}</p>
               <p>${element.date}</p>
               </div>
            </div> `);
          }
        });
      });
    });
  };
});
