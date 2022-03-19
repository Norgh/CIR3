package Projet;

import java.util.Scanner;

public class App {
	public static void main(String[] args){ 
		System.out.println("WHich screen would you like to display?"); 
		System.out.println("1 - Orderings Screen"); 
		System.out.println("2 - Kitchen Screen"); 
		System.out.println("3 - Bar Screen"); 
		System.out.println("4 - Monitoring Screen");
	
		try (Scanner scanner = new Scanner(System.in)) {
			int ScreenChoice = scanner.nextInt();
			System.out.println("You have chosen screen: " + ScreenChoice);
		}
	} 
}
