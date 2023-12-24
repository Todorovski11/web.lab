package mk.finki.ukim.mk.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.exception.MissingBookFieldException;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.BookRepository;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author author = authorRepository.findById(authorId).orElse(null);
        Book book = bookRepository.findByIsbn(isbn);
        bookRepository.addAuthorToBook(author,book);
        return author;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book create(String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore)
            throws MissingBookFieldException {
        if (isbn == null || isbn.isEmpty() || title == null || title.isEmpty()
                || genre == null || genre.isEmpty() || bookStore == null) {
            throw(new MissingBookFieldException());
        }
        Book book = new Book(isbn, title, genre, year, new ArrayList<>(), bookStore);
        return bookRepository.create(book);
    }
    @Override
    public Book findById(Long id){return bookRepository.findById(id);}

    @Override
    public Book update(Long id, String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) throws MissingBookFieldException {
        if (isbn == null || isbn.isEmpty() || title == null || title.isEmpty()
                || genre == null || genre.isEmpty() || bookStore == null) {
            throw(new MissingBookFieldException());
        }
        Book book = new Book(isbn, title, genre, year, authors, bookStore);
        book.setId(id);
        return bookRepository.update(book);
    }
    @Override
    public void delete(Long id){bookRepository.delete(findById(id));}

    @Override
    public Book makeCopy(Book book) {
        String newTitle = String.format("CopyOf%s",book.getTitle());
        Book copyBook = new Book(book.getIsbn(), newTitle,book.getGenre(),book.getYear(),book.getAuthors(),book.getBookStore());
        return bookRepository.create(copyBook);
    }


}
