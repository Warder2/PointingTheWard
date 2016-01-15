function emailValidation(email){
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;   
	
	if(regex.test(email) === false) {  
		alert("잘못된 이메일 형식입니다.");  
		return false;  
	} else {  
		return true;
	}  
}