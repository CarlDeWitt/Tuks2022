$(`.textarea`).keyup(function (e) {
  if (e.which == 13) {
    const now = new Date();
    var text = $(this).val();
    let timeNow = now.getTime();
    $.ajax({
      type: "POST", // Method type GET/POST
      url: "./PHP/getChatMSG.php", //Ajax Action url
      data: {
        type: "NotGet",
        from_UID: actualUID,
        to_UID: UID,
        message: text,
        time: timeNow,
      },
      success: function (data, textStatus, jqXHR) {
        $(`.chat`).empty();
        loadData();
      },
    });
  }
});

GoBack = () => {
  window.history.back();
};

const loadData = () => {
  // console.log(`sending ID: ${actualUID} recieving id ${UID}`);
  $.ajax({
    type: "POST", // Method type GET/POST
    url: "./PHP/getChatMSG.php", //Ajax Action url
    data: { type: "get", from_UID: actualUID, to_UID: UID },
    success: function (data, textStatus, jqXHR) {
      data = JSON.parse(data);
      let msgData = [];
      for (let i = 0; i < data.length; i++) {
        let now = new Date();
        now.setTime(data[i].time);
        const timeNow = now.getHours() + ":" + now.getMinutes();
        let msgs = {
          message: data[i].message,
          time: data[i].time,
          from: "self",
        };
        msgData.push(msgs);
      }
      $.ajax({
        type: "POST", // Method type GET/POST
        url: "./PHP/getChatMSG.php", //Ajax Action url
        data: { type: "get", from_UID: UID, to_UID: actualUID },
        success: function (data, textStatus, jqXHR) {
          data = JSON.parse(data);
          for (let i = 0; i < data.length; i++) {
            let msgs = {
              message: data[i].message,
              time: data[i].time,
              from: "other",
            };
            msgData.push(msgs);
          }
          msgData.sort((a, b) => a.time - b.time);

          for (let i = 0; i < msgData.length; i++) {
            let now = new Date();
            now.setTime(msgData[i].time);
            const timeNow = now.getHours() + ":" + now.getMinutes();
            $(`.chat`).append(`
          <li class=${msgData[i].from}>
              <div class="avatar"><img src="./Media/Images/profile/${FROMIMG}" draggable="false"/></div>
          <div class="msg">
              <p>${msgData[i].message}</p>
              <time>${timeNow}</time>
          </div>
          </li>
          `);
          }
        },
      });
    },
  });
};
loadData();
