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
			case 2:
				System.out.print("Would you like to:\n1) Edit total\n2) Add a category\n3) Remove a category");
				int action = input.nextInt();
				if(action == 1) {
					System.out.print("Please enter a new total amount: ");
					yourBudget.setTotal(input.nextInt());
				}
				else if(action == 2) {
					System.out.print("What category would you like to add?");
					String name = input.nextLine();
					System.out.print("What portion of your total would you like to reserve for this category?");
					yourBudget.addCategory(name, input.nextDouble());
				}
				else if(action == 3) {
					
					
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
