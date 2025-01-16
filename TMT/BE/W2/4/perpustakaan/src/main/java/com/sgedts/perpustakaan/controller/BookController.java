package com.sgedts.perpustakaan.controller;

import com.sgedts.perpustakaan.bean.BookListResponseBean;
import com.sgedts.perpustakaan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "api/books")
    public List<BookListResponseBean> getListBooks(@RequestParam(value = "keyword") String keyword) {
        return new ResponseEntity<>(bookService.getListBook(keyword), HttpStatus.OK).getBody();
    }
//    @GetMapping(value = "api/book/{id}")
//    public List<BookListResponseBean> getListBookDetail(@PathVariable String id) {
//        return new ResponseEntity<>(bookService.getListBookDetail(id), HttpStatus.OK).getBody();
//    }
//
//    @PostMapping
//
//    @PutMapping
//
//    @DeleteMapping

}
