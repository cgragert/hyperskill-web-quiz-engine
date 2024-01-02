package engine.service.user;

import engine.api.user.UserDto;
import engine.service.common.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceBean implements UserService {

    private final UserMappingService userMappingService;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceBean(final UserMappingService userMappingService, final UserRepository userRepository) {
        this.userMappingService = userMappingService;
        this.userRepository = userRepository;
    }

    @Override
    public void register(final UserDto userDto) throws BadRequestException {
        if (userRepository.existsById(userDto.getEmail())) {
            throw new BadRequestException();
        }
        final User user = userMappingService.mapToEntity(userDto);
        userRepository.save(user);
    }
}
