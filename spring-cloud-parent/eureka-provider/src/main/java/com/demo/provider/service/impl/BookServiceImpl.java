package com.demo.provider.service.impl;

import com.alibaba.excel.EasyExcel;
import com.demo.provider.common.util.ExcelUtil;
import com.demo.provider.entity.Book;
import com.demo.provider.mapper.BookMapper;
import com.demo.provider.service.BookService;
import com.demo.provider.vo.BookVO;
import org.bouncycastle.operator.OperatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    public void BookExport(HttpServletResponse response) throws OperatorException {
        ExcelUtil.requestHeaderPreprocessing(response, "图书列表.xlsx");
        List<Book> bookList = bookMapper.findAll();
        List<BookVO> bookVOS = new ArrayList<>();
        for (Book book : bookList) {
            BookVO bookVO = new BookVO(
                    book.getBid(),
                    book.getTitle(),
                    book.getAuthor());
            bookVOS.add(bookVO);
        }

        try {

            // 修改导出部分
            EasyExcel.write(response.getOutputStream(), BookVO.class)
                    .sheet("书籍")
                    .doWrite(bookVOS);


        } catch (IOException e) {
            throw new OperatorException("导出失败：" + e.getMessage());
        }



    }
}
