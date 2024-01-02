package engine.service.user;

import engine.api.user.UserDto;
import engine.service.common.Mapper;
import engine.service.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserMappingService implements Mapper<User, UserDto> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserMappingService(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User mapToEntity(final UserDto userDto) {
        return new User().setEmail(userDto.getEmail()).setPassword(passwordEncoder.encode(userDto.getPassword()));
    }

    @Override
    public UserDto mapToDto(final User user) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public Collection<UserDto> mapToDtos(final Collection<User> users) {
        throw new IllegalStateException("not implemented");
    }
}
