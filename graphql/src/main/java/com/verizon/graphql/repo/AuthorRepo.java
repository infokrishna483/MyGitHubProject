package com.verizon.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.graphql.entity.Author;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{

}
