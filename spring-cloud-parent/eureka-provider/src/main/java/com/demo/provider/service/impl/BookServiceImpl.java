package com.demo.provider.service.impl;

import com.demo.provider.entity.Book;
import com.demo.provider.mapper.BookMapper;
import com.demo.provider.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> list() {
        List<Book> bookList = bookMapper.findAll();
        return bookList;
    }
}
