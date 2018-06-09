package BankSys;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.Scanner;

public class BankId {
	
	private String ID;
	private int count;
	
	public BankId() {
		ID = null;
		count = 0;
	}
	
	public void Init() {
		System.out.print("Initialize: Bank ID/PW. " );
		this.ID = null;
	}

	public Access check(String ID, String PW) {
		
		Path fp = Paths.get("/Users/kimhyeongseon/Desktop/Git/BankSystem/IdentiDB.txt");
		//입력 버퍼에서 받을 파일 주소를 입력한다.
		
		try(BufferedReader br = Files.newBufferedReader(fp)) {
			// 파일 읽기 포인터를 생성한다.
			String str;
			String[] strip = new String[3];
			
			while(true) {
				str = br.readLine();
				if(str == null)
					break;
				// 파일 끝에서 while문 종료
				
				strip = str.split(", ");
				// IdentiDB는 ", " 으로 항목이 구분되어 있다.
				
				if (ID.equals(strip[1])) {
				// 입력받은 ID와 DB ID가 같을때 true 반환, 아닐때 false 반환 
					if (PW.equals(strip[2]))
					{	// 입력받은 PW와 DB PW가 같을때 true 반환, 아닐때 false 반환 
						
						System.out.println("Login Succeed: " + strip[1] + " Author: " + strip[0]);
						this.ID = strip[1];
						
						if (strip[0].equals("Client"))
						{
							// 고객이면 Client 생성자 생성 뒤 Access 객체 포인터로 반환
							Access Cl = new Client(strip[3],1);
							return Cl;
							
						}
						else if(strip[0].equals("Admin"))
						{
							// 운영자이면 Admin 객체 생성 뒤 Access 객체 포인터로 반
							Access Ad = new Admin("-1", 1);
							return Ad;
						}
						
	
					}
					
				}
					
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		// 해당하는 ID가 없다면 null 반
	}

}

