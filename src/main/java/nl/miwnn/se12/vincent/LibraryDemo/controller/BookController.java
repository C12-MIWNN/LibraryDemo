package nl.miwnn.se12.vincent.LibraryDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.vincent.LibraryDemo.model.Book;
import nl.miwnn.se12.vincent.LibraryDemo.repository.AuthorRepository;
import nl.miwnn.se12.vincent.LibraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle all requests related to books
 */
@Controller
@RequiredArgsConstructor
public class BookController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @GetMapping({"/", "/book/overview"})
    private String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());

        return "bookOverview";
    }

    @GetMapping("/book/new")
    private String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());

        return "bookForm";
    }

    @GetMapping("/book/edit/{title}")
    private String showEditBookForm(@PathVariable("title") String title, Model model) {
        Optional<Book> optionalBook = bookRepository.findBookByTitle(title);

        if (optionalBook.isEmpty()) {
            return "redirect:/book/overview";
        }

        model.addAttribute("book", optionalBook.get());
        model.addAttribute("allAuthors", authorRepository.findAll());

        return "bookForm";
    }

    @GetMapping("/book/delete/{title}")
    private String deleteBook(@PathVariable("title") String title) {
        Optional<Book> optionalBook = bookRepository.findBookByTitle(title);

        if (optionalBook.isEmpty()) {
            return "redirect:/book/overview";
        }

        bookRepository.delete(optionalBook.get());

        return "redirect:/book/overview";
    }

    @PostMapping("/book/new")
    private String saveOrUpdateBook(@ModelAttribute("book") Book bookToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(bookToBeSaved);
        }

        return "redirect:/";
    }

    @GetMapping("/book/detail/{title}")
    private String showBookDetails(@PathVariable("title") String title, Model model) {
        Optional<Book> optionalBook = bookRepository.findBookByTitle(title);

        if (optionalBook.isEmpty()) {
            return "redirect:/book/overview";
        }

        model.addAttribute("bookToBeShown", optionalBook.get());

        return "bookDetail";
    }
}
