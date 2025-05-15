import java.util.ArrayList;
import java.util.Scanner;
public class BudgetProject {
	public static ArrayList budgets = new ArrayList<Budget>();
	public static void listBudgets(){
		for(int i=0; i<budgets.size(); i++){
			System.out.println(i + " " + ((Budget)(budgets.get(i))).getName());
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean on = true;
		while(on) {
			System.out.println("Welcome to the Budget Calculator!  What would you like to do?\n1) Make a new Budget\n2) Edit Budget\n3) View Budget\n4) exit");
			int response = input.nextInt();
			input.nextLine();

			switch(response) {
			case 1:
				System.out.print("\nBudget name: ");
				String name = input.nextLine();
				System.out.print("Amount: ");
				double total = input.nextDouble();
				System.out.print("\nNumber of spending categories: ");
				int categories = input.nextInt();
				input.nextLine();
				Budget yourBudget = new Budget(total, name);
				for(int i=0; i<categories; i++) {
					System.out.print("\nWhat category would you like to add? ");
					name = input.nextLine();
					System.out.print("\nWhat percentage of your total would you like to reserve for this category? ");
					yourBudget.addCategory(name, input.nextDouble());
					if(!yourBudget.totalCategoryPortions()){
						System.out.print("\nThis goes over your budget! You must input a smaller portion or edit the other categories.");
						yourBudget.removeCategory(name);
					}
					input.nextLine();
				}
				budgets.add(yourBudget);
				System.out.print("\nYou have successfully created your budget calulator!");
				break;
			case 2:
				System.out.println("Select your budget: ");
				listBudgets();
				Budget budget = (Budget)budgets.get(input.nextInt());
				input.nextLine();
				System.out.println("your budget: ");
				budget.displayBudget();
				System.out.print("Would you like to:\n1) Edit total\n2) Add a category\n3) Remove a category ");
				int action = input.nextInt();
				input.nextLine();
				if(action == 1) {
					System.out.print("\nPlease enter a new total amount: ");
					budget.setTotal(input.nextInt());
					input.nextLine();
				}
				else if(action == 2) {
					System.out.print("\nWhat category would you like to add? ");
					name = input.nextLine();
					System.out.print("\nWhat percentage of your total would you like to reserve for this category? ");
					budget.addCategory(name, input.nextDouble());
					input.nextLine();
				}
				else if(action == 3) {
					System.out.print("\nWhich category would you like to remove? ");
					budget.removeCategory(input.nextLine());
				}
				else
					System.out.print("\nInvalid input.");
				System.out.println("your budget: ");
				budget.displayBudget();
					break;
			case 3:
				System.out.println("Select your budget: ");
				listBudgets();
				((Budget)budgets.get(input.nextInt())).displayBudget();
				input.nextLine();
				break;
			case 4:
				on = false;
				System.out.println("Goodbye!");
				input.close();
				break;
			default:
				System.out.println("Try again.");
			}
		}
	}
}
