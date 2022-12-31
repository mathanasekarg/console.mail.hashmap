package mail.model;
public class Mail {
	String fromMail, toMail;
	String subject,message;
	public Mail(){
		
	}
	public Mail(String fromMail, String toMail, String subject, String message){
		this.fromMail = fromMail;
		this.toMail = toMail;
		this.subject = subject;
		this.message = message;
	}
	public void setFromMail(String fromMail){
		this.fromMail = fromMail;
	}
	public String getFromMail(){
		return this.fromMail;
	}
	public void setToMail(String toMail){
		this.toMail = toMail;
	}
	public String getToMail(){
		return this.toMail;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	public String getSubject(){
		return this.subject;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
		return this.message;
	}
}