package mattgroupid.mattartifactid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

	// Setup
	private static Scanner keyboard = new Scanner(System.in);
	public static List<Manager> Managers = new ArrayList<Manager>();

	
	// Constants for easy changes 
	public final static int MANAGER_COST = 300;
	public final static int DEVELOPER_COST = 1000;
	public final static int QATESTER_COST = 500;

	public static void main(String[] args) {

		intro();
		String choice = "";
		
		// App will continue until "quit"
		do  {

			System.out.print("\nWhat's next?: ");
			
			switch (keyboard.next()) {
			case "help":
				ConsoleMethods.displayHelp();
				break;
			case "add":
				ConsoleMethods.doAdd();
				break;
			case "delete":
				ConsoleMethods.doDelete();
				break;
			case "hierarchy":
				ConsoleMethods.doHierarchy();
				break;
			case "calculate":
				ConsoleMethods.doCalculate();
				break;
			case "restart":
				ConsoleMethods.doRestart();
				break;
			case "quit":
				choice = "quit";
				break;
			default:
				ConsoleMethods.displayError();
				break;
			}
			

		} while (!choice.equalsIgnoreCase("quit"));

		System.out.println("\nGoodbye");
		System.exit(1);
	}
	
	//Ensures that a manager is input first
	static void intro() {
		System.out.println("Welcome. Type help for a list of commands ... \n");
		
		System.out.print("Add a manager first: ");
		Managers.add(new Manager(keyboard.nextLine()));
	}

	//A check of the manager list to ensure no repeats
	static boolean isNewManager(String name) {
		for (Manager m : Managers) {
			if (m.getName().equalsIgnoreCase(name))
				return false;
		}
		
		return true;
	}
	
}
