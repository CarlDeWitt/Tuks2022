$(`#SearchBTN`).keyup(function (e) {
  // if (e.which == 13) {
  $(`#SearchResults`).empty();
  var text = $(this).val();
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
          if (data[i].email.includes(text)) {
            $(`#SearchResults`).append(
              `<div class="srchOption" onClick="JumptoUser(${data[i].id})"><i class="fa-solid fa-user"></i>${data[i].name}</div>`
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
          if (data[i].name.includes(text)) {
            $(`#SearchResults`).append(
              `<div class="srchOption" onClick="JumptoUser(${data[i].id})"><i class="fa-solid fa-user"></i>${data[i].name}</div>`
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
        // data = JSON.parse(data);
        console.log(data);
        if (text[0] == "#") {
          // HASHTAG SEARCH
          for (let i = 0; i < data.length; i++) {
            if (data[i].hastags.includes(text)) {
              $(`#SearchResults`).append(
                `<div class="srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-hashtag"></i>${data[i].name}</div>`
              );
            }
          }
          return;
        } else if (text[0] == "/") {
          // DATE SEARCH
          text = text.slice(1);
          // console.log(text);
          for (let i = 0; i < data.length; i++) {
            if (data[i].date.includes(text)) {
              $(`#SearchResults`).append(
                `<div class="srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-calendar-days"></i>${data[i].name}</div>`
              );
            }
          }
        } else if (text[0] == "!") {
          // LOCATION SEARCH
          text = text.slice(1);
          for (let i = 0; i < data.length; i++) {
            if (data[i].location.includes(text)) {
              $(`#SearchResults`).append(
                `<div class="srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-map-pin"></i>${data[i].name}</div>`
              );
            }
          }
        } else if (text[0] == "$") {
          // DESCRIPTION SEARCH
          text = text.slice(1);
          for (let i = 0; i < data.length; i++) {
            if (data[i].description.includes(text)) {
              $(`#SearchResults`).append(
                `<div class="srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-regular fa-comment-dots"></i>${data[i].name}</div>`
              );
            }
          }
        } else {
          // NAME SEARCH
          if (text == "*") {
            text = "";
          }
          for (let i = 0; i < data.length; i++) {
            if (data[i].name.includes(text)) {
              $(`#SearchResults`).append(
                `<div class="srchOption" onClick="jumptoEvent(${data[i].id})"><i class="fa-solid fa-tent"></i>${data[i].name}</div>`
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
