package mk.finki.ukim.mk.lab.web.controller;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @PostMapping
    public String getAuthorList(@RequestParam String bookIsbn, Model model){
        model.addAttribute("authors", authorService.listAuthors());
        model.addAttribute("books",bookService.findBookByIsbn(bookIsbn));
        return "authorList";
    }


}
