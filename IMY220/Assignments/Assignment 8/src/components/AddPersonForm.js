import React from "react";
export class AddPersonForm extends React.Component {
  // rest of class definition goes here (see L18 – React 2)
  constructor(props) {
    super(props);
    this.submit = this.submit.bind(this);
    this.nameInput = React.createRef();
    this.surnameInput = React.createRef();
    this.ageInput = React.createRef();
  }

  submit(e) {
    e.preventDefault();
    let name = this.nameInput.current.value;
    let surname = this.surnameInput.current.value;
    let age = this.ageInput.current.value;
    this.props.onNewPerson(name, surname, age);
  }

  render() {
    return (
      <form onSubmit={this.submit}>
        <input type="text" ref={this.nameInput} /> <br />
        <input type="text" ref={this.surnameInput} /> <br />
        <input type="text" ref={this.ageInput} /> <br />
        <input type="submit" value="Add" />
      </form>
    );
  }
}
