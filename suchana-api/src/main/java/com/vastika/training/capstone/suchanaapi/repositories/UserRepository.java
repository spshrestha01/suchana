package com.vastika.training.capstone.suchanaapi.repositories;

import com.vastika.training.capstone.suchanaapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     User findByUsername(String username);
}
