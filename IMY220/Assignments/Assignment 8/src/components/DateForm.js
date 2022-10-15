import React from "react";
import PropTypes from "prop-types";

export class DateForm extends React.Component {
  constructor(props) {
    super(props);
    this.date = React.createRef();
    this.check = this.check.bind(this);
  }

  check() {
    this.props.dateFunc(this.date.current.value);
  }

  render() {
    return (
      <div>
        <input type="text" ref={this.date} onChange={this.check} />
      </div>
    );
  }
}

DateForm.propTypes = {
  dateFunc: PropTypes.func.isRequired,
};
