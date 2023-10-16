package nl.miwnn.se12.vincent.LibraryDemo.controller;

import nl.miwnn.se12.vincent.LibraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle all requests related to books
 */
@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    private String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());

        return "bookOverview";
    }
}
