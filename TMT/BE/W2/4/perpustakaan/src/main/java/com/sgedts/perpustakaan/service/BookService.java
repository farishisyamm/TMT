package com.sgedts.perpustakaan.service;

import com.sgedts.perpustakaan.bean.BookListResponseBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    public List<BookListResponseBean> getListBook(String param) {
        List<BookListResponseBean> books = new ArrayList<>();
        books.add(new BookListResponseBean(1, "Java", "Gilang"));
        books.add(new BookListResponseBean(2, "Golang", "Rizky"));
        books.add(new BookListResponseBean(3, "Kotlin", "Kemal"));

        if (null == param || param.isEmpty()) {
            return books;
        }
        return books.stream()
                .filter(bookListResponseBean -> bookListResponseBean
                .equals(param))
                .findAny()
                .stream()
                .toList();
    }
}
