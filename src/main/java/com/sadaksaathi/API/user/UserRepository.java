package com.sadaksaathi.API.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// This interface extends JpaRepository for standard database operations.
// We specify <User, Long> because it manages 'User' entities,
// and the ID of the User is of type 'Long'.
public interface UserRepository extends JpaRepository<User, Long> {

    // By simply declaring this method name, Spring Data JPA will automatically
    // write the code to find a user by their email address.
    Optional<User> findByEmail(String email);
}