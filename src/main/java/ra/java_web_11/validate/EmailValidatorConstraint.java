package ra.java_web_11.validate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidatorConstraint implements ConstraintValidator<EmailValidator, String> {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void initialize(EmailValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null) {
            return false;
        }
        if(email.length() > 50) {
            return false;
        }

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }
}