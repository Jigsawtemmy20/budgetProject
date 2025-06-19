import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BudgetProject {
	public static String acceptableChars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	static File file = new File("budgets.txt");
	public static PrintWriter setup() throws FileNotFoundException{
		PrintWriter budgetWriter = new PrintWriter(file);
		return budgetWriter;
	}
	public static Scanner scSetup(File file) throws FileNotFoundException{
		Scanner budgetReader = new Scanner(file);
		return budgetReader;
	}
	public static Scanner buildReader(){
		try{
			Scanner budgetReader = scSetup(file);
			return budgetReader;
		}catch(FileNotFoundException f){
			System.out.println(f);
			return null;
		}
	}
	public static PrintWriter buildWriter(){
		try{
			PrintWriter budgetWriter = setup();
			return budgetWriter;
		} catch(FileNotFoundException f){
			System.out.println(f);
			return null;
		}
	}
	public static ArrayList budgets = new ArrayList<Budget>();
	public static void budgetSetup(File file, ArrayList<Budget> budgets, Scanner budgetReader){
		budgetReader.next();
		while (budgetReader.hasNext()){
			String name = budgetReader.next();
			budgetReader.nextLine();
			budgetReader.next();
			budgetReader.next();
			double total = budgetReader.nextDouble();
			budgetReader.nextLine();
			budgetReader.nextLine();
			budgetReader.next();
			String next = budgetReader.next();
			ArrayList categories = new ArrayList<Category>();
			budgets.add(new Budget(total, name));
			while(!next.contains("name:")){
				budgets.get(budgets.size()-1).addCategory(next, budgetReader.nextDouble());
				budgetReader.nextLine();
				if(budgetReader.hasNext()){
					next = budgetReader.next();
					if (next.contains("name:")){
						break;
					}
					next = budgetReader.next();
				}
				else{
					break;
				}
			}
		}
	}
	public static void listBudgets(){
		for(int i=0; i<budgets.size(); i++){
			System.out.println(i + " " + ((Budget)(budgets.get(i))).getName());
		}
	}
	public static boolean nameCheck(String name){
		for(int i=0; i<budgets.size(); i++){
			if(name.equals(((Budget)(budgets.get(i))).getName())){
				System.out.println(name + " is already used.");
				return false;
			}
		}
		for(int i=0; i<name.length(); i++){
			if(acceptableChars.indexOf((name.charAt(i))) == -1){
				System.out.println(name.charAt(i) + " is not an acceptable character.");
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner budgetReader = buildReader();
		Scanner input = new Scanner(System.in);
		boolean on = true;
		budgetSetup(file, budgets, budgetReader);
		while(on) {
			System.out.println("Welcome to the Budget Calculator!  What would you like to do?\n1) Make a new Budget\n2) Edit Budget\n3) View Budget\n4) Spend money\n5) Remove a budget\n6) exit");
			int response;
			try{
				response = input.nextInt();
				}catch(InputMismatchException e){
					input.nextLine();
					System.out.println("try again");
					continue;
				}
			switch(response) {
			case 1:
				System.out.print("\nBudget name: ");
				String name = input.nextLine();
				if(!nameCheck(name)){
					break;
				}
				System.out.print("Amount: ");
				double total = input.nextDouble();
				Budget yourBudget = new Budget(total, name);
				System.out.println("would you like to:\n1) generate default budget\n2) create your own?");
				input.nextLine();
				if(input.nextInt()==1){
					yourBudget.addCategory("food", 25);
					yourBudget.addCategory("transportation", 25);
					yourBudget.addCategory("rent", 40);
					yourBudget.addCategory("savings", 10);
				}
				else{
					System.out.print("\nNumber of spending categories: ");
					int categories = input.nextInt();
					input.nextLine();
					System.out.println("Would you prefer to manually partition your budget? y/n ");
					if (input.nextLine().equals("n")){
						for(int i=0; i<categories; i++){
							System.out.print("\nEnter category: ");
							String catName = input.nextLine();
							while(!nameCheck(catName)){
								System.out.print("\nEnter category: ");
								catName = input.nextLine();
							}
							yourBudget.addCategory(catName, 100/categories);
						}
					}
					else{
						for(int i=0; i<categories; i++) {
							System.out.print("\nWhat category would you like to add? ");
							name = input.nextLine();
							while(!nameCheck(name)){
								System.out.print("\nEnter category: ");
								name = input.nextLine();
							}
							System.out.print("\nWhat percentage of your total would you like to reserve for this category? ");
							yourBudget.addCategory(name, input.nextDouble());
							if(!yourBudget.totalCategoryPortions()){
								System.out.print("\nThis goes over your budget! You must input a smaller portion or edit the other categories.");
								yourBudget.removeCategory(name);
							}
							input.nextLine();
						}
					}
				}
				budgets.add(yourBudget);
				System.out.print("\nYou have successfully created your budget!");
				yourBudget.displayBudget();
				break;
			case 2:
				System.out.println("Select your budget: ");
				listBudgets();
				Budget budget = (Budget)budgets.get(input.nextInt());
				input.nextLine();
				System.out.println("your budget: \n");
				budget.displayBudget();
				System.out.print("Would you like to:\n1) Edit total\n2) Add a category\n3) Remove a category ");
				int action = input.nextInt();
				input.nextLine();
				if(action == 1) {
					System.out.print("\nPlease enter a new total amount: ");
					budget.setTotal(input.nextDouble());
					input.nextLine();
				}
				else if(action == 2) {
					System.out.print("\nWhat category would you like to add? ");
					name = input.nextLine();
					if(nameCheck(name)){
						System.out.print("\nWhat percentage of your total would you like to reserve for this category? ");
						budget.addCategory(name, input.nextDouble());
						input.nextLine();
					}
					else{
						break;
					}
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
				listBudgets();
				System.out.println("Select your budget: ");
				Budget theBudget = (Budget)budgets.get(input.nextInt());
				theBudget.displayBudget();
				System.out.println("which category number would you like to spend in?");
				int choice = input.nextInt();
				input.nextLine();
				if(choice <0 || choice > theBudget.getCategories().size()){
					System.out.println("Index does not exist");
				}
				else{	
					System.out.println("How much are you spending? ");
					double amount = input.nextDouble();
					try{
						theBudget.spendMoney(choice, amount);
					}
					catch (OverSpentException e){
						System.out.println(e);
					}
				}
				break;
			case 5:
				listBudgets();
				System.out.print("which budget do you want to remove? ");
				budgets.remove(input.nextInt());
				input.nextLine();
				break;
			case 6:
				on = false;
				System.out.println("Goodbye!");
				PrintWriter budgetWriter = buildWriter();
				for(int i=0; i<budgets.size(); i++){
					budgetWriter.println(budgets.get(i).toString());
				}
				input.close();
				budgetReader.close();
				budgetWriter.close();
				break;
			default:
				System.out.println("Try again.");
			}
		}
	}
}