import React from "react";

export class EnrolmentList extends React.Component {
  render() {
    return (
      <div>
        <h1>Select a class</h1>
        <button
          className="btn btn-secondary dropdown-toggle"
          type="button"
          id="dropdownMenuButton"
          aria-haspopup="true"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Show 7 classes
        </button>
        <div className="dropdown-menu p-2" aria-labelledby="dropdownMenuButton">
          {this.props.codes.map((data, index) => (
            <div key={index} className="p-2">
              <div>{data.name}</div>
            </div>
          ))}
        </div>
      </div>
    );
  }
}
