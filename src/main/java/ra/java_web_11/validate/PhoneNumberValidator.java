package ra.java_web_11.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidatorConstraint.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberValidator {
    String message() default "Số điện thoại không hợp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}