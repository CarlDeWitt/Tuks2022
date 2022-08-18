class EventHandler {
  constructor(events) {
    this.events = events;
  }

  getEventsBetweenDates(dateStart, dateEnd) {
    return this.events.filter(
      (arr) => arr.dateStart >= dateStart && arr.dateEnd <= dateEnd
    );
  }

  getByMonth(month) {
    return this.events.filter((arr) =>
      arr.dateStart.includes("/" + month + "/")
    );
  }

  getUniqueDateAndSort() {
    return this.events.sort(
      (a, b) => a.dateStart.split("/")[1] - b.dateStart.split("/")[1]
    );
  }
  print() {
    return "Hello World";
  }
}
