package com.example.spring_mysql_api.repositories;

import com.example.spring_mysql_api.models.Book;
import com.example.spring_mysql_api.models.User;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findById(SingularAttribute<AbstractPersistable, Serializable> id);

}
