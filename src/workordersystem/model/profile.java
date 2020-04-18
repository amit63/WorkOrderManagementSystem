package workordersystem.model;

import workordersystem.model.profileErrorMsgs;
import workordersystem.model.profile;

public class profile {
	private static String user;
	private static String username;

	private static String password;
	private static String username1;

	private static String password1;

	private static String lastname;
	private static String firstname;
	private static String phone;
	private static String email;
	private static String address;
	private static String state;
	private static String zipcode;
	private static String role;
	private static String role1;
	private static String uta_id;
	private static String city;

	public void setRegister(String username, String password, String lastname, String firstname, String phone,
			String email, String address, String state, String zipcode, String role, String uta_id) {

		//System.out.println(uta_id);
		setUserName(username);
		setPassword(password);
		setLastName(lastname);
		setFirstName(firstname);
		setPhone(phone);
		setEmail(email);
		setAddress(address);
		setState(state);
		setZipCode(zipcode);
		setRole(role);
		setUtaId(uta_id);
		// setCity(city);
	}

	public void setLogin(String username1, String password1) {
		setUserName1(username1);
		setPassword1(password1);

	}


 

	public void setChangeUserProfile(String user, String role1) {
		setUser(user);
		 setRole(role1);
	}

	
	public void setViewProfile(String username) {
		setUserName(username);
	}
	public void setUpdateProfile(String username) {
		setUserName(username);
	}
	
	public void setViewUserProfile(String user) 
	{
		setUser(user);
		
	}
	
	
	public void setUser(String user) {
		this.user = user;

	}

