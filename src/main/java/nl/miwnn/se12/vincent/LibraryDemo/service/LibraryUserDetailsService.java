package nl.miwnn.se12.vincent.LibraryDemo.service;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.vincent.LibraryDemo.repository.LibraryUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Provide details about a user
 */
@Service
@RequiredArgsConstructor
public class LibraryUserDetailsService implements UserDetailsService {
    private final LibraryUserRepository libraryUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return libraryUserRepository.findLibraryUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User: %s does not exist", username))
        );
    }

}
