import java.util.ArrayList;
public class Budget {
	private double total;
	private ArrayList<Category> categories;
	public Budget(double total) {
		this.total = total;
		this.categories = new ArrayList<>();
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
		for(Category c:categories) {
			System.out.print(c);
		}
	}
	public boolean totalCategoryPortions() {
		double sum=0;
		for(Category c:categories) {
			sum+=c.getPortion();
			if(sum>100)
				return false;
		}
		return true;
	}
}
