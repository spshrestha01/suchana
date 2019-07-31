package com.vastika.training.capstone.suchanaapi.repositories;

import com.vastika.training.capstone.suchanaapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
     Author findByUsername(String username);
}
