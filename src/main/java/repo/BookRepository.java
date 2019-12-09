package repo;

import model.Book;
import model.Entity;

public class BookRepository implements Repo<Book> {

    @Override
    public Book insert(Entity entity) {
        return null;
    }

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public boolean delete(Entity entity) {
        return false;
    }
}
