package engine.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

    @Email(regexp = ".+@.*\\.[a-zA-Z]+")
    @NotBlank
    @JsonProperty("email")
    private String email;
    @Size(min = 5)
    @JsonProperty("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(final String password) {
        this.password = password;
        return this;
    }
}
