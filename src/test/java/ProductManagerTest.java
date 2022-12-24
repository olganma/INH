import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(3637, "Мастер и Маргарита ", 500, "Булгаков");
    Product book2 = new Book(3334, "Собачье сердце", 600, "Булгаков");
    Product book3 = new Book(2222, "Кошачье сердце", 600, "Неизвестный");
    Product smartphone1 = new Smartphone(104, "Galaxy A23", 30_000, "Samsung");
    Product smartphone2 = new Smartphone(106, "iPhone 14", 70_000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void ShouldAddRepo() {
        Product book4 = new Book(010, "Тихий Дон", 550, "Шолохов");
        manager.add(book4);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, book4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchOne() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Собачье");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldSearchFew() {
        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("сердце");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldSearchNone() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Человек");
        Assertions.assertArrayEquals(expected, actual);
    }


}
