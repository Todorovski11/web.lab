package mk.finki.ukim.mk.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.BookRepository;
import mk.finki.ukim.mk.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBookToAuthor(String bookIsbn, String authorId) {
        Book book  = bookRepository.findByIsbn(bookIsbn);
        Author author = authorRepository.findById(Long.parseLong(authorId)).orElse(null);
        assert author != null;
        authorRepository.addBookToAuthor(book,author);
        return book;
    }
}
