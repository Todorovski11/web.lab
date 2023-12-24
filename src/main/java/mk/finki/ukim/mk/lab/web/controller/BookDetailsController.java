package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookDetails")
public class BookDetailsController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookDetailsController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @PostMapping
    public String getBookDetails(@RequestParam String isbn, @RequestParam Long authorId, Model model) {
        Book book = bookService.findBookByIsbn(isbn);
        bookService.addAuthorToBook(authorId, isbn);
        authorService.addBookToAuthor(isbn, String.valueOf(authorId));
        model.addAttribute("book", book);
        return "bookDetails";
    }
}