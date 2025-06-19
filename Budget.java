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
	public ArrayList<Category> getCategories(){
		return this.categories;
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
	public String toString(){
		String s = "name: " + this.getName() + "\n" + "Total money: "+ this.getTotal() + "\n" + "name\tportion\tamount\t\n";
		int count =1;
		for(Category c:categories) {
			s += count + ". " + c.toString(total);
			count++;
		}
		return s;
	}
	public void displayBudget() {
		System.out.println(this.toString());
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
	public void spendMoney(int c, double amount){
		double maxAmount = categories.get(c).getAmount(this.getTotal());
        if (maxAmount < amount){
            throw new OverSpentException();
        }
        else{
            maxAmount -= amount;
			total -= amount;
			categories.get(c).setPortion(maxAmount*100/total);
			for(int i=0; i<categories.size(); i++){
				if(i==c){
					continue;
				}
				else{
					categories.get(i).setPortion(categories.get(i).getAmount(total)*100/total);
				}
			}
        }
    }
}
