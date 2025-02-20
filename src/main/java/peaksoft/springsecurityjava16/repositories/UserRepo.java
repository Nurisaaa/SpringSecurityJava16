package peaksoft.springsecurityjava16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import peaksoft.springsecurityjava16.entities.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String username);
}
