package com.demo.provider.service;

import com.demo.provider.common.Response;
import com.demo.provider.entity.Book;
import org.bouncycastle.operator.OperatorException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BookService {


    List<Book> list();

    void BookExport(HttpServletResponse response) throws OperatorException;

}
