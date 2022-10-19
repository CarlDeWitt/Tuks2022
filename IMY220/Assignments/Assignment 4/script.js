$("document").ready(function () {
  let id = 0;
  $(".submit").on("click", function () {
    /**
     * @Variable_info
     * strYaR = Youtube and Rest of the String
     * strYL = Youtube Link
     * rest = Rest of the String old string
     */

    displaySingle = (strYL, msg) => {
      $(".messages.row").prepend(
        "<div class='col-4 offset-4 msgs' id='imsg" +
          id++ +
          "'>" +
          msg +
          "<iframe width='100%' height='315' src='" +
          strYL +
          "' title='YouTube video player' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe></div>"
      );
    };

    displayMultiple = (strYL) => {
      const idstr = `imsg${id - 1}`;
      $("#" + idstr).append(
        "<iframe width='100%' height='315' src='" +
          strYL +
          "' title='YouTube video player' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>"
      );
    };

    displayVideo = (msg, links) => {
      const startPosition = msg.search("https://www.youtube.com/");
      const strYaR = msg.substring(startPosition);
      const endPosition = strYaR.search(" ");
      let strYL = strYaR.substring(0, endPosition);
      strYL = strYL.replace("watch?v=", "embed/");
      links++ == 0 ? displaySingle(strYL, msg) : displayMultiple(strYL);
      //rest check
      const rest = msg.substring(endPosition + 1, msg.length);
      rest.match(pattern) ? displayVideo(rest, links) : 0;
    };

    const msg = $("#message").val() + " ";
    const pattern = /https:\/\/www.youtube.com/;
    if (msg.match(pattern)) {
      let links = 0;
      displayVideo(msg, links);
    } else {
      if (msg !== "") {
        $(".messages.row").prepend(
          "<div class='col-4 offset-4 msgs'>" + msg + "</div>"
        );
      }
    }
    $(".msgs").css({
      borderRadius: "10px",
      marginBottom: "20px",
    });
  });
});
