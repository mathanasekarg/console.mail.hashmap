package mail.view;
import mail.model.Mail;
import mail.controller.MailController;
import java.util.HashMap;
import java.util.Map.Entry;
public class MailMenu extends Signup {
	protected static void menu(){
		System.out.println("\t------------------------ welcome  -----------------------");
		while (true) {
			System.out.print("\n\t1.compose -->\n\t2.Send messages -->\n\t3.Recieve messages -->\n\t0.Logout -->\n\tEnter your input : ");
			option = getShort(sc.nextLine());
			short opt = option;
			switch (option){
				case 1: compose();option=opt;break;
				case 2: sendMessages();option=opt;break;
				case 3: recieveMessages();option=opt;break;
				case 0: break;
				default : inputWarning();break;
			}
			if(option == 0) {
				System.out.println("\n\t <------------ Logout successfully ------------>\n");
				break;
			}
		}//End loop
	}
	private static void compose(){
		Mail mail = new Mail();
		MailController mailController = new MailController();
		System.out.println("\n\t <------------ Compose mail ------------>");
		while (true) {
			System.out.print("\n\tTO (want many send mails use ','): ");
			mail.setToMail(sc.nextLine());
			System.out.print("\tSubject : ");
			mail.setSubject(sc.nextLine());
			System.out.print("\tMessage : ");
			mail.setMessage(sc.nextLine());
			if(mailController.compose(mail)) System.out.println("\n\t <------------ Mail sent process completed ------------>\n");
			else System.out.println("\n\t <------------ Mail didn't sent ------------>\n");

			System.out.print("\n\t1.Press any button to continue ->\n\t0.To Exit ->\n\tEnter your input : ");
			option = getShort(sc.nextLine());
			if(option == 0) {
				System.out.println("\n\t<------- Thank you ------>\n");
				break;
			}
		}
	}
	private static void sendMessages(){
		System.out.println("\n\t <------------ Send Messages ------------>");
		MailController mailController = new MailController();
		String deleteId = "0";
		while(true){
			for(Entry<Integer,Mail> entry : mailController.getSendMessages().entrySet())
				System.out.println("\n\tMessage id : "+entry.getKey()+", To : "+entry.getValue().getToMail()+", Subject: "+entry.getValue().getSubject()+", Message : "+entry.getValue().getMessage());

			System.out.print("\n\tEnter delete message id ->\n\t0.To Exit ->\n\tEnter your input : ");
			deleteId = sc.nextLine();
			if(deleteId.equals("0")) {
				System.out.println("\n\t<------- Thank you ------>\n");
				break;
			} else{
				try{
					if(mailController.deleteSendMessage(Integer.parseInt(deleteId))) System.out.println("\n\t<------ Message deleted ...! ------>\n");
					else System.out.println("\n\t<------ message id doesn't exists ...! ------>\n");
				} catch(NumberFormatException e){
					System.out.println("\n\t<------ ERROR : Wrong input Try again ...! ------>\n");
				}
			}
		}
	}
	private static void recieveMessages(){
		System.out.println("\n\t <------------ Recieve Messages ------------>");
		MailController mailController = new MailController();
		String deleteId = "0";
		while(true){
			for(Entry<Integer,Mail> entry : mailController.getReceiveMessages().entrySet())
				System.out.println("\n\tMessage id : "+entry.getKey()+", From : "+entry.getValue().getFromMail()+", Subject: "+entry.getValue().getSubject()+", Message : "+entry.getValue().getMessage());

			System.out.print("\n\tEnter delete message id ->\n\t0.To Exit ->\n\tEnter your input : ");
			deleteId = sc.nextLine();
			if(deleteId.equals("0")) {
				System.out.println("\n\t<------- Thank you ------>\n");
				break;
			} else{
				try{
					if(mailController.deleteReceiveMessage(Integer.parseInt(deleteId))) System.out.println("\n\t<------ Message deleted ...! ------>\n");
					else System.out.println("\n\t<------ message id doesn't exists ...! ------>\n");
				} catch(NumberFormatException e){
					System.out.println("\n\t<------ ERROR : Wrong input Try again ...! ------>\n");
				}
			}
		}
	}
}