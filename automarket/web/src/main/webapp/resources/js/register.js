function validateForm() {

  var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  var email = document.getElementById("email").value;
  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;
  var confirmPassword = document.getElementById("confirm-password").value;

  if (!regex.test(email)) {
    alert("Invalid e-mail address!");
    return false;
  }
  if (username.length < 5) {
    alert("Username must have a minimum of 5 characters!");
    return false;
  }
  if (username.length > 15) {
    alert("Username must have a maximum of 15 characters!");
    return false;
  }
  if (password.length < 10) {
    alert("Password must have a minimum of 10 characters!");
    return false;
  }
  if (password.length > 20) {
    alert("Password must have a maximum of 20 characters!");
    return false;
  }
  if (confirmPassword != password) {
    alert("Password fields do not match!");
    return false;
  }

}
