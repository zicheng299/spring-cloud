package com.demo.provider.mapper;

import com.demo.provider.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  BookMapper {



    List<Book> findAll();

    int insert(Book book);

    int update(Book book);

    int delete(String id);
}
