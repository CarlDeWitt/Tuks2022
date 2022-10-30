$(`#SearchBTN`).keyup(function (e) {
  // if (e.which == 13) {
  $(`.helpInfo`).addClass("hideInfo");

  $(`#SearchResults`).empty();
  var text = $(this).val();
  text = text.toLowerCase();

  if (text == "") {
    return;
  }
  if (text[0] == "@" && text[1] == "@") {
    // EMAIL SEARCH
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/Search.php", //Ajax Action url
      data: {
        type: "users",
      },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);
        console.log(data);
        text = text.slice(2);
        //   console.log(text);
        // console.log(data[0].name.includes(text));

        for (let i = 0; i < data.length; i++) {
          if (data[i].email.toLowerCase().includes(text)) {
            $(`#SearchResults`).append(
              `<div class="col-6 srchOption" onClick="JumptoUser(${data[i].id})"><i class="fa-solid fa-user"></i>${data[i].name}</div>`
            );
          }
        }
      },
    });
  } else if (text[0] == "@") {
    // USERNAME SEARCH
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/Search.php", //Ajax Action url
      data: {
        type: "users",
      },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);
        //   console.log(data[0].name);
        text = text.slice(1);
        //   console.log(text);
        // console.log(data[0].name.includes(text));

        for (let i = 0; i < data.length; i++) {
          if (data[i].name.toLowerCase().includes(text)) {
            $(`#SearchResults`).append(
              `<div class="col-6 srchOption" onClick="JumptoUser(${data[i].id})"><i class="fa-solid fa-user"></i>${data[i].name}</div>`
            );
          }
        }
      },
    });
  } else {
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/Search.php", //Ajax Action url
      data: {
        type: "events",
      },
      success: function (data, textStatus, jqXHR) {
        data = JSON.parse(data);

        // console.log(text);
        // console.log(data);
        // console.log(text + "->" + data[0].hastags);
        if (text[0] == "#") {
          for (let i = 0; i < data.length; i++) {
            if (data[i].hastags.toLowerCase().includes(text)) {
              $(`#SearchResults`).append(
                `<div class="col-6 srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-hashtag"></i>${data[i].name}</div>`
              );
            }
          }
          return;
        } else if (text[0] == "/") {
          // DATE SEARCH
          text = text.slice(1);

          for (let i = 0; i < data.length; i++) {
            if (data[i].date.toLowerCase().includes(text)) {
              $(`#SearchResults`).append(
                `<div class="col-6 srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-calendar-days"></i>${data[i].name}</div>`
              );
            }
          }
        } else if (text[0] == "!") {
          // LOCATION SEARCH
          if (text.length == 1) {
            for (let i = 0; i < data.length; i++) {
              $(`#SearchResults`).append(
                `<div class="col-6 srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-map-pin"></i>${data[i].name}</div>`
              );
            }
          } else {
            text = text.slice(1);
          }
          for (let i = 0; i < data.length; i++) {
            if (data[i].location.toLowerCase().includes(text)) {
              $(`#SearchResults`).append(
                `<div class="col-6 srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-map-pin"></i>${data[i].name}</div>`
              );
            }
          }
        } else if (text[0] == "$") {
          // DESCRIPTION SEARCH
          text = text.slice(1);
          for (let i = 0; i < data.length; i++) {
            if (data[i].description.toLowerCase().includes(text)) {
              $(`#SearchResults`).append(
                `<div class="col-6 srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-regular fa-comment-dots"></i>${data[i].name}</div>`
              );
            }
          }
        } else {
          // NAME SEARCH
          if (text == "*") {
            text = "";
          }
          for (let i = 0; i < data.length; i++) {
            if (data[i].name.toLowerCase().includes(text)) {
              $(`#SearchResults`).append(
                `<div class="col-6 srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-tent"></i>${data[i].name}</div>`
              );
            }
          }
        }
      },
    });
  }
});

JumptoUser = (id) => {
  //   console.log(id);
  location.href = "./profilePage.php?UID=" + id;
};

jumptoEvent = (id) => {
  // window.location.replace("DSE.php?EID=" + e);
  location.href = "./DSE.php?EID=" + id;
};

$(`body`).click(function (e) {
  $(`#SearchResults`).empty();
});

$(`#SearchBTN`).mouseover(function (e) {
  $(`.helpInfo`).removeClass("hideInfo");
});

$(`body`).click(function (e) {
  $(`.helpInfo`).addClass("hideInfo");
});
