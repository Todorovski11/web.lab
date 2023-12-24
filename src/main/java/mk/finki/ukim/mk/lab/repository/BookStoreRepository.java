package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookStoreRepository {
    public List<BookStore> findAll(){return DataHolder.bookStores;}

    public Optional<BookStore> findById(Long id){
        return DataHolder.bookStores.stream()
                .filter(bs -> bs.getId().equals(id))
                .findFirst();
    }

}
