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
    if (password.length < 7) {
      alert("Password must be at least 8 characters long");
    }

    const upperCaseInLetter = /[A-Z]/;

    if(!password.match(upperCaseInLetter)){
      alert("You need an Upper Case letter in Password")
    }
    
    const didgitCheck = /[0-9]/gm;
    if (!password.match(didgitCheck)) {
      alert("Password must contain at least one digit");
    }

    /*USERNAME*/
    const specialChar = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
    if (specialChar.test(username)) {
      alert("username must not contain a special character");
    }
    const upperCheck = username[0].toUpperCase();
    if (username[0] !== upperCheck) {
      alert("username must start with a capital letter");
    }
    if(username.length < 2 ){
      alert("username must be longer than 2 chars")
    }
    
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

class LoginForm extends React.Component{
  constructor(e){
    
  }
}

ReactDOM.render(<UsernamePasswordInput validatePass={someFunctionHere}
  validateUsername={someFunctionHere}/>, document.getElementById("root"));

