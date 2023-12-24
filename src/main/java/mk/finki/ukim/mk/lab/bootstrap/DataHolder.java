package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    public static List<BookStore> bookStores = new ArrayList<>();

    @PostConstruct
    public void init(){
        authors.add(new Author(1L,"Martin","Todorovski","Biography1",new ArrayList<>()));
        authors.add(new Author(2L,"David","Krstevski","Biography2",new ArrayList<>()));
        authors.add(new Author(3L,"Mirko","Trpkovski","Biography3",new ArrayList<>()));
        authors.add(new Author(4L,"Sofija","Lozova","Biography4",new ArrayList<>()));
        authors.add(new Author(5L,"Vina","Rikijevska","Biography5",new ArrayList<>()));

        BookStore bs1 = new BookStore("LiteraturaMk","Skopje","Tiranska");
        BookStore bs2 = new BookStore("Prosvetno Delo","Bitola","Peklanje");
        BookStore bs3 = new BookStore("Trimaks","Kavadarci","Ilindenska");
        BookStore bs4 = new BookStore("Vranec","Kriva Palanka","Partizanska");
        BookStore bs5 = new BookStore("Steam Beaw","Denver","Roosvelt");

        bookStores.add(bs1);
        bookStores.add(bs2);
        bookStores.add(bs3);
        bookStores.add(bs4);
        bookStores.add(bs5);


        books.add(new Book("1","Maliot Princ","Drama",2002,new ArrayList<>(),bs1));
        books.add(new Book("2","Harry Potter","Fantasy",2003,new ArrayList<>(),bs2));
        books.add(new Book("3","Game of Thrones","Thriller",2004,new ArrayList<>(),bs3));
        books.add(new Book("4","House of the dragon","Comedy",2005,new ArrayList<>(),bs4));
        books.add(new Book("5","Amiral","Novel",2006,new ArrayList<>(),bs5));
    }
}
