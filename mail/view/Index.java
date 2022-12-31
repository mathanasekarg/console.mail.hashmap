package mail.view;
import java.util.Scanner;

public class Index extends Signin {
	public static void main(String[] args) {
		System.out.println("\t------------------------ welcome E-mail -----------------------\n");
		short opt = 0;
		while(true){
			System.out.print("\t1.Signin ->\n\t2.Signup ->\n\t0.Exit ->\n\tEnter your input : ");
			option = Index.getShort(sc.nextLine());
			opt = option;
			switch (option){
				case 1: signin();option=opt;break;
				case 2: signup();option=opt;break;
				case 0: System.out.println("\n\t <------------ Thank you for your time ------------>\n");System.exit(0);
				default : inputWarning();break;
			}
		}
	}
}