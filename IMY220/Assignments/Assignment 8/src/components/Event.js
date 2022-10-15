import React from "react";
import PropTypes from "prop-types";

export class Event extends React.Component {
  render() {
    return (
      <div className="card col-4">
        <div className="card-header">{this.props.event.name}</div>
        <div className="card-body">
          <h5 className="card-title">{this.props.event.description}</h5>
          <p className="card-text">{this.props.event.date}</p>
        </div>
      </div>
    );
  }
}

Event.propTypes = {
  event: PropTypes.object,
};
