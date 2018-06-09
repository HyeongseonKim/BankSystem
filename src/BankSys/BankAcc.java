package BankSys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


public class BankAcc {
   
   private String Filename;	//	고객 정보 파일 이름
   private String Name;	// 이름
   private String accNum;	// 계좌 번호
   private int left;   //   남은 돈
   
   public BankAcc() {
      
	   this.Name = null;
	   this.left = 0;
	   this.accNum = null;
   }
   
   public void SetFile(String AccTxt) {
	   Filename = AccTxt;
   }
   
   public void InitBA() {
	   
	   this.Name = null;
	   this.left = 0;
	   this.accNum = null;
   }
   
   // Account Text 파일에서 Name, account Number, left Money 요소 저
   public void AccTxtToVar() {
      
      Path fp = Paths.get(Filename);
      //입력 버퍼에서 받을 파일 주소를 입력한다.
      
      try(BufferedReader br = Files.newBufferedReader(fp)) {
         // 파일 읽기 포인터를 생성한다.
         String str;
         String[] strip = new String[6];
         
         while(true) {
            str = br.readLine();
            if(str == null)
               break;
            // 파일 끝에서 while문 종료
            
            strip = str.split(", ");
            // IdentiDB는 ", " 으로 항목이 구분되어 있다.
          
         }
         
         this.Name = strip[0];
         this.accNum = strip[1];
         this.left = Integer.parseInt(strip[4]);
         
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
      
   }
   
   public void AccTxtRead() {
      
      int count = 1;
      
      Path fp = Paths.get(Filename);
      //입력 버퍼에서 받을 파일 주소를 입력한다.
      
      try(BufferedReader br = Files.newBufferedReader(fp)) {
         // 파일 읽기 포인터를 생성한다.
         String str;
         
         while(true) {
            str = br.readLine();
            if(str == null)
               break;
            // 파일 끝에서 while문 종료
            
            System.out.println(count + ": " + str);   
            count++;
         }
         
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
   }

   // File에서 쓴다.
   public void AccTxtWrite(int money, int option) {
      BufferedWriter bw = null;
      FileWriter fw = null;
      try {
         fw = new FileWriter(Filename, true);
         bw = new BufferedWriter(fw);
         
         switch(option) {
         
         	case 1:	// Deposit
         		bw.newLine();
         		bw.write( Name +", " + accNum + ", " + money + ", 0, " + this.left);
         		break;
         	case 2:	// Withdraw
         		bw.newLine();
         		bw.write( Name +", " + accNum + ", 0, " +  money + ", " + this.left);
         		break;
         	default:
         		return;
         		
         }
         
      }
      catch(IOException e) {
         e.printStackTrace();
      }
      finally {
         try{
            if(bw !=null)
               bw.close();
            if(fw != null)
               fw.close();
         }
         catch(IOException ex) {
            ex.printStackTrace();
         }
      }      
   }

   public void deposit(int money) {
      
	  AccTxtToVar();
      this.left = money + left;
      AccTxtWrite(money, 1);
      
   }

   public void withdraw(int money) {
      
	   if ( this.left - money < 0) {
		   
		   	System.out.println("You don't have money");
			return;  
		   }
	   else {
		   this.left = this.left - money;
	   }
	  
      AccTxtWrite(left, 2);
      
   }

   public void showAll() {
      
      AccTxtRead();
      
   }

   public void showLeft() {
      
	  AccTxtToVar();
      System.out.println(this.left);
      
   }


}