/*
Name：first java program
Functionality: print one line
Arthur: Spencer
*/

import java.util.Scanner;
import java.util.Random;

public class helloworld {

	public static void main (String[] args) { 

		int age_in;
		String name_in;
		System.out.println("please enter the name and age:");
		
		Scanner sc = new Scanner(System.in); 		//initialize a scanner to take the user input
		name_in = sc.next();
		age_in = sc.nextInt();

		System.out.println("age = " + age_in);
		System.out.println("name = " + name_in);


		double f1 = 3.1415926;				//float number are always double type, add f behind to become a float type
		System.out.println("float/double number = " + f1);

		boolean b1 = true;
		b1 = false;					//b1=1; cannot be converted to be boolean
		System.out.println("boolean result = " + b1);

		char r1 = 'p';
		System.out.println("char result = " + r1);
		System.out.println("char Ascii code result = " + (int)r1);

		char r2 = '\u5b59';
		char r3 = '\u51cc';
		char r4 = '\u851a';
		System.out.println("char unicode result = " + r2 + r3 + r4);

		if(r1 == 'p'){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}

		switch(age_in/10){
			case(10):	System.out.println("100~");	break;
			case(9):	System.out.println("90~");	break;
			default:	System.out.println("others");	break;
		}

		
		for(int i=0; i<=100; i++){
			if(i%2 == 1){
				System.out.print(i);
			}
		}
		
		int num = 0;
		for(int i=0; i<=10000; i++){
			num+= i;
		}
		System.out.println(num);

		Random ra = new Random();
		int number_provided = ra.nextInt(100)+1;
		
		while(true){
			System.out.println("please enter a test number from 1-100");
			sc = new Scanner(System.in);
			int number_input = sc.nextInt();

			if(number_input == number_provided){
				System.out.println("you win");
				break;
			}
			else if(number_input > number_provided){
				System.out.println("to large");
			}
			else{
				System.out.println("to small");
			}
		}


		for(int row = 1; row < 10; row ++){
			for( int column = 1; column < 10; column ++){
				System.out.print(row + " * " + column+ " = " + (row*column) + "\t");
				if(row == column){
					System.out.println();
					break;
				}

			}
		}

		
		int array[] = new int[5];
		for(int index = 0; index < array.length; index++){
			if(index != 4)	array[index] = 11*(index+1);
			System.out.println("index = " + index + "   value =" + array[index]);
		}

		for (int index = array.length-1; index >= 0; index--){
			if(index !=0) 	array[index] = array[index-1];
			else		array[index] = 55;

			if(array[index]==22)	array[index]=220; 
		}

		int array_another[] = new int[3];
		
		// array from index 1, to array_another from index 0, for how many
		System.arraycopy(array, 1, array_another, 0, array_another.length-1);
		
		for(int index = 0; index < array_another.length; index++){
			System.out.println("index = " + index + "   value =" + array_another[index]);
		}
		






	}
}