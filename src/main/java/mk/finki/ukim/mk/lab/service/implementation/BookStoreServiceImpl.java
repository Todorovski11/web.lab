package mk.finki.ukim.mk.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.exception.NonExistentBookStoreException;
import mk.finki.ukim.mk.lab.repository.BookStoreRepository;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookStoreServiceImpl implements BookStoreService {

    private BookStoreRepository bookStoreRepository;

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore findById(Long id) throws NonExistentBookStoreException {
        return bookStoreRepository.findById(id).orElseThrow(NonExistentBookStoreException::new);
    }

}
