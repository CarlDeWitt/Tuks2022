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
      this.props.validateUser();
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
      <div>
        <input type="text" ref={this.nameInput} onChange={this.checkUsername} />
        <input
          type="text"
          ref={this.passwordInput}
          onChange={this.checkPassword}
        />
      </div>
    );
  }
}

class LoginForm extends React.Component {
  constructor(props) {
    super(props);
    this.submit = this.submit.bind(this);
    this.validateUserfunction = this.validateUserfunction.bind(this);
    this.validatePassfunction = this.validatePassfunction.bind(this);
    this.state = { state1: false, state2: false };
  }

  submit(e) {
    if (this.state.stat1 == true && this.state.stat2 == true) {
      console.log("submit");
    } else {
      console.log("not submit");
      e.preventDefault();
    }
  }

  validateUserfunction() {
    this.setState({ state1: true });
  }

  validatePassfunction() {
    this.setState({ state2: true });
  }

  render() {
    return (
      <form>
        <UsernamePasswordInput
          validateUser={this.validateUserfunction}
          validatePass={this.validatePassfunction}
        />
        <button type="submit" value="Add">
          Submit
        </button>
      </form>
    );
  }
}

ReactDOM.render(<LoginForm />, document.getElementById("root"));
