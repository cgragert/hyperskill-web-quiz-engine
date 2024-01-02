package engine.api.user;

import engine.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestResourceBean implements UserRestResource {

    private final UserService userService;

    @Autowired
    public UserRestResourceBean(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> register(final UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok().build();
    }
}
