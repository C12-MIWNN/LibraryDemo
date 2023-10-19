package nl.miwnn.se12.vincent.LibraryDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Configure security for the library
 */
@Configuration
@EnableWebSecurity
public class LibraryDemoSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/webjars/**").permitAll()
                        .antMatchers("/", "/book/overview").permitAll()
                        .anyRequest().authenticated())
                .formLogin().and()
                .logout().logoutSuccessUrl("/book/overview");

        return httpSecurity.build();
    }

}
