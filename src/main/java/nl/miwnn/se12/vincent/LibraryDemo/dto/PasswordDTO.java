package nl.miwnn.se12.vincent.LibraryDemo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * information needed to change a password
 */
@Getter @Setter
public class PasswordDTO {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
