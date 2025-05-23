package ra.java_web_11.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidatorConstraint implements ConstraintValidator<PhoneNumberValidator, String> {

    private static final String PHONE_PATTERN = "^0\\d{9}$";

    @Override
    public void initialize(PhoneNumberValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if(phoneNumber == null) {
            return false;
        }

        phoneNumber = phoneNumber.replaceAll("\\s+|-", "");

        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        if (phoneNumber.length() != 10) {
            context.buildConstraintViolationWithTemplate(
                    "Số điện thoại phải có đúng 10 chữ số"
            ).addConstraintViolation();
            isValid = false;
        }

        if (!phoneNumber.startsWith("0")) {
            context.buildConstraintViolationWithTemplate(
                    "Số điện thoại phải bắt đầu bằng số 0"
            ).addConstraintViolation();
            isValid = false;
        }

        if (!phoneNumber.matches("\\d+")) {
            context.buildConstraintViolationWithTemplate(
                    "Số điện thoại chỉ được chứa chữ số"
            ).addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}