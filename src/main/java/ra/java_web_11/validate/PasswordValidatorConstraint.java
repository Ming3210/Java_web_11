package ra.java_web_11.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidatorConstraint implements ConstraintValidator<PasswordValidator, String> {

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password == null) {
            return false;
        }

        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        if (password.length() < 8) {
            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu phải có ít nhất 8 ký tự"
            ).addConstraintViolation();
            isValid = false;
        }

        if (!Pattern.compile(".*[A-Z].*").matcher(password).matches()) {
            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu phải chứa ít nhất 1 chữ hoa"
            ).addConstraintViolation();
            isValid = false;
        }

        if (!Pattern.compile(".*[a-z].*").matcher(password).matches()) {
            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu phải chứa ít nhất 1 chữ thường"
            ).addConstraintViolation();
            isValid = false;
        }

        if (!Pattern.compile(".*[0-9].*").matcher(password).matches()) {
            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu phải chứa ít nhất 1 số"
            ).addConstraintViolation();
            isValid = false;
        }

        if (!Pattern.compile(".*[@#$%^&+=].*").matcher(password).matches()) {
            context.buildConstraintViolationWithTemplate(
                    "Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt (@#$%^&+=)"
            ).addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}