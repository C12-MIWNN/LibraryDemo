package nl.miwnn.se12.vincent.LibraryDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Authors can write one or more books either alone or in a group
 */
@Entity
@Getter @Setter
public class Author {

    public Author(String firstName, String infixName, String lastName) {
        this.firstName = firstName;
        this.infixName = infixName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Author() {
    }

    @Id @GeneratedValue
    private Long authorId;

    @Column(nullable = false)
    private String firstName;
    private String infixName;
    @Column(nullable = false)
    private String lastName;

    public String getDisplayName() {
        String displayName = firstName;

        if (infixName != null && !infixName.equals("")) {
            displayName += " " + infixName;
        }

        displayName += " " + lastName;

        return displayName;
    }
}
