package nl.miwnn.se12.vincent.LibraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * The concept of a book that is available at my library
 */
@Entity
@Getter @Setter
public class Book {

    @Id @GeneratedValue
    private Long bookId;

    @Column(unique = true)
    private String title;

    private String author;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }
}
