package com.covinoc.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covinoc.prueba.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdentification(Long identification);

}
