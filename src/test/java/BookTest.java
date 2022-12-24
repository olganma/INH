import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void ShouldGetParamsFromSuperClass() {
        Product book1 = new Book(3637, "Мастер и Маргарита", 500, "Булгаков");
        Assertions.assertEquals(3637, book1.getId());
        Assertions.assertEquals("Мастер и Маргарита", book1.getName());
        Assertions.assertEquals(500, book1.getPrice());
    }

}

