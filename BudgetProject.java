import java.util.Scanner;
public class BudgetProject {
	public static void main(String[] args) {
		Budget yourBudget;
		Scanner input = new Scanner(System.in);
		boolean on = true;
		while(on) {
			System.out.println("Welcome to the Budget Calculator!  What would you like to do?\n1) Make a new Budget\n2) Edit Budget\n3) View Budget\n4) exit");
			int response = input.nextInt();
			switch(response) {
			case 1:
				System.out.print("Amount: ");
				double total = input.nextDouble();
				System.out.print("\nNumber of spending categories: ");
				int categories = input.nextInt();
				yourBudget = new Budget(total);
				for(int i=0; i<categories; i++) {
					System.out.print("\nWhat category would you like to add?");
					String name = input.nextLine();
					System.out.print("\nWhat portion of your total would you like to reserve for this category?");
					if(yourBudget.totalCategoryPortions())
						yourBudget.addCategory(name, input.nextDouble());
					else
						System.out.print("\nThis goes over your budget! You must input a smaller portion or edit the other categories.");
				}
				System.out.print("\nYou have successfully created your budget calulator!");
				break;
			case 2:
				System.out.print("Would you like to:\n1) Edit total\n2) Add a category\n3) Remove a category");
				int action = input.nextInt();
				if(action == 1) {
					System.out.print("\nPlease enter a new total amount: ");
					yourBudget.setTotal(input.nextInt());
				}
				else if(action == 2) {
					System.out.print("\nWhat category would you like to add?");
					String name = input.nextLine();
					System.out.print("\nWhat portion of your total would you like to reserve for this category?");
					yourBudget.addCategory(name, input.nextDouble());
				}
				else if(action == 3) {
					System.out.print("\nWhich category would you like to remove?");
					yourBudget.removeCategory(input.nextLine());
				}
				else
					System.out.print("\nInvalid input.");
				break;
			case 3:
				yourBudget.displayBudget();
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
