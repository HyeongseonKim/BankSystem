package BankSys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BankAcc {
	
	public void AccTxtRead(String Filename) {
		
		Path fp
		
	}
	
	public void AccTxtWrite(String File, int money) {
		
		Path fw = Paths.get("File");
		//입력 버퍼에서 받을 파일 주소를 입력한다.
		
		String s = null;
		
		while((s=fw.rea))
		
		try(BufferedWriter bw = Files.newBufferedWriter(fw)) {
			// 파일 읽기 포인터를 생성한다.
			String str;
			String[] strip = new String[3];
			
			while(true) {
				str = bw.newLine();
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
		
	}

	public void deposit(String user, int money) {
		
		
		
	}

	public void withdraw(String user, int money) {
		// TODO Auto-generated method stub
		
	}

	public void showAll(String user) {
		// TODO Auto-generated method stub
		
	}

	public void showLeft(String user) {
		// TODO Auto-generated method stub
		
	}


}
