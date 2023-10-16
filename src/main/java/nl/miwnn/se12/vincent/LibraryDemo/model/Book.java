package nl.miwnn.se12.vincent.LibraryDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * The concept of a book that is available at my library
 */
@Entity
public class Book {

    @Id @GeneratedValue
    private Long bookId;

    private String title;

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
