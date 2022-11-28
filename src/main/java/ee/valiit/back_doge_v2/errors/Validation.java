package ee.valiit.back_doge_v2.errors;

import ee.valiit.back_doge_v2.infrastructure.exception.BusinessException;

import java.util.Optional;

public class Validation {

    public static void validationUser(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(LoginError.INCORRECT_CREDENTIALS.getMessage(), LoginError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }

}

