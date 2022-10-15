import React from "react";

import { User } from "./User";

export class UserList extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
          <div className="row">
            {this.props.users.map((user, index) => {
                return <User key={index} users={user} />;
            })}
          </div>
        );
      }
}