package com.example.demoFinal.repository;

import com.example.demoFinal.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"title"})
    Optional<Book> findByTitle(String title);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"id"})
    List<Book> findAll();

}