package com.sgedts.perpustakaan.repository;
import com.sgedts.perpustakaan.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findAll(String param);
    List<Books> findAllByName(String param);

    @Query(nativeQuery = true, value = "select * from {h-schema}books" + "where :param = '' or name like(concat('%',param,'%'))")
    List<Books> findAllByParam(String param);


}
