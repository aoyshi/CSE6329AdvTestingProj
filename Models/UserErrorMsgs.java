package car_rental_app.model;

public class UserErrorMsgs {

	private String errorMsg;
	private String firstNameError;
	private String lastNameError;
	private String usernameError;
	private String utaIdError;
	private String passwordError;
	private String emailError;
	private String ageError;
	
	public UserErrorMsgs () {
		this.errorMsg="";
		this.firstNameError="";
		this.lastNameError="";
		this.usernameError="";
		this.utaIdError="";
		this.emailError="";
		this.ageError="";
		this.passwordError="";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!firstNameError.equals("") || !lastNameError.equals("") || !usernameError.equals("") || 
		    !utaIdError.equals("") || !emailError.equals("") ||!ageError.equals("") || !passwordError.equals(""))
		  errorMsg="Please correct the following errors";
	}
	
	public String getFirstNameError() {
		return firstNameError;
	}
	public void setFirstNameError(String firstNameError) {
		this.firstNameError = firstNameError;
	}

	public String getLastNameError() {
		return lastNameError;
	}
	public void setLastNameError(String lastNameError) {
		this.lastNameError = lastNameError;
	}
	
	public String getUsernameError() {
		return usernameError;
	}
	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	
	public String getUtaIdError() {
		return utaIdError;
	}
	public void setUtaIdError(String utaIdError) {
		this.utaIdError = utaIdError;
	}
	
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	
	public String getAgeError() {
		return ageError;
	}
	public void setAgeError(String ageError) {
		this.ageError = ageError;
	}


}