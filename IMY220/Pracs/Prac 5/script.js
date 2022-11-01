$(document).ready(() => {
  /**
   * @section_1
   */
  $(`#events .col-4`).on("click", (e) => {
    const target = e.target.id;
    clearAllActive();
    $(`#${target}`).toggleClass("unactive");
    $(`#${target}`).toggleClass("active");
    loadEventDeets(target);
    // console.log(target);
  });

  const loadEventDeets = (id) => {
    return new Promise((resolve, reject) => {
      $(`#event`).load(`./events.html #${id}`);
      resolve(id);
    }).then((id) => {
      const url = `events.json`;
      const index = $(`#events>.col-4`).index($(`#${id}`));
      TWLAdd(url, index);
    });
  };

  clearAllActive = () => {
    $(`.col-4`).removeClass("active");
    $(`.col-4`).addClass("unactive");
  };

  /**
   * @section_2
   */

  const TWLAdd = (url, id) => {
    return new Promise((resolve, reject) => {
      $.getJSON(url, (data) => {
        resolve(data);
      });
    }).then((data) => {
      createEventCard(data[id]);
    });
  };

  const createEventCard = (event) => {
    $("#event").append(`<div class="card mb-3"> 
     <div class="card-body">
        <p>Time: ${event["time"]}</p>
        <p>Loaction: ${event["location"]}</p>
          <p>Wheater: ${event["weather"]}</p>
        </div>
        </div> `);
  };
});

/**
 * @breif 
 */
