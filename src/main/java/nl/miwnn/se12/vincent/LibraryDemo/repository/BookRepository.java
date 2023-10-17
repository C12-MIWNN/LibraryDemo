package nl.miwnn.se12.vincent.LibraryDemo.repository;

import nl.miwnn.se12.vincent.LibraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);
}
