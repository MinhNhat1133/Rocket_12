import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise2 {
	public static void main(String[] args) {
		Q1();
	}

public static void Q1 (){
	Account[] account =  new Account[5];
	for(int i=1; i< account.length ; i++){
		account[i] = new Account();
		account[i].email = "Email" + i;
		account[i].userName= "User name"+ i;
		account[i].fullName ="Full name" + i;
		String createDate = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(createDate);
		String date = simpleDateFormat.format(new Date());
//		account[i].createDate = new Date();
//		System.out.println("Email: "+ account[i].email + "\nUsername: "+account[i].userName +"\nFullName: "+account[i].fullName  );
		System.out.println("Email: "+ account[i].email);
		System.out.println("UserName: "+ account[i].userName);
		System.out.println("FullName: "+ account[i].fullName);
		System.out.println("CreateDate: "+date);
		}
	}
}
