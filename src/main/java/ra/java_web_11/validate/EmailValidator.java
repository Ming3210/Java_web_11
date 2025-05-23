package ra.java_web_11.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidatorConstraint.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidator {
    String message() default "Email không hợp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}