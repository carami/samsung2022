package com.exam.todojpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.todojpa.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User>	findByEmail(String email);
}
