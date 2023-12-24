package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {

    public List<Book> findAll(){return DataHolder.books;}

    public Book findByIsbn(String isbn){
        return DataHolder.books.stream()
                .filter(b -> Objects.equals(b.getIsbn(),isbn))
                .findFirst()
                .orElse(null);
    }

    public Author addAuthorToBook(Author author, Book book){
        book.getAuthors().add(author);
        return author;
    }

    public Book create(Book book){
        DataHolder.books.add(book);
        return book;
    }

    public Book findById(Long id){
        return DataHolder.books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    };


    public Book update(Book book){
        DataHolder.books.removeIf(b -> b.getId().equals(book.getId()));
        return create(book);
    }

    public void delete(Book book){DataHolder.books.remove(book);}
}
