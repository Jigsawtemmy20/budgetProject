import java.util.ArrayList;
public class Budget {
	private double total;
	private String name;
	private ArrayList<Category> categories;
	public Budget(double total, String name) {
		this.total = total;
		this.categories = new ArrayList<>();
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotal() {
		return this.total;
	}
	public void addCategory(String name, double portion){
		categories.add(new Category(name, portion));
	}
	public void removeCategory(String name){
		for(int i = 0; i < categories.size(); i++) {
			if(categories.get(i).getName().equalsIgnoreCase(name))
				categories.remove(i);
		}
	}
	public void displayBudget() {
		System.out.println("name: " + this.getName());
		System.out.println("Total money: "+ this.getTotal());
		for(Category c:categories) {
			System.out.print(c.toString(total));
		}
	}
	public boolean totalCategoryPortions() {
		double sum=0;
		for(Category c:categories) {
			sum+=c.getPortion();
			if(sum>100){
				System.out.println(sum);
				return false;
			}
		}
		return true;
	}
}
