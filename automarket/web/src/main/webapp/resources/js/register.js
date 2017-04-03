function validateEmail() {
  var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  var email = document.getElementById("email").value;
  return regex.test(email);
}

function validateUsername() {
  var username = document.getElementById("username").value;
  if (username.length < 5 || username.length > 15) {
    return false;
  }
  return true;
}

function validatePassword() {
  var password = document.getElementById("password").value;
  if (password.length < 10 || password.length > 20) {
    return false;
  }
  return true;
}

function validateConfirm() {
  var password = document.getElementById("password").value;
  var confirmPassword = document.getElementById("confirm-password").value;
  if (confirmPassword != password) {
    return false;
  }
  return true;
}

function validateForm() {
  
  var emailFlag = false;
  var usernameFlag = false;
  var passwordFlag = false;
  var confirmFlag = false;
  
  if (validateEmail()) {
    document.getElementById("email-form-group").className = "form-group";
    document.getElementById("email-error").className = "";
    document.getElementById("email-error").innerHTML = "";
  }
  else {
    emailFlag = true;
    document.getElementById("email-form-group").className = "form-group has-error";
    document.getElementById("email-error").className = "text-danger";
    document.getElementById("email-error").innerHTML = "Invalid e-mail!";
  }
  
  if (validateUsername()) {
    document.getElementById("username-form-group").className = "form-group";
    document.getElementById("username-error").className = "";
    document.getElementById("username-error").innerHTML = "";
  }
  else {
    usernameFlag = true;
    document.getElementById("username-form-group").className = "form-group has-error";
    document.getElementById("username-error").className = "text-danger";
    document.getElementById("username-error").innerHTML = "Username must have between 5 and 15 characters!";
  }
  
  if (validatePassword()) {
    document.getElementById("password-form-group").className = "form-group";
    document.getElementById("password-error").className = "";
    document.getElementById("password-error").innerHTML = "";
  }
  else {
    passwordFlag = true;
    document.getElementById("password-form-group").className = "form-group has-error";
    document.getElementById("password-error").className = "text-danger";
    document.getElementById("password-error").innerHTML = "Password must have between 10 and 20 characters!";
  }
  
  if (validateConfirm()) {
    document.getElementById("confirm-form-group").className = "form-group";
    document.getElementById("confirm-error").className = "";
    document.getElementById("confirm-error").innerHTML = "";
  }
  else {
    confirmFlag = true;
    document.getElementById("confirm-form-group").className = "form-group has-error";
    document.getElementById("confirm-error").className = "text-danger";
    document.getElementById("confirm-error").innerHTML = "Passwords do not match!";
  }
  
  if (emailFlag || usernameFlag || passwordFlag || confirmFlag) {
    return false;
  }
  
  return true;
}