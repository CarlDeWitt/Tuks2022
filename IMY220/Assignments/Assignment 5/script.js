$(document).ready(() => {
  /**
   * @Section1
   */

  getEvents = (URL) => {
    return new Promise((resolve, reject) => {
      $.getJSON(URL, (data) => {
        resolve(data);
      });
    }).then((data) => {
      createEventCard(data);
    });
  };

  /**
   * @createEvent
   */
  createEventCard = (events) => {
    // console.log(events[0]);
    events = sortByDate(events);
    let i = 2;
    events.forEach((element) => {
      const event = `<div class="card mb-3">
    <div class="card-header">${element["title"]}</div>
    <div class="card-body">
      <p>${element["description"]}</p>
      <b>${element["date"]}</b>
      <p>Will you be attending?</p>
      <div class="form-check" data-correct="true">
        <input
          class="form-check-input"
          type="radio"
          name="eventAttendance${i}"
          id="event${i}Attending1"
        />
        <label class="form-check-label" for="event${i}Attending1">
          Yes
        </label>
      </div>

      <div class="form-check" data-correct="false">
        <input
          class="form-check-input"
          type="radio"
          name="eventAttendance1"
          id="event${i}Attending2"
        />
        <label class="form-check-label" for="event${i}Attending2">
          No
        </label>
      </div>
    </div>
  </div>`;
      $("#eventList").append(event);

      i++;
    });
  };

  /**
   * @task 2
   * @function sortByDate
   */
  sortByDate = (events) => {
    events.sort((a, b) => {
      return new Date(a.date) - new Date(b.date);
    });
    return events;
  };
  getEvents(`events.json`);
  /**
   * @task 3
   * @function onClick
   */

  $(`#eventList`).on("click", ".form-check-input", (e) => {
    const id = e.target.id;
    const idPlace = id.substring(0, id.length - 1) + 2;
    const strNO = `<div class="alert alert-danger NOGO card mb-3 al${idPlace}" role="alert">You will not be attending❗</div>`;
    const strGo = `<div class="alert alert-success GO card mb-3 al${idPlace}"role="alert">You are going❗</div>`;
    if (id.includes("Attending1")) {
      $(`.al${idPlace}`).remove();

      $(`label[for=${idPlace}]`).after(strGo);
    } else {
      $(`.al${idPlace}`).remove();
      //   $(`.GO`).remove();
      $(`label[for=${idPlace}]`).after(strNO);
    }
    $(`.al${idPlace}`).css({ textAlign: "center" });
  });
});
