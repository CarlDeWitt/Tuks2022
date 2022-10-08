class UsernamePasswordInput extends React.Component {
  constructor(props) {
    super(props);
    this.checkUsername = this.checkUsername.bind(this);
    this.checkPassword = this.checkPassword.bind(this);
    this.nameInput = React.createRef();
    this.passwordInput = React.createRef();
  }

  checkUsername(e) {
    let username = this.nameInput.current.value;
    let casecheck = true;
    /*USERNAME*/
    const specialChar = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
    if (specialChar.test(username)) {
      console.log("username must not contain a special character");
      casecheck = false;
    }
    const upperCheck = username[0].toUpperCase();
    if (username[0] !== upperCheck) {
      console.log("username must start with a capital letter");
      casecheck = false;
    }
    if (username.length < 2) {
      console.log("username must be longer than 2 chars");
      casecheck = false;
    }

    if (casecheck) {
      this.props.validateUser(username);
    }
  }

  checkPassword(e) {
    let password = this.passwordInput.current.value;
    let casecheck = true;
    /*PASSWORD*/
    if (password.length < 7) {
      console.log("Password must be at least 8 characters long");
      casecheck = false;
    }

    const upperCaseInLetter = /[A-Z]/;

    if (!password.match(upperCaseInLetter)) {
      console.log("You need an Upper Case letter in Password");
      casecheck = false;
    }

    const didgitCheck = /[0-9]/gm;
    if (!password.match(didgitCheck)) {
      console.log("Password must contain at least one digit");
      casecheck = false;
    }

    if (casecheck) {
      this.props.validatePass();
    }
  }

  render() {
    return (
      <div className="row">
        <div className="col-6">
          <input
            type="text"
            placeholder="username"
            ref={this.nameInput}
            onChange={this.checkUsername}
          />
        </div>
        <div className="col-6">
          <input
            type="text"
            placeholder="password"
            ref={this.passwordInput}
            onChange={this.checkPassword}
          />
        </div>
      </div>
    );
  }
}

class LoginForm extends React.Component {
  constructor(props) {
    super(props);

    this.validateUserfunction = this.validateUserfunction.bind(this);
    this.validatePassfunction = this.validatePassfunction.bind(this);
    this.sendFunction = this.sendFunction.bind(this);
    this.state = { state1: false, state2: false, username: "" };
  }

  sendFunction(e) {
    e.preventDefault();
    if (this.state.state1 && this.state.state2) {
      ReactDOM.render(
        <ProfilePage insertUsername={this.state.username} />,
        document.getElementById("root")
      );
    }
  }

  validateUserfunction(name) {
    this.setState({ state1: true });
    this.setState({ username: name });
  }

  validatePassfunction() {
    this.setState({ state2: true });
  }

  render() {
    return (
      <div>
        <UsernamePasswordInput
          validateUser={this.validateUserfunction}
          validatePass={this.validatePassfunction}
        />
        <button
          type="submit"
          value="Add"
          onClick={this.sendFunction}
          disabled={this.state.state1 && this.state.state2 ? false : true}
        >
          Submit
        </button>
      </div>
    );
  }
}

class ProfilePage extends React.Component {
  constructor(props) {
    super(props);
    this.state = { username: "" };
    this.logout = this.logout.bind(this);
  }

  logout() {
    this.setState({ username: "" });
    ReactDOM.render(<LoginForm />, document.getElementById("root"));
  }

  render() {
    return (
      <div>
        <h1>Hi, welcome back {this.props.insertUsername}</h1>
        <button type="submit" value="Add" onClick={this.logout}>
          Log out
        </button>
      </div>
    );
  }
}

ReactDOM.render(<LoginForm />, document.getElementById("root"));
