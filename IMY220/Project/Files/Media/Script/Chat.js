$(`.textarea`).keyup(function (e) {
  if (e.which == 13) {
    var text = $(this).val();
    const now = new Date();
    const timeNow = now.getHours() + ":" + now.getMinutes();
    $(`.chat`).append(`
    <li class="self">
        <div class="avatar"><img src="./Media/Images/profile/${FROMIMG}" draggable="false"/></div>
    <div class="msg">
        <p>${text}</p>
        <time>${timeNow}</time>
    </div>
    </li>
    `);
  }
});

GoBack = () => {
  window.history.back();
};
