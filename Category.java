public class Category {
    private String name;
    private double portion;
    public Category(double portion, String name){
        this.portion = portion;
        this.name = name;
    }
    public double getPortion(){
        return this.portion;
    }
    public void setPortion(double portion){
        this.portion = portion;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getAmount(double total){
        return total*this.getPortion();
    }
    public String toString(){
        return("Name: " + this.getName() + "\nPortion: " + this.getPortion() + "%");
    }
}
