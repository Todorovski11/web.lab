package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.exception.MissingBookFieldException;
import mk.finki.ukim.mk.lab.model.exception.NonExistentBookStoreException;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class BookContoller {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BookStoreService storeService;
    @GetMapping("/books")
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("books",bookService.listBooks());
        model.addAttribute("authors",authorService.listAuthors());
        return "listBooks.html";
    }
    @GetMapping("/books/addBookForm")
    public String getAddBookForm(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "add-book";
    }
    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long storeId) {
        System.out.format("%s %d\n", title, storeId);
        try {
            BookStore bookStore = storeService.findById(storeId);
            bookService.create(isbn, title, genre, year, new ArrayList<>(), bookStore);
            return "redirect:/books";
        } catch (NonExistentBookStoreException | MissingBookFieldException e) {
            return "redirect:/books/addBookForm?error=" + e.getMessage();
        }
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long storeId) {
        Book book = bookService.findById(id);
        BookStore store = null;
        try {
            store = storeService.findById(storeId);
        } catch (NonExistentBookStoreException e) {
            return String.format("redirect:/books/editBookForm/%d?error=%s", id, e.getMessage());
        }
        try {
            bookService.update(id, isbn, title, genre, year, book.getAuthors(), store);
            return "redirect:/books";
        } catch (MissingBookFieldException e) {
            return String.format("redirect:/books/editBookForm/%d?error=%s", id, e.getMessage());
        }
    }
    @GetMapping("/books/editBookForm/{id}")
    public String getEditBookForm(@PathVariable Long id, @RequestParam (required = false) String error, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("bookStores", storeService.findAll());
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "editBook";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/books/copy/{id}")
    public String makeCopyOfBook(@PathVariable Long id){
        Book book = bookService.findById(id);
        bookService.makeCopy(book);
        return "redirect:/books";
    }
}
