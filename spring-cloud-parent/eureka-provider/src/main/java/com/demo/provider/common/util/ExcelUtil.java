package com.demo.provider.common.util;

import com.demo.provider.service.impl.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ExcelUtil {

    // 添加Logger
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void requestHeaderPreprocessing(HttpServletResponse response, String fileName) {
        // 设置响应头 - 使用正确的编码方式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

        try {
            // 正确的文件名编码方式
            String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + encodedFileName);
        } catch (UnsupportedEncodingException e) {
            logger.error("文件名处理失败：{}-{}", fileName, e.getMessage());
        }
    }
}
