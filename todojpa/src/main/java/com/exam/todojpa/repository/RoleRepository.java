package com.exam.todojpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.todojpa.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRolename(String rolename);
}
