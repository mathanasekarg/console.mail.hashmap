package mail.controller;
import mail.model.User;
import mail.repository.HashMapDatabase;
public class SigninController {
	public boolean usernamePassword(String email,String password){
		User dbUser = HashMapDatabase.database().getUser().get(email);
		HashMapDatabase.database().setLoggedEmail(email);
		return dbUser == null ? false : dbUser.getPassword().equals(password);
	}
}