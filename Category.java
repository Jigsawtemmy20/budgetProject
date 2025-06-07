public class Category {
    private String name;
    private double portion;
    public Category(String name, double portion){
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
        return total*this.getPortion()/100;
    }
    public String toString(double total){
        return(this.getName() + "\t" + this.getPortion() + "%\t$" + this.getAmount(total) + "\n");
    }
}
