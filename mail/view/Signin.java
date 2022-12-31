package mail.view;
import mail.controller.SigninController;
public class Signin extends Signup{
	protected static void signin(){
		SigninController controller = new SigninController();
		System.out.println("\n\t------------------------ welcome Sign in -----------------------");
		while (true) {
			System.out.print("\n\tEnter your Email : ");
			String email = sc.nextLine();
			System.out.print("\tEnter your Password : ");
			String password = sc.nextLine();
			if(controller.usernamePassword(email,password)){
				System.out.println("\n\t<------ Signin Successfully ------>\n");
				MailMenu.menu();
				break;
			}
			else {
				System.out.println("\n\t<------ E-mail or password is wrong Try again ------>\n");
				System.out.print("\n\t1.Press any button to continue ->\n\t0.To Exit ->\n\tEnter your input : ");
				option = getShort(sc.nextLine());
				if(option == 0) {
					System.out.println("\n\t<------- Thank you ------>\n");
					break;
				} else inputWarning();
			}
		}// End loop
	}
}