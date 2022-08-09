package io.github.adrienkoumgangt.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.adrienkoumgangt.api.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {


}
