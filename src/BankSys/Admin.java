package BankSys;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.Scanner;

public class Admin extends Access {
	
	private String CliStr;	// 고객 이름
	private Scanner keyboard = new Scanner(System.in);
	
	private BankAcc ba = new BankAcc();

	public Admin(String AccTxt, int logsit) {
		super(AccTxt, logsit);
		CliStr = null;
		super.FILENAME = null;
	}
	
	// Client DB에 있는 모든 고객 이름을 출력한다.
	public void ClientPrint() {
		
		Path fp = Paths.get("/Users/kimhyeongseon/Desktop/Git/BankSystem/IdentiDB.txt");
		//입력 버퍼에서 받을 파일 주소를 입력한다.
		
		try(BufferedReader br = Files.newBufferedReader(fp)) {
			// 파일 읽기 포인터를 생성한다.
			String str;
			int count = 1;
			
			while(true) {
				str = br.readLine();
				if(str == null)
					break;
				String[] strip = new String[3];
				strip = str.split(", ");
				
				
				// 파일 끝에서 while문 종료
				
				System.out.println(count++ +": " + strip[1]);
				// 고객 정보 인출 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 고객 이름에 해당하는 고객 DB의 위치를 반환 
	public String NametoAccTxt(String CliStr) {
		
		Path fp = Paths.get("/Users/kimhyeongseon/Desktop/Git/BankSystem/IdentiDB.txt");
		//입력 버퍼에서 받을 파일 주소를 입력한다.
		
		try(BufferedReader br = Files.newBufferedReader(fp)) {
			// 파일 읽기 포인터를 생성한다.
			String str;
			String[] strip = new String[3];
			
			while(true) {
				str = br.readLine();
				if(str == null)
				{
					System.out.println("Not valid, please enter again");
					break;
				}
				// 파일 끝에서 while문 종료
				
				strip = str.split(", ");
				// IdentiDB는 ", " 으로 항목이 구분되어 있다.
				
				if (CliStr.equals(strip[1])) {
				// 입력받은 ID와 DB ID가 같을때 true 반환, 아닐때 false 반환 
					System.out.println("----------------------------");
					System.out.println("Access ID" + strip[1] + ".");
					System.out.println("----------------------------");
					super.FILENAME = strip[3];
					return super.FILENAME;
				}
			}
					
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
		
		return super.FILENAME;
	}
	

	
	public void Desit() {
		
		ClientPrint();
		
		System.out.println("Choose the clients: ");
		CliStr = keyboard.nextLine();
	 	super.FILENAME = NametoAccTxt(CliStr);
		
		
		System.out.print("DEPOSIT: ");
		money = keyboard.nextInt();
		keyboard.nextLine();
		
		ba.deposit(super.FILENAME,money);
		
	}

	public void Widraw() {
		
		ClientPrint();
		
		System.out.println("Choose the clients: ");
		CliStr = keyboard.nextLine();
		super.FILENAME = NametoAccTxt(CliStr);
		
		System.out.print("WITHDRAW: ");
		money = keyboard.nextInt();
		keyboard.nextLine();
		
		ba.withdraw(super.FILENAME, money);
		
	}

	public void Show() {

		ClientPrint();
		
		System.out.println("Choose the clients: ");
		CliStr = keyboard.nextLine();
		super.FILENAME = NametoAccTxt(CliStr);
		
		System.out.print("ACCOUNT: ");
		
		ba.showAll(super.FILENAME);
	}

	public void Left() {
		
		ClientPrint();
		
		System.out.println("Choose the clients: ");
		CliStr = keyboard.nextLine();
		super.FILENAME = NametoAccTxt(CliStr);
		
		System.out.print("LEFT: ");
		ba.showLeft(super.FILENAME);
	}
	
}
