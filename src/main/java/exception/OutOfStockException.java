package exception;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException() throws OutOfStockException {
        super("Out of stock!");
    }
}
