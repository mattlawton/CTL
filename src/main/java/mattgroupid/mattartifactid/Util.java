package mattgroupid.mattartifactid;

import java.util.Scanner;

public class Util {

	static Scanner keyboard = new Scanner(System.in);

	// To be implemented to ensure no erroneous input
	public static String getNameFromConsole(String type) {
		int nonAlpha = 0;
		boolean valid = false;
		String input = "";
		while (!valid) {
			System.out.print("Enter " + type + "'s name: ");
			input = keyboard.nextLine();
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isAlphabetic(input.charAt(i))) {
					nonAlpha++;
				}
			}
			if (nonAlpha > 0)
				valid = false;
			else
				valid = true;
		}
		return input;
	}

	// Gets the manager's name and checks it before calling assignEmployee
	// Managers are handled differently in doManager
	// Type is expected to be Manager, Developer, or QA Tester, op is Add or Delete
	public static void getEmployee(String type, String op) {

		String input = "";

		if (type.equalsIgnoreCase("Manager")) {

			doManager(op);
		} else {

			boolean valid = false;
			while (!valid) {
				System.out.print(type + " for which manager? ");

				input = keyboard.nextLine();
				if (App.isNewManager(input)) {
					System.out.println("There's no manager with that name.");
				} else {
					assignEmployee(input, type, op);
					valid = true;
				}
			}
		}
	}

	// Managers might be assigned to another manager when created
	
	public static void doManager(String op) {

		String name = "";
		boolean marker = true;

		if (op.equalsIgnoreCase("Delete")) {
			name = keyboard.nextLine();
			System.out.print("Delete which manager?: ");
			for (Manager m : App.Managers) {
				if (m.getName().equalsIgnoreCase(name)) {
					App.Managers.remove(m);
					marker = true;
					if (m.getManagers().contains(name)) {
						m.removeManager(name);
					}
				}
			}
			if (marker)
				System.out.println("Deleted " + name);
		} else if (op.equalsIgnoreCase("Add")) {

			System.out.print("Manager's name?: ");
			name = keyboard.nextLine();

			System.out.print("Will this manager be assigned to another manager?: (y/n)");
			if (keyboard.nextLine().equalsIgnoreCase("y") ) {
				System.out.print("Which manager?: ");
				String name2 = keyboard.nextLine();
				for (Manager m : App.Managers) {
					if (m.getName().equalsIgnoreCase(name2)) {
						if (!m.addManager(name)) {
							System.out.println("Manager already assigned.");
						} 
					}
					
				}
			}
			for (Manager m : App.Managers) {
				if (m.getName().equalsIgnoreCase(name)) {
					System.out.println("That manager has already been entered. \n");
					marker = false;
				}
			}
			if (marker)
				App.Managers.add(new Manager(name));
		}

	}

	// Finds the manager getting the assigned employee and does the operation
	public static void assignEmployee(String name, String type, String op) {
		for (Manager m : App.Managers) {
			if (m.getName().equalsIgnoreCase(name))
				if (op.equalsIgnoreCase("Add")) {
					if (type.equalsIgnoreCase("Developer")) {
						m.addDeveloper();
						System.out.println("\nAdded " + type + ", assigned to " + name + "\n");
					} else if (type.equalsIgnoreCase("QATester")) {
						m.addQATester();
						System.out.println("\nAdded " + type + ", assigned to " + name + "\n");
					} 
						
				} else if (op.equalsIgnoreCase("Delete")) {
					if (type.equalsIgnoreCase("Developer")) {
						m.removeDeveloper();
						System.out.println("\nRemoved " + type + ", assigned to " + name + "\n");
					}

					else if (type.equalsIgnoreCase("QATester")) {
						m.removeQATester();
						System.out.println("\nRemoved " + type + ", assigned to " + name + "\n");
					}

					else if (type.equalsIgnoreCase("Manager"))
						if (!m.removeManager(name))
							System.out.println("\nThe manager couldn't be found. ");
				}
		}
	}

}
