package com.sgedts.perpustakaan.service;

import com.sgedts.perpustakaan.bean.BookListResponseBean;
import com.sgedts.perpustakaan.model.Books;
import com.sgedts.perpustakaan.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final BooksRepository booksRepository;
    List<BookListResponseBean> books;

    public BookService() {
        books = new ArrayList<>();
        books.add(new BookListResponseBean(1, "Java", "Gilang"));
        books.add(new BookListResponseBean(2, "Golang", "Rizky"));
        books.add(new BookListResponseBean(3, "Kotlin", "Kemal"));
    }

    public List<BookListResponseBean> getListBook(String param) {
        if (Objects.isNull(param) || param.isEmpty()) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getName().equalsIgnoreCase(param))
                .toList();
    }

    public BookListResponseBean getBookById(long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public BookListResponseBean addBook(BookListResponseBean newBook) {
        Books books1 = new Books();
        books1.setName(newBook.getName());
        books1.setAuthor(newBook.getAuthor());
        booksRepository.save(books1);
        return newBook;
    }

    public BookListResponseBean updateBook(long id, BookListResponseBean updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    public boolean deleteBook(long id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
