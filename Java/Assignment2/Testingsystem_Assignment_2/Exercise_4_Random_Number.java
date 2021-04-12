package program;

import java.time.LocalDate;
import java.util.Random;

public class Exercise_4_Random_Number {
public static void main(String[] args) {
	
	
	
	//========Random_Number========//
	
	Random random = new Random();
	//QUestion1:
	int x = random.nextInt();
	System.out.println(x);
	
	//Question2:
	float y = random.nextFloat();
	System.out.println(y);
	
	//question3:
	String a[] = {"nam","Nguyet","thu","Hang"};
	int i = random.nextInt(a.length);
	System.out.println(a[1]);
	
	//question4:
	int minDay = (int) LocalDate.of(1995,07,24).toEpochDay();
	int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
	long randomInt = minDay + random.nextInt(maxDay-minDay);
	LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
	System.out.println(randomDay);
	
	//quetion5:
	//?????;
	
	//quetion7:
	int h = random.nextInt( 999 - 100 + 1 ) + 99;
	System.out.println(h);

	
}
}
