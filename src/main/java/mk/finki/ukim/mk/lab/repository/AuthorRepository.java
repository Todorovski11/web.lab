package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class AuthorRepository {
    public List<Author> findAll(){return DataHolder.authors;}

    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream()
                .filter(a -> Objects.equals(a.getId(),id))
                .findFirst();
    }
    public Book addBookToAuthor(Book book, Author author){
        author.getBooks().removeIf(b -> b.getIsbn().equals(book.getIsbn()));
        author.getBooks().add(book);
        return book;
    }

}
