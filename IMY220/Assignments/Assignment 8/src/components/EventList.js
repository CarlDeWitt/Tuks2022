import React from "react";
import PropTypes from "prop-types";
import { Event } from "./Event";
import { DateForm } from "./DateForm";

export class EventList extends React.Component {
  constructor(props) {
    super(props);
    this.state = { date: this.props.theDate };
    this.dateFunc = this.dateFunc.bind(this);
  }

  dateFunc(dateSTR) {
    this.setState({ date: dateSTR });
  }

  render() {
    return (
      <div>
        <h1>Events on the {this.state.date}</h1>
        <DateForm dateFunc={this.dateFunc} />
        <div className="row">
          {this.props.event.map((event, i = 0) => {
            if (event.date == this.state.date) {
              return <Event key={i++} event={event} />;
            }
          })}
        </div>
      </div>
    );
  }
}

EventList.propTypes = {
  theDate: PropTypes.string,
  event: PropTypes.array,
};
