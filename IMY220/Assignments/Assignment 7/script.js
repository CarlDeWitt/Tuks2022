class UsernamePasswordInput extends React.Component {
  constructor(props) {
    super(props);
    this.submit = this.submit.bind(this);
    this.checkUsername = this.checkUsername.bind(this);
    this.checkPassword = this.checkPassword.bind(this);
    this.nameInput = React.createRef();
    this.passwordInput = React.createRef();
  }

  submit(e) {
    e.preventDefault();
    // let username = this.nameInput.current.value;
    let password = this.passwordInput.current.value;
    // console.log(username, password);
    /*PASSWORD*/
    if (password.length < 7) {
      console.log("Password must be at least 8 characters long");
    }

    const upperCaseInLetter = /[A-Z]/;

    if (!password.match(upperCaseInLetter)) {
      console.log("You need an Upper Case letter in Password");
    }

    const didgitCheck = /[0-9]/gm;
    if (!password.match(didgitCheck)) {
      console.log("Password must contain at least one digit");
    }
  }

  checkUsername(e) {
    let username = this.nameInput.current.value;
    /*USERNAME*/
    const specialChar = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
    if (specialChar.test(username)) {
      console.log("username must not contain a special character");
    }
    const upperCheck = username[0].toUpperCase();
    if (username[0] !== upperCheck) {
      console.log("username must start with a capital letter");
    }
    if (username.length < 2) {
      console.log("username must be longer than 2 chars");
    }
  }

  checkPassword(e) {
    let password = this.passwordInput.current.value;
    // console.log(username, password);
    // console.log(password);
    /*PASSWORD*/
    if (password.length < 7) {
      console.log("Password must be at least 8 characters long");
    }

    const upperCaseInLetter = /[A-Z]/;

    if (!password.match(upperCaseInLetter)) {
      console.log("You need an Upper Case letter in Password");
    }

    const didgitCheck = /[0-9]/gm;
    if (!password.match(didgitCheck)) {
      console.log("Password must contain at least one digit");
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
  constructor(e) {
    super(e);
    this.submit = this.submit.bind(this);
  }

  render() {
    return (
      <form>
        <UsernamePasswordInput />
        <button type="submit">Submit</button>
      </form>
    );
  }
}

ReactDOM.render(<LoginForm />, document.getElementById("root"));
