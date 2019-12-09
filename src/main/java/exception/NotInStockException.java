package exception;

public class NotInStockException extends RuntimeException {
    public NotInStockException() throws NotInStockException {
        super("Item not in stock!");
    }
}
