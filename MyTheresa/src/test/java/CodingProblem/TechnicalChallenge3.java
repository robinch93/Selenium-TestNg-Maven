package CodingProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TechnicalChallenge3 {

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		
		HashMap <Integer,String> hmap = new HashMap<Integer,String>();
		hmap.put(3, "my");
		hmap.put(5, "theresa");
		hmap.put(7, "clothes");
		
		List<String> divisors = new ArrayList<String>();
		
		System.out.println("Want to add more items, say Yes or No: ");
		String userChoice = sc.next();
		
		if(userChoice.equalsIgnoreCase("Yes")) {
			System.out.println("How many entries you want to add: ");
			int newItems = sc.nextInt();
			for(int i=1; i <= newItems; i++) {
				System.out.println("Add digit " + i + " :" );
				 Integer a=sc.nextInt();
				 System.out.println("Add word for " + a + ": " );
	             String b=sc.next(); 
	             hmap.put(a,b);
			}
		}else if (userChoice.equalsIgnoreCase("No")) {
			
		}else {
			System.out.println("Please select atleast one correct option.");
		}
		
		System.out.println("Start Playing: (Enter 0 to exit the game)");
		
		while(true) {		
		
			System.out.println("Number: ");
			int number = sc.nextInt();
			
			if(number == 0) {
				System.out.println("Exited");
				break;
			}
			
			for(int key: hmap.keySet()) {    
	             if(number % key == 0) {
	            	 divisors.add(hmap.get(key));
	             }
	         }  
			
			if(divisors.size() == 0) {
				System.out.println("output: " + number);
			}else {
				String result = divisors.stream().collect(Collectors.joining(""));
				System.out.println("output: " + result);
				divisors.removeAll(divisors);
			}	
	
		}
		
	}
}
