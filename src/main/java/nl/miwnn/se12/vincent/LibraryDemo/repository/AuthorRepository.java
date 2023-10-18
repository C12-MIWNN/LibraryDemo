package nl.miwnn.se12.vincent.LibraryDemo.repository;

import nl.miwnn.se12.vincent.LibraryDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
