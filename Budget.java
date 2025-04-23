import java.util.ArrayList;
public class Budget {
	private double total;
	private ArrayList<String> categories;
	public Budget(double total) {
		this.total = total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotal() {
		return this.total;
	}
}
