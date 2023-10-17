package nl.miwnn.se12.vincent.LibraryDemo.repository;

import nl.miwnn.se12.vincent.LibraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
