package com.demo.provider.common;

import java.io.Serializable;

/**
 * 统一响应结果封装类
 * @param <T> 数据类型
 */
public class Response<T> implements Serializable {
    private int code;       // 状态码
    private String message; // 消息
    private T data;         // 数据

    // 常用状态码常量
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 500;
    public static final int NOT_FOUND_CODE = 404;
    public static final int UNAUTHORIZED_CODE = 401;
    public static final int FORBIDDEN_CODE = 403;

    // 构造器
    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态工厂方法 - 成功
    public static <T> Response<T> success() {
        return new Response<>(SUCCESS_CODE, "操作成功", null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(SUCCESS_CODE, "操作成功", data);
    }

    public static <T> Response<T> success(String message, T data) {
        return new Response<>(SUCCESS_CODE, message, data);
    }

    // 静态工厂方法 - 错误
    public static <T> Response<T> error(String message) {
        return new Response<>(ERROR_CODE, message, null);
    }

    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message, null);
    }

    public static <T> Response<T> error(int code, String message, T data) {
        return new Response<>(code, message, data);
    }

    // 其他常用方法
    public static <T> Response<T> notFound(String message) {
        return new Response<>(NOT_FOUND_CODE, message, null);
    }

    public static <T> Response<T> unauthorized(String message) {
        return new Response<>(UNAUTHORIZED_CODE, message, null);
    }

    public static <T> Response<T> forbidden(String message) {
        return new Response<>(FORBIDDEN_CODE, message, null);
    }

    // 判断是否成功
    public boolean isSuccess() {
        return this.code == SUCCESS_CODE;
    }

    // getter 和 setter 方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}