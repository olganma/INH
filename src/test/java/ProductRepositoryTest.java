import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product book1 = new Book(002, "Мастер и Маргарита", 500, "Булгаков");
    Product book2 = new Book(004, "Собачье сердце", 600, "Булгаков");
    Product smartphone1 = new Smartphone(104, "Galaxy A23", 30_000, "Samsung" );
    Product smartphone2 = new Smartphone(106, "iPhone 14", 70_000, "Apple" );

    @Test
    public void ShouldFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.removeById(smartphone1.getId());
        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
}

