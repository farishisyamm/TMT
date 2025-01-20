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
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookListResponseBean>> getListBooks(@RequestParam(value = "keyword") String keyword) {
        List<BookListResponseBean> books = bookService.getListBook(keyword);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookListResponseBean> getBookDetail(@PathVariable long id) {
        BookListResponseBean book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<BookListResponseBean> addBook(@RequestBody BookListResponseBean newBook) {
        BookListResponseBean addedBook = bookService.addBook(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookListResponseBean> updateBook(@PathVariable long id, @RequestBody BookListResponseBean updatedBook) {
        BookListResponseBean book = bookService.updateBook(id, updatedBook);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook ( @PathVariable long id){
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

