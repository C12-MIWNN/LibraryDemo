package nl.miwnn.se12.vincent.LibraryDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.vincent.LibraryDemo.dto.PasswordDTO;
import nl.miwnn.se12.vincent.LibraryDemo.model.LibraryUser;
import nl.miwnn.se12.vincent.LibraryDemo.repository.LibraryUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Handle everything regarding LibraryUser objects
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class LibraryUserController {
    private final LibraryUserRepository libraryUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/changepassword")
    private String getChangePasswordForm(Model model) {
        model.addAttribute("passwordDetails", new PasswordDTO());

        return "passwordForm";
    }

    @PostMapping("/changepassword")
    private String updatePassword(@ModelAttribute("passwordDetails") PasswordDTO passwordDTO,
                                  Authentication authentication) {
        LibraryUser user = (LibraryUser) authentication.getPrincipal();

        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
            && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            libraryUserRepository.save(user);
        }

        return "redirect:/";
    }

}
