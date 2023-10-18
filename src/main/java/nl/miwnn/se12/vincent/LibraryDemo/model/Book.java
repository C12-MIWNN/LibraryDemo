package nl.miwnn.se12.vincent.LibraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * The concept of a book that is available at my library
 */
@Entity
@Getter
@Setter
public class Book {

    public Book(String title) {
        this.title = title;
    }

    public Book() {
    }

    @Id@GeneratedValue
    private Long bookId;

    @Column(unique = true)
    private String title;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Copy> copies;

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }

    public String getAllAuthorsDisplayString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Author author : authors) {
            stringBuilder.append(author.getDisplayName()).append(", ");
        }

        return stringBuilder.toString();
    }
}
