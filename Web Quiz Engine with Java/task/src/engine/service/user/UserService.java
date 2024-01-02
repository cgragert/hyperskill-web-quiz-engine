package engine.service.user;

import engine.api.user.UserDto;
import engine.service.common.BadRequestException;

public interface UserService {

    void register(final UserDto userDto) throws BadRequestException;
}
