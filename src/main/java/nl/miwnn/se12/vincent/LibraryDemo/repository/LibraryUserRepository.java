package nl.miwnn.se12.vincent.LibraryDemo.repository;

import nl.miwnn.se12.vincent.LibraryDemo.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
    Optional<LibraryUser> findLibraryUserByUsername(String username);
}
