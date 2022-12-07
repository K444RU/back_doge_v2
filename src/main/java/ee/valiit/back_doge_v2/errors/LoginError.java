package ee.valiit.back_doge_v2.errors;

import lombok.Getter;

@Getter
public enum LoginError {

    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud", "204"),
    USERNAME_TAKEN("Konto sellise kasutajanimega on juba registreeritud", "206");

    private final String message;
    private final String errorCode;

    LoginError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;

    }
}
