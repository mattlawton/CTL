package mattgroupid.mattartifactid;

import java.util.Scanner;

public class ConsoleMethods {

	private static Scanner keyboard = new Scanner(System.in);
	
	
	static void displayHelp() {
		System.out.println("Commands: add, delete, list, restart, calculate, quit");
	}
	
	static void displayError() {
		System.out.println("Hmm, check your spelling...");
	}
	static void doAdd() {
		System.out.print("What are you adding? ");
		System.out.println("1 - Manager, 2 - Developer, 3 - QA Tester, or 4 to exit adding");
		int choice = keyboard.nextInt();

		switch (choice) {
		case 1:
			Util.getEmployee("Manager", "Add");
			break;
		case 2:
			Util.getEmployee("Developer", "Add");
			break;
		case 3:
			Util.getEmployee("QATester", "Add");
			break;
		case 4:
			System.out.println("Exiting add...");
		default:
			System.out.println("I was expecting 1, 2, 3, or 4 ...\n");
			doAdd();
		}
	}

	static void doDelete() {
		System.out.print("What are you deleting? ");
		System.out.println("1 - Manager, 2 - Developer, 3 - QA Tester");
		int choice = keyboard.nextInt();

		switch (choice) {
		case 1:
			//Expected functionality is that removing a manager will cause subordinates
			// to need to be reassigned
			System.out.println("Deleting a manager will delete all their subordinates. Type back to exit.");
			
			Util.getEmployee("Manager", "Delete");
			break;
		case 2:
			Util.getEmployee("Developer", "Delete");
			break;
		case 3:
			Util.getEmployee("QATester", "Delete");
			break;
		case 4:
			System.out.println("Exiting add...");
		default:
			System.out.println("I was expecting 1, 2, 3, or 4 ...\n");
			doDelete();
		}
	}

	// Print each manager followed by their subordinates with a tab for each tier below
	// May need to change to display subordinates under managers that have managers 
	static void doHierarchy() {
		System.out.println("Printing current hierarchy...");
		for (Manager m : App.Managers) {
			System.out.println(m.getName());
				if (m.getManagers() != null) {
				for (String name : m.getManagers()) {
					System.out.println("\t" + name);
				}
				}
				int devs = m.getDevelopers();
				for (int i = 0; i < devs; i++) {
					System.out.println("\tDeveloper");
				}
				int qat = m.getQAtesters();
				for (int i = 0; i < qat; i++) {
					System.out.println("\tQA Tester");
				}
		}
	}
	
	// Pretty much the same as hierarchy but with a running sum as displayed
	static void doCalculate() {
		System.out.println("Finding sum...");
		int sum = 0;
		for (Manager m : App.Managers) {
			System.out.println(m.getName() + " $" + App.MANAGER_COST);
			sum += App.MANAGER_COST;
				if (m.getManagers() != null) {
				for (String name : m.getManagers()) {
					System.out.println("\t" + name);
				}
				}
				int devs = m.getDevelopers();
				for (int i = 0; i < devs; i++) {
					System.out.println("\tDeveloper" + " $" + App.DEVELOPER_COST);
					sum += App.DEVELOPER_COST;
				}
				int qat = m.getQAtesters();
				for (int i = 0; i < qat; i++) {
					System.out.println("\tQA Tester" + " $" + App.QATESTER_COST);
				}
		}
		System.out.println("\nSum: $" + sum);
	}

	// Clear Managers list if yes
	static void doRestart() {
		System.out.println("Are you sure? Y/N");
		if (keyboard.nextLine().equalsIgnoreCase("y")) {
			App.Managers.clear();
		}
	}
	
static void addQATester(String managerName) {
		
		for (Manager m : App.Managers) {
			
			if (m.getName() == managerName) {
				m.addQATester();
			}
		}
	}
	
	static void addDeveloper(String managerName) {
		
		for (Manager m : App.Managers) {
			
			if (m.getName() == managerName) {
				m.addDeveloper();
			}
		}
	}
	
static void removeQATester(String managerName) {
		
		for (Manager m : App.Managers) {
			
			if (m.getName() == managerName) {
				m.addQATester();
			}
		}
	}
	
	static void removeDeveloper(String managerName) {
		
		for (Manager m : App.Managers) {
			
			if (m.getName() == managerName) {
				m.addDeveloper();
			}
		}
	}
	
}
