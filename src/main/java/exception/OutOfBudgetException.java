package exception;

public class OutOfBudgetException extends RuntimeException {
    public OutOfBudgetException() throws OutOfBudgetException{
        super("Out of Budget!");
    }
}
