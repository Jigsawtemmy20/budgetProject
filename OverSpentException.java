public class OverSpentException extends RuntimeException{
    public OverSpentException(){
        super("Spending amount exceeds the budget amount.  Please alter your budget prior to spending this much.");
    }
}