window.onload = function(){

document.getElementById("contactForm").onsubmit = function(e){

e.preventDefault();

var name = document.getElementById("name").value;
var email = document.getElementById("email").value;
var message = document.getElementById("message").value;

var msg = document.getElementById("msg");

if(name == "" || email == "" || message == "")
{
msg.innerHTML = "Please fill all fields";
msg.style.color = "red";
return false;
}

if(email.indexOf("@") == -1 || email.indexOf(".") == -1)
{
msg.innerHTML = "Enter a valid email address";
msg.style.color = "red";
return false;
}

msg.innerHTML = "Message Sent Successfully!";
msg.style.color = "green";

};
};