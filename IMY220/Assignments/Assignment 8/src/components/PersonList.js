import React from "react";
// Since we're only defining a class but not rendering it, we don't need
// to import ReactDOM here
import { AddPerson } from "./AddPerson";
import { AddPersonForm } from "./AddPersonForm";
export class PersonList extends React.Component {
  constructor(props) {
    super(props);
    this.state = { people: this.props.people };
    this.addPerson = this.addPerson.bind(this);
  }

  addPerson(name, surname, age) {
    let people = this.state.people;
    people.push({ name, surname, age });
    this.setState(people);
  }

  render() {
    return (
      <div className="container">
        <h1>
          {this.state.people.length ? this.state.people.length : "No"}
          {this.state.people.length == 1 ? " person" : " people"} in the list:
        </h1>
        <ul>
          {this.state.people.map((person, index) => (
            <AddPerson key={index} person={person} />
          ))}
        </ul>
        <div>
          <AddPersonForm onNewPerson={this.addPerson} />
        </div>
      </div>
    );
  }
}
