package nl.miwnn.se12.vincent.LibraryDemo.controller;

import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import nl.miwnn.se12.vincent.LibraryDemo.model.Author;
import nl.miwnn.se12.vincent.LibraryDemo.model.Book;
import nl.miwnn.se12.vincent.LibraryDemo.model.Copy;
import nl.miwnn.se12.vincent.LibraryDemo.model.LibraryUser;
import nl.miwnn.se12.vincent.LibraryDemo.repository.AuthorRepository;
import nl.miwnn.se12.vincent.LibraryDemo.repository.BookRepository;
import nl.miwnn.se12.vincent.LibraryDemo.repository.CopyRepository;
import nl.miwnn.se12.vincent.LibraryDemo.repository.LibraryUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Initializes my DB with some testing data
 */
@Controller
@RequiredArgsConstructor
public class InitializeController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CopyRepository copyRepository;
    private final LibraryUserRepository libraryUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/initialize")
    private String initializeDB() {
        if (!libraryUserRepository.findAll().isEmpty()) {
            return "redirect:/";
        }

        LibraryUser adminUser = new LibraryUser();
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        // TODO Enforce the user to select a better password
        System.err.println("Admin user created, please make sure to change the password");
        libraryUserRepository.save(adminUser);

        Author patrick = new Author("Patrick", "Rothfuss");
        Author paul = new Author("Paul", "van", "Loon");

        authorRepository.save(patrick);
        authorRepository.save(paul);

        Book wind = new Book("The Name of the Wind");
        wind.addAuthor(patrick);
        bookRepository.save(wind);

        ArrayList<Copy> copies = new ArrayList<>();

        copies.add(new Copy(wind));
        copies.add(new Copy(wind));
        copies.add(new Copy(wind));

        Book bus = new Book("De Griezelbus");
        bus.addAuthor(paul);
        bookRepository.save(bus);

        copies.add(new Copy(bus));
        copies.add(new Copy(bus));

        copyRepository.saveAll(copies);

        return "redirect:/";
    }
}
