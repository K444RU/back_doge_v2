package ee.valiit.back_doge_v2.errors;

import ee.valiit.back_doge_v2.business.user.services.UserService;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.infrastructure.exception.BusinessException;

import javax.annotation.Resource;
import java.util.Optional;


public class Validation {

    public static void validationUser(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(LoginError.INCORRECT_CREDENTIALS.getMessage(), LoginError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }

    public static void validationUsername(Optional<User> userOptional) {
        if (userOptional.isPresent()) {
            throw new BusinessException(LoginError.INCORRECT_USERNAME.getMessage(), LoginError.INCORRECT_USERNAME.getErrorCode());
        }
    }

}

