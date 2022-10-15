import React from "react";

export class User extends React.Component {
    constructor(props) {
        super(props);
        this.state = {hide: true};
        this.toggel = this.toggel.bind(this);
    }

    toggel(){
        const currentState = this.state.hide;
        this.setState({ hide: !currentState });      
    }

    render() {
        return (
          <div className="col-6">
            <div className="card" onClick={this.toggel}>
                <div className="card-header">
                    {this.props.users.username}
                </div>
                <div className={this.state.hide ? `hide card-body` : `nothide card-body`}>
                    <p><b>Name:</b> {this.props.users.name}</p>
                    <p><b>Surname:</b> {this.props.users.surname}</p>
                    <p><b>Age:</b> {this.props.users.age}</p> 
                </div>
            </div>
          </div>
        );
      }
}