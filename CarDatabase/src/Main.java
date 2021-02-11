/**
 * @author Joshua Wood - jjwood1
 * CIS175 - Spring 2021
 * ${date}
 */
import java.util.List;
import java.util.Scanner;

import Controller.CarHelper;
import model.Car;


public class Main {

		static Scanner in = new Scanner(System.in);
		static CarHelper c = new CarHelper();

		private static void addCar() {
			
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter an year: ");
			String year = in.nextLine();
			Car add = new Car(name, year);
			c.insertItem(add);
		}

		private static void deleteCar() {
			System.out.println("Enter the Id of the car you are trying to delete: ");
			int id = in.nextInt();
			Car drop = new Car(id);
			c.deleteCar(drop);
		}

		private static void editCar() {
		
			Car toEdit;
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				toEdit = c.searchForCarById(idToEdit);
				
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getYear());
				System.out.println("Enter 1 to update car name");
				System.out.println("Enter 2 to Update year");
				System.out.println("Enter 3 to update both");
				
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				}
				else if (update == 3) {
					System.out.print("New name: ");
					String newName = in.nextLine();
					System.out.print("New year: ");
					String newYear = in.nextLine();

					toEdit.setName(newName);
					toEdit.setYear(newYear);
				}

				c.updateCar(toEdit);

	
		
}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean Repeat = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (Repeat) {
				System.out.println("===+===+===+===+===+===+===+===+");
				System.out.println("Select an option:");
				System.out.println("Press 1 to Add a car");
				System.out.println("Enter 2 to Edit a car");
				System.out.println("Enter 3 Delete a car");
				System.out.println("Enter 4 View the list of cars");
				System.out.println("Enter 5 to leave");
				System.out.println("===+===+===+===+===+===+===+===+");
				System.out.print("*  Your selection: ");
				
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addCar();
				} else if (selection == 2) {
					viewInventory();
					editCar();
				} else if (selection == 3) {
					viewInventory();
					deleteCar();
				} else if (selection == 4) {
					viewInventory();
				} else {
					c.cleanUp();
					System.out.println("EXITING");
					Repeat = false;
				}

			}

		}

		private static void viewInventory() {
			List<Car> allCars = c.showAllItems();
			for(Car singleItem : allCars)
			{
				System.out.println(singleItem.returnFullDetails());
				
			}
			

		}

	}