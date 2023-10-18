package nl.miwnn.se12.vincent.LibraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * A physical copy of a book that can be available for lending, or out being read
 */
@Entity
@Getter @Setter
public class Copy {

    public Copy(Book book) {
        this.book = book;
    }

    public Copy() {}

    @Id @GeneratedValue
    private Long copyId;

    private Boolean available = true;

    @ManyToOne
    private Book book;
}
