// U21444928 Carl de Witt
import { events } from "./script.js";
// do testing at the bottom of the page

function EventHandler(events) {
  this.events = events;

  this.getEventsBetweenDates = function (dateStart, dateEnd) {
    return events.filter(
      (arr) => arr.dateStart >= dateStart && arr.dateEnd <= dateEnd
    );
  };

  this.getByMonth = function (month) {
    return events.filter((arr) => arr.dateStart.includes("/" + month + "/"));
  };

  this.getUniqueDateAndSort = function () {
    return events
      .sort((a, b) => a.dateStart.split("/")[1] - b.dateStart.split("/")[1])
      .filter(
        (dateAfter, save, currentDate) =>
          currentDate.findIndex((n) => n.dateStart === dateAfter.dateStart) ===
          save
      );
  };

  this.getSummary = function () {
    if (this.constructor === Array) {
      return this.map((event) => {
        if (event.dateStart === event.dateEnd) {
          return `On ${event.dateStart}: ${event.name} (${event.description})`;
        } else {
          return `On ${event.dateStart} to ${event.dateEnd}: ${event.name} (${event.description})`;
        }
      });
    }
    if (arguments.length > 0) {
      var data = Array.prototype.slice.apply(arguments);
      return data.map((event) => {
        if (event.dateStart === event.dateEnd) {
          return `On ${event.dateStart}: ${event.name} (${event.description})`;
        } else {
          return `On ${event.dateStart} to ${event.dateEnd}: ${event.name} (${event.description})`;
        }
      });
    } else {
      return events.map((event) => {
        if (event.dateStart === event.dateEnd) {
          return `On ${event.dateStart}: ${event.name} (${event.description})`;
        } else {
          return `On ${event.dateStart} to ${event.dateEnd}: ${event.name} (${event.description})`;
        }
      });
    }
  };
}

// prototypes

Array.prototype.getEventsBetweenDates = function (dateStart, dateEnd) {
  return events.filter(
    (arr) => arr.dateStart >= dateStart && arr.dateEnd <= dateEnd
  );
};

Array.prototype.getByMonth = function (month) {
  return events.filter((arr) => arr.dateStart.includes("/" + month + "/"));
};

Array.prototype.getUniqueDateAndSort = function () {
  return events
    .sort((a, b) => a.dateStart.split("/")[1] - b.dateStart.split("/")[1])
    .filter(
      (dateAfter, save, currentDate) =>
        currentDate.findIndex((n) => n.dateStart === dateAfter.dateStart) ===
        save
    );
};

Array.prototype.getSummary = function () {
  if (this.constructor === Array) {
    return this.map((event) => {
      if (event.dateStart === event.dateEnd) {
        return `On ${event.dateStart}: ${event.name} (${event.description})`;
      } else {
        return `On ${event.dateStart} to ${event.dateEnd}: ${event.name} (${event.description})`;
      }
    });
  }
  if (arguments.length > 0) {
    var data = Array.prototype.slice.apply(arguments);
    return data.map((event) => {
      if (event.dateStart === event.dateEnd) {
        return `On ${event.dateStart}: ${event.name} (${event.description})`;
      } else {
        return `On ${event.dateStart} to ${event.dateEnd}: ${event.name} (${event.description})`;
      }
    });
  } else {
    return events.map((event) => {
      if (event.dateStart === event.dateEnd) {
        return `On ${event.dateStart}: ${event.name} (${event.description})`;
      } else {
        return `On ${event.dateStart} to ${event.dateEnd}: ${event.name} (${event.description})`;
      }
    });
  }
};

var eventHandler = new EventHandler(events);
/*--------------DO Testing here----------------*/
