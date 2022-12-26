import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product book1 = new Book(345, "Мастер и Маргарита", 500, "Булгаков");
    Product book2 = new Book(237, "Собачье сердце", 600, "Булгаков");
    Product smartphone1 = new Smartphone(104, "Galaxy A23", 30_000, "Samsung");
    Product smartphone2 = new Smartphone(106, "iPhone 14", 70_000, "Apple");

    @Test
    public void ShouldFindById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        Product expected = book2;
        Product actual = repo.findById(book2.getId());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveProductIfIdExits() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.removeById(smartphone1.getId());
        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveShouldShowMesIfIdNotExits() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(432);
        });
    }

    @Test
    public void ShouldSaveAndFindAll() {
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
    public void TestSaveShouldShowMesIfIdExits() {
        ProductRepository repo = new ProductRepository();
        Product book3 = new Book(345, "Война и мир", 700, "Толстой");
        repo.save(book1);
        repo.save(book2);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(book3);
        });
    }

}

