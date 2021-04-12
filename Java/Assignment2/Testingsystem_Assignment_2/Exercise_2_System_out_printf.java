package program;

import java.util.Locale;

public class Exercise_2_System_out_printf {
	public static void main(String[] args) {
		
	//Qwestion1:
	int a = 5;
	System.out.printf("%d%n",a);
	
	//Question2:
	int b = 100000000;
	System.out.printf(Locale.US, "%,d %n", b);
	
	//QUestion3:
	float c = 5.567098f;
	System.out.printf("%.4f%n", c);
	
	//Question4:
	String x = "Nguyen Van A";
	System.out.printf("Ten toi la " + x + " va toi ðang ðoc than ");
	
	//Question5:
	//???
	

}}
