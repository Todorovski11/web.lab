package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init(){
        authors.add(new Author(1L,"Name1","Surname1","Biography1"));
        authors.add(new Author(2L,"Name2","Surname2","Biography2"));
        authors.add(new Author(3L,"Name3","Surname3","Biography3"));
        authors.add(new Author(4L,"Name4","Surname4","Biography4"));
        authors.add(new Author(5L,"Name5","Surname5","Biography5"));

        books.add(new Book("1","Book1","genre1",2002,new ArrayList<>()));
        books.add(new Book("2","Book2","genre2",2003,new ArrayList<>()));
        books.add(new Book("3","Book3","genre3",2004,new ArrayList<>()));
        books.add(new Book("4","Book4","genre4",2005,new ArrayList<>()));
        books.add(new Book("5","Book5","genre5",2006,new ArrayList<>()));
    }
}
