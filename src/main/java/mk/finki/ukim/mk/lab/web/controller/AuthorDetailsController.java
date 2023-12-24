package mk.finki.ukim.mk.lab.web.controller;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authorDetails")
public class AuthorDetailsController {
    private final AuthorService authorService;

    public AuthorDetailsController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping
    public String getAuthorDetails(@RequestParam Long authorId, Model model) {
        model.addAttribute("author", authorService.findById(authorId));
        return "/authorDetails";
    }
}