package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@AllArgsConstructor
@WebServlet(name = "BookDetailsServlet", urlPatterns = "/bookDetails")
public class BookDetailsServlet extends HttpServlet {
    private final AuthorService authorService;
    private final BookService bookService;
    private final SpringTemplateEngine springTemplateEngine;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.
                buildApplication(getServletContext()).
                buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String bookIsbn = req.getParameter("isbn");
        Book book = bookService.findBookByIsbn(bookIsbn);
        Author author = authorService.findById(Long.parseLong(req.getParameter("authorId")));
        bookService.addAuthorToBook(author.getId(), book.getIsbn());
        authorService.addBookToAuthor(book.getIsbn(), String.valueOf(author.getId()));
        context.setVariable("book", book);
        springTemplateEngine.process("bookDetails.html", context, resp.getWriter());
    }
}
