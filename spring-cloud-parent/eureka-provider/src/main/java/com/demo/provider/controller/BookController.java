package com.demo.provider.controller;

import com.demo.provider.common.Response;
import com.demo.provider.entity.Book;
import com.demo.provider.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/list")
    public Response<List<Book>> list() {
        return Response.success(bookService.list());
    }


}
