package nl.miwnn.se12.vincent.LibraryDemo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.vincent.LibraryDemo.model.Book;
import nl.miwnn.se12.vincent.LibraryDemo.model.Copy;
import nl.miwnn.se12.vincent.LibraryDemo.repository.BookRepository;
import nl.miwnn.se12.vincent.LibraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle everything regarding copies
 */
@Controller
@RequiredArgsConstructor
public class CopyController {
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;

    @GetMapping("/copy/new/{bookId}")
    private String createNewCopy(@PathVariable("bookId") Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (bookOptional.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(bookOptional.get());
            copyRepository.save(copy);
        }

        return "redirect:/";
    }
}
