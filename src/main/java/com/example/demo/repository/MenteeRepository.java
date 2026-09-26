package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mentee;

public interface MenteeRepository extends JpaRepository<Mentee, Long> {

    Optional<Mentee> findByEmail(String email);
}
