class UsernamePasswordInput extends React.Component {
  constructor(props) {
    super(props);
    this.submit = this.submit.bind(this);
    this.nameInput = React.createRef();
    this.passwordInput = React.createRef();
  }

  submit(e) {
    e.preventDefault();
    let username = this.nameInput.current.value;
    let password = this.passwordInput.current.value;
    // console.log(username, password);
    /*PASSWORD*/
    if (password.length <= 8) {
      alert("Password must be at least 8 characters long");
    }
    const upperCheck = password[0].toUpperCase();
    if (password[0] !== upperCheck) {
      alert("Password must start with a capital letter");
    }

    const didgitCheck = /[0-9]/gm;
    if (!password.match(didgitCheck)) {
      alert("Password must contain at least one digit");
    }

    // /*USERNAME*/
    // const specialChar = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
    // if (specialChar.test(password)) {
    //   alert("Password must contain a special character");
    // }
  }

  render() {
    return (
      <div>
        <form onSubmit={this.submit}>
          <input type="text" ref={this.nameInput} /> <br />
          <input type="text" ref={this.passwordInput} /> <br />
          <input type="submit" value="Add" />
        </form>
      </div>
    );
  }
}

ReactDOM.render(<UsernamePasswordInput />, document.getElementById("root"));
