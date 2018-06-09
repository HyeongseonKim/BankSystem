package BankSys;
import java.util.Scanner;

public class MAIN {
	
	public static void main(String args[]) {
		
		// 입출력 그룹 
		Scanner keyboard = new Scanner(System.in);
		String ID, PW;
		
		// 변수 그룹
		int option = -1;
		
		// 객체 그룹
		BankId Identi = new BankId();	// ID, PW 인에 필요한 객체이다.
		Access Temp;				// Access를 통해 Client와 Administer를 이용할 수 있도록 한다.
		
		while(true) {
		
			do {
			System.out.println("----------------Login--------------");
			System.out.print("ID: ");
			ID = keyboard.nextLine();
			System.out.print("PW: ");
			PW = keyboard.nextLine();
			System.out.println("------------------------------------");
		
			Temp = Identi.check(ID, PW);
			if (Temp == null)
			{
				System.out.println("Not valid, please login again");
			}
			
			}while ( Temp == null);
			
			while(true) {
				
				System.out.println("-----------------------------------------------------------------");
				System.out.println("1. Deposit\t2. Withdraw\t3. Show\t  4.Left Money\t5. Logout");
				System.out.println("-----------------------------------------------------------------");
				
				option = keyboard.nextInt();
				keyboard.nextLine();
				switch(option) {
				
				case 1:
					Temp.Desit();
					break;
				case 2:
					Temp.Widraw();
					break;
				case 3:
					Temp.Show();
					break;
				case 4:
					Temp.Left();
					break;
				case 5:
					Identi.Init();
					Temp.logout();
					break;
				default:
					System.out.println("Error. Please enter the number again");
					
				}//switch
			
				if (Temp.logcheck() == 0) break;
			}//while2 infinite
				
		}//while1 infinite
		
		
	}//main method

}// MAIN CLASS
