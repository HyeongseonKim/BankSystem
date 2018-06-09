package BankSys;
import java.util.Scanner;

public class Access {
	
	
	private int logsit = -1;		// login의 상태를 표시 1 : logon, 0 : logout;
	protected int money = 0;
	protected String ID;		// 고객 ID
	
	private Scanner keyboard = new Scanner(System.in);
	private BankAcc ba = new BankAcc();	//	고객 Account DB를 다루어줄 BankAcc 객체 생
	
	
	public Access(String AccTxt, int logsit) {
		this.logsit = logsit;
		money = 0;
		ba.SetFile(AccTxt);	// 객체가 생성될 때, 고객의 파일을 받는다.
	}
	
	public void Desit() {
		
		System.out.println("----------------DEPOSIT----------------");
		money = keyboard.nextInt();
		
		ba.deposit(money);
		
	}

	public void Widraw() {
		
		System.out.println("----------------WITHDRAW---------------");
		money = keyboard.nextInt();
		
		ba.withdraw(money);
		
	}

	public void Show() {
		System.out.println("---------------ACCOUNT---------------");
		ba.showAll();
	}

	public void Left() {
		System.out.println("----------------LEFT----------------");
		ba.showLeft();
	}

	public void logout() {
		System.out.println("Logout.");
		this.logsit = 0;
	}

	public void login() {
		
		this.logsit = 1;
	}
	
	public int logcheck() {
		return this.logsit;
	}

}
