import java.util.ArrayList;
public class Budget {
	private double total;
	private ArrayList<Category> categories;
	public Budget(double total) {
		this.total = total;
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
	public void removeCategory(Category c){
		categories.remove(c);
	}
}