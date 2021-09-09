package projectRecruiterPlus.graphicsInterface.Scenes.NewUser;

import javafx.scene.paint.Color;
import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.User;

public class UserValidation {
	
	private NewUserScene newUserScene;
	
	public UserValidation(NewUserScene newUserScene) {
		super();
		this.newUserScene = newUserScene;
	}

	public boolean validUser(User newUser) {
		newUserScene.getInvalidInput().setTextFill(Color.web("#F08080"));
		int complexValidations = 0, notNullsvalidations = 0;
		notNullsvalidations = validateNulls();
		complexValidations = complexValidation();

		if (complexValidations == 4 && notNullsvalidations == 3) {
			return true;
		} else if (complexValidations == 4 && notNullsvalidations != 3) {
			newUserScene.getInvalidInput().setText("Please fill in the blanks");
			return false;
		}
		return false;
	}
	
	private int validateNulls() {
		int notNulls = 0;
		
		if (newUserScene.getFirstNameTextField().getText().equals("")) {
			newUserScene.getFirstNameTextField().setStyle("-fx-border-color: red;");
		} else {
			newUserScene.getFirstNameTextField().setStyle("-fx-border-color: blue;");
			notNulls++;
		}
		if (newUserScene.getLastnameTextField().getText().equals("")) {
			newUserScene.getLastnameTextField().setStyle("-fx-border-color: red;");
		} else {
			newUserScene.getLastnameTextField().setStyle("-fx-border-color: blue;");
			notNulls++;
		}
		if (newUserScene.getAdressTextField().getText().equals("")) {
			newUserScene.getAdressTextField().setStyle("-fx-border-color: red;");
		} else {
			newUserScene.getAdressTextField().setStyle("-fx-border-color: blue;");
			notNulls++;
		}
		return notNulls;
	}
	
	private int complexValidation() {
		int validations = 0;
		if (validSalary(newUserScene.getGrossTextField().getText(), newUserScene.getNetTextField().getText()))
			validations++;
		if (validEmail(newUserScene.getEmailTextField().getText()))
			validations++;
		if (validPassword(newUserScene.getPasswordTextField().getText()))
			validations++;
		if (validUsername(newUserScene.getUsernameTextField().getText()))
			validations++;
		return validations;
	}

	private boolean validSalary(String gross, String net) {
		int grossValue = 0, netValue = 0;
		boolean exit = false;
		try {
			grossValue = Integer.parseInt(gross);
		} catch (Exception e) {
			newUserScene.getGrossTextField().setStyle("-fx-border-color: red;");
			newUserScene.getInvalidInput().setText("Gross is not a valid number");
			exit = true;
		}
		try {
			netValue = Integer.parseInt(net);
		} catch (Exception e) {
			newUserScene.getNetTextField().setStyle("-fx-border-color: red;");
			newUserScene.getInvalidInput().setText("Net is not a valid number");
			exit = true;
		}
		if (exit) {
			return false;
		} else if (grossValue < netValue) {
			newUserScene.getGrossTextField().setStyle("-fx-border-color: red;");
			newUserScene.getNetTextField().setStyle("-fx-border-color: red;");
			newUserScene.getInvalidInput().setText("Net is bigger then Gross");
			return false;
		} else {
			newUserScene.getGrossTextField().setStyle("-fx-border-color: blue;");
			newUserScene.getNetTextField().setStyle("-fx-border-color: blue;");
		}
		return true;
	}

	private boolean validEmail(String text) {
		char[] email = text.toCharArray();
		boolean condi1 = false;
		boolean condi2 = false;
		for (char c : email) {
			if (c == '@')
				condi1 = true;
			if (c == '.' && condi1)
				condi2 = true;
		}
		if (condi1 && condi2) {
			newUserScene.getEmailTextField().setStyle("-fx-border-color: blue;");
			return true;
		}
		newUserScene.getInvalidInput().setText("invalid Email");
		newUserScene.getEmailTextField().setStyle("-fx-border-color: red;");
		return false;
	}

	private boolean validUsername(String text) {
		if (text.length() < 5) {
			newUserScene.getInvalidInput().setText("Username needs to have more then 4 characters!");
			newUserScene.getUsernameTextField().setStyle("-fx-border-color: red;");
			return false;
		}
		if (uniqueUsername(text)) {
			newUserScene.getInvalidInput().setText("Username in use!");
			newUserScene.getUsernameTextField().setStyle("-fx-border-color: red;");
			return false;
		}
		newUserScene.getUsernameTextField().setStyle("-fx-border-color: blue;");
		return true;
	}

	private boolean uniqueUsername(String text) {
		String usernameValidation = App.resources.getDaoUser().getbyUsername(text).getUsername();
		if (text.equals(usernameValidation)) {
			return true;
		}
		return false;
	}

	private boolean validPassword(String pass) {
		String answer = "Invalid Password! The password need to have:";
		char[] password = pass.toCharArray();
		boolean smallLetter = false, bigLetter = false, number = false, specialCharacter = false, space = false;
		for (char c : password) {
			if (c >= 33 && c <= 47 || c >= 58 && c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 126)
				specialCharacter = true;
			if (c >= 97 && c <= 122)
				smallLetter = true;
			if (c >= 65 && c <= 90)
				bigLetter = true;
			if (c >= 48 && c <= 57)
				number = true;
			if (c == 32)
				space = true;
		}
		if (pass.length() < 8)
			answer = answer + " more then 7 characters,";
		if (!smallLetter)
			answer = answer + " at least one small letter,";
		if (!bigLetter)
			answer = answer + " at least one big letter,";
		if (!number)
			answer = answer + " at least one number,";
		if (!specialCharacter)
			answer = answer + " at least one special character,";
		if (space) {
			newUserScene.getInvalidInput().setText("Can't use space in password");
			newUserScene.getPasswordTextField().setStyle("-fx-border-color: red;");
		} else if (answer.equals("Invalid Password! The password need to have:")) {
			newUserScene.getPasswordTextField().setStyle("-fx-border-color: blue;");
			return true;
		} else {
			newUserScene.getPasswordTextField().setStyle("-fx-border-color: red;");
			newUserScene.getInvalidInput().setText(answer.substring(0, answer.length() - 1) + "!");
		}
		return false;
	}
}
