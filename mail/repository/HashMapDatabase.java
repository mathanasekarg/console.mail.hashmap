package mail.repository;
import mail.model.User;
import mail.model.Mail;
import java.util.HashMap;
public class HashMapDatabase {
	private static HashMapDatabase hashMapDatabase;
	private String loggedEmail;
	private Integer receiveMessageCount;
	private Integer sentMessageCount;
	private Integer sendMessageCount;
	private HashMap<String,User> users;
	private HashMap<String,HashMap<Integer,Mail>> receiveMessages;
	private HashMap<String,HashMap<Integer,Mail>> sendMessages;
	private HashMapDatabase(){
		this.loggedEmail = "";
		this.receiveMessageCount = 0;
		this.sentMessageCount = 0;
		setUser(new HashMap<String,User>());
		setReceiveMessage(new HashMap<String,HashMap<Integer,Mail>>());
		setSendMessage(new HashMap<String,HashMap<Integer,Mail>>());
	}
	public Integer getReceiveMessageCount(){
		return ++this.receiveMessageCount;
	}
	public Integer getSentMessageCount(){
		return ++this.sentMessageCount;
	}
	public void setLoggedEmail(String email){
		this.loggedEmail = email;
	}
	public String getLoggedEmail(){
		return loggedEmail;
	}
	public static HashMapDatabase database(){
		if(hashMapDatabase == null) hashMapDatabase = new HashMapDatabase();
		return hashMapDatabase;
	}
	public void setUser(HashMap<String,User> user){
		this.users = user;
	}
	public HashMap<String,User> getUser(){
		return users;
	}
	public void setReceiveMessage(HashMap<String,HashMap<Integer,Mail>> receiveMessage){
		this.receiveMessages = receiveMessage;
	}
	public HashMap<Integer,Mail> getReceiveMessage(String loggedEmail){
		return receiveMessages.get(loggedEmail);
	}
	public HashMap<String,HashMap<Integer,Mail>> getReceiveMessage(){
		return receiveMessages;
	}
	public void setSendMessage(HashMap<String,HashMap<Integer,Mail>> sendMessage){
		this.sendMessages = sendMessage;
	}
	public HashMap<Integer,Mail> getSendMessage(String loggedEmail){
		return sendMessages.get(loggedEmail);
	}
	public HashMap<String,HashMap<Integer,Mail>> getSendMessage(){
		return sendMessages;
	}
}