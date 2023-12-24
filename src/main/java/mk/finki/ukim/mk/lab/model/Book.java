package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Book {
    private static Random randomIdGenerator = new Random();
    private Long id;
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;
    private BookStore bookStore;

    public Book(String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.id = randomIdGenerator.nextLong(1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }
}
