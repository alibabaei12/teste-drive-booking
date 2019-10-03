function validation() {
	
	var names = document.getElementById("customer_name");

	var licence = document.getElementById("licence");
	var errorMsg = document.getElementById("error_msg");
	var dof = document.getElementById("drive_date");
	var letterNumber = /^[0-9a-zA-Z]+$/;
	var dateValidatio = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
	//testing the name
	if (/\d/.test(names.value)) {
		errorMsg.innerHTML = "There are numbers in the name";
		return false;
	}

	//testing the license
	if(!(/\d/.test(licence.value)))
	{
		errorMsg.innerHTML = "No numbers in your licence";
		return false;
	}
	if(!(licence.value.match(/[a-z]/i)))
		{
		errorMsg.innerHTML = "No letters in your licence";
		return false;
		}
	return true;
	
//	if (!dof.value.match(dateValidatio)) {
//		errorMsg.innerHTML = "Wrong Date validation";
//		return false;
//	} else {
//		var strsplt = dof.value.split("/");
//		var age2 = 2019 - strsplt[2];
//		age.value = age2;
//
//		return false;
//	}
}