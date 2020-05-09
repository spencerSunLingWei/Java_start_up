/*
Name：stage_one_part_one_homework
Arthur: Lingwei Sun
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class helloworld {

	public static void main (String[] args) { 

	// question 1
		int q1_result = 0;

		//take user input
		System.out.print("please entering one day of a year in the order of year-month-day:\t");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		
		//check if is a lunar year
		if(year % 4 == 0){	
			//calculate the date and check for invalid input
			switch(month){
				case(1):	
					if(day>0 && day<32)  	q1_result = day;
					else 			System.out.println("invalid input for day in January");	
					break;
				case(2):	
					if(day>0 && day<30) 	q1_result = 31+day;
					else 			System.out.println("invalid input for day in February");	
					break;
				case(3):	
					if(day>0 && day<32)	q1_result = 31+29+day;
					else 			System.out.println("invalid input for day in March");	
					break;
				
				case(4):	
					if(day>0 && day<31)	q1_result = 31+29+31+day;
					else 			System.out.println("invalid input for day in April");	
					break;
				case(5):	
					if(day>0 && day<32)  	q1_result = 31+29+31+30+day;
					else 			System.out.println("invalid input for day in May");	
					break;
				case(6):	
					if(day>0 && day<31)	q1_result = 31+29+31+30+31+day;
					else			System.out.println("invalid input for day in June");	
					break;
				
				case(7):	
					if(day>0 && day<32) 	q1_result = 31+29+31+30+31+30+day; 
					else 			System.out.println("invalid input for day in July");	
					break;
				case(8):	
					if(day>0 && day<32)	q1_result = 31+29+31+30+31+30+31+day; 
					else 			System.out.println("invalid input for day in August");	
					break;
				case(9):	
					if(day>0 && day<31)	q1_result = 31+29+31+30+31+30+31+31+day; 
					else 			System.out.println("invalid input for day in September");
					break;
				
				case(10):	
					if(day>0 && day<32)	q1_result = 31+29+31+30+31+30+31+31+30+day;
					else 			System.out.println("invalid input for day in October");	
					break;
				case(11):	
					if(day>0 && day<31)	q1_result = 31+29+31+30+31+30+31+31+30+31+day;
					else 			System.out.println("invalid input for day in November");	
					break;
				case(12):	
					if(day>0 && day<32) 	q1_result = 31+29+31+30+31+30+31+31+30+31+30+day;
					else			System.out.println("invalid input for day in December");	
					break;

				default:	System.out.println("invalid input for month");
			}
		}
		else{	
			//calculate the date and check for invalid input
			switch(month){
				case(1):	
					if(day>0 && day<32)  	q1_result = day;
					else 			System.out.println("invalid input for day in January");	
					break;
				case(2):	
					if(day>0 && day<29) 	q1_result = 31+day;
					else 			System.out.println("invalid input for day in February");	
					break;
				case(3):	
					if(day>0 && day<32)	q1_result = 31+28+day;
					else 			System.out.println("invalid input for day in March");	
					break;
				
				case(4):	
					if(day>0 && day<31)	q1_result = 31+28+31+day;
					else 			System.out.println("invalid input for day in April");	
					break;
				case(5):	
					if(day>0 && day<32)  	q1_result = 31+28+31+30+day;
					else 			System.out.println("invalid input for day in May");	
					break;
				case(6):	
					if(day>0 && day<31)	q1_result = 31+28+31+30+31+day;
					else			System.out.println("invalid input for day in June");	
					break;
				
				case(7):	
					if(day>0 && day<32) 	q1_result = 31+28+31+30+31+30+day; 
					else 			System.out.println("invalid input for day in July");	
					break;
				case(8):	
					if(day>0 && day<32)	q1_result = 31+28+31+30+31+30+31+day; 
					else 			System.out.println("invalid input for day in August");	
					break;
				case(9):	
					if(day>0 && day<31)	q1_result = 31+28+31+30+31+30+31+31+day; 
					else 			System.out.println("invalid input for day in September");
					break;
				
				case(10):	
					if(day>0 && day<32)	q1_result = 31+28+31+30+31+30+31+31+30+day;
					else 			System.out.println("invalid input for day in October");	
					break;
				case(11):	
					if(day>0 && day<31)	q1_result = 31+28+31+30+31+30+31+31+30+31+day;
					else 			System.out.println("invalid input for day in November");	
					break;
				case(12):	
					if(day>0 && day<32) 	q1_result = 31+28+31+30+31+30+31+31+30+31+30+day;
					else			System.out.println("invalid input for day in December");	
					break;

				default:	System.out.println("invalid input for month");

			}
		}

		//check for invalid input
		if(q1_result != 0){
			System.out.println("question one result: " + q1_result);
		}







	// question 2
		System.out.print("\n\nquestion two result: ");

		//loop each number from 1-999
		for(int i = 1; i<1000; i++){
			int value = 0; 
			for(int j=1; j<=(i/2); j++){
				if(i%j == 0)	value += j;
			}
			
			//check if value calculated is the same as the original one
			if(i == value)	System.out.print(i + "  ");
		}

		System.out.println();

	




	//  question 3
		System.out.println("\n\nquestion three result: ");
		Random ra = new Random();
		
		//randomize the six value for red ones
		int red_num_1 = ra.nextInt(33)+1;
		int red_num_2 = ra.nextInt(33)+1;
		int red_num_3 = ra.nextInt(33)+1;
		int red_num_4 = ra.nextInt(33)+1;
		int red_num_5 = ra.nextInt(33)+1;
		int red_num_6 = ra.nextInt(33)+1;

		
		//randomize the one value for blue ones
		int blue_num_1 = ra.nextInt(16)+1;
		
		System.out.println("\t\tred: " + red_num_1 + "  " + red_num_2 + "  " + red_num_3 + "  " + red_num_4 + "  " + red_num_5 + "  " + red_num_6);
		System.out.println("\t\tblue: " + blue_num_1);

	





	// question 4
		System.out.println("\n\nquestion four result: ");
		
		//initilazation
		int size = 10;
		int q4_result_arr[] = new int[size];
		int other_arr[] = new int[size];
		System.out.println("\t\tarray size initialization to be length:  " + q4_result_arr.length);
		
		//testing loop
		boolean test = true;
		while(test){
			//take user input
			System.out.print("\n\t\tThe process will let 80% of the position of the current array to be randomly assigned a number within range 1-100.");
			System.out.print("\n\t\tpress anything to continue, press n to quit the extention process: ");

			//check user input if is a 'n' to quit
			if("n".equals(sc.next()))	test = false;
			if(test == false)		break;
			System.out.println();
			
			//randomly given number to the array
			int index;
			for(index = 0; index < q4_result_arr.length * 0.8; index++){
				q4_result_arr[index] = ra.nextInt(100)+1;
			}
			System.out.println("\n\t\tlength of the array:  " + q4_result_arr.length + "  +  numbers of positions are used:  " + index);

			//print out all numbers in the array
			System.out.print("\t\tall numbers inside the array are: ");
			for(index = 0; index < q4_result_arr.length; index++){
				System.out.print(q4_result_arr[index] + " ");
			}
			System.out.println();
		
			//new heap occupation
			size = (int)Math.ceil(size * 1.5);
			other_arr = new int[size];

			//copy all the values inside the original one to the new address
			System.arraycopy(q4_result_arr, 0, other_arr, 0, q4_result_arr.length-1);
			q4_result_arr = other_arr;
			System.out.println("\t\tarray size extended to be length:  " + q4_result_arr.length);
			
			
			//print out all numbers in the array
			System.out.print("\t\tall numbers inside the array are now: ");
			for(index = 0; index < q4_result_arr.length; index++){
				System.out.print(q4_result_arr[index] + " ");
			}
			System.out.println();
		}




	



	// question 5
		System.out.println("\n\nquestion five result: ");
		
		//2D array initilaization
		int size_2d = 16;
		char q5_arr[][] = new char[size_2d][size_2d];
		
		// storing and printing items in/to the array
		System.out.print("\t\t  ");
		for(int col = 1; col < size_2d; col++){
			if(col<10) 	q5_arr[0][col] = (char)(48+col-1);
			if(col>=10)	q5_arr[0][col] = (char)(97+col-10);
			System.out.print(" " + q5_arr[0][col]);	
		}

		for(int row = 1; row < size_2d; row++){
			System.out.println();
			
			if(row<10) 	q5_arr[row][0] = (char)(48+row-1);
			if(row>=10)	q5_arr[row][0] = (char)(97+row-10);
			System.out.print("\t\t " + q5_arr[row][0]);
			
			
			for(int col = 1; col < size_2d; col++){
				q5_arr[row][col] = '+';
				System.out.print(" " + q5_arr[row][col]);	
			}
		}
		System.out.println();


	}
}