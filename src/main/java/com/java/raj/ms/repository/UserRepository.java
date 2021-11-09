package com.java.raj.ms.repository;

import com.java.raj.ms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserRepository  extends JpaRepository<User, Integer> {
}
