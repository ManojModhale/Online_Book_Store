/* new user */
function displayTooltip(spanId, message) 
{
    var tooltipSpan = document.getElementById(spanId);
    tooltipSpan.textContent = message;
    tooltipSpan.style.display = "inline-block";
    tooltipSpan.style.visibility = "visible";
    tooltipSpan.style.fontSize = "20px";
    tooltipSpan.style.marginLeft = "5px";
    tooltipSpan.style.color = "red";
    tooltipSpan.style.textDecoration = "underline";
}

function clearTooltip(tooltipSpan) {
    tooltipSpan.textContent = "";
    tooltipSpan.style.display = "none";
    tooltipSpan.style.visibility = "hidden";
    tooltipSpan.style.fontSize = "";
    tooltipSpan.style.marginLeft = "";
    tooltipSpan.style.color = "";
    tooltipSpan.style.textDecoration = "";
}

function validateFirstName() 
{
    var firstName = document.getElementById("fname").value.trim();
    if (firstName === "") {
        displayTooltip("sp1", "Please enter your first name.");
        return false;
    }
    return true;
}
function validateLastName() 
{
    var lastName = document.getElementById("lname").value.trim();
    if (lastName === "") {
        displayTooltip("sp2", "Please enter your last name.");
        return false;
    }
    return true;
}
function validateUserName() 
{
    var userName = document.getElementById("uname").value.trim();
    if (userName === "") {
        displayTooltip("sp3", "Please enter your user name.");
        return false;
    }
    return true;
}
function validatePassword() 
{
    var password = document.getElementById("pass").value.trim();
    if (password === "") {
        displayTooltip("sp4", "Please enter your password.");
        return false;
    }
    return true;
}
function validateConfirmPass() 
{
    var conf_password = document.getElementById("confirmpass").value.trim();
    if (conf_password === "") {
        displayTooltip("sp5", "Please enter your password again.");
        return false;
    }
    return true;
}
function validateEmail() 
{
    var email = document.getElementById("mail").value.trim();
    if (email === "") {
        displayTooltip("sp6", "Please enter email address.");
        return false;
    }
    return true;
}
function validateMobile() 
{
    var mobile = document.getElementById("mobileno").value.trim();
    if (mobile === "") {
        displayTooltip("sp7", "Please enter your mobile number.");
        return false;
    }
    return true;
}
function validateGender()
{
	var gen1=document.getElementById('m').checked;
	var gen2=document.getElementById('f').checked;
	if(!gen1&&!gen2)
	{
		document.getElementById('sp8').innerHTML="Please Select One Gender Option";
		return false;
	}
	return true;
}


function validateForm() 
{
    var isFirstNameValid = validateFirstName();
    var isLastNameValid = validateLastName(); 
    var isUserNameValid = validateUserName(); 
    var isPasswordValid = validatePassword();
    var isConf_PasswordValid = validateConfirmPass();
    var isEmailValid = validateEmail();
    var isMobileValid = validateMobile(); 
    var isGenderValid = validateGender();  

    return isFirstNameValid && isLastNameValid && isUserNameValid && isPasswordValid 
    && isConf_PasswordValid && isEmailValid && isMobileValid && isGenderValid ; 
}

/* new password */

function showForm() 
{
	var otp=document.getElementById('otpp').value;

	if(otp=="")
	{
		document.getElementById('spp').innerHTML="Please Enter OTP";
		return false;
	}
	else
	{
		var form = document.getElementById("myForm");

		  // Check the current visibility state
		  if (form.style.visibility === "hidden") 
		  {
		    // If hidden, make it visible
		    form.style.visibility = "visible";
		  }
		  return true;
	}
	
	
	
  
}


