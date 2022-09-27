$(document).ready(() => {
  $("#submitBtn").on("click", () => {
    const username = $("#username").val();
    const password = $("#password").val();

    getUsersDB("users.json", username, password);
  });

  getUsersDB = (URL, username, password) => {
    return new Promise((res, rej) => {
      $.getJSON(URL, (data) => {
        res(data);
      });
    })
      .then((data) => {
        let size = data.length;
        for (let i = 0; i < size; i++) {
          if (
            data[i]["username"] == username &&
            data[i]["password"] == password
          ) {
            const userID = data[i].userID;
            $(`#loginForm`).hide();
            $(`.events`).addClass("row");
            $(`.events`).append(`<div class="col-12">
            <p><b>Hi</b>, ${username}</p>
            <p>Here are your upcoming events</p>
            <div>`);
            return userID;
          }
        }
      })
      .then((userID) => {
        console.log(userID);
        $.getJSON(`events.json`, (data) => {
          data.forEach((element) => {
            element.attending.forEach((user) => {
              if (user == userID) {
                // console.log("hit");
                $(`<div></div>`, {
                  class: "card col-sm-4",
                  html: `<div class="card-header">${element.title}</div>
                  <div class="card-body">
                  <p>${element.description}</p>
                  <p>${element.date}</p>
                  </div>`,
                }).appendTo(`.events`);
                // $(".events").append(`<div class="card col-sm-4">
                // <div class="card-header">${element.title}</div>
                // <div class="card-body">
                //    <p>${element.description}</p>
                //    <p>${element.date}</p>
                //    </div>
                // </div> `);
              }
            });
          });
        });
      });
  };
});
