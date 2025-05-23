package ra.java_web_11.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidatorConstraint.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    String message() default "Mật khẩu không đủ mạnh";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}