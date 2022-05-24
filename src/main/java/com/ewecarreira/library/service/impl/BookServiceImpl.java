package com.ewecarreira.library.service.impl;

import com.ewecarreira.library.exception.BusinessException;
import com.ewecarreira.library.model.entity.Book;
import com.ewecarreira.library.model.repository.BookRepository;
import com.ewecarreira.library.service.BookService;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new BusinessException("Isbn já cadastrado.");
        }
        return bookRepository.save(book);
    }
}
