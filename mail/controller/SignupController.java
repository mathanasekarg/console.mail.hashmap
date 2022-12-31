package mail.controller;
import mail.model.User;
import mail.model.Mail;
import java.util.HashMap;
import mail.repository.HashMapDatabase;
public class SignupController {
	public boolean isExistEmail (String email) {
		return HashMapDatabase.database().getUser().containsKey(email);
	}
	public boolean saveUser (User user) {
		HashMapDatabase.database().getUser().put(user.getEmail(),user);
		HashMapDatabase.database().getReceiveMessage().put(user.getEmail(),new HashMap<Integer,Mail>());
		HashMapDatabase.database().getSendMessage().put(user.getEmail(),new HashMap<Integer,Mail>());
		HashMapDatabase.database().setLoggedEmail(user.getEmail());
		return true;
	}
}