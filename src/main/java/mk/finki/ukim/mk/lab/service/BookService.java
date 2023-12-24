package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.exception.MissingBookFieldException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);

    Book create(String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) throws MissingBookFieldException;

    Book findById(Long id);

    Book update(Long id, String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) throws MissingBookFieldException;

    void delete(Long id);

    Book makeCopy(Book book);
}
