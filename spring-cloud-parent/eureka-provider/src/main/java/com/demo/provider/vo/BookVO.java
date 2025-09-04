package com.demo.provider.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {


    @ExcelProperty("ID")
    private String id;


    @ExcelProperty("书名")
    private String title;


    @ExcelProperty("作者")
    private String author;





}