	public String getUser() {
		return user;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;

	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getPassword() {
		return password;
	}
	public String getUserName1() {
		return username1;
	}

	public void setUserName1(String username1) {
		this.username1 = username1;

	}

	public void setPassword1(String password1) {
		this.password1 = password1;

	}

	public String getPassword1() {
		return password1;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;

	}

	public String getLastName() {
		return lastname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;

	}

	public String getFirstName() {
		return firstname;
	}

	public void setPhone(String phone) {
		this.phone = phone;

	}

	public String getPhone() {
		return phone;
	}

	public void setZipCode(String zipcode) {
		this.zipcode = zipcode;

	}

	public String getZipCode() {
		return zipcode;
	}

	public void setRole(String role) {
		this.role = role;

	}

	public String getRole() {
		return role;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public String getEmail() {
		return email;
	}

	public void setAddress(String address) {
		this.address = address;

	}

	public String getAddress() {
		return address;
	}

	public void setState(String state) {
		this.state = state;

	}

	public String getState() {
		return state;
	}

	public void setUtaId(String uta_id) {
		this.uta_id = uta_id;

	}

	public String getUtaId() {
		return uta_id;
	}

//	public void setCity(String city) {
//		this.city=city;
//		
//	}
//	public String getCity() {
//		return city;
//	}

	public static void validateUser(String action, profile reg, profileErrorMsgs errorMsgs) {

		//System.out.println("checking");
		/*
		 * if (action.equals("login")) {
		 * 
		 * //System.out.println("login");
		 * errorMsgs.setUsernameError(validateUsername(reg.getUserName()));
		 * errorMsgs.setPasswordError(validatePassword(reg.getPassword()));
		 * errorMsgs.setErrorMsg();
		 * 
		 * }
		 */

		if (action.equals("register")) {

			//System.out.println("register");
			errorMsgs.setUsernameError(validateUsername(reg.getUserName()));
			errorMsgs.setPasswordError(validatePassword(reg.getPassword()));
			errorMsgs.setLastNameError(validateLastName(reg.getLastName()));
			errorMsgs.setFirstNameError(validateFirstName(reg.getFirstName()));
			errorMsgs.setPhoneError(validatePhone((reg.getPhone())));
			errorMsgs.setEmailError(validateEmail(reg.getEmail()));
			//errorMsgs.setutaidError(validateUtaId(reg.getUtaId()));
			errorMsgs.setaddressError(validateAddress(reg.getAddress()));
			// errorMsgs.setStateError(validateState(reg.getState()));
			errorMsgs.setZipcodeError(validateZipCode(reg.getZipCode()));
			// errorMsgs.setZipcodeError(validateCity(reg.getCity()));

			errorMsgs.setErrorMsg();

		} 
		
		
		if (action.equals("changerole")) {
			//System.out.println("Before validation");
			//System.out.print(reg.getUser());
			//System.out.println("after validation");
			errorMsgs.setUsernameError(validateUsername(reg.getUser()));

			errorMsgs.setErrorMsg();

		}

		
		 if (action.equals("viewprofile1")) {
			//System.out.println("Before validation");
			//System.out.print(reg.getUser());
			//System.out.println("after validation");
			errorMsgs.setUsernameError(validateUsername(reg.getUserName()));

			errorMsgs.setErrorMsg();

		} 
			
			
			
		 else if(action.equals("viewuserprofile"))  {
		  //System.out.println("Before validation"); System.out.print(reg.getUser());
		  //System.out.println("after validation");
		  errorMsgs.setUsernameError(validateUsername(reg.getUser()));
		  errorMsgs.setErrorMsg();
		  }
		 

	}

	public static void validateLogin(String action, profile log, profileErrorMsgs errorMsgs) {

		//System.out.println("Validate");

		if (action.equals("login")) {
			//System.out.println("login");
			errorMsgs.setUsernameError(validateUsername(log.getUserName1()));
			errorMsgs.setPasswordError(validatePassword(log.getPassword1()));
			errorMsgs.setErrorMsg();

		}
	}

	public static void validateUpdateUser(String action, profile reg, profileErrorMsgs errorMsgs) {
		// System.out.println("checking");

		if (action.equals("updateprofile")) {

			//System.out.println("update");
			//errorMsgs.setUsernameError(validateUsername(reg.getUserName()));
			errorMsgs.setPasswordError(validatePassword(reg.getPassword()));
			// System.out.println(reg.getLastName());
			// errorMsgs.setLastNameError(validateLastName(reg.getLastName()));
			// errorMsgs.setFirstNameError(validateFirstName(reg.getFirstName()));
			errorMsgs.setPhoneError(validatePhone((reg.getPhone())));
			errorMsgs.setEmailError(validateEmail(reg.getEmail()));
			// errorMsgs.setutaidError(validateUtaId(reg.getUtaId()));
			errorMsgs.setaddressError(validateAddress(reg.getAddress()));
			// errorMsgs.setStateError(validateState(reg.getState()));
			errorMsgs.setZipcodeError(validateZipCode(reg.getZipCode()));
			// errorMsgs.setCityError(validateCity(reg.getCity()));

			errorMsgs.setErrorMsg();

		}

		else if (action.equals("updateprofile1")) {

			//System.out.println("update");
			//errorMsgs.setUsernameError(validateUsername(reg.getUserName()));
			errorMsgs.setPasswordError(validatePassword(reg.getPassword()));
			// System.out.println(reg.getLastName());
			//errorMsgs.setLastNameError(validateLastName(reg.getLastName()));
			//errorMsgs.setFirstNameError(validateFirstName(reg.getFirstName()));
			errorMsgs.setPhoneError(validatePhone((reg.getPhone())));
			errorMsgs.setEmailError(validateEmail(reg.getEmail()));
			//errorMsgs.setutaidError(validateUtaId(reg.getUtaId()));
			errorMsgs.setaddressError(validateAddress(reg.getAddress()));
			// errorMsgs.setStateError(validateState(reg.getState()));
			errorMsgs.setZipcodeError(validateZipCode(reg.getZipCode()));
			// errorMsgs.setCityError(validateCity(reg.getCity()));

			errorMsgs.setErrorMsg();

		}

		if (action.equals("changerole")) {
			//System.out.println("Before validation");
			//System.out.print(reg.getUser());
			//System.out.println("after validation");
			errorMsgs.setUsernameError(validateUsername(reg.getUser()));

			errorMsgs.setErrorMsg();

		}

		else if (action.equals("viewuserprofile")) {
			//System.out.println("Before validation");
			//System.out.print(reg.getUser());
			//System.out.println("after validation");
			errorMsgs.setUsernameError(validateUsername(reg.getUser()));

			errorMsgs.setErrorMsg();

		}

	}

	public static String validateAddress(String address) {
		String result = "";

		if (address.equals("")) {
			result = "this field required";
		} else {

			if (!stringSize(address, 10, 100)) {
				result = "Your Address must between 10 and 100 characters";
			}

		}
		return result;
	}

	public static String validateFirstName(String firstname) {
		String result = "";

		if (firstname.equals("")) {
			result = "this field required";
		} else {

			if (!stringSize(firstname, 3, 16)) {
				result = "Your first Name must between 3 and 16 characters";
			} else if (Character.isLowerCase(firstname.charAt(0))) {
				result = "Your first name must start with a capital letter";
			}

		}
		return result;
	}

	public static String validateLastName(String lastname) {
		String result = "";
		if (lastname.equals("")) {
			result = "this field required";
		} else {

			if (!stringSize(lastname, 3, 16)) {
				//System.out.println("In Validate Last Name");
				result = "Your Last Name must between 3 and 16 characters";
			} else if (Character.isLowerCase(lastname.charAt(0))) {
				result = "Your Last name must start with a Uppercase";
			}

		}
		return result;
	}

	public static String validatePassword(String password) {
		String result = "";
		if (password.equals("")) {
			result = "this field required";
		} else {

			if (!stringSize(password, 3, 16)) {
				result = "Your password must between 3 and 16 characters";
			}
		}
		return result;
	}

	public static String validateUsername(String username) {
		String result = "";

		//System.out.println("Before");
		if (username.equals("")) {
			//System.out.println("Before here");
			result = "this field required";
		} else {

			if (!stringSize(username, 3, 16)) {
				result = "Your User Name must between 3 and 16 characters";
			} else if (Character.isLowerCase(username.charAt(0))) {
				result = "Your User name must start with a Uppercase";
			}

		}
		return result;
	}

	private static boolean stringSize(String string, int min, int max) {
		return string.length() >= min && string.length() <= max;
	}

	private static String validatePhone(String phone) {
		String result = "";

		//System.out.println("Before");
		if (phone.equals("")) {
			//System.out.println("Before here");
			result = "this field required";
		} else {

			if (!isTextAnInteger(phone)) {
				result = "Phone number must be a number";
			}

			else if (phone.length() != 10) {
				result = "Phone number must be 10 digits in length";
			}

		}

		return result;
	}

	/*public static String validateUtaId(String uta_id) {
		String result = "";
		//System.out.println("Before");
		if (uta_id.equals("")) {
			//System.out.println("Before here");
			result = "this field required";
		}

		else {

			if (!isTextAnInteger(uta_id)) {
				result = "UTA ID must be a number";
			}

			else if (uta_id.length() != 10) {
				result = "UTA ID must be 10 digits in length";
			} else {
				result = "";
			}

		}
		return result;
	}*/

	public static String validateZipCode(String zipcode) {
		String result = "";
		//System.out.println("Before");
		if (zipcode.equals("")) {
			//System.out.println("Before here");
			result = "this field required";
		}

		else {

			if (!isTextAnInteger(zipcode)) {
				result = "Zipcode must be a number";
			} else if (zipcode.length() != 5) {
				result = "Zipcode must be 5 digits in length";

			}
			
			else {
				result ="";
			}
		}
		return result;
	}

	public static String validateEmail(String email) {
		String result = "", extension = "";

//System.out.println("Before");

		if (email.equals("")) {
			// System.out.println("Before here");
			result = "this field required";
		}

		else if (!email.contains("@")) {
			System.out.println("Inside of email validation @");
			result = "Email address needs to contain @";
		} else if (!stringSize(email, 7, 45)) {
			result = "Email address must be between 7 and 45 characters long";
		} else {
			extension = email.substring(email.length() - 4, email.length());
			if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com")
					&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil")&& !extension.equals("l.co"))
				result = "Invalid domain name";
		}

		return result;
	}

	private static boolean isTextAnInteger(String string) {
		boolean result;
		try {
			Long.parseLong(string);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}
}

