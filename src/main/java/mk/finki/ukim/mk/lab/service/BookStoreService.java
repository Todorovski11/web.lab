package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.model.exception.NonExistentBookStoreException;

import java.util.List;
import java.util.Optional;

public interface BookStoreService {
    public List<BookStore> findAll();

    public BookStore findById(Long id) throws NonExistentBookStoreException;
}
