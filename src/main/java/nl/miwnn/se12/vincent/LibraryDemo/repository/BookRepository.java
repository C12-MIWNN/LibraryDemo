package nl.miwnn.se12.vincent.LibraryDemo.repository;

import nl.miwnn.se12.vincent.LibraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Get and save Books to the DB
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
