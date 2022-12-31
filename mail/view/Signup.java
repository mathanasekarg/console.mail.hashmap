package mail.view;
import java.util.regex.Pattern;
import java.util.Scanner;
import mail.model.User;
import mail.controller.SignupController;
public class Signup {
	protected static Scanner sc = new Scanner(System.in);
	protected static short option = 0;
	protected static User user = new User();
	protected static void signup(){
		SignupController controller = new SignupController();
		System.out.println("\n\t------------------------ welcome Sign up -----------------------\n");
		while (true) {
			System.out.print("\tEnter your First name (min length 3) : ");
			user.setFirstName(sc.nextLine());
			System.out.print("\tEnter your Last name (min length 3) : ");
			user.setLastName(sc.nextLine());
			System.out.print("\tEnter your E-mail (min length 3 (use @ )) : ");
			user.setEmail(sc.nextLine());
			System.out.print("\tEnter your Password (min length 6) : ");
			user.setPassword(sc.nextLine());
			if(user.getFirstName().length() < 3 || user.getLastName().length() < 3){
				System.out.println("\n\t<----- Error : First name or last name length is less than 3 Try agin ------>\n");
			}
			else if (user.getPassword().length() < 6 || !Pattern.matches("^(.+)@(.+)$",user.getEmail()))
				if(!Pattern.matches("^(.+)@(.+)$",user.getEmail())){
					System.out.println("\n\t<----- Error : Invalid E-mail Try agin ------>\n");
				}
				else{
					System.out.println("\n\t<----- Error : Password length is less than 6 Try agin ------>\n");
				}
			else if(controller.isExistEmail(user.getEmail())){
				System.out.println("\n\t<----- Error : Email already exists Try agin ------>\n");
			}
			else if(controller.saveUser(user)){
				System.out.println("\n\t<------ User created ------>\n");
				MailMenu.menu();
				break;
			}
			else {
				System.out.print("\n\t1.Press any button to continue ->\n\t0.To Exit ->\n\tEnter your input : ");
				option = getShort(sc.nextLine());
				if(option == 0) {
					System.out.println("\n\t<------- Thank you ------>\n");
					break;
				} else inputWarning();
			}
		}//End loop
	}
	protected static void inputWarning(){
		System.out.println("\n\t<------ ERROR : Wrong input Try again ...! ------>\n");
	}
	
	protected static short getShort(String option){
		return (option.length() == 1) ? Short.parseShort(option.substring(0,1)) : 11;
	}
}