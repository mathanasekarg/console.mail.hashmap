package mail.controller;
import mail.repository.HashMapDatabase;
import mail.model.Mail;
import java.util.HashMap;
public class MailController extends SignupController {
	public MailController(){

	}
	public boolean compose(Mail mail) {
		boolean flag = false;
		String[] toUsers = mail.getToMail().split(",");
		mail.setFromMail(HashMapDatabase.database().getLoggedEmail());
		for(String toMail : toUsers){
			if(isExistEmail(toMail)) {
				if(toMail.equals(mail.getFromMail())) System.out.println("\n\t <------ ERROR : "+toMail+" (send and receive mail is same) Mail not sent ------->\n");
				else{
					HashMapDatabase.database().getReceiveMessage(mail.getToMail()).put(HashMapDatabase.database().getReceiveMessageCount(),mail);
					System.out.println("\n\t <------ '"+toMail+"' Mail sent successfully ------->\n");
					flag = true;
				}
			}
			else System.out.println("\n\t <------ ERROR : '"+toMail+"' doesn't exists Mail not sent ------->\n");
		}
		if(flag){
			HashMapDatabase.database().getSendMessage(mail.getFromMail()).put(HashMapDatabase.database().getSentMessageCount(),mail);
		}
		return flag;
	}
	public HashMap<Integer,Mail> getSendMessages() {
		return HashMapDatabase.database().getSendMessage(HashMapDatabase.database().getLoggedEmail());
	}
	public boolean deleteSendMessage(Integer messageId){
		return HashMapDatabase.database().getSendMessage(HashMapDatabase.database().getLoggedEmail()).remove(messageId)==null?false:true;
	}
	public HashMap<Integer,Mail> getReceiveMessages() {
		return HashMapDatabase.database().getReceiveMessage(HashMapDatabase.database().getLoggedEmail());
	}
	public boolean deleteReceiveMessage(Integer messageId){
		return HashMapDatabase.database().getReceiveMessage(HashMapDatabase.database().getLoggedEmail()).remove(messageId)==null?false:true;
	}
}