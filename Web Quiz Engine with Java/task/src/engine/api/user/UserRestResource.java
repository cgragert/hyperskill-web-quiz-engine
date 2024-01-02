package engine.api.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserRestResource {

    @PostMapping("/api/register")
    ResponseEntity<Void> register(@RequestBody @Valid UserDto userDto);
}
