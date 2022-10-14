import React from "react";
export class AddPerson extends React.Component {
  // rest of class definition goes here (see L18 – React 2)
  render() {
    return (
      <li>{`${this.props.person.name[0]}. ${this.props.person.surname}`}</li>
    );
  }
}
