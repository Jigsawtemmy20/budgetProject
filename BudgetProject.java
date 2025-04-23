import java.util.Scanner;
public class BudgetProject {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean on = true;
		while(on) {
			System.out.println("Welcome to the Budget Calculator!  What would you like to do?\n1) Make a new Budget\n2) Edit Budget\n3) View Budget\n4) exit");
			int response = input.nextInt();
			switch(response) {
			case 1:
				System.out.print("amount: ");
				double total = input.nextDouble();
				System.out.print("number of spending categories: ");
				int categories = input.nextInt();
				Budget yourBudget = new Budget(total);
			case 2:
				break;
			case 3:
				break;
			case 4:
				on = false;
				System.out.println("goodbye!");
				input.close();
				break;
			default:
				System.out.println("try again");
			}
		}
	}
}
