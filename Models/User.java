package car_rental_app.model;

import java.io.Serializable;
import car_rental_app.data.UserDAO;

public class User implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String utaId;
	private int age;
	private int aacMembership;
	private String role;
	private int isRevoked;

	//user-provided age in registration form
	private String ageAsString;
	
	//overloaded constructor for newly registered users
	public void setUser(String firstName, String lastName, String username, String password, String email, 
			String utaId, String age, String aacMembership, String role) 
	{	  
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.utaId = utaId;
		this.ageAsString = age; //will be verified if int
		this.aacMembership = Integer.parseInt(aacMembership); //safe, aacMem is strictly 0/1 from jsp form
		this.role = role;
		this.isRevoked = 0; //default for newly registered user is unrevoked
	}
	
	//overloaded constructor for existing users
	public void setUser(String firstName, String lastName, String username, String password, String email, 
			String utaId, int age, int aacMembership, String role, int isRevoked) 
	{	  
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.utaId = utaId;
		this.age = age;
		this.aacMembership = aacMembership;
		this.role = role;
		this.isRevoked = isRevoked; 
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getAgeAsString() {
		return ageAsString;
	}
	
	public int getIsRevoked() {
		return isRevoked;
	}
	public void setIsRevoked(int isRevoked) { 
		this.isRevoked = isRevoked;
	}
	
	public String getUtaId(){
		return utaId;
	}
	
	public void setUtaId(String utaId){
		this.utaId=utaId;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username=username;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName=lastName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public int getAacMembership() {
		return aacMembership;
	}
	
	public void setAacMembership(int aacMembership) {
		this.aacMembership=aacMembership;
	}
	
	public String getRole(){
		return role;
	}

	public void setRole(String role){
		this.role=role;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age=age;
	}
	
	/************ VALIDATIONS *************/
	
	public void validateUser (User user, UserErrorMsgs errorMsgs) {
		
		errorMsgs.setFirstNameError(validateFirstName(user.getFirstName()));
		errorMsgs.setLastNameError(validateLastName(user.getLastName()));
		errorMsgs.setUsernameError(validateUsername(user.getUsername()));
		errorMsgs.setPasswordError(validatePassword(user.getPassword()));
		errorMsgs.setEmailError(validateEmail(user.getEmail()));
		errorMsgs.setUtaIdError(validateUtaId(user.getUtaId()));
		errorMsgs.setAgeError(validateAge(user.getAgeAsString()));

		errorMsgs.setErrorMsg();
	}
	
	private String validateFirstName (String firstName) {
		String result="";
		firstName = firstName.trim(); //trim out trailing and leading spaces
		
		if (!stringSize(firstName,2,50))
			result= "Your First Name must between 2 and 50 characters";
		else
			if (!firstName.matches("^[a-zA-Z]+$"))
				result="Your First Name must only contain alphabets";
		
		return result;
	}
	
	private String validateLastName (String lastName) {
		String result="";
		lastName = lastName.trim(); //trim out trailing and leading spaces
		
		if (!stringSize(lastName,2,50))
			result= "Your Last Name must between 2 and 50 characters";
		else
			if (!lastName.matches("^[a-zA-Z]+$"))
				result="Your Last Name must only contain alphabets";
		
		return result;
	}
	

	private String validateUsername(String username) {
		username = username.trim();
		String result="";
		if (!stringSize(username,2,16))
			result= "Your username must between 2 and 16 digits";
		else
			if (!username.matches("^[a-zA-Z0-9]+$"))
				result="Your username must only contain alphabets and numbers";
			else
				if (!UserDAO.uniqueUsername(username))
					result="Username already in database";
		return result;				
	}

	private String validatePassword(String password) {
		password = password.trim();
		String result="";
		if (!stringSize(password,8,16))
			result= "Your password must between 8 and 16 characters";
		else 
			if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@._#$%^&+=]).{8,}$"))
				result= "Your password must contain at least 1 upper case letter, at least 1 lower case letter and at least 1 special character(@#$%^&+=._)";
				
		//explanation of regex:
		/*      ^                 # start-of-string
				(?=.*[0-9])       # a digit must occur at least once
				(?=.*[a-z])       # a lower case letter must occur at least once
				(?=.*[A-Z])       # an upper case letter must occur at least once
				(?=.*[@#$%^&+=])  # a special character must occur at least once
				.{8,}             # anything, at least eight places though
				$                 # end-of-string/
		*/
		return result;
	}
	
	private String validateEmail(String email) {
		email = email.trim();
		String result="";
		if (!stringSize(email,7,45))
			result= "Your email must between 7 and 45 characters";
		else 
		   if(!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.com|.gov|.net|.org|.edu|.mil)$"))
			 result= "Your email must contain @ and any one of the following extensions {.com,.gov,.net,.org,.edu,.mil}"; 
			  
		return result;
	}
	
	private String validateUtaId(String utaId) {
		utaId = utaId.trim();
		String result="";
		if (utaId.length()!=10)
			result= "Your UTA ID must be exactly 10 digits long";
		else
			if (!isTextAnInteger(utaId))
				result="Your UTA ID must be a number";
		return result;
	}
	
	private String validateAge(String ageAsString) {
		String result="";
		
		if(!isTextAnInteger(ageAsString))
			result= "Your age must be a whole number";
		
		else {
			int age = 0;
			try {
			      age = Integer.parseInt(ageAsString); //convert age to an int
			} catch(NumberFormatException e) {				
			}
			
			this.age = age;
			
			if (age < 18)
				result= "You must be at least 18 years old to rent a car";
			else
			{
				if(age > 130) 
					result= "Your age cannot be greater than 130 years";
			}
		}
				
		return result;
	}

	/************* VERIFY PASSWORD-USERNAME MATCH FOR LOG-IN ****************/
	public void verifyUser (User user, UserErrorMsgs errorMsgs) {		
		errorMsgs.setUsernameError(verifyUsername(user.getUsername()));
		errorMsgs.setPasswordError(verifyPassword(user.getPassword(),user.getUsername()));	
		errorMsgs.setErrorMsg();
	}
	private String verifyUsername(String username) {
		String result="";
		username = username.trim();
		if (username.isEmpty())
			result = "Username cannot be blank";
		else
			if (UserDAO.uniqueUsername(username))
				result="This username is not registered yet";
		return result;				
	}

	private String verifyPassword(String password, String username) {
		String result="";
		if (password.isEmpty())
			result = "Password cannot be blank";
		else
			if (!UserDAO.uniqueUsername(username))//if user exists, get password from DB & check for match
				if (! (UserDAO.getUser(username).getPassword().equals(password)) )
					result="Incorrect password";
		return result;	
	}
	
	
	/************* AUXILIARY FUNCTIONS *************/
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}	
	
}
